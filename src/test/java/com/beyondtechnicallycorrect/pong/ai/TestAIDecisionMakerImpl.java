package com.beyondtechnicallycorrect.pong.ai;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModel;
import com.beyondtechnicallycorrect.pong.models.game.Element;
import com.beyondtechnicallycorrect.pong.models.game.MovableElement;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;

public final class TestAIDecisionMakerImpl {
	
	@Test
	public void analyzeAndAct_WhenBallIsHeadingUpAndPaddleIsLeftOfCentre_ShouldMoveRightToCentre() {
		final int PADDLE_X1 = 250;
		final int PADDLE_X2 = 260;
		AppViewModel appViewModel =
				getAppViewModelWithNegativeBallVelocity(PADDLE_X1, PADDLE_X2);
		BallDestinationCalculator ballDestCalc =
				new BallDestinationCalculatorStub();
		AIDecisionMaker decisionMaker =
				new AIDecisionMakerImpl(appViewModel, ballDestCalc);
		
		decisionMaker.analyzeAndAct();
		
		verify(appViewModel).moveOpponentPaddleRight();
	}
	
	@Test
	public void analyzeAndAct_WhenBallIsHeadingUpAndPaddleIsRightOfCentre_ShouldMoveLeftToCentre() {
		final int PADDLE_X1 = 750;
		final int PADDLE_X2 = 760;
		AppViewModel appViewModel =
				getAppViewModelWithNegativeBallVelocity(PADDLE_X1, PADDLE_X2);
		BallDestinationCalculator ballDestCalc =
				new BallDestinationCalculatorStub();
		AIDecisionMaker decisionMaker =
				new AIDecisionMakerImpl(appViewModel, ballDestCalc);
		
		decisionMaker.analyzeAndAct();
		
		verify(appViewModel).moveOpponentPaddleLeft();
	}
	
	@Test
	public void analyzeAndAct_WhenBallIsHeadingUpAndPaddleIsAtCentre_ShouldStayAtCentre() {
		final int PADDLE_X1 = 480;
		final int PADDLE_X2 = 520;
		AppViewModel appViewModel =
				getAppViewModelWithNegativeBallVelocity(PADDLE_X1, PADDLE_X2);
		BallDestinationCalculator ballDestCalc =
				new BallDestinationCalculatorStub();
		AIDecisionMaker decisionMaker =
				new AIDecisionMakerImpl(appViewModel, ballDestCalc);
		
		decisionMaker.analyzeAndAct();
		
		verify(appViewModel).stopMovingOpponentPaddle();
	}
	
	@Test
	public void analyzeAndAct_WhenBallIsHeadingDownAndBallDestCalcSaysFinalXIsLeft_ShouldMoveLeft() {
		final int PADDLE_X1 = 480;
		final int PADDLE_X2 = 520;
		final int DEST_X = 300;
		AppViewModel appViewModel =
				getAppViewModelWithPositiveBallVelocity(PADDLE_X1, PADDLE_X2);
		BallDestinationCalculator ballDestCalc =
				new BallDestinationCalculatorStub(DEST_X);
		AIDecisionMaker decisionMaker =
				new AIDecisionMakerImpl(appViewModel, ballDestCalc);
		
		decisionMaker.analyzeAndAct();
		
		verify(appViewModel).moveOpponentPaddleLeft();
	}
	
	@Test
	public void analyzeAndAct_WhenBallIsHeadingDownAndBallDestCalcSaysFinalXIsRight_ShouldMoveRight() {
		final int PADDLE_X1 = 480;
		final int PADDLE_X2 = 520;
		final int DEST_X = 700;
		AppViewModel appViewModel =
				getAppViewModelWithPositiveBallVelocity(PADDLE_X1, PADDLE_X2);
		BallDestinationCalculator ballDestCalc =
				new BallDestinationCalculatorStub(DEST_X);
		AIDecisionMaker decisionMaker =
				new AIDecisionMakerImpl(appViewModel, ballDestCalc);
		
		decisionMaker.analyzeAndAct();
		
		verify(appViewModel).moveOpponentPaddleRight();
	}
	
	@Test
	public void analyzeAndAct_WhenBallIsHeadingDownAndBallDestCalcSaysFinalXIsCurrentPosition_ShouldStopMoving() {
		final int PADDLE_X1 = 480;
		final int PADDLE_X2 = 520;
		final int DEST_X = 500;
		AppViewModel appViewModel =
				getAppViewModelWithPositiveBallVelocity(PADDLE_X1, PADDLE_X2);
		BallDestinationCalculator ballDestCalc =
				new BallDestinationCalculatorStub(DEST_X);
		AIDecisionMaker decisionMaker =
				new AIDecisionMakerImpl(appViewModel, ballDestCalc);
		
		decisionMaker.analyzeAndAct();
		
		verify(appViewModel).stopMovingOpponentPaddle();
	}
	
	private AppViewModel getAppViewModelWithPositiveBallVelocity(
			int paddleX1,
			int paddleX2
		) {
		
		AppViewModel viewModel = getAppViewModel(paddleX1, paddleX2, 3.0);
		return viewModel;
	}
	
	private AppViewModel getAppViewModelWithNegativeBallVelocity(
			int paddleX1,
			int paddleX2
		) {
		
		AppViewModel viewModel = getAppViewModel(paddleX1, paddleX2, -3.0);
		return viewModel;
	}
	
	private AppViewModel getAppViewModel(
			int paddleX1,
			int paddleX2,
			double ballYVelocity
		) {
		
		MovableElement paddle =
				new MovableElementStub(paddleX1, paddleX2, 0, 0);
		MovableElement ball =
				new MovableElementStub(0, 0, 0, 0, 0, ballYVelocity);
		Element wall = new ElementStub();
		Collection<Element> walls = new ArrayList<Element>();
		walls.add(wall);
		CourtViewModel courtViewModel =
				new CourtViewModelStub(paddle, ball, walls);
		AppViewModel appViewModel = mock(AppViewModel.class);
		when(appViewModel.getViewModel()).thenReturn(courtViewModel);
		
		return appViewModel;
	}

}
