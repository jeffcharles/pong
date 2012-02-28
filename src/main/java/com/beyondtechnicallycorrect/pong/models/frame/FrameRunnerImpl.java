package com.beyondtechnicallycorrect.pong.models.frame;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelUpdater;
import com.beyondtechnicallycorrect.pong.models.player.Player;

final class FrameRunnerImpl implements FrameRunner {

	private final Runner m_runner;
	
	public FrameRunnerImpl(
			FrameProcessor frameProcessor,
			CourtViewModelUpdater viewModel
		) {
		
		m_runner = new Runner(
				frameProcessor,
				viewModel
			);
	}
	
	@Override
	public void matchStarting() {
		start();
	}

	@Override
	public void matchEnding(Player winningPlayer) {
		stop();
	}
	
	private void start() {
		assert(!m_runner.getMatchRunning());
		m_runner.setMatchRunning(true);
		m_runner.run();
	}

	private void stop() {
		assert(m_runner.getMatchRunning());
		m_runner.setMatchRunning(false);
	}
	
	private class Runner implements Runnable {
		
		private final FrameProcessor m_frameProcessor;
		private final CourtViewModelUpdater m_viewModel;
		
		private boolean m_matchRunning;
		
		public Runner(
				FrameProcessor frameProcessor,
				CourtViewModelUpdater viewModel
			) {
			
			m_frameProcessor = frameProcessor;
			m_viewModel = viewModel;
			
			m_matchRunning = false;
		}

		@Override
		public void run() {
			while(m_matchRunning) {
				m_frameProcessor.processFrame();
				m_viewModel.update();
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
