package com.beyondtechnicallycorrect.pong.models.ball;

import org.junit.Test;

import junit.framework.Assert;

import com.beyondtechnicallycorrect.pong.models.collision.AdjustVelocityDelegate;

public final class TestWallCollisionAdjustVelocityDelegate {
	
	@Test
	public void testGetAdjustedAmountToMove_WhenGivenPositiveNumber_ShouldReturnSameNumberButNegative() {
		AdjustVelocityDelegate del = new WallCollisionAdjustVelocityDelegate();
		final int POSITIVE_NUMBER = 2;
		int returnedNumber = del.getAdjustedAmountToMove(POSITIVE_NUMBER);
		final int EXPECTED = -POSITIVE_NUMBER;
		Assert.assertEquals(EXPECTED, returnedNumber);
	}
	
	@Test
	public void testGetAdjustedAmountToMove_WhenGivenNegativeNumber_ShouldReturnSameNumberButPositive() {
		AdjustVelocityDelegate del = new WallCollisionAdjustVelocityDelegate();
		final int NEGATIVE_NUMBER = -3;
		int returnedNumber = del.getAdjustedAmountToMove(NEGATIVE_NUMBER);
		final int EXPECTED = -NEGATIVE_NUMBER;
		Assert.assertEquals(EXPECTED, returnedNumber);
	}
	
	@Test
	public void testGetAdjustedAmountToMove_WhenGivenZero_ShouldReturnZero() {
		AdjustVelocityDelegate del = new WallCollisionAdjustVelocityDelegate();
		final int ZERO = 0;
		int returnedNumber = del.getAdjustedAmountToMove(ZERO);
		Assert.assertEquals(ZERO, returnedNumber);
	}

}
