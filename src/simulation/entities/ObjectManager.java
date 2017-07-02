package simulation.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import simulation.Handler;


public class ObjectManager{
		
		private Handler handler;
		private ArrayList<Object> objects;
		
		public ObjectManager(Handler handler){
			objects = new ArrayList<Object>();
		}
		
		public void render(Graphics g){
			for(Object e : objects){
				e.render(g);
			}
		}
		
		public void addEntity(Object e){
			objects.add(e);
		}
}
