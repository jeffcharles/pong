package com.beyondtechnicallycorrect.pong.models.position;

public final class PositionFactoryImpl implements PositionFactory {
	
	public Position create(
			int x1,
			int x2,
			int y1,
			int y2
		) {
		
		return new PositionImpl(x1, x2, y1, y2);
	}

}
