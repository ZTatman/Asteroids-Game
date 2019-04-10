package asteroidgame;

import blobz.BlobGUI;
import java.util.Random;
import blobz.SandBox;
import blobz.SandBoxMode;

/*
* University of Central Florida	
* COP3330 - Spring 2019
* Author(s): Zach Tatman
*/

public class AsteroidGame implements BlobGUI {
	
	private final SandBox sandbox;
	private static int amount;
	private final Random rand = new Random();

	public AsteroidGame(int n) {
		amount = n;
		sandbox = new SandBox();
		sandbox.setSandBoxMode(SandBoxMode.FLOW);
		sandbox.setFrameRate(15);
		sandbox.init(this);
	}

	public static void main(String[] args) {
		String howMany = args[0];
		new AsteroidGame(Integer.parseInt(howMany));
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
		int width = sandbox.getPanelBounds().width;
		int height = sandbox.getPanelBounds().height;
		
		int center_x = width / 2;
		int center_y = height / 2;
		
		Rocket spaceship = new Rocket(center_x, center_y, sandbox);

		sandbox.addBlob(spaceship);
		
		for (int i = 0; i < amount; i++) {
		
			int random_velocity_x = 0;
			int random_velocity_y = 0;
			while (random_velocity_x == 0 || random_velocity_y == 0)
			{
				random_velocity_x = rand.nextInt(7) - 3;
				random_velocity_y = rand.nextInt(7) - 3;
			}
			
		    // Randomly Select a direction value of -.1 or .1
		    int direction = -1 + rand.nextInt(3);
		    while(direction == 0)
		    {	
		    	direction = -1 + rand.nextInt(3);
		    }

		    // Now calculate the rotation.
		    double rotation = (0.1) * direction;
		    
		   Asteroid a = new Asteroid(random_velocity_x, random_velocity_y, rotation);
		   sandbox.addBlob(a);
		}				
	}

}
