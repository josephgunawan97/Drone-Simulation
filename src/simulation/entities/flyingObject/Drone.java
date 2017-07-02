package simulation.entities.flyingObject;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import simulation.Handler;
import simulation.entities.Object;
import simulation.graphics.Assets;

public class Drone extends FlyingObj{

	private Handler handler;
	private int Xrange;
	private int Yrange;
	private int Range;
	private int set=0;
	
	public Drone(Handler handler)
	{
		super(handler, 0, 0,40);
		this.handler=handler;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.drone, getX(),getY(), 20, 20, null);
		
		 new Thread() {
	        	//Continue to run while pressed
	            public void run() {

	        		isDetected();    
	            }
	        }.start();
		setX(getX());
		setY(getY());
	}

	@Override
	
	public boolean isDetected()
	{
		int index=handler.getFrame().getControl().getIndex("By Drone");
		for(int i=0;i<handler.getWorld().getShips().size();i++)
		{

			Xrange=Math.abs(getX()-handler.getSimulation().getWorld().getShip(i).getX());
			Yrange=Math.abs(getY()-handler.getSimulation().getWorld().getShip(i).getY());
			Range =(int) Math.sqrt((int)(Xrange*Xrange + Yrange*Yrange));
			if(Range<=handler.getSimulation().getWorld().getDrone().getR())
			{
				handler.getSimulation().getWorld().getShip(i).getDetected();
				if(index>=0)
				{
					handler.getFrame().getControl().setList("SHIP DETECTED AT X :"+getX() +" Y :"+getY()+" By Drone",index);
					
				}
				else
				{
					handler.getFrame().getControl().addList("SHIP DETECTED AT X :"+getX() +" Y :"+getY()+" By Drone");
						
				}
				return true;
			}
		
		}
		 return false;
		
	}
	
	public void reset()
	{
		set=0;
	}

}
