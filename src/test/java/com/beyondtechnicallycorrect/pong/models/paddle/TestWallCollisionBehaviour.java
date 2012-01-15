package com.beyondtechnicallycorrect.pong.models.paddle;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.beyondtechnicallycorrect.pong.models.collision.AdjustVelocityDelegate;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.wall.Wall;

public final class TestWallCollisionBehaviour {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testGetTypeCollidedWith() {
		com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour cb =
				mock(com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour.class);
		AdjustVelocityDelegate del = new AdjustVelocityDelegateStub();
		InternalPaddle paddle = new InternalPaddleStub();
		CollisionBehaviour<Wall> wcb = new WallCollisionBehaviour(cb, del, paddle);
		Assert.assertEquals(Wall.class, wcb.getTypeCollidedWith());
	}
	
	@Test
	public void testCollide() {
		com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour cb =
				mock(com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour.class);
		AdjustVelocityDelegate del = new AdjustVelocityDelegateStub();
		InternalPaddle paddle = new InternalPaddleStub();
		WallCollisionBehaviour wcb = new WallCollisionBehaviour(cb, del, paddle);
		Placeable model = new PlaceableStub();
		
		wcb.collide(model);
		
		verify(cb).collide(paddle, model, del);
	}

}
