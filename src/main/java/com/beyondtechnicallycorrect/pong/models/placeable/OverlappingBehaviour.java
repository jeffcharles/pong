package com.beyondtechnicallycorrect.pong.models.placeable;

import com.beyondtechnicallycorrect.pong.models.position.Position;

public interface OverlappingBehaviour {
	
	public boolean isOverlap(Placeable model, Position pos);

}
