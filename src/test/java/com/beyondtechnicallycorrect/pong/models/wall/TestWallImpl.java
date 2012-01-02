package com.beyondtechnicallycorrect.pong.models.wall;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.position.Position;

public class TestWallImpl {
	
	@Test
	public void testGetX1() {
		final int X1 = 1;
		Position pos = new PositionStub(X1, 2, 3, 4);
		Wall wall = new WallImpl(pos);
		Assert.assertEquals(X1, wall.getX1());
	}
	
	@Test
	public void testGetX2() {
		final int X2 = 2;
		Position pos = new PositionStub(1, X2, 3, 4);
		Wall wall = new WallImpl(pos);
		Assert.assertEquals(X2, wall.getX2());
	}
	
	@Test
	public void testGetY1() {
		final int Y1 = 3;
		Position pos = new PositionStub(1, 2, Y1, 4);
		Wall wall = new WallImpl(pos);
		Assert.assertEquals(Y1, wall.getY1());
	}
	
	@Test
	public void testGetY2() {
		final int Y2 = 4;
		Position pos = new PositionStub(1, 2, 3, Y2);
		Wall wall = new WallImpl(pos);
		Assert.assertEquals(Y2, wall.getY2());
	}

}
