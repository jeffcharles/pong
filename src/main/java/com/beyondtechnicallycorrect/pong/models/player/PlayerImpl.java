package com.beyondtechnicallycorrect.pong.models.player;

final class PlayerImpl implements Player, Scorable, ScoreIncrementable {
	
	private int m_score;

	public PlayerImpl() {
		m_score = 0;
	}
	
	@Override
	public void incrementScore() {
		m_score++;
	}

	@Override
	public int getScore() {
		return m_score;
	}

}
