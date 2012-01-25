package com.beyondtechnicallycorrect.pong.models.velocity;

final class VelocityViewerImpl implements VelocityViewer {
	
	private final VelocityInfo m_velocityInfo;
	
	public VelocityViewerImpl(
			VelocityInfo velocityInfo
		) {
		
		m_velocityInfo = velocityInfo;
	}

	@Override
	public double getXVelocity() {
		double xAmountToMove = m_velocityInfo.getXAmountToMove();
		double xFramesPerMove = m_velocityInfo.getXFramesPerMove();
		assert(xFramesPerMove != 0);
		return xAmountToMove / xFramesPerMove;
	}

	@Override
	public double getYVelocity() {
		double yAmountToMove = m_velocityInfo.getYAmountToMove();
		double yFramesPerMove = m_velocityInfo.getYFramesPerMove();
		assert(yFramesPerMove != 0);
		return yAmountToMove / yFramesPerMove;
	}

}
