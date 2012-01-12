package com.beyondtechnicallycorrect.pong.models.collision;

import org.junit.Test;

import junit.framework.Assert;

public final class CollisionBehavioursFactoryImplIT {
	
	@Test
	public void testCreate() {
		CollisionBehavioursFactory factory =
				new CollisionBehavioursFactoryImpl();
		CollisionBehaviours cb = factory.create();
		Assert.assertNotNull(cb);
	}

}
