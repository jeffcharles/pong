package com.beyondtechnicallycorrect.pong.models.frame;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;
import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelUpdater;
import com.beyondtechnicallycorrect.pong.models.player.Player;
import com.google.inject.Inject;

final class FrameRunnerImpl implements FrameRunner {

	private final CourtViewModelUpdater m_viewModel;
	private final FrameProcessorFactory m_frameProcessorFactory;
	
	private Runner m_runner;
	
	@Inject
	public FrameRunnerImpl(
			CourtViewModelUpdater viewModel,
			FrameProcessorFactory frameProcessorFactory
		) {
		
		m_viewModel = viewModel;
		m_frameProcessorFactory = frameProcessorFactory;
	}
	
	@Override
	public void initialize(
			MovableCollidable playerPaddle,
			MovableCollidable opponentPaddle,
			MovableCollidable ball,
			Iterable<Collidable> walls,
			Iterable<Collidable> terminalWalls
		) {
		
		FrameProcessor processor =
				m_frameProcessorFactory.create(
						playerPaddle,
						opponentPaddle,
						ball,
						walls,
						terminalWalls
					);
		m_runner = new Runner(
				processor,
				m_viewModel
			);
	}
	
	@Override
	public void matchStarting() {
		start();
	}
	
	@Override
	public void matchEndingWithNoWinner() {
		stop();
	}

	@Override
	public void matchEndingWithWinner(Player winningPlayer) {
		stop();
	}
	
	private void start() {
		assert(m_runner != null);
		assert(!m_runner.getMatchRunning());
		m_runner.setMatchRunning(true);
		new Thread(m_runner, "Frame processing").start();
	}

	private void stop() {
		assert(m_runner != null);
		assert(m_runner.getMatchRunning());
		m_runner.setMatchRunning(false);
	}
	
	private class Runner implements Runnable {
		
		private final CourtViewModelUpdater m_viewModel;
		
		private FrameProcessor m_frameProcessor;
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
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
				}
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
