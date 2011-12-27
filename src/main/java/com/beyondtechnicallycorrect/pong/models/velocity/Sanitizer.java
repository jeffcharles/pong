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
		
		int amountToMove = info.getAmountToMove();
		int frames = info.getFramesPerMove();
		
		boolean greaterThanOne = amountToMove > frames;
		int quotient = greaterThanOne ?
				amountToMove / frames :
				frames / amountToMove;
		int remainder = greaterThanOne ?
				amountToMove % frames :
				frames % amountToMove;
		
		if(remainder < quotient) {
			int sanitizedAmount = greaterThanOne ? amountToMove / frames : 1;
			int sanitizedFrames = greaterThanOne ? 1 : frames / amountToMove;
			
			return new DirectionalVelocityInfo(
					sanitizedAmount, sanitizedFrames);
		}
		
		return info;
	}
	
}
