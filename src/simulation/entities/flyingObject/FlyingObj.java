package simulation.entities.flyingObject;


import simulation.entities.Object;

import javax.swing.JOptionPane;

import simulation.Handler;

public abstract class FlyingObj extends Object
{
	private Handler handler;

	
	public FlyingObj(Handler handler, int x,int y,double r)
	{
		super(handler,x,y,r);
		this.handler=handler;
	}	
	public abstract boolean isDetected();
	
}
