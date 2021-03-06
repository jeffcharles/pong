package com.beyondtechnicallycorrect.pong.ai;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModel;
import com.beyondtechnicallycorrect.pong.models.game.Element;
import com.beyondtechnicallycorrect.pong.models.game.MovableElement;

final class CourtViewModelStub implements CourtViewModel {

	private final MovableElement m_opponentPaddle;
	private final MovableElement m_ball;
	private final Iterable<Element> m_walls;
	
	public CourtViewModelStub(
			MovableElement opponentPaddle,
			MovableElement ball,
			Iterable<Element> walls
		) {
		
		m_opponentPaddle = opponentPaddle;
		m_ball = ball;
		m_walls = walls;
	}
	
	@Override
	public MovableElement getPlayerPaddle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovableElement getOpponentPaddle() {
		return m_opponentPaddle;
	}

	@Override
	public MovableElement getBall() {
		return m_ball;
	}

	@Override
	public Iterable<Element> getWalls() {
		return m_walls;
	}

	@Override
	public Iterable<Element> getTerminalWalls() {
		// TODO Auto-generated method stub
		return null;
	}

}
