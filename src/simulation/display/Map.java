package simulation.display;

import java.awt.Graphics;

import simulation.Handler;
import simulation.entities.Object;
import simulation.graphics.Assets;

public class Map extends Object{
	
	private Handler handler;
	public int test = 0;
	
	
	public Map(Handler handler, int x, int y)
	{
		super(handler, x, y, 100);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.map, 0, 0, null);
		g.drawImage(Assets.heliport, 30,30, 30,30,null);
		g.drawImage(Assets.heliport, 375, 0, 30,30,null);
		g.drawImage(Assets.heliport, 290,111, 30,30,null);
		g.drawImage(Assets.heliport, 103, 147, 30,30,null);
	}
}
