package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

final class InternalBallStub implements InternalBall {

	private final int m_x1;
	private final int m_x2;
	private final int m_y1;
	private final int m_y2;
	
	private final int m_xAmountToMove;
	private final int m_xFramesPerMove;
	private final int m_yAmountToMove;
	private final int m_yFramesPerMove;
	
	private final boolean m_isOverlapping;
	
	private boolean m_setVelocityCalled;
	private int m_setVelocityXAmountArg;
	private int m_setVelocityXFramesArg;
	private int m_setVelocityYAmountArg;
	private int m_setVelocityYFramesArg;
	
	public InternalBallStub() {
		m_x1 = 0;
		m_x2 = 0;
		m_y1 = 0;
		m_y2 = 0;
		
		m_xAmountToMove = 0;
		m_xFramesPerMove = 0;
		m_yAmountToMove = 0;
		m_yFramesPerMove = 0;
		
		m_isOverlapping = false;
		
		m_setVelocityCalled = false;
		m_setVelocityXAmountArg = 0;
		m_setVelocityXFramesArg = 0;
		m_setVelocityYAmountArg = 0;
		m_setVelocityYFramesArg = 0;
	}
	
	public InternalBallStub(
			int x1,
			int x2,
			int y1,
			int y2
		) {
		
		m_x1 = x1;
		m_x2 = x2;
		m_y1 = y1;
		m_y2 = y2;
		
		m_xAmountToMove = 0;
		m_xFramesPerMove = 0;
		m_yAmountToMove = 0;
		m_yFramesPerMove = 0;
		
		m_isOverlapping = false;
		
		m_setVelocityCalled = false;
		m_setVelocityXAmountArg = 0;
		m_setVelocityXFramesArg = 0;
		m_setVelocityYAmountArg = 0;
		m_setVelocityYFramesArg = 0;
	}
	
	public InternalBallStub(
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
		
		m_isOverlapping = false;
		
		m_setVelocityXAmountArg = 0;
		m_setVelocityXFramesArg = 0;
		m_setVelocityYAmountArg = 0;
		m_setVelocityYFramesArg = 0;
	}
	
	public InternalBallStub(
			boolean isOverlapping
		) {
		
		m_x1 = 0;
		m_x2 = 0;
		m_y1 = 0;
		m_y2 = 0;
		
		m_xAmountToMove = 0;
		m_xFramesPerMove = 0;
		m_yAmountToMove = 0;
		m_yFramesPerMove = 0;
		
		m_isOverlapping = isOverlapping;
		
		m_setVelocityCalled = false;
		m_setVelocityXAmountArg = 0;
		m_setVelocityXFramesArg = 0;
		m_setVelocityYAmountArg = 0;
		m_setVelocityYFramesArg = 0;
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
	public void setVelocity(
			int xAmountToMove,
			int xFramesPerMove,
			int yAmountToMove,
			int yFramesPerMove
		) {
		
		m_setVelocityCalled = true;
		m_setVelocityXAmountArg = xAmountToMove;
		m_setVelocityXFramesArg = xFramesPerMove;
		m_setVelocityYAmountArg = yAmountToMove;
		m_setVelocityYFramesArg = yFramesPerMove;
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
	
	public boolean getSetVelocityCalled() {
		return m_setVelocityCalled;
	}
	
	public int getSetVelocityXAmountArg() {
		return m_setVelocityXAmountArg;
	}
	
	public int getSetVelocityXFramesArg() {
		return m_setVelocityXFramesArg;
	}
	
	public int getSetVelocityYAmountArg() {
		return m_setVelocityYAmountArg;
	}
	
	public int getSetVelocityYFramesArg() {
		return m_setVelocityYFramesArg;
	}

}
