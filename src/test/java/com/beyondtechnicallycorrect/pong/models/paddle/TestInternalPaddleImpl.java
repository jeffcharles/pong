package com.beyondtechnicallycorrect.pong.models.paddle;

import static org.mockito.Mockito.*;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.movement.MovementBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.OverlappingBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityFactory;

public final class TestInternalPaddleImpl {
	
	@Test
	public void testGetX1() {
		final int X1 = 1;
		Position pos = new PositionStub(X1, 0, 0, 0);
		InternalPaddle paddle =
				new InternalPaddleImpl(null, null, null, null, null, pos, null);
		Assert.assertEquals(X1, paddle.getX1());
	}
	
	@Test
	public void testGetX2() {
		final int X2 = 2;
		Position pos = new PositionStub(0, X2, 0, 0);
		InternalPaddle paddle =
				new InternalPaddleImpl(null, null, null, null, null, pos, null);
		Assert.assertEquals(X2, paddle.getX2());
	}
	
	@Test
	public void testGetY1() {
		final int Y1 = 3;
		Position pos = new PositionStub(0, 0, Y1, 0);
		InternalPaddle paddle =
				new InternalPaddleImpl(null, null, null, null, null, pos, null);
		Assert.assertEquals(Y1, paddle.getY1());
	}
	
	@Test
	public void testGetY2() {
		final int Y2 = 4;
		Position pos = new PositionStub(0, 0, 0, Y2);
		InternalPaddle paddle =
				new InternalPaddleImpl(null, null, null, null, null, pos, null);
		Assert.assertEquals(Y2, paddle.getY2());
	}
	
	@Test
	public void testGetXAmountToMove() {
		final int X_AMOUNT = 1;
		Velocity vel = new VelocityStub(X_AMOUNT, 0, 0, 0);
		InternalPaddle paddle =
				new InternalPaddleImpl(null, null, null, null, null, null, vel);
		Assert.assertEquals(X_AMOUNT, paddle.getXAmountToMove());
	}
	
	@Test
	public void testGetXFramesPerMove() {
		final int X_FRAMES = 2;
		Velocity vel = new VelocityStub(0, X_FRAMES, 0, 0);
		InternalPaddle paddle =
				new InternalPaddleImpl(null, null, null, null, null, null, vel);
		Assert.assertEquals(X_FRAMES, paddle.getXFramesPerMove());
	}
	
	@Test
	public void testGetYAmountToMove() {
		final int Y_AMOUNT = 3;
		Velocity vel = new VelocityStub(0, 0, Y_AMOUNT, 0);
		InternalPaddle paddle =
				new InternalPaddleImpl(null, null, null, null, null, null, vel);
		Assert.assertEquals(Y_AMOUNT, paddle.getYAmountToMove());
	}
	
	@Test
	public void testGetYFramesPerMove() {
		final int Y_FRAMES = 4;
		Velocity vel = new VelocityStub(0, 0, 0, Y_FRAMES);
		InternalPaddle paddle =
				new InternalPaddleImpl(null, null, null, null, null, null, vel);
		Assert.assertEquals(Y_FRAMES, paddle.getYFramesPerMove());
	}
	
	@Test
	public void testSetVelocity() {
		final int X_AMOUNT = 1;
		final int X_FRAMES = 2;
		final int Y_AMOUNT = 3;
		final int Y_FRAMES = 4;
		VelocityFactory factory = new VelocityFactoryStub();
		InternalPaddle paddle =
				new InternalPaddleImpl(factory, null, null, null, null, null, null);
		
		paddle.setVelocity(X_AMOUNT, X_FRAMES, Y_AMOUNT, Y_FRAMES);
		
		Assert.assertEquals(
				"X amount should match",
				X_AMOUNT, paddle.getXAmountToMove());
		Assert.assertEquals(
				"X frames should match",
				X_FRAMES, paddle.getXFramesPerMove());
		Assert.assertEquals(
				"Y amount should match",
				Y_AMOUNT, paddle.getYAmountToMove());
		Assert.assertEquals(
				"Y frames should match",
				Y_FRAMES, paddle.getYFramesPerMove());
	}
	
	@Test
	public void testIsOverlapping_WhenBehaviourReturnsFalse_ShouldReturnFalse() {
		final boolean IS_OVERLAPPING = false;
		OverlappingBehaviour ob = new OverlappingBehaviourStub(IS_OVERLAPPING);
		InternalPaddle paddle =
				new InternalPaddleImpl(null, ob, null, null, null, null, null);
		Placeable otherModel = new PlaceableStub();
		Assert.assertEquals(IS_OVERLAPPING, paddle.isOverlapping(otherModel));
	}
	
	@Test
	public void testIsOverlapping_WhenBehaviourReturnsTrue_ShouldReturnTrue() {
		final boolean IS_OVERLAPPING = true;
		OverlappingBehaviour ob = new OverlappingBehaviourStub(IS_OVERLAPPING);
		InternalPaddle paddle =
				new InternalPaddleImpl(null, ob, null, null, null, null, null);
		Placeable otherModel = new PlaceableStub();
		Assert.assertEquals(IS_OVERLAPPING, paddle.isOverlapping(otherModel));
	}
	
	@Test
	public void testMove_ShouldCallMoveBehaviour() {
		MovementBehaviour mb = mock(MovementBehaviour.class);
		InstructionToVelocityConverter converter =
				new InstructionToVelocityConverterStub();
		PaddleInstructionGetter instruction = new PaddleInstructionGetterStub();
		Position pos = new PositionStub(0, 0, 0, 0);
		Velocity vel = new VelocityStub(0, 0, 0, 0);
		InternalPaddle paddle =
				new InternalPaddleImpl(
						null, null, mb, converter, instruction, pos, vel);
		paddle.move();
		verify(mb).move(pos, vel);
	}
	
	@Test
	public void testMove_ShouldUpdatePosition() {
		final int X1 = 1;
		final int X2 = 2;
		final int Y1 = 3;
		final int Y2 = 4;
		Position endingPos = new PositionStub(X1, X2, Y1, Y2);
		MovementBehaviour mb = new MovementBehaviourStub(endingPos);
		InstructionToVelocityConverter converter =
				new InstructionToVelocityConverterStub();
		PaddleInstructionGetter instruction = new PaddleInstructionGetterStub();
		InternalPaddle paddle =
				new InternalPaddleImpl(
						null, null, mb, converter, instruction, null, null);
		paddle.move();
		Assert.assertEquals("X1 should match", X1, paddle.getX1());
		Assert.assertEquals("X2 should match", X2, paddle.getX2());
		Assert.assertEquals("Y1 should match", Y1, paddle.getY1());
		Assert.assertEquals("Y2 should match", Y2, paddle.getY2());
	}
	
	@Test
	public void testMove_ShouldUseInstruction() {
		final int OLD_X_AMOUNT = 1;
		final int NEW_X_AMOUNT = -1;
		Velocity oldVel = new VelocityStub(OLD_X_AMOUNT, 1, 0, 1);
		Velocity newVel = new VelocityStub(NEW_X_AMOUNT, 1, 0, 1);
		MovementBehaviour mb = new MovementBehaviourStub();
		InstructionToVelocityConverter converter =
				new InstructionToVelocityConverterStub(newVel);
		PaddleInstructionGetter instruction = new PaddleInstructionGetterStub();
		InternalPaddle paddle =
				new InternalPaddleImpl(
						null, null, mb, converter, instruction, null, oldVel);
		paddle.move();
		Assert.assertEquals(NEW_X_AMOUNT, paddle.getXAmountToMove());
	}
	
	@Test
	public void test_WhenVelocityIsSet_ShouldNotUseInstructionNextMove() {
		final int OLD_X_AMOUNT = 1;
		final int NEW_X_AMOUNT = -1;
		Velocity oldVel = new VelocityStub(OLD_X_AMOUNT, 1, 0, 1);
		Velocity newVel = new VelocityStub(NEW_X_AMOUNT, 1, 0, 1);
		VelocityFactory velFactory = new VelocityFactoryStub();
		MovementBehaviour mb = new MovementBehaviourStub();
		InstructionToVelocityConverter converter =
				new InstructionToVelocityConverterStub(newVel);
		PaddleInstructionGetter instruction = new PaddleInstructionGetterStub();
		InternalPaddle paddle =
				new InternalPaddleImpl(
						velFactory, null, mb, converter, instruction, null, oldVel);
		paddle.setVelocity(OLD_X_AMOUNT, 1, 0, 1);
		paddle.move();
		Assert.assertEquals(OLD_X_AMOUNT, paddle.getXAmountToMove());
	}
	
	@Test
	public void test_WhenVelocityIsSet_ShouldUseInstructionAfterNextMove() {
		final int OLD_X_AMOUNT = 1;
		final int NEW_X_AMOUNT = -1;
		Velocity oldVel = new VelocityStub(OLD_X_AMOUNT, 1, 0, 1);
		Velocity newVel = new VelocityStub(NEW_X_AMOUNT, 1, 0, 1);
		VelocityFactory velFactory = new VelocityFactoryStub();
		MovementBehaviour mb = new MovementBehaviourStub();
		InstructionToVelocityConverter converter =
				new InstructionToVelocityConverterStub(newVel);
		PaddleInstructionGetter instruction = new PaddleInstructionGetterStub();
		InternalPaddle paddle =
				new InternalPaddleImpl(
						velFactory, null, mb, converter, instruction, null, oldVel);
		paddle.setVelocity(OLD_X_AMOUNT, 1, 0, 1);
		paddle.move();
		paddle.move();
		Assert.assertEquals(NEW_X_AMOUNT, paddle.getXAmountToMove());
	}
	
	@Test
	public void test_WhenVelocityIsSet_ShouldUseInstructionAfterNextTwoMoves() {
		final int OLD_X_AMOUNT = 1;
		final int NEW_X_AMOUNT = -1;
		Velocity oldVel = new VelocityStub(OLD_X_AMOUNT, 1, 0, 1);
		Velocity newVel = new VelocityStub(NEW_X_AMOUNT, 1, 0, 1);
		VelocityFactory velFactory = new VelocityFactoryStub();
		MovementBehaviour mb = new MovementBehaviourStub();
		InstructionToVelocityConverter converter =
				new InstructionToVelocityConverterStub(newVel);
		PaddleInstructionGetter instruction = new PaddleInstructionGetterStub();
		InternalPaddle paddle =
				new InternalPaddleImpl(
						velFactory, null, mb, converter, instruction, null, oldVel);
		paddle.setVelocity(OLD_X_AMOUNT, 1, 0, 1);
		paddle.move();
		paddle.move();
		paddle.move();
		Assert.assertEquals(NEW_X_AMOUNT, paddle.getXAmountToMove());
	}
	
	@Test
	public void testUnMove_ShouldCallUnMoveBehaviour() {
		MovementBehaviour mb = mock(MovementBehaviour.class);
		Position pos = new PositionStub(0, 0, 0, 0);
		Velocity vel = new VelocityStub(0, 0, 0, 0);
		InternalPaddle paddle =
				new InternalPaddleImpl(null, null, mb, null, null, pos, vel);
		paddle.unMove();
		verify(mb).unMove(pos, vel);
	}
	
	@Test
	public void testUnMove_ShouldUpdatePosition() {
		final int X1 = 1;
		final int X2 = 2;
		final int Y1 = 3;
		final int Y2 = 4;
		Position startingPos = new PositionStub(X1, X2, Y1, Y2);
		String junkSoWeSetStartingPosition = "";
		MovementBehaviour mb =
				new MovementBehaviourStub(startingPos,
						junkSoWeSetStartingPosition);
		InternalPaddle paddle =
				new InternalPaddleImpl(null, null, mb, null, null, null, null);
		paddle.unMove();
		Assert.assertEquals("X1 should match", X1, paddle.getX1());
		Assert.assertEquals("X2 should match", X2, paddle.getX2());
		Assert.assertEquals("Y1 should match", Y1, paddle.getY1());
		Assert.assertEquals("Y2 should match", Y2, paddle.getY2());
	}

}
