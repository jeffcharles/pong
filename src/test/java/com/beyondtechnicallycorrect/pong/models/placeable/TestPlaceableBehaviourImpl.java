package com.beyondtechnicallycorrect.pong.models.placeable;

import static org.mockito.Mockito.*;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.position.*;

public final class TestPlaceableBehaviourImpl {

	@Test
	public void testIsOverlap_WhenUnderlyingPositionReturnsFalse_ShouldReturnFalse() {
		final boolean UNDERLYING_OVERLAP = false;
		
		PositionFactory factory = new PositionFactoryStub(UNDERLYING_OVERLAP);
		PlaceableBehaviour pb = new PlaceableBehaviourImpl(factory);
		Placeable model = new PlaceableStub();
		Position pos = new PositionStub(UNDERLYING_OVERLAP);
		
		boolean overlap = pb.isOverlap(model, pos);
		
		Assert.assertFalse(overlap);
	}
	
	@Test
	public void testIsOverlap_WhenUnderlyingPositionReturnsTrue_ShouldReturnTrue() {
		final boolean UNDERLYING_OVERLAP = true;
		
		PositionFactory factory = new PositionFactoryStub(UNDERLYING_OVERLAP);
		PlaceableBehaviour pb = new PlaceableBehaviourImpl(factory);
		Placeable model = new PlaceableStub();
		Position pos = new PositionStub(UNDERLYING_OVERLAP);
		
		boolean overlap = pb.isOverlap(model, pos);
		
		Assert.assertTrue(overlap);
	}
	
	@Test
	public void testConstructedPositionIsCorrect() {
		final int X1 = 1;
		final int X2 = 2;
		final int Y1 = 3;
		final int Y2 = 4;
		
		PositionFactory factory = mock(PositionFactory.class);
		Position innerPos = new PositionStub(true);
		when(factory.create(X1, X2, Y1, Y2)).thenReturn(innerPos);
		Placeable model = new PlaceableStub(X1, X2, Y1, Y2);
		Position pos = new PositionStub(true);
		PlaceableBehaviour pb = new PlaceableBehaviourImpl(factory);
		
		pb.isOverlap(model, pos);
		
		verify(factory).create(X1, X2, Y1, Y2);
	}
}
