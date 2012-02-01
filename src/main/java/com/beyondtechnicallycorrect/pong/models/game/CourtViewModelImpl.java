package com.beyondtechnicallycorrect.pong.models.game;

final class CourtViewModelImpl implements CourtViewModel {
	
	private final MovableElement m_playerPaddle;
	private final MovableElement m_opponentPaddle;
	private final MovableElement m_ball;
	private final Iterable<Element> m_walls;
	private final Iterable<Element> m_terminalWalls;
	
	public CourtViewModelImpl(
			MovableElement playerPaddle,
			MovableElement opponentPaddle,
			MovableElement ball,
			Iterable<Element> walls,
			Iterable<Element> terminalWalls
		) {
		
		m_playerPaddle = playerPaddle;
		m_opponentPaddle = opponentPaddle;
		m_ball = ball;
		m_walls = walls;
		m_terminalWalls = terminalWalls;
	}

	@Override
	public MovableElement getPlayerPaddle() {
		return m_playerPaddle;
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
		return m_terminalWalls;
	}

}
