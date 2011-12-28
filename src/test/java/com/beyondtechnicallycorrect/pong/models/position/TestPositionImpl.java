package com.beyondtechnicallycorrect.pong.models.position;

import junit.framework.Assert;
import org.junit.*;
import org.junit.rules.ExpectedException;

import com.beyondtechnicallycorrect.pong.models.position.PositionImpl;

public final class TestPositionImpl {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private static PositionImpl m_noOverlapTopLeft;
	private static PositionImpl m_noOverlapTop;
	private static PositionImpl m_noOverlapTopRight;
	private static PositionImpl m_noOverlapMiddleLeft;
	private static PositionImpl m_noOverlapMiddle;
	private static PositionImpl m_noOverlapMiddleRight;
	private static PositionImpl m_noOverlapBottomLeft;
	private static PositionImpl m_noOverlapBottom;
	private static PositionImpl m_noOverlapBottomRight;
	
	private static PositionImpl m_overlapTopLeft;
	private static PositionImpl m_overlapTop;
	private static PositionImpl m_overlapTopRight;
	private static PositionImpl m_overlapMiddleLeft;
	private static PositionImpl m_overlapMiddle;
	private static PositionImpl m_overlapMiddleRight;
	private static PositionImpl m_overlapBottomLeft;
	private static PositionImpl m_overlapBottom;
	private static PositionImpl m_overlapBottomRight;
	
	@BeforeClass
	public static void setUpClass() {
		m_noOverlapTopLeft =     new PositionImpl(1, 10, 1, 10);
		m_noOverlapTop =         new PositionImpl(11, 20, 1, 10);
		m_noOverlapTopRight =    new PositionImpl(21, 30, 1, 10);
		m_noOverlapMiddleLeft =  new PositionImpl(1, 10, 11, 20);
		m_noOverlapMiddle =      new PositionImpl(11, 20, 11, 20);
		m_noOverlapMiddleRight = new PositionImpl(21, 30, 11, 20);
		m_noOverlapBottomLeft =  new PositionImpl(1, 10, 21, 30);
		m_noOverlapBottom =      new PositionImpl(11, 20, 21, 30);
		m_noOverlapBottomRight = new PositionImpl(21, 30, 21, 30);
		
		m_overlapTopLeft = new PositionImpl(1, 11, 1, 11);
		m_overlapTop = new PositionImpl(12, 19, 1, 11);
		m_overlapTopRight = new PositionImpl(20, 30, 1, 11);
		m_overlapMiddleLeft = new PositionImpl(12, 19, 1, 11);
		m_overlapMiddle = new PositionImpl(11, 20, 11, 20);
		m_overlapMiddleRight = new PositionImpl(20, 30, 12, 19);
		m_overlapBottomLeft = new PositionImpl(1, 11, 20, 30);
		m_overlapBottom = new PositionImpl(12, 19, 20, 30);
		m_overlapBottomRight = new PositionImpl(20, 30, 20, 30);
	}
	
	private void standardNoOverlapTest(PositionImpl noOverlapPositionToTest) {
		boolean isOverlapping =
				noOverlapPositionToTest.isOverlapping(m_noOverlapMiddle);
		Assert.assertFalse(isOverlapping);
	}
	
	private void standardOverlapTest(PositionImpl overlapPositionToTest) {
		boolean isOverlapping =
				overlapPositionToTest.isOverlapping(m_overlapMiddle);
		Assert.assertTrue(isOverlapping);
	}
	
	@Test
	public void testCtor_WhenX1LessThanZero_ShouldThrowIllegalArgException() {
		exception.expect(IllegalArgumentException.class);
		new PositionImpl(-1, 1, 0, 1);
	}
	
	@Test
	public void testCtor_WhenX2LessThanZero_ShouldThrowIllegalArgException() {
		exception.expect(IllegalArgumentException.class);
		new PositionImpl(0, -1, 0, 1);
	}
	
	@Test
	public void testCtor_WhenY1LessThanZero_ShouldThrowIllegalArgException() {
		exception.expect(IllegalArgumentException.class);
		new PositionImpl(0, 1, -1, 1);
	}
	
	@Test
	public void testCtor_WhenY2LessThanZero_ShouldThrowIllegalArgException() {
		exception.expect(IllegalArgumentException.class);
		new PositionImpl(0, 1, 0, -1);
	}
	
	@Test
	public void testCtor_WhenX2EqualsX1_ShouldThrowIllegalArgException() {
		exception.expect(IllegalArgumentException.class);
		new PositionImpl(1, 1, 0, 1);
	}
	
	@Test
	public void testCtor_WhenX2LessThanX1_ShouldThrowIllegalArgException() {
		exception.expect(IllegalArgumentException.class);
		new PositionImpl(2, 1, 0, 1);
	}
	
	@Test
	public void testCtor_WhenY2EqualsY1_ShouldThrowIllegalArgException() {
		exception.expect(IllegalArgumentException.class);
		new PositionImpl(1, 2, 1, 1);
	}
	
	@Test
	public void testCtor_WhenY2LessThanY1_ShouldThrowIllegalArgException() {
		exception.expect(IllegalArgumentException.class);
		new PositionImpl(1, 2, 2, 1);
		
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsSame_ShouldBeTrue() {
		PositionImpl pos = new PositionImpl(1, 10, 1, 10);
		
		boolean isOverlapping = pos.isOverlapping(pos);
		
		Assert.assertTrue(isOverlapping);
	}

	@Test
	public void testIsOverlapping_WhenPositionIsSuperset_ShouldBeTrue() {
		PositionImpl superset = new PositionImpl(1, 10, 1, 10);
		PositionImpl subset = new PositionImpl(3, 7, 3, 7);
		
		boolean isOverlapping = superset.isOverlapping(subset);
		
		Assert.assertTrue(isOverlapping);
	}
	
	@Test
	public void testIsOverlapping_WhenPositionIsSubset_ShouldBeTrue() {
		PositionImpl superset = new PositionImpl(1, 10, 1, 10);
		PositionImpl subset = new PositionImpl(3, 7, 3, 7);
		
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
