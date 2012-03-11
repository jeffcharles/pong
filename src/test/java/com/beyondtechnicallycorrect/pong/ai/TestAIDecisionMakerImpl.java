package com.beyondtechnicallycorrect.pong.ai;

import static org.mockito.Mockito.*;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModel;
import com.beyondtechnicallycorrect.pong.models.game.MovableElement;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;

public final class TestAIDecisionMakerImpl {
	
	@Test
	public void analyzeAndAct_WhenBallIsLeftOfPaddle_ShouldMovePaddleLeft() {
		MovableElement paddle = new MovableElementStub(3, 4);
		MovableElement ball = new MovableElementStub(1, 2);
		AppViewModel appViewModel = getAppViewModel(paddle, ball);
		AIDecisionMaker decisionMaker = new AIDecisionMakerImpl(appViewModel);
		
		decisionMaker.analyzeAndAct();
		
		verify(appViewModel).moveOpponentPaddleLeft();
	}
	
	@Test
	public void analyzeAndAct_WhenBallIsRightOfPaddle_ShouldMovePaddleRight() {
		MovableElement paddle = new MovableElementStub(1, 2);
		MovableElement ball = new MovableElementStub(3, 4);
		AppViewModel appViewModel = getAppViewModel(paddle, ball);
		AIDecisionMaker decisionMaker = new AIDecisionMakerImpl(appViewModel);
		
		decisionMaker.analyzeAndAct();
		
		verify(appViewModel).moveOpponentPaddleRight();
	}
	
	@Test
	public void analyzeAndAct_WhenBallIsOnTopOfPaddle_ShouldStopMoving() {
		MovableElement paddle = new MovableElementStub(2, 3);
		MovableElement ball = new MovableElementStub(2, 3);
		AppViewModel appViewModel = getAppViewModel(paddle, ball);
		AIDecisionMaker decisionMaker = new AIDecisionMakerImpl(appViewModel);
		
		decisionMaker.analyzeAndAct();
		
		verify(appViewModel).stopMovingOpponentPaddle();
	}
	
	private AppViewModel getAppViewModel(
			MovableElement paddle,
			MovableElement ball
		) {
		
		CourtViewModel courtViewModel = new CourtViewModelStub(paddle, ball);
		AppViewModel appViewModel = mock(AppViewModel.class);
		when(appViewModel.getViewModel()).thenReturn(courtViewModel);
		
		return appViewModel;
	}

}
