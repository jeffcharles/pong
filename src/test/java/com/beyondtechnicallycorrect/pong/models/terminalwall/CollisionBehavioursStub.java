package com.beyondtechnicallycorrect.pong.models.terminalwall;

import java.util.ArrayList;
import java.util.Collection;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviours;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

final class CollisionBehavioursStub implements CollisionBehaviours {

	private final Collection<CollisionBehaviour<? extends Placeable>> m_behaviours;
	
	public CollisionBehavioursStub() {
		m_behaviours = new ArrayList<CollisionBehaviour<? extends Placeable>>();
	}
	
	@Override
	public void addBehaviour(CollisionBehaviour<? extends Placeable> behaviour) {
		m_behaviours.add(behaviour);
	}

	@Override
	public void collide(Placeable collidedWith) {
		// TODO Auto-generated method stub

	}
	
	public boolean containsBallCollisionBehaviour() {
		for(CollisionBehaviour<? extends Placeable> behaviour : m_behaviours) {
			if(behaviour instanceof BallCollisionBehaviour) {
				return true;
			}
		}
		return false;
	}

}
