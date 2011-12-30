package com.beyondtechnicallycorrect.pong.models.placeable;

import com.beyondtechnicallycorrect.pong.models.position.Position;

public interface PlaceableBehaviour {
	
	public boolean isOverlap(Placeable model, Position pos);

}
