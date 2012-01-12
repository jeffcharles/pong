package com.beyondtechnicallycorrect.pong.models.paddle;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehavioursFactory;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionModule;
import com.beyondtechnicallycorrect.pong.models.movement.MovementBehaviour;
import com.beyondtechnicallycorrect.pong.models.movement.MovementModule;
import com.beyondtechnicallycorrect.pong.models.placeable.OverlappingBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.PlaceableModule;
import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.position.PositionFactory;
import com.beyondtechnicallycorrect.pong.models.position.PositionModule;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityFactory;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public final class PaddleFactoryImplIT {
	
	@Test
	public void testCreate_ShouldNotReturnNull() {
		Injector injector = Guice.createInjector(
				new PositionModule(),
				new VelocityModule(),
				new PlaceableModule(),
				new MovementModule(),
				new CollisionModule()
			);
		
		VelocityFactory velocityFactory =
				injector.getInstance(VelocityFactory.class);
		OverlappingBehaviour overlappingBehaviour =
				injector.getInstance(OverlappingBehaviour.class);
		MovementBehaviour movementBehaviour =
				injector.getInstance(MovementBehaviour.class);
		CollisionBehavioursFactory collisionBehavioursFactory =
				injector.getInstance(CollisionBehavioursFactory.class);
		
		PaddleFactory paddleFactory = new PaddleFactoryImpl(
				velocityFactory,
				overlappingBehaviour,
				movementBehaviour,
				collisionBehavioursFactory
			);
		
		PaddleInstructionGetter instruction = new PaddleInstructionHolderImpl();
		PositionFactory positionFactory =
				injector.getInstance(PositionFactory.class);
		Position pos = positionFactory.create(0, 1, 0, 1);
		
		Paddle paddle = paddleFactory.create(instruction, pos);
		
		Assert.assertNotNull(paddle);
	}
	
	@Test
	public void testCreate_ShouldAddWallCollisionBehaviour() {
		Injector injector = Guice.createInjector(
				new PositionModule(),
				new VelocityModule(),
				new PlaceableModule(),
				new MovementModule(),
				new CollisionModule()
			);
		
		VelocityFactory velocityFactory =
				injector.getInstance(VelocityFactory.class);
		OverlappingBehaviour overlappingBehaviour =
				injector.getInstance(OverlappingBehaviour.class);
		MovementBehaviour movementBehaviour =
				injector.getInstance(MovementBehaviour.class);
		
		CollisionBehavioursStub cb = new CollisionBehavioursStub();
		CollisionBehavioursFactory collisionBehavioursFactory =
				new CollisionBehavioursFactoryStub(cb);
		
		PaddleFactory paddleFactory = new PaddleFactoryImpl(
				velocityFactory,
				overlappingBehaviour,
				movementBehaviour,
				collisionBehavioursFactory
			);
		
		PaddleInstructionGetter instruction = new PaddleInstructionHolderImpl();
		PositionFactory positionFactory =
				injector.getInstance(PositionFactory.class);
		Position pos = positionFactory.create(0, 1, 0, 1);
		
		paddleFactory.create(instruction, pos);
		
		Assert.assertTrue(cb.containsWallCollisionBehaviour());
	}

}
