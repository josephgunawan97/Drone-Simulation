package simulation.entities;

import java.awt.Graphics;
import java.util.Random;

import simulation.Handler;

public abstract class Object 
{
	protected static Random rand=new Random();
	private int x;
	private int y;
	private double r;
	private Handler handler;
	
	public Object(Handler handler, int x,int y,double r)
	{
		this.handler=handler;
		this.x=x;
		this.y=y;
		this.r=r;	
	}
	
	public Object(Handler handler, int x,int y)
	{
		this(handler,x,y,0);	
	}
	
	public abstract void render(Graphics g);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
	
	public void addX()
	{
		if(getX()==780);
		else
		setX(getX()+1);
	}
	public void minX()
	{
		if(getX()==0);
		else
		setX(getX()-1);
	}
	public void addY()
	{
		if(getY()==470);
		else
		setY(getY()+1);
	}
	public void minY()
	{
		if(getY()==0);
		else
		setY(getY()-1);
	}
	

}
