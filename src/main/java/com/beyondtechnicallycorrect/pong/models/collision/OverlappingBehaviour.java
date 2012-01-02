package com.beyondtechnicallycorrect.pong.models.collision;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.position.Position;

public interface OverlappingBehaviour {
	
	public boolean isOverlap(Placeable model, Position pos);

}
