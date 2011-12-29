package com.beyondtechnicallycorrect.pong.models.velocity;

interface DirectionalVelocity {

	public int getAmountToMove();

	public int getFramesPerMove();

	/**
	 * Returns how much to move for this frame
	 * @return The amount of movement for this frame
	 */
	public int move();

	/**
	 * Reverses a move() and returns what move() did but negated
	 * @return The amount of movement to reverse the last move()
	 */
	public int unMove();

}