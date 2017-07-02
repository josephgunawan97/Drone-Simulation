package simulation;

import simulation.display.MainFrame;
import simulation.entities.World;

public class Handler {

	private Simulation simulation;
	private MainFrame frame;
	private World world;

	public Handler (Simulation Simulation)
	{
		this.simulation=Simulation;
	}
	
	public Simulation getSimulation()
	{
		return simulation;
	}
	
	public MainFrame getFrame()
	{
		return  simulation.getMainFrame();
	}
	public World getWorld()
	{
		return simulation.getWorld();
	}
	
}
