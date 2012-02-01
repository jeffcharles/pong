package com.beyondtechnicallycorrect.pong.models.game;

public interface CourtViewModel {
	
	public MovableElement getPlayerPaddle();
	public MovableElement getOpponentPaddle();
	public MovableElement getBall();
	public Iterable<Element> getWalls();
	public Iterable<Element> getTerminalWalls();

}
