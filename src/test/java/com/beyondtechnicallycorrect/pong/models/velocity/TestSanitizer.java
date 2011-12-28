package com.beyondtechnicallycorrect.pong.models.velocity;

import junit.framework.Assert;

import org.junit.*;

import com.beyondtechnicallycorrect.pong.models.velocity.DirectionalVelocityInfo;
import com.beyondtechnicallycorrect.pong.models.velocity.Sanitizer;

public final class TestSanitizer {
	
	private static Sanitizer m_sanitizer;
	
	@BeforeClass
	public static void setUpClass() {
		m_sanitizer = new Sanitizer();
	}
	
	private void assertDirectionalVelocityInfo(
			int expectedAmountToMove,
			int expectedFramesPerMove,
			DirectionalVelocityInfo velocityInfo
		) {
		
		Assert.assertEquals(
				"Expected amount to move did not match with info",
				expectedAmountToMove, velocityInfo.getAmountToMove());
		Assert.assertEquals(
				"Expected frames per move did not match with info",
				expectedFramesPerMove, velocityInfo.getFramesPerMove());
	}
	
	@Test
	public void testSanitize_WhenOneAmountAndOneFrames_ShouldReturnSame() {
		final int AMOUNT_TO_MOVE = 1;
		final int FRAMES = 1;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES);
		DirectionalVelocityInfo sanitized = m_sanitizer.sanitize(info);
		assertDirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES, sanitized);
	}
	
	@Test
	public void testSanitize_WhenOneAmountAndTwoFrames_ShouldReturnSame() {
		final int AMOUNT_TO_MOVE = 1;
		final int FRAMES = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES);
		DirectionalVelocityInfo sanitized = m_sanitizer.sanitize(info);
		assertDirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES, sanitized);
	}
	
	@Test
	public void testSanitize_WhenOneAmountAndThreeFrames_ShouldReturnSame() {
		final int AMOUNT_TO_MOVE = 1;
		final int FRAMES = 3;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES);
		DirectionalVelocityInfo sanitized = m_sanitizer.sanitize(info);
		assertDirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES, sanitized);
	}
	
	@Test
	public void testSanitize_WhenTwoAmountAndTwoFrames_ShouldReturnOneAndOne() {
		final int AMOUNT_TO_MOVE = 2;
		final int FRAMES = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES);
		DirectionalVelocityInfo sanitized = m_sanitizer.sanitize(info);
		
		final int SANITIZED_AMOUNT = 1;
		final int SANITIZED_FRAMES = 1;
		assertDirectionalVelocityInfo(
				SANITIZED_AMOUNT, SANITIZED_FRAMES, sanitized);
	}
	
	@Test
	public void testSanitize_WhenThreeAmountAndTwoFrames_ShouldReturnSame() {
		final int AMOUNT_TO_MOVE = 3;
		final int FRAMES = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES);
		DirectionalVelocityInfo sanitized = m_sanitizer.sanitize(info);
		assertDirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES, sanitized);
	}
	
	@Test
	public void testSanitize_WhenFourAmountAndTwoFrames_ShouldReturnTwoAndOne() {
		final int AMOUNT_TO_MOVE = 4;
		final int FRAMES = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES);
		DirectionalVelocityInfo sanitized = m_sanitizer.sanitize(info);
		
		final int SANITIZED_AMOUNT = 2;
		final int SANITIZED_FRAMES = 1;
		assertDirectionalVelocityInfo(
				SANITIZED_AMOUNT, SANITIZED_FRAMES, sanitized);
	}
	
	@Test
	public void testSanitize_WhenFiveAmountAndTwoFrames_ShouldReturnTwoAndOne() {
		final int AMOUNT_TO_MOVE = 5;
		final int FRAMES = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES);
		DirectionalVelocityInfo sanitized = m_sanitizer.sanitize(info);
		
		final int SANITIZED_AMOUNT = 2;
		final int SANITIZED_FRAMES = 1;
		assertDirectionalVelocityInfo(
				SANITIZED_AMOUNT, SANITIZED_FRAMES, sanitized);
	}
	
	@Test
	public void testSanitize_WhenTwoAmountAndThreeFrames_ShouldReturnSame() {
		final int AMOUNT_TO_MOVE = 2;
		final int FRAMES = 3;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES);
		DirectionalVelocityInfo sanitized = m_sanitizer.sanitize(info);
		assertDirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES, sanitized);
	}
	
	@Test
	public void testSanitize_WhenTwoAmountAndFourFrames_ShouldReturnOneAndTwo() {
		final int AMOUNT_TO_MOVE = 2;
		final int FRAMES = 4;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES);
		DirectionalVelocityInfo sanitized = m_sanitizer.sanitize(info);
		
		final int SANITIZED_AMOUNT = 1;
		final int SANITIZED_FRAME = 2;
		assertDirectionalVelocityInfo(
				SANITIZED_AMOUNT, SANITIZED_FRAME, sanitized);
	}
	
	@Test
	public void testSanitize_WhenTwoAmountAndFiveFrames_ShouldReturnOneAndTwo() {
		final int AMOUNT_TO_MOVE = 2;
		final int FRAMES = 5;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES);
		DirectionalVelocityInfo sanitized = m_sanitizer.sanitize(info);
		
		final int SANITIZED_AMOUNT = 1;
		final int SANITIZED_FRAMES = 2;
		assertDirectionalVelocityInfo(
				SANITIZED_AMOUNT, SANITIZED_FRAMES, sanitized);
	}
	
	@Test
	public void testSanitize_WhenNegFourAmountAndTwoFrames_ShouldReturnNegTwoAndOne() {
		final int AMOUNT_TO_MOVE = -4;
		final int FRAMES = 2;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES);
		DirectionalVelocityInfo sanitized = m_sanitizer.sanitize(info);
		
		final int SANITIZED_AMOUNT = -2;
		final int SANITIZED_FRAMES = 1;
		assertDirectionalVelocityInfo(
				SANITIZED_AMOUNT, SANITIZED_FRAMES, sanitized);
	}
	
	@Test
	public void testSanitize_WhenNegTwoAmountAndFiveFrames_ShouldReturnNegOneAndTwo() {
		final int AMOUNT_TO_MOVE = -2;
		final int FRAMES = 5;
		DirectionalVelocityInfo info =
				new DirectionalVelocityInfo(AMOUNT_TO_MOVE, FRAMES);
		DirectionalVelocityInfo sanitized = m_sanitizer.sanitize(info);
		
		final int SANITIZED_AMOUNT = -1;
		final int SANITIZED_FRAMES = 2;
		assertDirectionalVelocityInfo(
				SANITIZED_AMOUNT, SANITIZED_FRAMES, sanitized);
	}

}
