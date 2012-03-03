package com.beyondtechnicallycorrect.pong.models.game;

import com.beyondtechnicallycorrect.pong.models.paddle.PaddleInstructionHolder;
import com.beyondtechnicallycorrect.pong.models.player.Player;

public interface MatchFactory {

	public void create(
			CourtViewModelInitializer viewModel,
			Player player,
			Player opponent,
			PaddleInstructionHolder playerPaddleInstructionHolder,
			PaddleInstructionHolder opponentPaddleInstructionHolder
		);

}