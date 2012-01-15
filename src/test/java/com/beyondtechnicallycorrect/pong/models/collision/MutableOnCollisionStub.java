package com.beyondtechnicallycorrect.pong.models.collision;

final class MutableOnCollisionStub implements MutableOnCollision {

	private final int m_x1;
	private final int m_x2;
	private final int m_y1;
	private final int m_y2;
	private final int m_xAmountToMove;
	private final int m_xFramesPerMove;
	private final int m_yAmountToMove;
	private final int m_yFramesPerMove;
	
	private boolean m_setVelocityCalled;
	private int m_setVelocityXAmountArg;
	private int m_setVelocityYAmountArg;
	
	public MutableOnCollisionStub(
			int x1,
			int x2,
			int y1,
			int y2,
			int xAmountToMove,
			int xFramesPerMove,
			int yAmountToMove,
			int yFramesPerMove
		) {
		
		m_x1 = x1;
		m_x2 = x2;
		m_y1 = y1;
		m_y2 = y2;
		m_xAmountToMove = xAmountToMove;
		m_xFramesPerMove = xFramesPerMove;
		m_yAmountToMove = yAmountToMove;
		m_yFramesPerMove = yFramesPerMove;
		
		m_setVelocityCalled = false;
		m_setVelocityXAmountArg = 0;
		m_setVelocityYAmountArg = 0;
	}
	
	@Override
	public int getX1() {
		return m_x1;
	}

	@Override
	public int getX2() {
		return m_x2;
	}

	@Override
	public int getY1() {
		return m_y1;
	}

	@Override
	public int getY2() {
		return m_y2;
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

	@Override
	public void setVelocity(int xAmountToMove, int xFramesPerMove,
			int yAmountToMove, int yFramesPerMove) {
		
		m_setVelocityCalled = true;
		m_setVelocityXAmountArg = xAmountToMove;
		m_setVelocityYAmountArg = yAmountToMove;
	}
	
	public boolean getSetVelocityCalled() {
		return m_setVelocityCalled;
	}
	
	public int getSetVelocityXAmountToMoveArg() {
		return m_setVelocityXAmountArg;
	}
	
	public int getSetVelocityYAmountToMoveArg() {
		return m_setVelocityYAmountArg;
	}

}
