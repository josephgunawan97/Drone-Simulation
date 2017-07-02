package simulation.entities.ship;

import java.awt.Graphics;

import simulation.Handler;
import simulation.entities.Object;
import simulation.graphics.Assets;

public class Ship extends Object
{



	private Handler handler;
	private int kapasitas;
	private int random;
	private int count=0;
	private boolean isRand=false;
	private boolean detect=false,destroyed=false;
	private int num;
	private Censor censor;
	
	public Ship(Handler handler,int x,int y, int kapasitas,int num)
	{
		super(handler, x, y,10);
		this.censor=new Censor();
		this.handler=handler;
		this.kapasitas=kapasitas;
		this.num=num;
	}

	public int getNum()
	{
		return num;
	}
	
	public int getKapasitas() {
		return kapasitas;
	}

	public void getDetected()
	{
		detect=true;	
	}
	
	public boolean getShipDetected()
	{
		return detect;
	}
	
	
	public void setDetect(boolean detect) {
		this.detect = detect;
	}

	public void random()
	{
		if(isRand==false)
		{
			random=((int)(Math.floor(Math.random()*5)));
			isRand=true;
			
		}
		else 
		{
			count+=1;
			if(count==100)
			{
				isRand=false;
				count=0;
			}
		}
		walk();
	}
	
	public void setKapasitas(int kapasitas) {
		this.kapasitas = kapasitas;
	}

	private void walk() {
		// TODO Auto-generated method stub
		if(random==0)
		{
			if(censor.check(getX(),getY())==false) addX();
			else {
				minX();
				random=2;
			}
		}
		if(random==1)
		{
			if(censor.check(getX(),getY())==false) addX();
			else  
				{
				minX();
				random=2;
				}
		}
		else if(random==2)
		{
			if(censor.check(getX(),getY())==false) minX();
			else  {
				addX();
				random=1;
			}
		}
		else if(random==3)
		{
			if(censor.check(getX(),getY())==false) addY();
			else  {
				minY();
				random=4;
			}
		}
		else if(random==4)
		{
			if(censor.check(getX(),getY())==false) minY();
			else  {
				addY();
				random=3;
			}
		}
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if(getKapasitas()>0)
			{
				g.drawImage(Assets.ship, getX(), getY(), 30, 30,null);
				random();
			}
		else if(getKapasitas()<=0)
		{
			setX(-55);
			setY(-55);
			destroyed=true;
		}
		if(getShipDetected()==true && getKapasitas()>0)
		{
			g.drawImage(Assets.target, getX(), getY(), 30, 30,null);
			random();
		}
		
	}

	public boolean isDestroyed() {
		return destroyed;
	}
	

}

