package com.beyondtechnicallycorrect.pong.models.player;

import org.junit.Test;

import junit.framework.Assert;

public final class TestPlayerImpl {
	
	@Test
	public void testGetScore_WithDefault_ReturnsZero() {
		Scorable player = new PlayerImpl();
		Assert.assertEquals(0, player.getScore()); 
	}
	
	@Test
	public void testIncrementScore() {
		PlayerImpl player = new PlayerImpl();
		ScoreIncrementable si = player;
		Scorable scorable = player;
		
		si.incrementScore();
		final int EXPECTED_SCORE = 1;
		Assert.assertEquals(EXPECTED_SCORE, scorable.getScore());
	}

}
