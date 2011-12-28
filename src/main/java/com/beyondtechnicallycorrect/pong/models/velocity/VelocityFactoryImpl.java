package com.beyondtechnicallycorrect.pong.models.velocity;

import com.google.inject.Inject;

public final class VelocityFactoryImpl implements VelocityFactory {
	
	private final Sanitizer m_sanitizer;
	
	@Inject
	public VelocityFactoryImpl(
			Sanitizer sanitizer
		) {
		
		m_sanitizer = sanitizer;
	}

	@Override
	public Velocity create(
			int xAmountToMove,
			int xFramesPerMove,
			int yAmountToMove,
			int yFramesPerMove
		) {
		
		DirectionalVelocityInfo xVelocityInfo =
				new DirectionalVelocityInfo(xAmountToMove, xFramesPerMove);
		DirectionalVelocityInfo yVelocityInfo =
				new DirectionalVelocityInfo(yAmountToMove, yFramesPerMove);
		
		DirectionalVelocityInfo sanitizedXVelocity =
				m_sanitizer.sanitize(xVelocityInfo);
		DirectionalVelocityInfo sanitizedYVelocity =
				m_sanitizer.sanitize(yVelocityInfo);
		
		DirectionalVelocity xVelocity =
				new DirectionalVelocity(sanitizedXVelocity);
		DirectionalVelocity yVelocity =
				new DirectionalVelocity(sanitizedYVelocity);
		
		Velocity velocity = new VelocityImpl(xVelocity, yVelocity);
		return velocity;
	}

}
