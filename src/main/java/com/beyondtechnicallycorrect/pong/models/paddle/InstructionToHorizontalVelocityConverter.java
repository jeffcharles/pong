package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityFactory;

final class InstructionToHorizontalVelocityConverter implements
		InstructionToVelocityConverter {
	
	final int X_POS = 1;
	final int X_STATIONARY = 0;
	final int X_NEG = -1;
	
	private final VelocityFactory m_velocityFactory;
	
	public InstructionToHorizontalVelocityConverter(
			VelocityFactory velocityFactory
		) {
		
		m_velocityFactory = velocityFactory;
	}

	@Override
	public Velocity convertInstructionToVelocity(
			PaddleInstruction instruction,
			Velocity currentVelocity
		) {
		
		int xAmount =
				instruction == PaddleInstruction.POS ?
						X_POS :
						instruction == PaddleInstruction.NEG ?
								X_NEG :
								X_STATIONARY;
		
		if(xAmount == currentVelocity.getXAmountToMove()) {
			return currentVelocity;
		}
		
		Velocity vel = m_velocityFactory.create(xAmount, 1, 0, 1);
		return vel;
	}

}
