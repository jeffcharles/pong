package com.beyondtechnicallycorrect.pong.models.position;

import org.junit.*;

public final class PositionFactoryImplIT {

	@Test
	public void testCreate() {
		final int X1 = 1;
		final int X2 = 2;
		final int Y1 = 3;
		final int Y2 = 4;
		PositionFactory factory = new PositionFactoryImpl();
		Position pos = factory.create(X1, X2, Y1, Y2);
		Assert.assertEquals(
				"X1 should match",
				X1, pos.getX1());
		Assert.assertEquals(
				"X2 should match",
				X2, pos.getX2());
		Assert.assertEquals(
				"Y1 should match",
				Y1, pos.getY1());
		Assert.assertEquals(
				"Y2 should match",
				Y2, pos.getY2());
	}
}
