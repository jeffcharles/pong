package com.beyondtechnicallycorrect.pong.models.velocity;

import java.util.HashMap;
import java.util.Map;

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

		int greatestCommonDenominator =
				findGreatestCommonDenominator(
						sanitizedAmountToMove,
						sanitizedFramesPerMove
					);
		sanitizedAmountToMove /= greatestCommonDenominator;
		sanitizedFramesPerMove /= greatestCommonDenominator;
		
		final int MAX_AMOUNT_TO_MOVE = 10;
		if(Math.abs(sanitizedAmountToMove) > MAX_AMOUNT_TO_MOVE) {
			int divisor = Math.abs(sanitizedAmountToMove) / MAX_AMOUNT_TO_MOVE + 1;
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
	
	private int findGreatestCommonDenominator(int left, int right) {
		int greatestCommonDenominator = 1;
		int wholeLeft = Math.abs(left);
		int wholeRight = Math.abs(right);
		if(wholeLeft == 0 || wholeRight == 0) {
			return greatestCommonDenominator;
		}
		Map<Integer, Integer> leftPrimes = getPrimes(wholeLeft);
		Map<Integer, Integer> rightPrimes = getPrimes(wholeRight);
		for(int prime : leftPrimes.keySet()) {
			if(rightPrimes.containsKey(prime)) {
				int leftCount = leftPrimes.get(prime);
				int rightCount = rightPrimes.get(prime);
				int commonCount = Math.min(leftCount, rightCount);
				greatestCommonDenominator *= prime * commonCount;
			}
		}
		return greatestCommonDenominator;
	}
	
	private Map<Integer, Integer> getPrimes(int num) {
		final int[] PRIME_NUMBERS =
				new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
		Map<Integer, Integer> primes = new HashMap<Integer, Integer>();
		int numInProgress = num;
		for(int primeNumber : PRIME_NUMBERS) {
			int occurrences = 0;
			while(numInProgress % primeNumber == 0) {
				++occurrences;
				numInProgress /= primeNumber;
			}
			if(occurrences > 0) {
				primes.put(primeNumber, occurrences);
			}
			if(numInProgress == 1) {
				break;
			}
		}
		return primes;
	}
	
}
