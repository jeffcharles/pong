package com.beyondtechnicallycorrect.pong.models.collision;

import java.lang.reflect.Type;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

public interface Collidable extends Placeable {

	public void move();
	public void unMove();
	public boolean isOverlapping(Placeable otherModel);
	public void collide(Type typeCollidedWith, Placeable objectCollidedWith);
	
}
