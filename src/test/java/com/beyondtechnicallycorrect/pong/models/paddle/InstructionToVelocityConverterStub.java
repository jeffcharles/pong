package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;

final class InstructionToVelocityConverterStub implements
		InstructionToVelocityConverter {

	private final boolean m_velocityPassedIn;
	private final Velocity m_velocityToReturn;
	
	public InstructionToVelocityConverterStub() {
		m_velocityPassedIn = false;
		m_velocityToReturn = null;
	}
	
	public InstructionToVelocityConverterStub(
			Velocity velocityToReturn
		) {
		
		m_velocityPassedIn = true;
		m_velocityToReturn = velocityToReturn;
	}
	
	@Override
	public Velocity convertInstructionToVelocity(
			PaddleInstruction instruction,
			Velocity currentVelocity
		) {
		
		if(m_velocityPassedIn) {
			return m_velocityToReturn;
		}
		
		return currentVelocity;
	}

}
