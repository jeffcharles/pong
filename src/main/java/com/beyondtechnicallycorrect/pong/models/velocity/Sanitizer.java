package com.beyondtechnicallycorrect.pong.models.velocity;

final class Sanitizer {

	/**
	 * Takes in a DirectionalVelocityInfo and returns one with sanitized values
	 * @param info The unsanitized values to sanitize
	 * @return The sanitized DirectionalVelocityInfo
	 */
	public DirectionalVelocityInfo sanitize(
			DirectionalVelocityInfo info
		) {
		
		// intent is to minimize value of amountToMove and frames, while
		// keeping the approximate value of amountToMove / frames the same
		
		int startingAmountToMove = info.getAmountToMove();
		int startingFramesPerMove = info.getFramesPerMove();
		
		int sanitizedAmountToMove = startingAmountToMove;
		int sanitizedFramesPerMove = startingFramesPerMove;
		if(sanitizedAmountToMove % sanitizedFramesPerMove == 0) {
			sanitizedAmountToMove /= sanitizedFramesPerMove;
			sanitizedFramesPerMove = 1;
		}
		if(sanitizedAmountToMove != 0 &&
				sanitizedFramesPerMove % sanitizedAmountToMove == 0
			) {
			
			sanitizedFramesPerMove /= Math.abs(sanitizedAmountToMove);
			sanitizedAmountToMove = sanitizedAmountToMove > 0 ? 1 : -1;
		}
		
		final int MAX_AMOUNT_TO_MOVE = 10;
		if(sanitizedAmountToMove > MAX_AMOUNT_TO_MOVE) {
			int divisor = sanitizedAmountToMove / MAX_AMOUNT_TO_MOVE + 1;
			sanitizedAmountToMove /= divisor;
			sanitizedFramesPerMove /= divisor;
		}
		
		final int MAX_FRAMES_PER_MOVE = 5;
		if(sanitizedFramesPerMove > MAX_FRAMES_PER_MOVE) {
			int divisor = sanitizedFramesPerMove / MAX_FRAMES_PER_MOVE + 1;
			sanitizedAmountToMove /= divisor;
			sanitizedFramesPerMove /= divisor;
		}
		
		if(sanitizedFramesPerMove < 1) {
			sanitizedFramesPerMove = 1;
		}
		
		DirectionalVelocityInfo sanitizedVelocity =
				new DirectionalVelocityInfo(
						sanitizedAmountToMove,
						sanitizedFramesPerMove
					);
		return sanitizedVelocity;
	}
	
}
