package com.beyondtechnicallycorrect.pong.models.game;

import junit.framework.Assert;

import org.junit.Test;

public final class TestElementImpl {
	
	@Test
	public void testGetX1() {
		final int X1 = 1;
		Element element = new ElementImpl(X1, 2, 3, 4);
		Assert.assertEquals(X1, element.getX1());
	}
	
	@Test
	public void testGetX2() {
		final int X2 = 2;
		Element element = new ElementImpl(1, X2, 3, 4);
		Assert.assertEquals(X2, element.getX2());
	}
	
	@Test
	public void testGetY1() {
		final int Y1 = 3;
		Element element = new ElementImpl(1, 2, Y1, 4);
		Assert.assertEquals(Y1, element.getY1());
	}
	
	@Test
	public void testGetY2() {
		final int Y2 = 4;
		Element element = new ElementImpl(1, 2, 3, Y2);
		Assert.assertEquals(Y2, element.getY2());
	}

}
