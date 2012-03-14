package com.beyondtechnicallycorrect.pong.ai;

import com.beyondtechnicallycorrect.pong.models.player.Player;

final class AIRunnerImpl implements AIRunner {
	
	private final Runner m_runner;
	
	public AIRunnerImpl(
			AIDecisionMaker decisionMaker
		) {
		
		m_runner = new Runner(decisionMaker);
	}

	@Override
	public void matchStarting() {
		assert(!m_runner.getMatchRunning());
		m_runner.setMatchRunning(true);
		new Thread(m_runner, "Opponent AI").start();
	}

	@Override
	public void matchEndingWithNoWinner() {
		stopAI();
	}

	@Override
	public void matchEndingWithWinner(Player winningPlayer) {
		stopAI();
	}
	
	private void stopAI() {
		assert(m_runner.getMatchRunning());
		m_runner.setMatchRunning(false);
	}
	
	private class Runner implements Runnable {
		
		private final AIDecisionMaker m_decisionMaker;
		
		private boolean m_matchRunning;
		
		public Runner(
				AIDecisionMaker decisionMaker
			) {
			
			m_decisionMaker = decisionMaker;
			
			m_matchRunning = false;
		}

		@Override
		public void run() {
			while(m_matchRunning) {
				m_decisionMaker.analyzeAndAct();
				try {
					final int MILLIS_BETWEEN = 20;
					Thread.sleep(MILLIS_BETWEEN);
				} catch (InterruptedException e) {
				}
			}
		}
		
		public boolean getMatchRunning() {
			return m_matchRunning;
		}
		
		public void setMatchRunning(boolean matchRunning) {
			m_matchRunning = matchRunning;
		}
		
	}

}
