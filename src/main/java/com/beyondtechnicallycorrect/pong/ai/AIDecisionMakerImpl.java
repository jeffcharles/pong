package com.beyondtechnicallycorrect.pong.ai;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModel;
import com.beyondtechnicallycorrect.pong.models.game.Element;
import com.beyondtechnicallycorrect.pong.models.game.MovableElement;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;

final class AIDecisionMakerImpl implements AIDecisionMaker {

	private final AppViewModel m_appViewModel;
	private final BallDestinationCalculator m_ballDestCalculator;
	
	public AIDecisionMakerImpl(
			AppViewModel appViewModel,
			BallDestinationCalculator ballDestCalculator
		) {
		
		m_appViewModel = appViewModel;
		m_ballDestCalculator = ballDestCalculator;
	}
	
	@Override
	public void analyzeAndAct() {
		CourtViewModel courtViewModel = m_appViewModel.getViewModel();
		MovableElement paddle = courtViewModel.getOpponentPaddle();
		MovableElement ball = courtViewModel.getBall();
		
		int collidingX = 500;
		boolean ballMovingTowardOpponent = ball.getYVelocity() > 0;
		if(ballMovingTowardOpponent) {
			Iterable<Element> walls = courtViewModel.getWalls();
			int courtWidth = 0;
			int wallThickness = 0;
			for(Element wall : walls) {
				if(wall.getX2() > courtWidth) {
					courtWidth = wall.getX2();
					wallThickness = wall.getX2() - wall.getX1();
				}
			}
			int paddleY1 = paddle.getY1();
			collidingX =
					m_ballDestCalculator.getXPositionOfBallDestination(
							courtWidth,
							wallThickness,
							paddleY1,
							ball
						);
		}
		
		boolean goRight = paddle.getX2() < collidingX;
		boolean goLeft = collidingX < paddle.getX1();
		
		if(goRight) {
			m_appViewModel.moveOpponentPaddleRight();
		} else if(goLeft) {
			m_appViewModel.moveOpponentPaddleLeft();
		} else {
			m_appViewModel.stopMovingOpponentPaddle();
		}
	}

}
