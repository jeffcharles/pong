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
		
		if(amountToMove == 0) {
			return new DirectionalVelocityInfo(amountToMove, 1);
		}
		
		boolean greaterThanOne =
				Math.abs(amountToMove) / frames >= 1;
		int quotient = Math.abs(greaterThanOne ?
				amountToMove / frames :
				frames / amountToMove);
		int remainder = greaterThanOne ?
				amountToMove % frames :
				frames % amountToMove;
		
		if(remainder < quotient) {
			int sanitizedAmount = greaterThanOne ?
					amountToMove / frames :
					amountToMove > 0 ? 1 : -1;
			int sanitizedFrames = greaterThanOne ?
					1 :
					frames / Math.abs(amountToMove);
			
			return new DirectionalVelocityInfo(
					sanitizedAmount, sanitizedFrames);
		}
		
		return info;
	}
	
}
