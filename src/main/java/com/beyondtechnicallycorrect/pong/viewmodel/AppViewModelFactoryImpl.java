package com.beyondtechnicallycorrect.pong.viewmodel;

import com.beyondtechnicallycorrect.pong.models.frame.FrameRunner;
import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelGetter;
import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelInitializer;
import com.beyondtechnicallycorrect.pong.models.game.MatchFactory;
import com.beyondtechnicallycorrect.pong.models.game.MatchStatePublisher;
import com.beyondtechnicallycorrect.pong.models.game.MatchStateSubscription;
import com.beyondtechnicallycorrect.pong.models.paddle.PaddleInstructionHolder;
import com.beyondtechnicallycorrect.pong.models.player.Player;
import com.beyondtechnicallycorrect.pong.models.player.ScoringSubscriber;
import com.google.inject.Inject;

final class AppViewModelFactoryImpl implements AppViewModelFactory {
	
	private final MatchFactory m_matchFactory;
	private final CourtViewModelInitializer m_courtViewModelInitializer;
	private final Player m_player;
	private final Player m_opponent;
	private final PaddleInstructionHolder m_playerPaddleInstructionHolder;
	private final PaddleInstructionHolder m_opponentPaddleInstructionHolder;
	private final MatchStatePublisher m_matchStatePublisher;
	private final CourtViewModelGetter m_courtViewModelGetter;
	private final MatchStateSubscription m_matchStateSubscription;
	private final FrameRunner m_frameRunner;
	private final ScoringSubscriber m_scoringSubscriber;
	
	@Inject
	public AppViewModelFactoryImpl(
			MatchFactory matchFactory,
			CourtViewModelInitializer courtViewModelInitializer,
			Player player,
			Player opponent,
			PaddleInstructionHolder playerPaddleInstructionHolder,
			PaddleInstructionHolder opponentPaddleInstructionHolder,
			MatchStatePublisher matchStatePublisher,
			CourtViewModelGetter courtViewModelGetter,
			MatchStateSubscription matchStateSubscription,
			FrameRunner frameRunner,
			ScoringSubscriber scoringSubscriber
		) {
		
		m_matchFactory = matchFactory;
		m_courtViewModelInitializer = courtViewModelInitializer;
		m_player = player;
		m_opponent = opponent;
		m_playerPaddleInstructionHolder = playerPaddleInstructionHolder;
		m_opponentPaddleInstructionHolder = opponentPaddleInstructionHolder;
		m_matchStatePublisher = matchStatePublisher;
		m_courtViewModelGetter = courtViewModelGetter;
		m_matchStateSubscription = matchStateSubscription;
		m_frameRunner = frameRunner;
		m_scoringSubscriber = scoringSubscriber;
	}

	@Override
	public AppViewModel create() {
		m_matchStateSubscription.subscribe(m_frameRunner);
		m_matchStateSubscription.subscribe(m_scoringSubscriber);
		
		AppViewModel viewModel = new AppViewModelImpl(
				m_matchFactory,
				m_courtViewModelInitializer,
				m_player,
				m_opponent,
				m_playerPaddleInstructionHolder,
				m_opponentPaddleInstructionHolder,
				m_matchStatePublisher,
				m_courtViewModelGetter
			);
		
		return viewModel;
	}

}
