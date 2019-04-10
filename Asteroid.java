package asteroidgame;

import java.awt.Point;
import java.util.Random;
import blobz.BlobUtils;
import blobz.PolyBlob;

/*
* University of Central Florida	
* COP3330 - Spring 2019
* Author(s): Zach Tatman
*/

public class Asteroid extends PolyBlob {
	
	private static final Random random = new Random();
	
	public Asteroid( int xVel, int yVel, double rotation) {
		
		// Contruct a polyblob asteroid using the 
		// angle and position parameters given below.
		super(-100, -100, rotation);
		super.setDelta(xVel, yVel);		
		
		
		// Declare and Initialize sides to a random number (5 - 9)
		int sides = 5 + random.nextInt(5);
		int originDist = 5 + random.nextInt(11);
		
		// Vertices Array
		int Vertex[] = new int[sides];

		for(int i = 0; i < sides; i++)
		{
			Vertex[i] = originDist;
		}

		// Angles Array for Vertices[i]
		double Angle[] = new double[sides];
		double regionSize = (2 * Math.PI) / sides;


		// Give each vertex an originDistance (5 - 15)
		// Give each vertex an angle as well
		for(int i = 0; i < sides; i++)
		{			
			Angle[i] = (i * regionSize) + (Math.random() * regionSize); 
		}
		
		// Declare a new Point Array 
		 Point[] p = new Point[sides];

		
		for (int i = 0; i < sides; i++)
		{
			p[i] = BlobUtils.rotatePoint(Vertex[i], Angle[i]);
		}
		setPolygon(p);
	}
}
