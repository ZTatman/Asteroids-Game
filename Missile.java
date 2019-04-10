package asteroidgame;

import blobz.BlobProximity;
import java.awt.Color;
import blobz.Blob;

/*
* University of Central Florida	
* COP3330 - Spring 2019
* Author(s): Zach Tatman
*/

public class Missile extends Blob implements BlobProximity {

	private final double speed = 5.0;
	private final int blobDiam = 5;
	
	public Missile(int x, int y, double angle) {
		super(x, y, Color.yellow);
		// TODO Auto-generated constructor stub
		
		// Set the size of "this" missile equal to Blob diameter.
		this.setSize(blobDiam);
		
		// Set the starting location of "this" missile.
		this.setLoc(x, y);
		
		// Find the change of "this" missile angle with respect to x & y.
		int dx = (int)Math.round(speed*Math.cos(angle));
		int dy = (int)Math.round(speed*Math.sin(angle));
		
		// Set "this" missiles angle.
		this.setDelta(dx, dy);
	}
}
