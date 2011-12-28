package com.beyondtechnicallycorrect.pong.models.velocity;

import org.junit.*;

import com.beyondtechnicallycorrect.pong.models.velocity.DirectionalVelocity;
import com.beyondtechnicallycorrect.pong.models.velocity.DirectionalVelocityInfo;

public final class TestDirectionalVelocity {

	@Test
	public void testMove_WhenOneFramePerMove_ShouldMove() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 1;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		int amountMoved = velocity.move();
		Assert.assertEquals(AMOUNT_TO_MOVE, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenOneFramePerMove_ShouldUnMove() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 1;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(-AMOUNT_TO_MOVE, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenTwoFramesPerMove_ShouldMove() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		int amountMoved = velocity.move();
		Assert.assertEquals(AMOUNT_TO_MOVE, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenTwoFramesPerMove_ShouldNotUnMove_WithOneCall() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(0, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenTwoFramesPerMove_ShouldNotMove_WithTwoCalls() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.move();
		int amountMoved = velocity.move();
		Assert.assertEquals(0, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenTwoFramesPerMove_ShouldUnMove_WithTwoCalls() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.unMove();
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(-AMOUNT_TO_MOVE, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenThreeFramesPerMove_ShouldMove_WithOneCall() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 3;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		int amountMoved = velocity.move();
		Assert.assertEquals(AMOUNT_TO_MOVE, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenThreeFramesBetweenMoves_ShouldNotUnMove_WithOneCall() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 3;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(0, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenThreeFramesPerMove_ShouldNotMove_WithTwoCalls() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 3;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.move();
		int amountMoved = velocity.move();
		Assert.assertEquals(0, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenThreeFramesPerMove_ShouldNotUnMove_WithTwoCalls() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 3;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.unMove();
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(0, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenThreeFramesPerMove_ShouldNotMove_WithThreeCalls() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 3;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.move();
		velocity.move();
		int amountMoved = velocity.move();
		Assert.assertEquals(0, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenThreeFramesPerMove_ShouldUnMove_WithThreeCalls() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 3;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.unMove();
		velocity.unMove();
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(-AMOUNT_TO_MOVE, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenOneFramePerMove_ShouldMove_WithTwoCalls() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 1;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.move();
		int amountMoved = velocity.move();
		Assert.assertEquals(AMOUNT_TO_MOVE, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenOneFramePerMove_ShouldUnMove_WithTwoCalls() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 1;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.unMove();
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(-AMOUNT_TO_MOVE, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenTwoFramesPerMove_ShouldMove_WithThreeCalls() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.move();
		velocity.move();
		int amountMoved = velocity.move();
		Assert.assertEquals(AMOUNT_TO_MOVE, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenTwoFramesPerMove_ShouldNotUnMove_WithThreeCalls() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.unMove();
		velocity.unMove();
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(0, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenTwoFramesPerMove_ShouldNotMove_WithFourCalls() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.move();
		velocity.move();
		velocity.move();
		int amountMoved = velocity.move();
		Assert.assertEquals(0, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenTwoFramesPerMove_ShouldUnMove_WithFourCalls() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.unMove();
		velocity.unMove();
		velocity.unMove();
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(-AMOUNT_TO_MOVE, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenOneFramePerMove_ShouldMove_AfterUnMove() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 1;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.unMove();
		int amountMoved = velocity.move();
		Assert.assertEquals(AMOUNT_TO_MOVE, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenOneFramePerMove_ShouldUnMove_AfterMove() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 1;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.move();
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(-AMOUNT_TO_MOVE, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenTwoFramesPerMove_ShouldNotMove_AfterUnMove() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.unMove();
		int amountMoved = velocity.move();
		Assert.assertEquals(0, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenTwoFramesPerMove_ShouldUnMove_AfterMove() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.move();
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(-AMOUNT_TO_MOVE, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenTwoFramesPerMove_ShouldMove_AfterTwoUnMoves() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.unMove();
		velocity.unMove();
		int amountMoved = velocity.move();
		Assert.assertEquals(AMOUNT_TO_MOVE, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenTwoFramesPerMove_ShouldNotUnMove_AfterTwoMoves() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.move();
		velocity.move();
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(0, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenTwoFramesPerMove_ShouldNotMove_AfterTwoUnMovesAndOneMove() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.unMove();
		velocity.unMove();
		velocity.move();
		int amountMoved = velocity.move();
		Assert.assertEquals(0, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenTwoFramesPerMove_ShouldUnMove_AfterTwoMovesAndOneUnMove() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.move();
		velocity.move();
		velocity.unMove();
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(-AMOUNT_TO_MOVE, amountUnMoved);
	}
	
	@Test
	public void testMove_WhenTwoFramesPerMove_ShouldMove_AfterTwoUnMovesAndTwoMoves() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.unMove();
		velocity.unMove();
		velocity.move();
		velocity.move();
		int amountMoved = velocity.move();
		Assert.assertEquals(AMOUNT_TO_MOVE, amountMoved);
	}
	
	@Test
	public void testUnMove_WhenTwoFramesPerMove_ShouldNotUnMove_AfterTwoMovesAndTwoUnMoves() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES_PER_MOVE = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES_PER_MOVE);
		DirectionalVelocity velocity = new DirectionalVelocity(info);
		velocity.move();
		velocity.move();
		velocity.unMove();
		velocity.unMove();
		int amountUnMoved = velocity.unMove();
		Assert.assertEquals(0, amountUnMoved);
	}
	
	@Test
	public void testGetAmountToMove() {
		final int AMOUNT_TO_MOVE = 20;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, 1);
		DirectionalVelocity vel = new DirectionalVelocity(info);
		Assert.assertEquals(AMOUNT_TO_MOVE, vel.getAmountToMove());
	}
	
	@Test
	public void testGetFramesPerMove() {
		final int FRAMES_PER_MOVE = 10;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(1, FRAMES_PER_MOVE);
		DirectionalVelocity vel = new DirectionalVelocity(info);
		Assert.assertEquals(FRAMES_PER_MOVE, vel.getFramesPerMove());
	}
	
}
