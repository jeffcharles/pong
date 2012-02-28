package com.beyondtechnicallycorrect.pong.models.paddle;

import static org.mockito.Mockito.*;
import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviours;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

public final class TestPaddleImpl {
	
	@Test
	public void testMove() {
		InternalPaddle internalPaddle = mock(InternalPaddle.class);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		
		paddle.move();
		
		verify(internalPaddle).move();
	}
	
	@Test
	public void testUnMove() {
		InternalPaddle internalPaddle = mock(InternalPaddle.class);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		
		paddle.unMove();
		
		verify(internalPaddle).unMove();
	}
	
	
	@Test
	public void testIsOverlapping_WhenUnderlyingReturnsFalse_ShouldReturnFalse() {
		final boolean IS_OVERLAPPING = false;
		InternalPaddle internalPaddle =
				new InternalPaddleStub(IS_OVERLAPPING);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		Placeable model = new PlaceableStub();
		Assert.assertEquals(IS_OVERLAPPING, paddle.isOverlapping(model));
	}
	
	@Test
	public void testIsOverlapping_WhenUnderlyingReturnsTrue_ShouldReturnTrue() {
		final boolean IS_OVERLAPPING = true;
		InternalPaddle internalPaddle =
				new InternalPaddleStub(IS_OVERLAPPING);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		Placeable model = new PlaceableStub();
		Assert.assertEquals(IS_OVERLAPPING, paddle.isOverlapping(model));
	}
	
	@Test
	public void testCollide() {
		InternalPaddle internalPaddle =
				new InternalPaddleStub(0, 0, 0, 0);
		CollisionBehaviours cb = mock(CollisionBehaviours.class);
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		Placeable model = new PlaceableStub();
		
		paddle.collide(model);
		
		verify(cb).collide(model);
	}
	
	@Test
	public void testGetX1() {
		final int X1 = 1;
		InternalPaddle internalPaddle =
				new InternalPaddleStub(X1, 0, 0, 0);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		Assert.assertEquals(X1, paddle.getX1());
	}
	
	@Test
	public void testGetX2() {
		final int X2 = 2;
		InternalPaddle internalPaddle =
				new InternalPaddleStub(0, X2, 0, 0);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		Assert.assertEquals(X2, paddle.getX2());
	}
	
	@Test
	public void testGetY1() {
		final int Y1 = 3;
		InternalPaddle internalPaddle =
				new InternalPaddleStub(0, 0, Y1, 0);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		Assert.assertEquals(Y1, paddle.getY1());
	}
	
	@Test
	public void testGetY2() {
		final int Y2 = 4;
		InternalPaddle internalPaddle =
				new InternalPaddleStub(0, 0, 0, Y2);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		Assert.assertEquals(Y2, paddle.getY2());
	}
	
	@Test
	public void testGetXAmountToMove() {
		final int X_AMOUNT = 1;
		InternalPaddle internalPaddle =
				new InternalPaddleStub(0, 0, 0, 0, X_AMOUNT, 0, 0, 0);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		Assert.assertEquals(X_AMOUNT, paddle.getXAmountToMove());
	}
	
	@Test
	public void testGetXFramesPerMove() {
		final int X_FRAMES = 2;
		InternalPaddle internalPaddle =
				new InternalPaddleStub(0, 0, 0, 0, 0, X_FRAMES, 0, 0);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		Assert.assertEquals(X_FRAMES, paddle.getXFramesPerMove());
	}
	
	@Test
	public void testGetYAmountToMove() {
		final int Y_AMOUNT = 2;
		InternalPaddle internalPaddle =
				new InternalPaddleStub(0, 0, 0, 0, 0, 0, Y_AMOUNT, 0);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		Assert.assertEquals(Y_AMOUNT, paddle.getYAmountToMove());
	}
	
	@Test
	public void testGetYFramesPerMove() {
		final int Y_FRAMES = 1;
		InternalPaddle internalPaddle =
				new InternalPaddleStub(0, 0, 0, 0, 0, 0, 0, Y_FRAMES);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Paddle paddle = new PaddleImpl(internalPaddle, cb);
		Assert.assertEquals(Y_FRAMES, paddle.getYFramesPerMove());
	}

}
