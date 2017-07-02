package simulation;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import simulation.display.MainFrame;
import simulation.entities.World;
import simulation.graphics.Assets;

public class Simulation{

	private MainFrame mainFrame;

	private int width, height;
	public String title;
	
	private boolean running = true;
	private Thread thread;


	private BufferStrategy bs;
	private Graphics g;
	
	//Handler
	private Handler handler;
	private World world;
	
	public Simulation(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;

		handler = new Handler(this);
		world = new World(handler);
		run();
	}

	private void init(){
		
		mainFrame = new MainFrame(handler,title, width, height);
		Assets.init();
		
	}
	
	private void render(){
		
		
		bs = mainFrame.getCanvas().getBufferStrategy();
		
		if(bs == null){
			mainFrame.getCanvas().createBufferStrategy(3);
			return;
		}
		// Get a new graphics
		g = bs.getDrawGraphics();

		g.clearRect(width, 0, width, height);  //Clear Screen

		world.render(g);             // Render world
		bs.show();                   // Display the buffer
		g.dispose();                 // Dispose the graphics
		
	}
	
	
	public void run(){
		
		init();
		
		int fps = 100;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick /4;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				render();
				delta--;
			}
			
			if(timer >= 1000000000){
				
				timer = 0;
			}
		}
		
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	
	public Handler getHandler() {
		return handler;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public World getWorld()
	{
		return world;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simulation Simulation = new Simulation("Simulation", 800, 500);
	}

}