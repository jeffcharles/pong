package com.beyondtechnicallycorrect.pong.models.position;

public interface PositionFactory {
	
	Position create(
			int x1,
			int x2,
			int y1,
			int y2
		);

}
