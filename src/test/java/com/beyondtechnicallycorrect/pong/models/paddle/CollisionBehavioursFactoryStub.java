package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviours;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehavioursFactory;

final class CollisionBehavioursFactoryStub implements
		CollisionBehavioursFactory {

	private final CollisionBehaviours m_collisionBehavioursToReturn;
	
	public CollisionBehavioursFactoryStub(
			CollisionBehaviours collisionBehavioursToReturn
		) {
		
		m_collisionBehavioursToReturn = collisionBehavioursToReturn;
	}
	
	@Override
	public CollisionBehaviours create() {
		return m_collisionBehavioursToReturn;
	}

}
