package simulation.entities.flyingObject;

import java.awt.Graphics;
import java.util.Random;
import java.util.logging.MemoryHandler;

import simulation.Handler;
import simulation.entities.Movement;
import simulation.entities.Object;
import simulation.graphics.Assets;

public class Plane extends FlyingObj
{
	private final long PERIOD = 1000L; // Adjust to suit timing

	private long lastTime = System.currentTimeMillis() - PERIOD;

	private int Xrange;
	private int Yrange;
	private int Range;
	private int set=0;
	private int kapasitas;
	private int num;
	private Movement move;
	private Handler handler;
	private boolean moved;
	int index=-1;
			
	public Plane (Handler handler, int x ,int y,double r,int num)
	{
		super (handler,x,y,r);
		this.kapasitas=2;
		this.num=num;
		this.move=new Movement(handler);
		this.handler=handler;
	}
	
	
	@Override
	public void render(Graphics g) 
	{
		 
		g.drawImage(Assets.plane, getX(), getY(), 30, 30, null);
		
	
	        	//Continue to run while pressed

		long thisTime = System.currentTimeMillis();

	    if ((thisTime - lastTime) >= PERIOD) {
	        lastTime = thisTime;

	        isDetected();  //If my variable is true
	          //  boolean = true; //Setting my boolean to true
	           move.move(num);
	           
	            //I need a delay for about one second here.
	           // boolean = false; //Setting my boolean to false;
	        
	    }
		setX(getX());
		setY(getY());
	}
	
	
	public boolean isDetected()
	{
		String number=Integer.toString(num);
		
		
		for(int i=0;i<handler.getWorld().getShips().size();i++)
		{

			Xrange=Math.abs(getX()-handler.getSimulation().getWorld().getShip(i).getX());
			Yrange=Math.abs(getY()-handler.getSimulation().getWorld().getShip(i).getY());
			Range =(int) Math.sqrt((int)(Xrange*Xrange + Yrange*Yrange));
			if(Range<=getR())
			{
				index=handler.getFrame().getControl().getIndex("By plane "+number);
				handler.getSimulation().getWorld().getShip(i).getDetected();
				if(index>=0)
				{
					handler.getFrame().getControl().setList("SHIP DETECTED AT X :"+getX() +" Y :"+getY()+" By plane "+ num+" ",index);
					
				}
				else
				{
					handler.getFrame().getControl().addList("SHIP DETECTED AT X :"+getX() +" Y :"+getY()+" By plane "+ num);
				
				
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
