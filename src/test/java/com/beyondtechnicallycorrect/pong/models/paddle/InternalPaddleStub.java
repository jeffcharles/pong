package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

final class InternalPaddleStub implements InternalPaddle {

	private final int m_x1;
	private final int m_x2;
	private final int m_y1;
	private final int m_y2;
	private final boolean m_isOverlapping;
	private final int m_xAmountToMove;
	private final int m_xFramesPerMove;
	private final int m_yAmountToMove;
	private final int m_yFramesPerMove;
	
	private boolean m_setVelocity_called;
	private int m_setVelocity_xAmountToMoveArg;
	private int m_setVelocity_xFramesPerMoveArg;
	private int m_setVelocity_yAmountToMoveArg;
	private int m_setVelocity_yFramesPerMoveArg;
	
	public InternalPaddleStub() {
		m_x1 = 0;
		m_x2 = 0;
		m_y1 = 0;
		m_y2 = 0;
		m_isOverlapping = false;
		m_xAmountToMove = 0;
		m_xFramesPerMove = 0;
		m_yAmountToMove = 0;
		m_yFramesPerMove = 0;
		
		m_setVelocity_called = false;
	}
	
	public InternalPaddleStub(
			int x1,
			int x2,
			int y1,
			int y2
		) {
		
		m_x1 = x1;
		m_x2 = x2;
		m_y1 = y1;
		m_y2 = y2;
		m_isOverlapping = false;
		m_xAmountToMove = 0;
		m_xFramesPerMove = 0;
		m_yAmountToMove = 0;
		m_yFramesPerMove = 0;
		
		m_setVelocity_called = false;
	}
	
	public InternalPaddleStub(
			boolean isOverlapping
		) {
		
		m_x1 = 0;
		m_x2 = 0;
		m_y1 = 0;
		m_y2 = 0;
		m_isOverlapping = isOverlapping;
		m_xAmountToMove = 0;
		m_xFramesPerMove = 0;
		m_yAmountToMove = 0;
		m_yFramesPerMove = 0;
		
		m_setVelocity_called = false;
	}
	
	public InternalPaddleStub(
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
		m_isOverlapping = false;
		m_xAmountToMove = xAmountToMove;
		m_xFramesPerMove = xFramesPerMove;
		m_yAmountToMove = yAmountToMove;
		m_yFramesPerMove = yFramesPerMove;
		
		m_setVelocity_called = false;
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
	public boolean isOverlapping(Placeable otherModel) {
		return m_isOverlapping;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unMove() {
		// TODO Auto-generated method stub

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
	public void setVelocity(
			int xAmountToMove,
			int xFramesPerMove,
			int yAmountToMove,
			int yFramesPerMove
		) {
		
		m_setVelocity_called = true;
		m_setVelocity_xAmountToMoveArg = xAmountToMove;
		m_setVelocity_xFramesPerMoveArg = xFramesPerMove;
		m_setVelocity_yAmountToMoveArg = yAmountToMove;
		m_setVelocity_yFramesPerMoveArg = yFramesPerMove;
	}
	
	public boolean getSetVelocityCalled() {
		return m_setVelocity_called;
	}
	
	public int getSetVelocityXAmountToMoveArg() {
		return m_setVelocity_xAmountToMoveArg;
	}
	
	public int getSetVelocityXFramesPerMoveArg() {
		return m_setVelocity_xFramesPerMoveArg;
	}
	
	public int getSetVelocityYAmountToMoveArg() {
		return m_setVelocity_yAmountToMoveArg;
	}
	
	public int getSetVelocityYFramesPerMoveArg() {
		return m_setVelocity_yFramesPerMoveArg;
	}

}
