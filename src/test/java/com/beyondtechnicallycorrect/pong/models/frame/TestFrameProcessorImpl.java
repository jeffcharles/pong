package com.beyondtechnicallycorrect.pong.models.frame;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.mockito.InOrder;

public final class TestFrameProcessorImpl {
	
	@Test
	public void processFrame_WhenOneElement_ShouldMoveElement() {
		FrameElement fe = mock(FrameElement.class);
		Collection<FrameElement> movers = new ArrayList<FrameElement>();
		movers.add(fe);
		Collection<FrameElement> nonMovers = new ArrayList<FrameElement>();
		FrameProcessor fp = new FrameProcessorImpl(movers, nonMovers);
		
		fp.processFrame();
		
		verify(fe).move();
	}
	
	@Test
	public void processFrame_WhenOneMovingAndOneNotMovingThatDontCollide_ShouldMoveMovingElement() {
		FrameElement movingElement = mock(FrameElement.class);
		FrameElement nonMovingElement = new FrameElementStub();
		when(movingElement.isOverlapping(nonMovingElement)).thenReturn(false);
		
		Collection<FrameElement> movers = new ArrayList<FrameElement>();
		movers.add(movingElement);
		
		Collection<FrameElement> nonMovers = new ArrayList<FrameElement>();
		nonMovers.add(nonMovingElement);
		
		FrameProcessor fp = new FrameProcessorImpl(movers, nonMovers);
		
		fp.processFrame();
		
		verify(movingElement).move();
	}
	
	@Test
	public void processFrame_WhenOneMovingAndOneNotMovingThatDontCollide_ShouldNotBeAnyCollisions() {
		FrameElement movingElement = mock(FrameElement.class);
		FrameElement nonMovingElement = mock(FrameElement.class);
		when(movingElement.isOverlapping(nonMovingElement)).thenReturn(false);
		
		Collection<FrameElement> movers = new ArrayList<FrameElement>();
		movers.add(movingElement);
		
		Collection<FrameElement> nonMovers = new ArrayList<FrameElement>();
		nonMovers.add(nonMovingElement);
		
		FrameProcessor fp = new FrameProcessorImpl(movers, nonMovers);
		
		fp.processFrame();
		
		verify(movingElement, never()).collide(nonMovingElement);
		verify(nonMovingElement, never()).collide(movingElement);
	}
	
	@Test
	public void processFrame_WhenOneMovingAndOneNotMovingThatCollide_ShouldMoveThenUnMoveThenCollideThenMoveOnMover() {
		FrameElement movingElement = mock(FrameElement.class);
		FrameElement nonMovingElement = mock(FrameElement.class);
		when(movingElement.isOverlapping(nonMovingElement)).thenReturn(true);
		when(nonMovingElement.isOverlapping(movingElement)).thenReturn(true);
		
		Collection<FrameElement> movers = new ArrayList<FrameElement>();
		movers.add(movingElement);
		
		Collection<FrameElement> nonMovers = new ArrayList<FrameElement>();
		nonMovers.add(nonMovingElement);
		
		FrameProcessor fp = new FrameProcessorImpl(movers, nonMovers);
		
		fp.processFrame();
		
		InOrder inOrder = inOrder(movingElement);
		inOrder.verify(movingElement).move();
		inOrder.verify(movingElement).unMove();
		inOrder.verify(movingElement, times(1)).collide(nonMovingElement);
		inOrder.verify(movingElement).move();
	}
	
	@Test
	public void processFrame_WhenOneMovingAndNotMovingThatCollide_ShouldCallCollideOnNonMover() {
		FrameElement movingElement = mock(FrameElement.class);
		FrameElement nonMovingElement = mock(FrameElement.class);
		when(movingElement.isOverlapping(nonMovingElement)).thenReturn(true);
		when(nonMovingElement.isOverlapping(movingElement)).thenReturn(true);
		
		Collection<FrameElement> movers = new ArrayList<FrameElement>();
		movers.add(movingElement);
		
		Collection<FrameElement> nonMovers = new ArrayList<FrameElement>();
		nonMovers.add(nonMovingElement);
		
		FrameProcessor fp = new FrameProcessorImpl(movers, nonMovers);
		
		fp.processFrame();
		
		verify(nonMovingElement, times(1)).collide(movingElement);
	}
	
	@Test
	public void processFrame_WhenTwoNonCollidingMovingElements_ShouldMoveElements() {
		FrameElement fe1 = mock(FrameElement.class);
		FrameElement fe2 = mock(FrameElement.class);
		when(fe1.isOverlapping(fe2)).thenReturn(false);
		when(fe2.isOverlapping(fe1)).thenReturn(false);
		
		Collection<FrameElement> movers = new ArrayList<FrameElement>();
		movers.add(fe1);
		movers.add(fe2);
		
		Collection<FrameElement> nonMovers = new ArrayList<FrameElement>();
		
		FrameProcessor fp = new FrameProcessorImpl(movers, nonMovers);
		
		fp.processFrame();
		
		verify(fe1).move();
		verify(fe2).move();
	}
	
	@Test
	public void processFrame_WhenTwoNonCollidingMovingElements_ShouldNotBeAnyCollisions() {
		FrameElement fe1 = mock(FrameElement.class);
		FrameElement fe2 = mock(FrameElement.class);
		when(fe1.isOverlapping(fe2)).thenReturn(false);
		when(fe2.isOverlapping(fe1)).thenReturn(false);
		
		Collection<FrameElement> movers = new ArrayList<FrameElement>();
		movers.add(fe1);
		movers.add(fe2);
		
		Collection<FrameElement> nonMovers = new ArrayList<FrameElement>();
		
		FrameProcessor fp = new FrameProcessorImpl(movers, nonMovers);
		
		fp.processFrame();
		
		verify(fe1, never()).collide(fe2);
		verify(fe2, never()).collide(fe1);
	}
	
	@Test
	public void processFrame_WhenTwoCollidingMovingElements_ShouldMoveThenUnMoveThenCollideThenMoveElements() {
		FrameElement fe1 = mock(FrameElement.class);
		FrameElement fe2 = mock(FrameElement.class);
		when(fe1.isOverlapping(fe2)).thenReturn(true);
		when(fe2.isOverlapping(fe1)).thenReturn(true);
		
		Collection<FrameElement> movers = new ArrayList<FrameElement>();
		movers.add(fe1);
		movers.add(fe2);
		
		Collection<FrameElement> nonMovers = new ArrayList<FrameElement>();
		
		FrameProcessor fp = new FrameProcessorImpl(movers, nonMovers);
		
		fp.processFrame();
		
		InOrder inOrder = inOrder(fe1, fe2);
		inOrder.verify(fe1).move();
		inOrder.verify(fe2).move();
		inOrder.verify(fe1).unMove();
		inOrder.verify(fe2).unMove();
		inOrder.verify(fe1, times(1)).collide(fe2);
		inOrder.verify(fe2, times(1)).collide(fe1);
		inOrder.verify(fe1).move();
		inOrder.verify(fe2).move();
	}
	
	@Test
	public void processFrame_WhenFourElementsWithTwoCollisions_ShouldCallCollideCorrectly() {
		FrameElement mover1 = mock(FrameElement.class);
		FrameElement mover2 = mock(FrameElement.class);
		FrameElement nonMover1 = mock(FrameElement.class);
		FrameElement nonMover2 = mock(FrameElement.class);
		when(mover1.isOverlapping(nonMover1)).thenReturn(true);
		when(mover2.isOverlapping(nonMover2)).thenReturn(true);
		when(mover1.isOverlapping(nonMover2)).thenReturn(false);
		when(mover2.isOverlapping(nonMover1)).thenReturn(false);
		when(mover1.isOverlapping(mover2)).thenReturn(true);
		
		Collection<FrameElement> movers = new ArrayList<FrameElement>();
		movers.add(mover1);
		movers.add(mover2);
		
		Collection<FrameElement> nonMovers = new ArrayList<FrameElement>();
		nonMovers.add(nonMover1);
		nonMovers.add(nonMover2);
		
		FrameProcessor fp = new FrameProcessorImpl(movers, nonMovers);
		
		fp.processFrame();
		
		verify(mover1, times(1)).collide(nonMover1);
		verify(mover1, never()).collide(nonMover2);
		verify(mover1, times(1)).collide(mover2);
		verify(mover2, never()).collide(nonMover1);
		verify(mover2, times(1)).collide(nonMover2);
		verify(mover2, times(1)).collide(mover1);
	}

}
