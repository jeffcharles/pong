package com.beyondtechnicallycorrect.pong.viewmodel;

import static org.mockito.Mockito.*;
import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModel;
import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelGetter;
import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelInitializer;
import com.beyondtechnicallycorrect.pong.models.game.MatchFactory;
import com.beyondtechnicallycorrect.pong.models.game.MatchStatePublisher;
import com.beyondtechnicallycorrect.pong.models.paddle.PaddleInstruction;
import com.beyondtechnicallycorrect.pong.models.paddle.PaddleInstructionHolder;
import com.beyondtechnicallycorrect.pong.models.player.Player;

public final class TestAppViewModelImpl {
	
	@Test
	public void createMatch_ShouldCreateMatch() {
		MatchFactory factory = mock(MatchFactory.class);
		CourtViewModelInitializer courtViewModelInitializer =
				new CourtViewModelInitializerStub();
		Player player = new PlayerStub();
		Player opponent = new PlayerStub();
		PaddleInstructionHolder playerPaddleInstructionHolder =
				new PaddleInstructionHolderStub();
		PaddleInstructionHolder opponentPaddleInstructionHolder =
				new PaddleInstructionHolderStub();
		AppViewModel viewModel =
				new AppViewModelImpl(
						factory,
						courtViewModelInitializer,
						player,
						opponent,
						playerPaddleInstructionHolder,
						opponentPaddleInstructionHolder,
						null,
						null
					);
		
		viewModel.createMatch();
		
		verify(factory).create(
				courtViewModelInitializer,
				player,
				opponent,
				playerPaddleInstructionHolder,
				opponentPaddleInstructionHolder
			);
	}
	
	@Test
	public void startMatch_ShouldPublishMatchStart() {
		MatchStatePublisher publisher = mock(MatchStatePublisher.class);
		AppViewModel viewModel =
				new AppViewModelImpl(
						null,
						null,
						null,
						null,
						null,
						null,
						publisher,
						null
					);
		
		viewModel.startMatch();
		
		verify(publisher).publishMatchStarting();
	}
	
	@Test
	public void endMatch_ShouldPublishMatchEndingWithoutWinner() {
		MatchStatePublisher publisher = mock(MatchStatePublisher.class);
		AppViewModel viewModel =
				new AppViewModelImpl(
						null,
						null,
						null,
						null,
						null,
						null,
						publisher,
						null
					);
		
		viewModel.endMatch();
		
		verify(publisher).publishMatchEndingWithNoWinner();
	}
	
	@Test
	public void getViewModel_ShouldReturnViewModel() {
		CourtViewModel courtViewModel = new CourtViewModelStub();
		CourtViewModelGetter courtViewModelGetter =
				new CourtViewModelGetterStub(courtViewModel);
		AppViewModel viewModel =
				new AppViewModelImpl(
						null,
						null,
						null,
						null,
						null,
						null,
						null,
						courtViewModelGetter
					);
		
		CourtViewModel returnedViewModel = viewModel.getViewModel();
		
		Assert.assertSame(courtViewModel, returnedViewModel);
	}
	
	@Test
	public void getPlayerScore_ShouldReturnPlayerScore() {
		final int PLAYER_SCORE = 3;
		Player player = new PlayerStub(PLAYER_SCORE);
		AppViewModel viewModel =
				new AppViewModelImpl(
						null,
						null,
						player,
						null,
						null,
						null,
						null,
						null
					);
		
		int returnedScore = viewModel.getPlayerScore();
		
		Assert.assertEquals(PLAYER_SCORE, returnedScore);
	}
	
	@Test
	public void getOpponentScore_ShouldReturnOpponentScore() {
		final int OPPONENT_SCORE = 4;
		Player opponent = new PlayerStub(OPPONENT_SCORE);
		AppViewModel viewModel =
				new AppViewModelImpl(
						null,
						null,
						null,
						opponent,
						null,
						null,
						null,
						null
					);
		
		int returnedScore = viewModel.getOpponentScore();
		
		Assert.assertEquals(OPPONENT_SCORE, returnedScore);
	}
	
	@Test
	public void movePlayerPaddleLeft_ShouldIssueInstructionToMovePlayerPaddleNegatively() {
		PaddleInstructionHolder playerPaddleInstructionHolder =
				mock(PaddleInstructionHolder.class);
		AppViewModel viewModel =
				new AppViewModelImpl(
						null,
						null,
						null,
						null,
						playerPaddleInstructionHolder,
						null,
						null,
						null
					);
		
		viewModel.movePlayerPaddleLeft();
		
		verify(playerPaddleInstructionHolder).setPaddleInstruction(PaddleInstruction.NEG);
	}
	
	@Test
	public void movePlayerPaddleRight_ShouldIssueInstructionToMovePlayerPaddlePositively() {
		PaddleInstructionHolder playerPaddleInstructionHolder =
				mock(PaddleInstructionHolder.class);
		AppViewModel viewModel =
				new AppViewModelImpl(
						null,
						null,
						null,
						null,
						playerPaddleInstructionHolder,
						null,
						null,
						null
					);
		
		viewModel.movePlayerPaddleRight();
		
		verify(playerPaddleInstructionHolder).setPaddleInstruction(PaddleInstruction.POS);
	}
	
	@Test
	public void stopMovingPlayerPaddle_ShouldIssueInstructionToMakePlayerPaddleStationary() {
		PaddleInstructionHolder playerPaddleInstructionHolder =
				mock(PaddleInstructionHolder.class);
		AppViewModel viewModel =
				new AppViewModelImpl(
						null,
						null,
						null,
						null,
						playerPaddleInstructionHolder,
						null,
						null,
						null
					);
		
		viewModel.stopMovingPlayerPaddle();
		
		verify(playerPaddleInstructionHolder).setPaddleInstruction(PaddleInstruction.STATIONARY);
	}
	
	@Test
	public void moveOpponentPaddleLeft_ShouldIssueInstructionToMoveOpponentPaddleNegatively() {
		PaddleInstructionHolder opponentPaddleInstructionHolder =
				mock(PaddleInstructionHolder.class);
		AppViewModel viewModel =
				new AppViewModelImpl(
						null,
						null,
						null,
						null,
						null,
						opponentPaddleInstructionHolder,
						null,
						null
					);
		
		viewModel.moveOpponentPaddleLeft();
		
		verify(opponentPaddleInstructionHolder).setPaddleInstruction(PaddleInstruction.NEG);
	}
	
	@Test
	public void moveOpponentPaddleRight_ShouldIssueInstructionToMoveOpponentPaddlePositively() {
		PaddleInstructionHolder opponentPaddleInstructionHolder =
				mock(PaddleInstructionHolder.class);
		AppViewModel viewModel =
				new AppViewModelImpl(
						null,
						null,
						null,
						null,
						null,
						opponentPaddleInstructionHolder,
						null,
						null
					);
		
		viewModel.moveOpponentPaddleRight();
		
		verify(opponentPaddleInstructionHolder).setPaddleInstruction(PaddleInstruction.POS);
	}
	
	@Test
	public void stopMovingOpponentPaddle_ShouldIssueInstructionToMakeOpponentPaddleStationary() {
		PaddleInstructionHolder opponentPaddleInstructionHolder =
				mock(PaddleInstructionHolder.class);
		AppViewModel viewModel =
				new AppViewModelImpl(
						null,
						null,
						null,
						null,
						null,
						opponentPaddleInstructionHolder,
						null,
						null
					);
		
		viewModel.stopMovingOpponentPaddle();
		
		verify(opponentPaddleInstructionHolder).setPaddleInstruction(PaddleInstruction.STATIONARY);
	}

}
