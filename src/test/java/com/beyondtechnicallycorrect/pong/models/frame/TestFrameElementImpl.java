package com.beyondtechnicallycorrect.pong.models.frame;

import static org.mockito.Mockito.*;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;

public final class TestFrameElementImpl {
	
	@Test
	public void isOverlapping_WithMovableElementAndUnderlyingReturnsTrue_ShouldReturnTrue() {
		MovableCollidable mc = new MovableCollidableStub(true);
		FrameElement fe = new FrameElementImpl(mc);
		
		FrameElement other = new FrameElementStub();
		
		boolean result = fe.isOverlapping(other);
		
		Assert.assertTrue(result);
	}
	
	@Test
	public void isOverlapping_WithMovableElementAndUnderlyingReturnsFalse_ShouldReturnFalse() {
		MovableCollidable mc = new MovableCollidableStub(false);
		FrameElement fe = new FrameElementImpl(mc);
		
		FrameElement other = new FrameElementStub();
		
		boolean result = fe.isOverlapping(other);
		
		Assert.assertFalse(result);
	}
	
	@Test
	public void move_WithMovableElement_ShouldCallMoveOnUnderlying() {
		MovableCollidable mc = mock(MovableCollidable.class);
		FrameElement fe = new FrameElementImpl(mc);
		
		fe.move();
		
		verify(mc).move();
	}
	
	@Test
	public void move_WithNonmovableElement_ShouldNotThrowAnException() {
		Collidable c = new CollidableStub();
		FrameElement fe = new FrameElementImpl(c);
		
		fe.move();
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void unMove_WithMovableElement_ShouldCallUnMoveOnUnderlying() {
		MovableCollidable mc = mock(MovableCollidable.class);
		FrameElement fe = new FrameElementImpl(mc);
		
		fe.unMove();
		
		verify(mc).unMove();
	}
	
	@Test
	public void unMove_WithNonmovableElement_ShouldNotThrowAnException() {
		Collidable c = new CollidableStub();
		FrameElement fe = new FrameElementImpl(c);
		
		fe.unMove();
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void collide_WithMovableElement_ShouldCallCollideOnUnderlying() {
		MovableCollidable mc = mock(MovableCollidable.class);
		FrameElement fe = new FrameElementImpl(mc);
		
		Collidable stub = new CollidableStub();
		FrameElement other = new FrameElementImpl(stub);
		
		fe.collide(other);
		
		verify(mc).collide(stub);
	}
	
	@Test
	public void collide_WithNonmovableElement_ShouldCallCollideOnUnderlying() {
		Collidable c = mock(Collidable.class);
		FrameElement fe = new FrameElementImpl(c);
		
		Collidable stub = new CollidableStub();
		FrameElement other = new FrameElementImpl(stub);
		
		fe.collide(other);
		
		verify(c).collide(stub);
	}
	
	@Test
	public void getUnderlyingCollidable_WhenConstructedWithMovable_ShouldReturnSame() {
		MovableCollidable mc = new MovableCollidableStub();
		FrameElement fe = new FrameElementImpl(mc);
		
		Collidable result = fe.getUnderlyingCollidable();
		
		Assert.assertSame(mc, result);
	}
	
	@Test
	public void getUnderlyingCollidable_WhenConstructedWithNonmovable_ShouldReturnSame() {
		Collidable c = new CollidableStub();
		FrameElement fe = new FrameElementImpl(c);
		
		Collidable result = fe.getUnderlyingCollidable();
		
		Assert.assertSame(c, result);
	}

}
