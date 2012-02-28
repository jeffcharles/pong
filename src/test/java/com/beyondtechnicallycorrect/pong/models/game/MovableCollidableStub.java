package com.beyondtechnicallycorrect.pong.models.game;

import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

final class MovableCollidableStub implements MovableCollidable {

	private int m_x1;
	private final int m_x2;
	private final int m_y1;
	private final int m_y2;
	private final int m_xAmountToMove;
	private final int m_xFramesPerMove;
	private final int m_yAmountToMove;
	private final int m_yFramesPerMove;
	
	public MovableCollidableStub(
			int x1
		) {
		
		m_x1 = x1;
		m_x2 = 0;
		m_y1 = 0;
		m_y2 = 0;
		m_xAmountToMove = 0;
		m_xFramesPerMove = 0;
		m_yAmountToMove = 0;
		m_yFramesPerMove = 0;
	}
	
	public MovableCollidableStub(
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
	}
	
	@Override
	public void collide(Placeable objectCollidedWith) {
		// TODO Auto-generated method stub

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
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unMove() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isOverlapping(Placeable otherModel) {
		// TODO Auto-generated method stub
		return false;
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
	
	public void setX1(int x1) {
		m_x1 = x1;
	}

}
