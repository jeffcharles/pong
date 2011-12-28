package com.beyondtechnicallycorrect.pong.models.position;

public interface Position {

	int getX1();
	int getX2();
	int getY1();
	int getY2();
	
	boolean isOverlapping(Position position);
	
}
