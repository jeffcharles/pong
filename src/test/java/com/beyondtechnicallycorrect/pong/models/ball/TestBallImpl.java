package com.beyondtechnicallycorrect.pong.models.ball;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviours;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

public final class TestBallImpl {
	
	@Test
	public void testMove() {
		InternalBall internalBall = mock(InternalBall.class);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Ball ball = new BallImpl(internalBall, cb);
		
		ball.move();
		
		verify(internalBall).move();
	}
	
	@Test
	public void testUnMove() {
		InternalBall internalBall = mock(InternalBall.class);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Ball ball = new BallImpl(internalBall, cb);
		
		ball.unMove();
		
		verify(internalBall).unMove();
	}
	
	@Test
	public void testIsOverlapping_WhenUnderlyingReturnsFalse_ShouldReturnFalse() {
		final boolean IS_OVERLAPPING = false;
		InternalBall internalBall = new InternalBallStub(IS_OVERLAPPING);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Ball ball = new BallImpl(internalBall, cb);
		Placeable model = new PlaceableStub();
		Assert.assertEquals(IS_OVERLAPPING, ball.isOverlapping(model));
	}
	
	@Test
	public void testIsOverlapping_WhenUnderlyingReturnsTrue_ShouldReturnTrue() {
		final boolean IS_OVERLAPPING = true;
		InternalBall internalBall = new InternalBallStub(IS_OVERLAPPING);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Ball ball = new BallImpl(internalBall, cb);
		Placeable model = new PlaceableStub();
		Assert.assertEquals(IS_OVERLAPPING, ball.isOverlapping(model));
	}
	
	@Test
	public void testCollide() {
		InternalBall internalBall = new InternalBallStub();
		CollisionBehaviours cb = mock(CollisionBehaviours.class);
		Ball ball = new BallImpl(internalBall, cb);
		Placeable model = new PlaceableStub();
		
		ball.collide(model);
		
		verify(cb).collide(model);
	}
	
	@Test
	public void testGetX1() {
		final int X1 = 1;
		InternalBall internalBall = new InternalBallStub(X1, 2, 3, 4);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Ball ball = new BallImpl(internalBall, cb);
		Assert.assertEquals(X1, ball.getX1());
	}
	
	@Test
	public void testGetX2() {
		final int X2 = 2;
		InternalBall internalBall = new InternalBallStub(1, X2, 3, 4);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Ball ball = new BallImpl(internalBall, cb);
		Assert.assertEquals(X2, ball.getX2());
	}
	
	@Test
	public void testGetY1() {
		final int Y1 = 3;
		InternalBall internalBall = new InternalBallStub(1, 2, Y1, 4);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Ball ball = new BallImpl(internalBall, cb);
		Assert.assertEquals(Y1, ball.getY1());
	}
	
	@Test
	public void testGetY2() {
		final int Y2 = 4;
		InternalBall internalBall = new InternalBallStub(1, 2, 3, Y2);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		Ball ball = new BallImpl(internalBall, cb);
		Assert.assertEquals(Y2, ball.getY2());
	}

}
