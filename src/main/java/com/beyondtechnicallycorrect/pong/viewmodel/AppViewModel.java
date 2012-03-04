package com.beyondtechnicallycorrect.pong.viewmodel;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModel;

public interface AppViewModel {
	
	public void createMatch();
	public void startMatch();
	public void endMatch();
	
	public CourtViewModel getViewModel();
	
	public int getPlayerScore();
	public int getOpponentScore();
	
	public void movePlayerPaddleLeft();
	public void movePlayerPaddleRight();
	public void stopMovingPlayerPaddle();
	
	public void moveOpponentPaddleLeft();
	public void moveOpponentPaddleRight();
	public void stopMovingOpponentPaddle();

}
