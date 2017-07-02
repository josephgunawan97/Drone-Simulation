package simulation.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import simulation.Handler;
import simulation.display.Map;
import simulation.entities.flyingObject.Drone;
import simulation.entities.flyingObject.Helikopter;
import simulation.entities.flyingObject.Plane;
import simulation.entities.ship.Censor;
import simulation.entities.ship.Ship;
import simulation.graphics.Assets;

public class World {
	
	private Random rand=new Random();
	private Handler handler;
	public ObjectManager objectManager;
	private Map map;
	private Drone drone;
	private ArrayList<Plane> planes=new ArrayList<Plane>();
	private ArrayList<Ship> ship=new ArrayList<Ship>();
	private Helikopter heli1,heli2,heli3,heli4;
	private int Xrange;
	private int Yrange;
	private int Range;
	private Censor censor;
	
	public World(Handler handler)
	{
		censor=new Censor();
		
		objectManager = new ObjectManager(handler);
		
		this.map = new Map(handler, 0, 0);
		objectManager.addEntity(map);
		
		int x,y;
		for(int i=0;i<rand.nextInt(8)+1;i++)
		{
			
			do
			{
				 x=rand.nextInt(750);
				 y=rand.nextInt(480);
			}
			while(censor.check(x, y)==true);
			ship.add(new Ship(handler, x, y,rand.nextInt(10)+2,i));
			objectManager.addEntity(ship.get(i));
			
		}
	
		this.drone = new Drone(handler);
		objectManager.addEntity(drone);
		
		for(int i=0;i<=(int)(rand.nextInt(8)+1);i++)
		  {
		   planes.add(new Plane(handler,rand.nextInt(750),rand.nextInt(480),50,i));
		   objectManager.addEntity(planes.get(i));
		  }
		
		
		this.heli1=new Helikopter(handler,30,30,0);
		objectManager.addEntity(heli1);
		
		this.heli2=new Helikopter(handler,375,0,0);
		objectManager.addEntity(heli2);
		
		this.heli3=new Helikopter(handler,290,111,0);
		objectManager.addEntity(heli3);
		
		this.heli4=new Helikopter(handler,103,147,0);
		objectManager.addEntity(heli4);

	}

	
	public void render(Graphics g){
		objectManager.render(g);
	}
	
	public Ship getShip(int i)
	{
		return ship.get(i);
	}
	
	public Drone getDrone()
	{
		return drone;
	}
	
	public Plane getPlane(int i)
	{
		return planes.get(i);
	}
	
	public ArrayList<Ship> getShips()
	{
		return ship;
	}
}
