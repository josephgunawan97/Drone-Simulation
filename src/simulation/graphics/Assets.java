package simulation.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets {

		public static BufferedImage map;
		public static BufferedImage drone, heliport, heli;
		public static BufferedImage ship, plane, target;
		
	public static void init() {
		// TODO Auto-generated method stub
		
		try {
			
			map = ImageIO.read(new File("./images/Texture2.jpg"));
			drone = ImageIO.read(new File("./images/drone2.png"));
			ship = ImageIO.read(new File("./images/ship.png"));
			plane = ImageIO.read(new File("./images/plane.png"));
			target = ImageIO.read(new File("./images/target.png"));
			heli = ImageIO.read(new File("./images/helicopter.png"));
			heliport=ImageIO.read(new File("./images/heliport.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
