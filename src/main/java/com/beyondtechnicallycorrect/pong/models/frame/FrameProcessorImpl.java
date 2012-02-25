package com.beyondtechnicallycorrect.pong.models.frame;

import java.util.Collection;
import java.util.TreeSet;

final class FrameProcessorImpl implements FrameProcessor {

	private final Iterable<FrameElement> m_movers;
	private final Iterable<FrameElement> m_nonMovers;
	
	public FrameProcessorImpl(
			Iterable<FrameElement> movers,
			Iterable<FrameElement> nonMovers
		) {
		
		m_movers = movers;
		m_nonMovers = nonMovers;
	}
	
	@Override
	public void processFrame() {
		moveAllElements();
		Iterable<CollisionPair> collisions = getCollisions();
		unMoveCollidedElements(collisions);
		callCollideOnCollidedElements(collisions);
		reMoveCollidedElements(collisions);
	}
	
	private void moveAllElements() {
		for(FrameElement mover : m_movers) {
			mover.move();
		}
	}
	
	private Iterable<CollisionPair> getCollisions() {
		Collection<CollisionPair> collisions = new TreeSet<CollisionPair>();
		for(FrameElement mover : m_movers) {
			for(FrameElement potentiallyCollidedWith : m_movers) {
				if(mover != potentiallyCollidedWith &&
						mover.isOverlapping(potentiallyCollidedWith)) {
					
					CollisionPair collision =
							new CollisionPair(mover, potentiallyCollidedWith);
					collisions.add(collision);
				}
			}
			for(FrameElement potentiallyCollidedWith : m_nonMovers) {
				if(mover.isOverlapping(potentiallyCollidedWith)) {
					CollisionPair collision =
							new CollisionPair(mover, potentiallyCollidedWith);
					collisions.add(collision);
				}
			}
		}
		return collisions;
	}
	
	private void unMoveCollidedElements(Iterable<CollisionPair> collisions) {
		for(CollisionPair collision : collisions) {
			collision.getFirst().unMove();
			collision.getSecond().unMove();
		}
	}
	
	private void callCollideOnCollidedElements(
			Iterable<CollisionPair> collisions
		) {
		
		for(CollisionPair collision : collisions) {
			FrameElement first = collision.getFirst();
			FrameElement second = collision.getSecond();
			first.collide(second);
			second.collide(first);
		}
	}
	
	private void reMoveCollidedElements(Iterable<CollisionPair> collisions) {
		for(CollisionPair collision : collisions) {
			collision.getFirst().move();
			collision.getSecond().move();
		}
	}

}
