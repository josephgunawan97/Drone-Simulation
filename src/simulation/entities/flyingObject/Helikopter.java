package simulation.entities.flyingObject;

import java.awt.Graphics;

import simulation.Handler;
import simulation.entities.Object;
import simulation.graphics.Assets;

public class Helikopter extends FlyingObj
{
	
	private int kapasitas;
	private Handler handler;
	private boolean action=false;
	private int shiptarget, jarX, jarY;
	private int basecampX, basecampY;
	

	public Helikopter (Handler handler,int x, int y, double r)
	{
		super (handler,x,y,r);
		this.basecampX=x;
		this.basecampY=y;
		this.handler=handler;
		this.kapasitas=3;

		jarX=randomScale();
		jarY=randomScale();
	}
	
	
	public boolean inAction()
	{
		return action;
	}
	public void checkSatelit()
	{
		if(action==false)
		{
			for (int i=0; i<handler.getWorld().getShips().size(); i++)
			{
				if(handler.getWorld().getShip(i).getShipDetected()==true && handler.getWorld().getShip(i).isDestroyed()==false) 
				{
					
						action=true;
						shiptarget=i;
						break;
				}
				if(i==handler.getWorld().getShips().size()-1)
				{
					fly(basecampX,basecampY);
				}
			}
		}
		if(action==true)
		{
			if(handler.getWorld().getShip(shiptarget).getKapasitas()>0) fly(shiptarget,jarX,jarY);
			//else if(getX()==basecampX && getY()==basecampY) action=false;
			else action=false;
		}
		
	}

	private void fly(int x, int y) {
		// TODO Auto-generated method stub
		if(getX()<x) addX();
		if(getY()<y) addY();
		if(getX()>x) minX();
		if(getY()>y) minY();
	}

	public void fly(int i, int jarX, int jarY)
	{
		
int index=handler.getFrame().getControl().getIndex("ATTACK");
		
		if(getX()!=handler.getWorld().getShip(i).getX()
			|| getY()!=handler.getWorld().getShip(i).getY())
		{
			if(getX()<handler.getWorld().getShip(i).getX()+jarX) addX();
			else if(getX()>handler.getWorld().getShip(i).getX()+jarX) minX();
			
			if(getY()<handler.getWorld().getShip(i).getY()+jarY) addY();
			else if(getY()>handler.getWorld().getShip(i).getY()+jarY) minY();
			
			if(getX()==handler.getWorld().getShip(i).getX()+jarX
					&& getY()==handler.getWorld().getShip(i).getY()+jarY && action==true){
				handler.getWorld().getShip(i).setKapasitas(handler.getWorld().getShip(i).getKapasitas()-3);
				
				
			
		}	
			else if(getX()==handler.getWorld().getShip(i).getX()+jarX
					&& getY()!=handler.getWorld().getShip(i).getY()+jarY)
			{
				if(index>=0)
				{
					handler.getFrame().getControl().setList("ATTACK SHIP " +(handler.getWorld().getShip(i).getNum()+1) ,index);
					
				}
				else
				{
					handler.getFrame().getControl().addList("ATTACK SHIP " +handler.getWorld().getShip(i).getNum());
				
				
				}
				action=false;
			
			}
			
		}
		
		
	}
	@Override
	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub
		g.drawImage(Assets.heli,getX(),getY(), 30,30,null);
		 new Thread() {
	            public void run() {
	        		checkSatelit();    
	            }
	        }.start();
	}

	@Override
	public boolean isDetected() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int randomScale()
	{
		return rand.nextInt(30)-15;
	}
}
