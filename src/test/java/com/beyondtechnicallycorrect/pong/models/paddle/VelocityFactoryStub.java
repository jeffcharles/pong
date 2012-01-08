package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityFactory;

final class VelocityFactoryStub implements VelocityFactory {

	private final boolean m_returnPassedInVelocity;
	private final Velocity m_velocityToReturn;
	
	public VelocityFactoryStub() {
		m_returnPassedInVelocity = false;
		m_velocityToReturn = null;
	}
	
	public VelocityFactoryStub(
			Velocity velocityToReturn
		) {
		
		m_returnPassedInVelocity = true;
		m_velocityToReturn = velocityToReturn;
	}
	
	@Override
	public Velocity create(
			int xAmountToMove,
			int xFramesPerMove,
			int yAmountToMove,
			int yFramesPerMove
		) {
		
		if(m_returnPassedInVelocity) {
			return m_velocityToReturn;
		}
		
		return new VelocityStub(
				xAmountToMove,
				xFramesPerMove,
				yAmountToMove,
				yFramesPerMove
			);
	}

}
