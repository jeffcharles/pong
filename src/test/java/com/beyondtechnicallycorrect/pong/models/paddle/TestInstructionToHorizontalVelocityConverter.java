package com.beyondtechnicallycorrect.pong.models.paddle;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityFactory;

public final class TestInstructionToHorizontalVelocityConverter {
	
	@Test
	public void testConvertInstructionToVelocity_WhenPosInstruction_ShouldReturnGreaterThanZeroVelocity() {
		VelocityFactory velFactory = new VelocityFactoryStub();
		InstructionToVelocityConverter converter =
				new InstructionToHorizontalVelocityConverter(velFactory);
		final int STARTING_X = -1;
		Velocity vel = new VelocityStub(STARTING_X, 1, 0, 1);
		
		final PaddleInstruction PADDLE_INSTRUCTION = PaddleInstruction.POS;
		Velocity retVel =
				converter.convertInstructionToVelocity(
						PADDLE_INSTRUCTION, vel);
		
		Assert.assertTrue(
				"Returned velocity should be greater than zero",
				retVel.getXAmountToMove() > 0
			);
	}
	
	@Test
	public void testConvertInstructionToVelocity_WhenStationaryInstruction_ShouldReturnZeroVelocity() {
		VelocityFactory velFactory = new VelocityFactoryStub();
		InstructionToVelocityConverter converter =
				new InstructionToHorizontalVelocityConverter(velFactory);
		final int STARTING_X = 1;
		Velocity vel = new VelocityStub(STARTING_X, 1, 0, 1);
		
		final PaddleInstruction PADDLE_INSTRUCTION = PaddleInstruction.STATIONARY;
		Velocity retVel =
				converter.convertInstructionToVelocity(
						PADDLE_INSTRUCTION, vel);
		
		Assert.assertEquals(
				"Returned velocity should equal zero",
				retVel.getXAmountToMove(), 0
			);
	}
	
	@Test
	public void testConvertInstructionToVelocity_WhenNegInstruction_ShouldReturnLessThanZeroVelocity() {
		VelocityFactory velFactory = new VelocityFactoryStub();
		InstructionToVelocityConverter converter =
				new InstructionToHorizontalVelocityConverter(velFactory);
		final int STARTING_X = 1;
		Velocity vel = new VelocityStub(STARTING_X, 1, 0, 1);
		
		final PaddleInstruction PADDLE_INSTRUCTION = PaddleInstruction.NEG;
		Velocity retVel =
				converter.convertInstructionToVelocity(
						PADDLE_INSTRUCTION, vel);
		
		Assert.assertTrue(
				"Returned velocity should be less than zero",
				retVel.getXAmountToMove() < 0
			);
	}
	
	@Test
	public void testConvertInstructionToVelocity_WhenVelocitySame_ShouldReturnCurrentVelocity() {
		VelocityFactory velFactory = new VelocityFactoryStub();
		InstructionToVelocityConverter converter =
				new InstructionToHorizontalVelocityConverter(velFactory);
		final int STARTING_X = 1;
		Velocity vel = new VelocityStub(STARTING_X, 1, 0, 1);
		
		final PaddleInstruction PADDLE_INSTRUCTION = PaddleInstruction.POS;
		Velocity retVel =
				converter.convertInstructionToVelocity(
						PADDLE_INSTRUCTION, vel);
		
		Assert.assertSame(vel, retVel);
	}

}
