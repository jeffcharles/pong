package com.beyondtechnicallycorrect.pong.models.paddle;

import junit.framework.Assert;

import org.junit.Test;

public final class TestPaddleInstructionHolder {
	
	@Test
	public void testGetPaddleInstruction() {
		PaddleInstructionGetter holder = new PaddleInstructionHolderImpl();
		PaddleInstruction currentInstruction = holder.getPaddleInstruction();
		Assert.assertEquals(PaddleInstruction.STATIONARY, currentInstruction);
	}
	
	@Test
	public void testSetPaddleInstruction() {
		PaddleInstructionHolderImpl holder = new PaddleInstructionHolderImpl();
		PaddleInstructionSetter setter = holder;
		final PaddleInstruction INSTRUCTION = PaddleInstruction.POS;
		setter.setPaddleInstruction(INSTRUCTION);
		Assert.assertEquals(INSTRUCTION, holder.getPaddleInstruction());
	}

}
