package com.beyondtechnicallycorrect.pong.models.frame;

import junit.framework.Assert;

import org.junit.Test;

public final class TestCollisionPair {
	
	@Test
	public void getFirst() {
		FrameElement fe = new FrameElementStub();
		CollisionPair pair = new CollisionPair(fe, null);
		
		Assert.assertEquals(fe, pair.getFirst());
	}
	
	@Test
	public void getSecond() {
		FrameElement fe = new FrameElementStub();
		CollisionPair pair = new CollisionPair(null, fe);
		
		Assert.assertEquals(fe, pair.getSecond());
	}
	
	@Test
	public void equals_WhenDifferentType_ShouldReturnFalse() {
		CollisionPair pair = new CollisionPair(null, null);
		Assert.assertFalse(pair.equals(new Object()));
	}
	
	@Test
	public void equals_WhenSameElementsInPairInSameOrder_ShouldReturnTrue() {
		FrameElement fe1 = new FrameElementStub();
		FrameElement fe2 = new FrameElementStub();
		CollisionPair pair1 = new CollisionPair(fe1, fe2);
		CollisionPair pair2 = new CollisionPair(fe1, fe2);
		
		Assert.assertTrue(pair1.equals(pair2));
	}
	
	@Test
	public void equals_WhenSameElementsInPairInOppositeOrder_ShouldReturnTrue() {
		FrameElement fe1 = new FrameElementStub();
		FrameElement fe2 = new FrameElementStub();
		CollisionPair pair1 = new CollisionPair(fe1, fe2);
		CollisionPair pair2 = new CollisionPair(fe2, fe1);
		
		Assert.assertTrue(pair1.equals(pair2));
	}
	
	@Test
	public void equals_WhenOneElementDifferentInPairButInSamePosition_ShouldReturnFalse() {
		FrameElement fe1 = new FrameElementStub();
		FrameElement fe2 = new FrameElementStub();
		FrameElement fe3 = new FrameElementStub();
		CollisionPair pair1 = new CollisionPair(fe1, fe2);
		CollisionPair pair2 = new CollisionPair(fe1, fe3);
		
		Assert.assertFalse(pair1.equals(pair2));
	}
	
	@Test
	public void equals_WhenOneElementDifferentInPairButInDifferentPosition_ShouldReturnFalse() {
		FrameElement fe1 = new FrameElementStub();
		FrameElement fe2 = new FrameElementStub();
		FrameElement fe3 = new FrameElementStub();
		CollisionPair pair1 = new CollisionPair(fe1, fe2);
		CollisionPair pair2 = new CollisionPair(fe3, fe1);
		
		Assert.assertFalse(pair1.equals(pair2));
	}
	
	@Test
	public void equals_WhenDifferentElementsInPair_ShouldReturnFalse() {
		FrameElement fe1 = new FrameElementStub();
		FrameElement fe2 = new FrameElementStub();
		FrameElement fe3 = new FrameElementStub();
		FrameElement fe4 = new FrameElementStub();
		CollisionPair pair1 = new CollisionPair(fe1, fe2);
		CollisionPair pair2 = new CollisionPair(fe3, fe4);
		
		Assert.assertFalse(pair1.equals(pair2));
	}

}
