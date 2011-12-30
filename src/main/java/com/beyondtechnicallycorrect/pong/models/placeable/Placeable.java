package com.beyondtechnicallycorrect.pong.models.placeable;

public interface Placeable {

	public int getX1();
	public int getX2();
	public int getY1();
	public int getY2();
	public boolean isOverlap(Placeable model); 
	
}
