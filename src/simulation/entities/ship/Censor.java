package simulation.entities.ship;

public class Censor {
	
	private boolean land=false;
	
	public boolean check(int x,int y)
	{
		if(x<=422 && y<=175) land=true;
		else if(x<=360 && x>=220 && y<=293 && y>=175) land=true;
		else land=false;
		return land;
	}

}
