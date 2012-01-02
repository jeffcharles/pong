package com.beyondtechnicallycorrect.pong.models.wall;

public interface WallFactory {
	
	public Wall create(
			int x1,
			int x2,
			int y1,
			int y2
		);

}
