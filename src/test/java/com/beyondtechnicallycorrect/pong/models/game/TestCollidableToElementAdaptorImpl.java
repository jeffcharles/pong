package com.beyondtechnicallycorrect.pong.models.game;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;

public final class TestCollidableToElementAdaptorImpl {
	
	@Test
	public void getElementFromCollidable_X1ShouldBeTheSame() {
		final int X1 = 1;
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorImpl();
		Collidable collidable = new CollidableStub(X1, 0, 0, 0);
		
		Element elem = adaptor.getElementFromCollidable(collidable);
		
		Assert.assertEquals(X1, elem.getX1());
	}
	
	@Test
	public void getElementFromCollidable_X2ShouldBeTheSame() {
		final int X2 = 2;
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorImpl();
		Collidable collidable = new CollidableStub(0, X2, 0, 0);
		
		Element elem = adaptor.getElementFromCollidable(collidable);
		
		Assert.assertEquals(X2, elem.getX2());
	}
	
	@Test
	public void getElementFromCollidable_Y1ShouldBeTheSame() {
		final int Y1 = 3;
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorImpl();
		Collidable collidable = new CollidableStub(0, 0, Y1, 0);
		
		Element elem = adaptor.getElementFromCollidable(collidable);
		
		Assert.assertEquals(Y1, elem.getY1());
	}
	
	@Test
	public void getElementFromCollidable_Y2ShouldBeTheSame() {
		final int Y2 = 4;
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorImpl();
		Collidable collidable = new CollidableStub(0, 0, 0, Y2);
		
		Element elem = adaptor.getElementFromCollidable(collidable);
		
		Assert.assertEquals(Y2, elem.getY2());
	}
	
	@Test
	public void getMovableElementFromMovableCollidable_X1ShouldBeTheSame() {
		final int X1 = 1;
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorImpl();
		MovableCollidable mc =
				new MovableCollidableStub(X1, 0, 0, 0, 0, 1, 0, 1);
		
		MovableElement elem =
				adaptor.getMovableElementFromMovableCollidable(mc);
		
		Assert.assertEquals(X1, elem.getX1());
	}
	
	@Test
	public void getMovableElementFromMovableCollidable_X2ShouldBeTheSame() {
		final int X2 = 2;
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorImpl();
		MovableCollidable mc =
				new MovableCollidableStub(0, X2, 0, 0, 0, 1, 0, 1);
		
		MovableElement elem =
				adaptor.getMovableElementFromMovableCollidable(mc);
		
		Assert.assertEquals(X2, elem.getX2());
	}
	
	@Test
	public void getMovableElementFromMovableCollidable_Y1ShouldBeTheSame() {
		final int Y1 = 3;
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorImpl();
		MovableCollidable mc =
				new MovableCollidableStub(0, 0, Y1, 0, 0, 1, 0, 1);
		
		MovableElement elem =
				adaptor.getMovableElementFromMovableCollidable(mc);
		
		Assert.assertEquals(Y1, elem.getY1());
	}
	
	@Test
	public void getMovableElementFromMovableCollidable_Y2ShouldBeTheSame() {
		final int Y2 = 4;
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorImpl();
		MovableCollidable mc =
				new MovableCollidableStub(0, 0, 0, Y2, 0, 1, 0, 1);
		
		MovableElement elem =
				adaptor.getMovableElementFromMovableCollidable(mc);
		
		Assert.assertEquals(Y2, elem.getY2());
	}
	
	@Test
	public void getMovableElementFromMovableCollidable_XVelocityShouldMatchUp() {
		final int X_AMOUNT = 1;
		final int X_FRAMES = 2;
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorImpl();
		MovableCollidable mc =
				new MovableCollidableStub(0, 0, 0, 0, X_AMOUNT, X_FRAMES, 0, 1);
		
		MovableElement elem =
				adaptor.getMovableElementFromMovableCollidable(mc);
		
		Assert.assertEquals(0.5, elem.getXVelocity(), 0.05);
	}
	
	@Test
	public void getMovableElementFromMovableCollidable_YVelocityShouldMatchUp() {
		final int Y_AMOUNT = 2;
		final int Y_FRAMES = 1;
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorImpl();
		MovableCollidable mc =
				new MovableCollidableStub(0, 0, 0, 0, 0, 1, Y_AMOUNT, Y_FRAMES);
		
		MovableElement elem =
				adaptor.getMovableElementFromMovableCollidable(mc);
		
		Assert.assertEquals(2.0, elem.getYVelocity(), 0.05);
	}

}
