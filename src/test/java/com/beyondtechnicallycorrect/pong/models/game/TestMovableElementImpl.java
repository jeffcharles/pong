package com.beyondtechnicallycorrect.pong.models.game;

import junit.framework.Assert;

import org.junit.Test;

public final class TestMovableElementImpl {
	
	@Test
	public void testGetX1() {
		final int X1 = 1;
		MovableElement element = new MovableElementImpl(X1, 2, 3, 4, 5, 6);
		Assert.assertEquals(X1, element.getX1());
	}
	
	@Test
	public void testGetX2() {
		final int X2 = 2;
		MovableElement element = new MovableElementImpl(1, X2, 3, 4, 5, 6);
		Assert.assertEquals(X2, element.getX2());
	}
	
	@Test
	public void testGetY1() {
		final int Y1 = 3;
		MovableElement element = new MovableElementImpl(1, 2, Y1, 4, 5, 6);
		Assert.assertEquals(Y1, element.getY1());
	}
	
	@Test
	public void testGetY2() {
		final int Y2 = 4;
		MovableElement element = new MovableElementImpl(1, 2, 3, Y2, 5, 6);
		Assert.assertEquals(Y2, element.getY2());
	}
	
	@Test
	public void testGetXVelocity() {
		final double X_VELOCITY = 5;
		MovableElement element =
				new MovableElementImpl(1, 2, 3, 4, X_VELOCITY, 6);
		Assert.assertEquals(X_VELOCITY, element.getXVelocity());
	}
	
	@Test
	public void testGetYVelocity() {
		final double Y_VELOCITY = 6;
		MovableElement element =
				new MovableElementImpl(1, 2, 3, 4, 5, Y_VELOCITY);
		Assert.assertEquals(Y_VELOCITY, element.getYVelocity());
	}

}
