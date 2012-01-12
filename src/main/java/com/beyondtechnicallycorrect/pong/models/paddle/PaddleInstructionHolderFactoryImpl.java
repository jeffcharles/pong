package com.beyondtechnicallycorrect.pong.models.paddle;

final class PaddleInstructionHolderFactoryImpl implements
		PaddleInstructionHolderFactory {

	@Override
	public PaddleInstructionHolder create() {
		return new PaddleInstructionHolderImpl();
	}

}
