package com.beyondtechnicallycorrect.pong.models.implementations;

import junit.framework.Assert;
import org.junit.*;

public final class TestPosition {
	
	private static Position m_noOverlapTopLeft;
	private static Position m_noOverlapTop;
	private static Position m_noOverlapTopRight;
	private static Position m_noOverlapMiddleLeft;
	private static Position m_noOverlapMiddle;
	private static Position m_noOverlapMiddleRight;
	private static Position m_noOverlapBottomLeft;
	private static Position m_noOverlapBottom;
	private static Position m_noOverlapBottomRight;
	
	private static Position m_overlapTopLeft;
	private static Position m_overlapTop;
	private static Position m_overlapTopRight;
	private static Position m_overlapMiddleLeft;
	private static Position m_overlapMiddle;
	private static Position m_overlapMiddleRight;
	private static Position m_overlapBottomLeft;
	private static Position m_overlapBottom;
	private static Position m_overlapBottomRight;
	
	@BeforeClass
	public static void setUpClass() {
		m_noOverlapTopLeft =     new Position(1, 10, 1, 10);
		m_noOverlapTop =         new Position(11, 20, 1, 10);
		m_noOverlapTopRight =    new Position(21, 30, 1, 10);
		m_noOverlapMiddleLeft =  new Position(1, 10, 11, 20);
		m_noOverlapMiddle =      new Position(11, 20, 11, 20);
		m_noOverlapMiddleRight = new Position(21, 30, 11, 20);
		m_noOverlapBottomLeft =  new Position(1, 10, 21, 30);
		m_noOverlapBottom =      new Position(11, 20, 21, 30);
		m_noOverlapBottomRight = new Position(21, 30, 21, 30);
		
		m_overlapTopLeft = new Position(1, 11, 1, 11);
		m_overlapTop = new Position(12, 19, 1, 11);
		m_overlapTopRight = new Position(20, 30, 1, 11);
		m_overlapMiddleLeft = new Position(12, 19, 1, 11);
		m_overlapMiddle = new Position(11, 20, 11, 20);
		m_overlapMiddleRight = new Position(20, 30, 12, 19);
		m_overlapBottomLeft = new Position(1, 11, 20, 30);
		m_overlapBottom = new Position(12, 19, 20, 30);
		m_overlapBottomRight = new Position(20, 30, 20, 30);
	}
	
	private void standardNoOverlapTest(Position noOverlapPositionToTest) {
		boolean isOverlapping =
				noOverlapPositionToTest.isOverlapping(m_noOverlapMiddle);
		Assert.assertFalse(isOverlapping);
	}
	
	private void standardOverlapTest(Position overlapPositionToTest) {
		boolean isOverlapping =
				overlapPositionToTest.isOverlapping(m_overlapMiddle);
		Assert.assertTrue(isOverlapping);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsSame_ShouldBeTrue() {
		Position pos = new Position(1, 10, 1, 10);
		
		boolean isOverlapping = pos.isOverlapping(pos);
		
		Assert.assertTrue(isOverlapping);
	}

	@Test
	public void testIsOverlapping_WhenPositionIsSuperset_ShouldBeTrue() {
		Position superset = new Position(1, 10, 1, 10);
		Position subset = new Position(3, 7, 3, 7);
		
		boolean isOverlapping = superset.isOverlapping(subset);
		
		Assert.assertTrue(isOverlapping);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsSubset_ShouldBeTrue() {
		Position superset = new Position(1, 10, 1, 10);
		Position subset = new Position(3, 7, 3, 7);
		
		boolean isOverlapping = subset.isOverlapping(superset);
		
		Assert.assertTrue(isOverlapping);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsToTopLeft_ShouldBeFalse() {
		standardNoOverlapTest(m_noOverlapTopLeft);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsOnTop_ShouldBeFalse() {
		standardNoOverlapTest(m_noOverlapTop);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsToTopRight_ShouldBeFalse() {
		standardNoOverlapTest(m_noOverlapTopRight);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsToLeft_ShouldBeFalse() {
		standardNoOverlapTest(m_noOverlapMiddleLeft);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsToRight_ShouldBeFalse() {
		standardNoOverlapTest(m_noOverlapMiddleRight);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsToBottomLeft_ShouldBeFalse() {
		standardNoOverlapTest(m_noOverlapBottomLeft);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsBelow_ShouldBeFalse() {
		standardNoOverlapTest(m_noOverlapBottom);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsToBottomRight_ShouldBeFalse() {
		standardNoOverlapTest(m_noOverlapBottomRight);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsOverlappingTopLeft_ShouldBeTrue() {
		standardOverlapTest(m_overlapTopLeft);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsOverlappingTop_ShouldBeTrue() {
		standardOverlapTest(m_overlapTop);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsOverlappingTopRight_ShouldBeTrue() {
		standardOverlapTest(m_overlapTopRight);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsOverlappingLeft_ShouldBeTrue() {
		standardOverlapTest(m_overlapMiddleLeft);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsOverlappingRight_ShouldBeTrue() {
		standardOverlapTest(m_overlapMiddleRight);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsOverlappingBottomLeft_ShouldBeTrue() {
		standardOverlapTest(m_overlapBottomLeft);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsOverlappingBottom_ShouldBeTrue() {
		standardOverlapTest(m_overlapBottom);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsOverlappingBottomRight_ShouldBeTrue() {
		standardOverlapTest(m_overlapBottomRight);
	}
	
}
