package com.beyondtechnicallycorrect.pong.models.paddle;

/**
 * Responsible for holding the player's current instruction for the paddle.
 * There should only be two references, one for the player and one for the
 * paddle.
 *
 */
final class PaddleInstructionHolderImpl implements PaddleInstructionGetter,
		PaddleInstructionSetter, PaddleInstructionHolder {
	
	private PaddleInstruction m_instruction;
	
	public PaddleInstructionHolderImpl() {
		m_instruction = PaddleInstruction.STATIONARY;
	}

	@Override
	public void setPaddleInstruction(PaddleInstruction instruction) {
		m_instruction = instruction;
	}

	@Override
	public PaddleInstruction getPaddleInstruction() {
		return m_instruction;
	}

}
