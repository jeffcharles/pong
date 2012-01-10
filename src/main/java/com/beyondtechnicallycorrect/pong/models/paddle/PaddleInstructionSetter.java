package com.beyondtechnicallycorrect.pong.models.paddle;

/**
 * Allows a controller to set the current paddle's instruction.
 * There should only be one instance per paddle.
 *
 */
public interface PaddleInstructionSetter {

	public void setPaddleInstruction(PaddleInstruction instruction);
	
}
