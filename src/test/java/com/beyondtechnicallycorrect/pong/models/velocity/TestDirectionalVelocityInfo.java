package com.beyondtechnicallycorrect.pong.models.velocity;

import org.junit.*;
import org.junit.rules.ExpectedException;

public final class TestDirectionalVelocityInfo {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testCtor_WhenFramesLessThanOne_ShouldThrowIllegalArgException() {
		exception.expect(IllegalArgumentException.class);
		new DirectionalVelocityInfo(20, 0);
	}

}
