package com.beyondtechnicallycorrect.pong.viewmodel;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModel;
import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelGetter;
import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelInitializer;
import com.beyondtechnicallycorrect.pong.models.game.MatchFactory;
import com.beyondtechnicallycorrect.pong.models.game.MatchStatePublisher;
import com.beyondtechnicallycorrect.pong.models.paddle.PaddleInstruction;
import com.beyondtechnicallycorrect.pong.models.paddle.PaddleInstructionHolder;
import com.beyondtechnicallycorrect.pong.models.player.Player;

final class AppViewModelImpl implements AppViewModel {
	
	private final MatchFactory m_matchFactory;
	private final CourtViewModelInitializer m_courtViewModelInitializer;
	private final Player m_player;
	private final Player m_opponent;
	private final PaddleInstructionHolder m_playerPaddleInstructionHolder;
	private final PaddleInstructionHolder m_opponentPaddleInstructionHolder;
	private final MatchStatePublisher m_matchStatePublisher;
	private final CourtViewModelGetter m_courtViewModelGetter;
	
	public AppViewModelImpl(
			MatchFactory matchFactory,
			CourtViewModelInitializer courtViewModelInitializer,
			Player player,
			Player opponent,
			PaddleInstructionHolder playerPaddleInstructionHolder,
			PaddleInstructionHolder opponentPaddleInstructionHolder,
			MatchStatePublisher matchStatePublisher,
			CourtViewModelGetter courtViewModelGetter
		) {
		
		m_matchFactory = matchFactory;
		m_courtViewModelInitializer = courtViewModelInitializer;
		m_player = player;
		m_opponent = opponent;
		m_playerPaddleInstructionHolder = playerPaddleInstructionHolder;
		m_opponentPaddleInstructionHolder = opponentPaddleInstructionHolder;
		m_matchStatePublisher = matchStatePublisher;
		m_courtViewModelGetter = courtViewModelGetter;
	}

	@Override
	public void createMatch() {
		m_matchFactory.create(
				m_courtViewModelInitializer,
				m_player,
				m_opponent,
				m_playerPaddleInstructionHolder,
				m_opponentPaddleInstructionHolder
			);
	}

	@Override
	public void startMatch() {
		m_matchStatePublisher.publishMatchStarting();
	}

	@Override
	public void endMatch() {
		m_matchStatePublisher.publishMatchEndingWithNoWinner();
	}

	@Override
	public CourtViewModel getViewModel() {
		CourtViewModel viewModel = m_courtViewModelGetter.get();
		return viewModel;
	}

	@Override
	public int getPlayerScore() {
		int playerScore = m_player.getScore();
		return playerScore;
	}

	@Override
	public int getOpponentScore() {
		int opponentScore = m_opponent.getScore();
		return opponentScore;
	}

	@Override
	public void movePlayerPaddleLeft() {
		m_playerPaddleInstructionHolder.setPaddleInstruction(
				PaddleInstruction.NEG
			);
	}

	@Override
	public void movePlayerPaddleRight() {
		m_playerPaddleInstructionHolder.setPaddleInstruction(
				PaddleInstruction.POS
			);
	}

	@Override
	public void stopMovingPlayerPaddle() {
		m_playerPaddleInstructionHolder.setPaddleInstruction(
				PaddleInstruction.STATIONARY
			);
	}

	@Override
	public void moveOpponentPaddleLeft() {
		m_opponentPaddleInstructionHolder.setPaddleInstruction(
				PaddleInstruction.NEG
			);
	}

	@Override
	public void moveOpponentPaddleRight() {
		m_opponentPaddleInstructionHolder.setPaddleInstruction(
				PaddleInstruction.POS
			);
	}

	@Override
	public void stopMovingOpponentPaddle() {
		m_opponentPaddleInstructionHolder.setPaddleInstruction(
				PaddleInstruction.STATIONARY
			);
	}

}
