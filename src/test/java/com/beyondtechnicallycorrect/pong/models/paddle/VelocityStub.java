package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityResult;

final class VelocityStub implements Velocity {
	
	private final int m_xAmountToMove;
	private final int m_xFramesPerMove;
	private final int m_yAmountToMove;
	private final int m_yFramesPerMove;
	
	public VelocityStub(
			int xAmountToMove,
			int xFramesPerMove,
			int yAmountToMove,
			int yFramesPerMove
		) {
		
		m_xAmountToMove = xAmountToMove;
		m_xFramesPerMove = xFramesPerMove;
		m_yAmountToMove = yAmountToMove;
		m_yFramesPerMove = yFramesPerMove;
	}

	@Override
	public VelocityResult move() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VelocityResult unMove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getXAmountToMove() {
		return m_xAmountToMove;
	}

	@Override
	public int getXFramesPerMove() {
		return m_xFramesPerMove;
	}

	@Override
	public int getYAmountToMove() {
		return m_yAmountToMove;
	}

	@Override
	public int getYFramesPerMove() {
		return m_yFramesPerMove;
	}

}
