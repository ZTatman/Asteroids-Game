package asteroidgame;

import java.awt.Point;
import java.awt.event.KeyEvent;
import blobz.BlobAction;
import blobz.BlobProximity;
import blobz.BlobUtils;
import blobz.PolyBlob;
import blobz.SandBox;

/*
* University of Central Florida	
* COP3330 - Spring 2019
* Author(s): Zach Tatman
*/

public class Rocket extends PolyBlob implements BlobAction, BlobProximity {

	// Shape of Rocket Ship
	private final Point[] p = {
			new Point(10, 0),
			new Point(-10, -7),
			new Point(-5, 0),
			new Point(-10, 7)
			
	};
	

	private double angle = 0.0; 	// direction of motion
	private final double delta = 0.15; // Angular change per key press
	private final double speed = 10.0; // speed in direction of motion
	
	// SandBox static variable "sandbox"
	static SandBox sandbox;
	
	public Rocket(int initial_Xpos, int initial_Ypos, SandBox box) {
		super(initial_Xpos, initial_Ypos, 0);
		// TODO Auto-generated constructor stub
		sandbox = box;
		super.setPolygon(p);
		
	}
	
	// Turning rocket ship right
	private void rotate_right()
	{
		this.angle += delta;
		
		if (angle > (2*Math.PI))
		{
			angle -= (2*Math.PI);
		}
		this.setAngle(this.angle);
	}
	
	// Turning rocket ship left
	private void rotate_left()
	{
		this.angle -= delta;
		
		if (angle < 0)
		{
			angle += (2*Math.PI);
		}
		this.setAngle(this.angle);
	}
	
	// Moving rocket ship forward
	private void move_up()
	{
		Point p = this.getLoc();
		
		int xloc = p.x;
		int yloc = p.y;
		
		xloc = xloc + (int)Math.round(speed * Math.cos(angle));
		yloc = yloc + (int)Math.round(speed * Math.sin(angle));
	
		this.setLoc(xloc, yloc);
	}

	private void launch(SandBox box) {
		// TODO Auto-generated method stub
		
		// Find the bounding radius of the rocket
		int bounding_r = this.getSize()/2;
		
		// Find the current location of the rocket
		Point current_position  = this.getLoc();
		
		// Find the point of launch for "this" missile
		Point launch_point = BlobUtils.rotatePoint(bounding_r + 5, angle);
		
		// Find the distance of launch from the rocket
		int distance_x = current_position.x + launch_point.x;
		int distance_y = current_position.y + launch_point.y;
		
		// Create a new missile object
		Missile shoot = new Missile(distance_x, distance_y, angle);
		
		// Add the new missile object to the sandbox
		sandbox.addBlob(shoot);
	}
	
	// Key press events
	@Override
	public void keyAction(KeyEvent e) {
		// TODO Auto-generated method stub
		
		// Left <- key pressed
		if (e.getKeyCode() == 37)
		{
			rotate_left();
		}
		// Right -> key pressed
		else if (e.getKeyCode() == 39)
		{
			rotate_right();
		}
		// Up key pressed
		else if (e.getKeyCode() == 38)
		{
			move_up();
		}
		// Spacebar key pressed
		else if (e.getKeyCode() == 32) {
			launch(sandbox);
			//BlobUtils.playSound();
		}
	}
}
