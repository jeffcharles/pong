package com.beyondtechnicallycorrect.pong.models.movement;

import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.position.PositionFactory;

final class PositionFactoryStub implements PositionFactory {

	@Override
	public Position create(
			int x1,
			int x2,
			int y1,
			int y2
		) {
		
		return new PositionStub(x1, x2, y1, y2);
	}

}
