package com.beyondtechnicallycorrect.pong.models.collision;

import java.util.ArrayList;
import java.util.Collection;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

final class CollisionBehavioursImpl implements CollisionBehaviours {

	private Collection<CollisionBehaviour<? extends Placeable>> m_behaviours;
	
	public CollisionBehavioursImpl() {
		m_behaviours = new ArrayList<CollisionBehaviour<? extends Placeable>>();
	}
	
	@Override
	public void addBehaviour(CollisionBehaviour<? extends Placeable> behaviour) {
		m_behaviours.add(behaviour);
	}

	@Override
	public void collide(Placeable collidedWith) {
		for(CollisionBehaviour<? extends Placeable> behaviour : m_behaviours) {
			Class<? extends Placeable> behaviourType = 
					behaviour.getTypeCollidedWith();
			boolean collidedWithImplementsBehaviourType =
					behaviourType.isInstance(collidedWith);
			if(collidedWithImplementsBehaviourType) {
				behaviour.collide(collidedWith);
			}
		}
	}

}
