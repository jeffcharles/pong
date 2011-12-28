package com.beyondtechnicallycorrect.pong.models.velocity;

final class VelocityImpl implements Velocity {

	private final DirectionalVelocity m_velocityX;
	private final DirectionalVelocity m_velocityY;
	
	public VelocityImpl(
			DirectionalVelocity velocityX,
			DirectionalVelocity velocityY
		) {
		
		m_velocityX = velocityX;
		m_velocityY = velocityY;
	}
	
	@Override
	public int getXAmountToMove() {
		return m_velocityX.getAmountToMove();
	}

	@Override
	public int getXFramesPerMove() {
		return m_velocityX.getFramesPerMove();
	}

	@Override
	public int getYAmountToMove() {
		return m_velocityY.getAmountToMove();
	}

	@Override
	public int getYFramesPerMove() {
		return m_velocityY.getFramesPerMove();
	}

	@Override
	public VelocityResult move() {
		int xAmountMoved = m_velocityX.move();
		int yAmountMoved = m_velocityY.move();
		return new VelocityResult(xAmountMoved, yAmountMoved);
	}

	@Override
	public VelocityResult unMove() {
		int xAmountUnMoved = m_velocityX.unMove();
		int yAmountUnMoved = m_velocityY.unMove();
		return new VelocityResult(xAmountUnMoved, yAmountUnMoved);
	}

}
