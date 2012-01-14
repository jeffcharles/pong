package com.beyondtechnicallycorrect.pong.models.ball;

import static org.mockito.Mockito.*;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.movement.MovementBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.OverlappingBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityFactory;

public final class TestInternalBallImpl {
	
	@Test
	public void testGetX1() {
		final int X1 = 1;
		Position pos = new PositionStub(X1, 2, 3, 4);
		InternalBall ball = new InternalBallImpl(null, null, null, pos, null);
		Assert.assertEquals(X1, ball.getX1());
	}
	
	@Test
	public void testGetX2() {
		final int X2 = 2;
		Position pos = new PositionStub(1, X2, 3, 4);
		InternalBall ball = new InternalBallImpl(null, null, null, pos, null);
		Assert.assertEquals(X2, ball.getX2());
	}
	
	@Test
	public void testGetY1() {
		final int Y1 = 3;
		Position pos = new PositionStub(1, 2, Y1, 4);
		InternalBall ball = new InternalBallImpl(null, null, null, pos, null);
		Assert.assertEquals(Y1, ball.getY1());
	}
	
	@Test
	public void testGetY2() {
		final int Y2 = 4;
		Position pos = new PositionStub(1, 2, 3, Y2);
		InternalBall ball = new InternalBallImpl(null, null, null, pos, null);
		Assert.assertEquals(Y2, ball.getY2());
	}
	
	@Test
	public void testIsOverlap_WhenUnderlyingReturnsTrue_ShouldReturnTrue() {
		final boolean IS_OVERLAP = true;
		OverlappingBehaviour overlappingBehaviour =
				new OverlappingBehaviourStub(IS_OVERLAP);
		InternalBall ball =
				new InternalBallImpl(null, overlappingBehaviour, null, null, null);
		Placeable otherModel = new PlaceableStub();
		Assert.assertTrue(ball.isOverlapping(otherModel));
	}
	
	@Test
	public void testIsOverlap_WhenUnderlyingReturnsFalse_ShouldReturnFalse() {
		final boolean IS_OVERLAP = false;
		OverlappingBehaviour overlappingBehaviour =
				new OverlappingBehaviourStub(IS_OVERLAP);
		InternalBall ball =
				new InternalBallImpl(null, overlappingBehaviour, null, null, null);
		Placeable otherModel = new PlaceableStub();
		Assert.assertFalse(ball.isOverlapping(otherModel));
	}
	
	@Test
	public void testMove_ShouldCallMoveOnMovementBehaviour() {
		MovementBehaviour mb = mock(MovementBehaviour.class);
		Position pos = new PositionStub();
		Velocity vel = new VelocityStub();
		InternalBall ball =
				new InternalBallImpl(null, null, mb, pos, vel);
		ball.move();
		verify(mb).move(pos, vel);
	}
	
	@Test
	public void testMove_ShouldUpdatePosition() {
		final int STARTING_X1 = 1;
		Position startingPos = new PositionStub(STARTING_X1, 2, 1, 2);
		final int ENDING_X1 = 2;
		Position endingPos = new PositionStub(ENDING_X1, 3, 1, 2);
		MovementBehaviour mb = new MovementBehaviourStub(endingPos);
		Velocity vel = new VelocityStub();
		InternalBall ball =
				new InternalBallImpl(null, null, mb, startingPos, vel);
		ball.move();
		Assert.assertEquals(ENDING_X1, ball.getX1());
	}
	
	@Test
	public void testUnMove_ShouldCallUnMoveOnMovementBehaviour() {
		MovementBehaviour mb = mock(MovementBehaviour.class);
		Position pos = new PositionStub();
		Velocity vel = new VelocityStub();
		InternalBall ball =
				new InternalBallImpl(null, null, mb, pos, vel);
		ball.unMove();
		verify(mb).unMove(pos, vel);
	}
	
	@Test
	public void testUnMove_ShouldUpdatePosition() {
		final int ENDING_X1 = 2;
		Position endingPos = new PositionStub(ENDING_X1, 3, 1, 2);
		final int STARTING_X1 = 1;
		Position startingPos = new PositionStub(STARTING_X1, 2, 1, 2);
		String randomStringToHaveArgSetToStartingPosition = "";
		MovementBehaviour mb =
				new MovementBehaviourStub(
						startingPos, randomStringToHaveArgSetToStartingPosition);
		Velocity vel = new VelocityStub();
		InternalBall ball =
				new InternalBallImpl(null, null, mb, endingPos, vel);
		ball.unMove();
		Assert.assertEquals(STARTING_X1, ball.getX1());
	}
	
	@Test
	public void testGetXAmountToMove() {
		final int X_AMOUNT = 1;
		Velocity vel = new VelocityStub(X_AMOUNT, 2, 3, 4);
		InternalBall ball = new InternalBallImpl(null, null, null, null, vel);
		Assert.assertEquals(X_AMOUNT, ball.getXAmountToMove());
	}
	
	@Test
	public void testGetXFramesPerMove() {
		final int X_FRAMES = 2;
		Velocity vel = new VelocityStub(1, X_FRAMES, 3, 4);
		InternalBall ball = new InternalBallImpl(null, null, null, null, vel);
		Assert.assertEquals(X_FRAMES, ball.getXFramesPerMove());
	}
	
	@Test
	public void testGetYAmountToMove() {
		final int Y_AMOUNT = 3;
		Velocity vel = new VelocityStub(1, 2, Y_AMOUNT, 4);
		InternalBall ball = new InternalBallImpl(null, null, null, null, vel);
		Assert.assertEquals(Y_AMOUNT, ball.getYAmountToMove());
	}
	
	@Test
	public void testGetYFramesPerMove() {
		final int Y_FRAMES = 4;
		Velocity vel = new VelocityStub(1, 2, 3, Y_FRAMES);
		InternalBall ball = new InternalBallImpl(null, null, null, null, vel);
		Assert.assertEquals(Y_FRAMES, ball.getYFramesPerMove());
	}
	
	@Test
	public void testSetVelocity() {
		final int STARTING_X_AMOUNT = 1;
		final int STARTING_X_FRAMES = 2;
		final int STARTING_Y_AMOUNT = 3;
		final int STARTING_Y_FRAMES = 4;
		final int ENDING_X_AMOUNT = 5;
		final int ENDING_X_FRAMES = 6;
		final int ENDING_Y_AMOUNT = 7;
		final int ENDING_Y_FRAMES = 8;
		Velocity startingVel = new VelocityStub(
				STARTING_X_AMOUNT,
				STARTING_X_FRAMES,
				STARTING_Y_AMOUNT,
				STARTING_Y_FRAMES
			);
		VelocityFactory velFactory = new VelocityFactoryStub();
		InternalBall ball =
				new InternalBallImpl(velFactory, null, null, null, startingVel);
		
		ball.setVelocity(
				ENDING_X_AMOUNT,
				ENDING_X_FRAMES,
				ENDING_Y_AMOUNT,
				ENDING_Y_FRAMES
			);
		
		Assert.assertEquals(
				"X amount should be equal",
				ENDING_X_AMOUNT, ball.getXAmountToMove());
		Assert.assertEquals(
				"X frames should be equal",
				ENDING_X_FRAMES, ball.getXFramesPerMove());
		Assert.assertEquals(
				"Y amount should be equal",
				ENDING_Y_AMOUNT, ball.getYAmountToMove());
		Assert.assertEquals(
				"Y frames should be equal",
				ENDING_Y_FRAMES, ball.getYFramesPerMove());
	}

}
