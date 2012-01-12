package com.beyondtechnicallycorrect.pong.models.paddle;

import junit.framework.Assert;

import org.junit.Test;

public final class PaddleInstructionHolderFactoryImplIT {
	
	@Test
	public void testCreate() {
		PaddleInstructionHolderFactory factory =
				new PaddleInstructionHolderFactoryImpl();
		PaddleInstructionHolder holder = factory.create();
		Assert.assertNotNull(holder);
	}

}
