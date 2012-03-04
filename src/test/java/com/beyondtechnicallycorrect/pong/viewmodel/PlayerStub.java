package com.beyondtechnicallycorrect.pong.viewmodel;

import com.beyondtechnicallycorrect.pong.models.player.Player;

final class PlayerStub implements Player {

	private final int m_score;
	
	public PlayerStub() {
		m_score = 0;
	}
	
	public PlayerStub(int score) {
		m_score = score;
	}
	
	@Override
	public int getScore() {
		return m_score;
	}

	@Override
	public void incrementScore() {
		// TODO Auto-generated method stub

	}

}
