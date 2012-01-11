package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;

interface InstructionToVelocityConverter {
	
	Velocity convertInstructionToVelocity(
			PaddleInstruction instruction,
			Velocity currentVelocity
		);

}
