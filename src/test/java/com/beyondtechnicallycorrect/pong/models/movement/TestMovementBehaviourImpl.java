package com.beyondtechnicallycorrect.pong.models.movement;

import org.junit.*;

import com.beyondtechnicallycorrect.pong.models.position.*;
import com.beyondtechnicallycorrect.pong.models.velocity.*;

public final class TestMovementBehaviourImpl {

	private static MovementBehaviourImpl m_movementBehaviour;
	
	@BeforeClass
	public static void setUpClass() {
		PositionFactory positionFactory = new PositionFactoryStub();
		m_movementBehaviour = new MovementBehaviourImpl(positionFactory);
	}
	
	private void assertPosition(
			int expectedX1,
			int expectedX2,
			int expectedY1,
			int expectedY2,
			Position actualPosition
		) {
		
		Assert.assertEquals(
				"X1 should be equal",
				expectedX1, actualPosition.getX1());
		Assert.assertEquals(
				"X2 should be equal",
				expectedX2, actualPosition.getX2());
		Assert.assertEquals(
				"Y1 should be equal",
				expectedY1, actualPosition.getY1());
		Assert.assertEquals(
				"Y2 should be equal",
				expectedY2, actualPosition.getY2());
	}
	
	private void checkMove(
			int startingPosX1,
			int startingPosX2,
			int startingPosY1,
			int startingPosY2,
			int xVelocity,
			int yVelocity,
			int endingPosX1,
			int endingPosX2,
			int endingPosY1,
			int endingPosY2
		) {
		
		Position startingPos = new PositionStub(
				startingPosX1, startingPosX2, startingPosY1, startingPosY2);
		VelocityBehaviour vel =
				new VelocityBehaviourStub(xVelocity, yVelocity, 0, 0);
		
		Position endingPos = m_movementBehaviour.move(startingPos, vel);
		
		assertPosition(
				endingPosX1, endingPosX2, endingPosY1, endingPosY2, endingPos);
	}
	
	private void checkUnMove(
			int startingPosX1,
			int startingPosX2,
			int startingPosY1,
			int startingPosY2,
			int xVelocity,
			int yVelocity,
			int endingPosX1,
			int endingPosX2,
			int endingPosY1,
			int endingPosY2
		) {
		
		Position startingPos = new PositionStub(
				startingPosX1, startingPosX2, startingPosY1, startingPosY2);
		VelocityBehaviour vel =
				new VelocityBehaviourStub(0, 0, -xVelocity, -yVelocity);
		
		Position endingPos = m_movementBehaviour.unMove(startingPos, vel);
		
		assertPosition(
				endingPosX1, endingPosX2, endingPosY1, endingPosY2, endingPos);
	}
	
	@Test
	public void testMove_WithPositionAtTwoTwoAndVelocityNegOneNegOne_ShouldReturnOneOne() {
		checkMove(2, 3, 2, 3, -1, -1, 1, 2, 1, 2);
	}
	
	@Test
	public void testMove_WithPositionAtTwoTwoAndVelocityNegOneAndZero_ShouldReturnOneTwo() {
		checkMove(2, 3, 2, 3, -1, 0, 1, 2, 2, 3);
	}
	
	@Test
	public void testMove_WithPositionAtTwoTwoAndVelocityNegOneAndOne_ShouldReturnOneThree() {
		checkMove(2, 3, 2, 3, -1, 1, 1, 2, 3, 4);
	}
	
	@Test
	public void testMove_WithPositionAtTwoTwoAndVelocityZeroAndNegOne_ShouldReturnTwoOne() {
		checkMove(2, 3, 2, 3, 0, -1, 2, 3, 1, 2);
	}
	
	@Test
	public void testMove_WithPositionAtTwoTwoAndVelocityZeroAndZero_ShouldReturnTwoTwo() {
		checkMove(2, 3, 2, 3, 0, 0, 2, 3, 2, 3);
	}
	
	@Test
	public void testMove_WithPositionAtTwoTwoAndVelocityZeroAndOne_ShouldReturnTwoThree() {
		checkMove(2, 3, 2, 3, 0, 1, 2, 3, 3, 4);
	}
	
	@Test
	public void testMove_WithPositionAtTwoTwoAndVelocityOneAndNegOne_ShouldReturnThreeOne() {
		checkMove(2, 3, 2, 3, 1, -1, 3, 4, 1, 2);
	}
	
	@Test
	public void testMove_WithPositionAtTwoTwoAndVelocityOneAndZero_ShouldReturnThreeAndTwo() {
		checkMove(2, 3, 2, 3, 1, 0, 3, 4, 2, 3);
	}
	
	@Test
	public void testMove_WithPositionAtTwoTwoAndVelocityOneOne_ShouldReturnThreeThree() {
		checkMove(2, 3, 2, 3, 1, 1, 3, 4, 3, 4);
	}
	
	@Test
	public void testMove_WithPositionAtTwoTwoAndVelocityTwoThree_ShouldReturnFourFive() {
		checkMove(2, 4, 2, 5, 2, 3, 4, 6, 5, 8);
	}
	
	@Test
	public void testUnMove_WithPositionAtTwoTwoAndVelocityNegOneAndNegOne_ShouldReturnThreeThree() {
		checkUnMove(2, 3, 2, 3, -1, -1, 3, 4, 3, 4);
	}
	
	@Test
	public void testUnMove_WithPositionAtTwoTwoAndVelocityNegOneAndZero_ShouldReturnThreeTwo() {
		checkUnMove(2, 3, 2, 3, -1, 0, 3, 4, 2, 3);
	}
	
	@Test
	public void testUnMove_WithPositionAtTwoTwoAndVelocityNegOneAndOne_ShouldReturnThreeAndOne() {
		checkUnMove(2, 3, 2, 3, -1, 1, 3, 4, 1, 2);
	}
	
	@Test
	public void testUnMove_WithPositionAtTwoTwoAndVelocityZeroAndNegOne_ShouldReturnTwoThree() {
		checkUnMove(2, 3, 2, 3, 0, -1, 2, 3, 3, 4);
	}
	
	@Test
	public void testUnMove_WithPositionAtTwoTwoAndVelocityZeroAndZero_ShouldReturnTwoTwo() {
		checkUnMove(2, 3, 2, 3, 0, 0, 2, 3, 2, 3);
	}
	
	@Test
	public void testUnMove_WithPositionAtTwoTwoAndVelocityZeroAndOne_ShouldReturnTwoOne() {
		checkUnMove(2, 3, 2, 3, 0, 1, 2, 3, 1, 2);
	}
	
	@Test
	public void testUnMove_WithPositionAtTwoTwoAndVelocityOneAndNegOne_ShouldReturnOneThree() {
		checkUnMove(2, 3, 2, 3, 1, -1, 1, 2, 3, 4);
	}
	
	@Test
	public void testUnMove_WithPositionAtTwoTwoAndVelocityOneAndZero_ShouldReturnOneTwo() {
		checkUnMove(2, 3, 2, 3, 1, 0, 1, 2, 2, 3);
	}
	
	@Test
	public void testUnMove_WithPositionAtTwoTwoAndVelocityOneAndOne_ShouldReturnOneOne() {
		checkUnMove(2, 3, 2, 3, 1, 1, 1, 2, 1, 2);
	}
	
	@Test
	public void testUnMove_WithPositionAtFourSevenAndVelocityTwoAndFive_ShouldReturnTwoTwo() {
		checkUnMove(4, 6, 7, 10, 2, 5, 2, 4, 2, 5);
	}
	
}
