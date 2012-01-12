package com.beyondtechnicallycorrect.pong.models.collision;

final class CollisionBehavioursFactoryImpl implements
		CollisionBehavioursFactory {

	@Override
	public CollisionBehaviours create() {
		return new CollisionBehavioursImpl();
	}

}
