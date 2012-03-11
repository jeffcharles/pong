package com.beyondtechnicallycorrect.pong.ai;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModel;
import com.beyondtechnicallycorrect.pong.models.game.MovableElement;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;

final class AIDecisionMakerImpl implements AIDecisionMaker {

	private final AppViewModel m_appViewModel;
	
	public AIDecisionMakerImpl(
			AppViewModel appViewModel
		) {
		
		m_appViewModel = appViewModel;
	}
	
	@Override
	public void analyzeAndAct() {
		CourtViewModel courtViewModel = m_appViewModel.getViewModel();
		
		MovableElement paddle = courtViewModel.getOpponentPaddle();
		int paddleX1 = paddle.getX1();
		int paddleX2 = paddle.getX2();
		
		MovableElement ball = courtViewModel.getBall();
		int ballX1 = ball.getX1();
		int ballX2 = ball.getX2();
		
		boolean ballRightOfPaddle = paddleX2 < ballX1;
		boolean ballLeftOfPaddle = ballX2 < paddleX1;
		
		if(ballRightOfPaddle) {
			m_appViewModel.moveOpponentPaddleRight();
		} else if(ballLeftOfPaddle) {
			m_appViewModel.moveOpponentPaddleLeft();
		} else {
			m_appViewModel.stopMovingOpponentPaddle();
		}
	}

}
