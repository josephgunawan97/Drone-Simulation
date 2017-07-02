package simulation.entities;

import java.util.Random;

import simulation.Handler;

public class Movement 
{
	private Random rand=new Random();
	private Handler handler;
	private int dx;
	private int dy;
	private int dir;
	private int xpos;
	private int ypos;
	private int xmove;
	private int ymove;
	public Movement(Handler handler)
	{
		this.handler=handler;
	}

	public void move(final int m)
	{

		 new Thread() {
	        	//Continue to run while pressed
	            public void run() 
	            {
	            	sleepp();
	            	
						dx=rand.nextInt(250)-125;
						dy=rand.nextInt(150)-75;
	            	
						xpos=handler.getWorld().getPlane(m).getX();
	            		ypos=handler.getWorld().getPlane(m).getY();

						xmove=dx+xpos;
	            		ymove=dy+ypos;

						if(xmove>xpos && xmove<=780)
	            		{
	            			for (int i=0; i<dx;i++)
	            				{
	            				sleepp();
	            				
	            				handler.getWorld().getPlane(m).addX();
	            				}
	            		}	
	            		else if(xmove<xpos && xmove>=0)
	            		{
	            			for (int i=dx; i<0;i++)
	            				{	
	            					sleepp();
	            					handler.getWorld().getPlane(m).minX();
	            				}
	            		}
	            		
	            		if(ymove>ypos && ymove<=480)
	            		{
	            			for (int i=0; i<dy;i++)
	            				{
	            					sleepp();
	            					handler.getWorld().getPlane(m).addY();
	            				}
	            		}
	            		else if(ymove<ypos && ymove>=0)
	            		{
	            			for (int i=dy; i<0;i++)
	            				{
	            					sleepp();
	            					handler.getWorld().getPlane(m).minY();
	            				}
	            		}
	            		
	            }

	        }.start();
	        
		}
	
	public void sleepp()
	{
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


	

