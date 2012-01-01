package com.beyondtechnicallycorrect.pong.models.collision;

import java.lang.reflect.Type;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

public interface Collidable extends Placeable {

	void move();
	void unMove();
	void collide(Type typeCollidedWith, Placeable objectCollidedWith);
	
}
