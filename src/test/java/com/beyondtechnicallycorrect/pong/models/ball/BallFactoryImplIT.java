package com.beyondtechnicallycorrect.pong.models.ball;

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
import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityFactory;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public final class BallFactoryImplIT {

	@Test
	public void testCreate_ShouldNotReturnNull() {
		Injector injector = setUpInjector();
		VelocityFactory velFactory =
				injector.getInstance(VelocityFactory.class);
		OverlappingBehaviour overlappingBehaviour =
				injector.getInstance(OverlappingBehaviour.class);
		MovementBehaviour movementBehaviour =
				injector.getInstance(MovementBehaviour.class);
		CollisionBehavioursFactory collisionBehavioursFactory =
				injector.getInstance(CollisionBehavioursFactory.class);
		com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour wallCollisionBehaviour =
				injector.getInstance(com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour.class);
		
		BallFactory factory = new BallFactoryImpl(
				velFactory,
				overlappingBehaviour,
				movementBehaviour,
				collisionBehavioursFactory,
				wallCollisionBehaviour
			);
		
		PositionFactory positionFactory =
				injector.getInstance(PositionFactory.class);
		Position pos = positionFactory.create(1, 2, 1, 2);
		Velocity vel = velFactory.create(2, 1, 0, 1);
		
		Ball ball = factory.create(pos, vel);
		
		Assert.assertNotNull(ball);
	}
	
	@Test
	public void testCreate_ShouldAddPaddleCollisionBehaviour() {
		Injector injector = setUpInjector();
		VelocityFactory velFactory =
				injector.getInstance(VelocityFactory.class);
		OverlappingBehaviour overlappingBehaviour =
				injector.getInstance(OverlappingBehaviour.class);
		MovementBehaviour movementBehaviour =
				injector.getInstance(MovementBehaviour.class);
		com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour wallCollisionBehaviour =
				injector.getInstance(com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour.class);
		
		CollisionBehavioursStub cb = new CollisionBehavioursStub();
		CollisionBehavioursFactory collisionBehavioursFactory =
				new CollisionBehavioursFactoryStub(cb);
		
		BallFactory factory = new BallFactoryImpl(
				velFactory,
				overlappingBehaviour,
				movementBehaviour,
				collisionBehavioursFactory,
				wallCollisionBehaviour
			);
		
		PositionFactory positionFactory =
				injector.getInstance(PositionFactory.class);
		Position pos = positionFactory.create(1, 2, 1, 2);
		Velocity vel = velFactory.create(2, 1, 0, 1);
		
		factory.create(pos, vel);
		
		Assert.assertTrue(cb.containsPaddleCollisionBehaviour());
	}
	
	@Test
	public void testCreate_ShouldAddTerminalWallCollisionBehaviour() {
		Injector injector = setUpInjector();
		VelocityFactory velFactory =
				injector.getInstance(VelocityFactory.class);
		OverlappingBehaviour overlappingBehaviour =
				injector.getInstance(OverlappingBehaviour.class);
		MovementBehaviour movementBehaviour =
				injector.getInstance(MovementBehaviour.class);
		com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour wallCollisionBehaviour =
				injector.getInstance(com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour.class);
		
		CollisionBehavioursStub cb = new CollisionBehavioursStub();
		CollisionBehavioursFactory collisionBehavioursFactory =
				new CollisionBehavioursFactoryStub(cb);
		
		BallFactory factory = new BallFactoryImpl(
				velFactory,
				overlappingBehaviour,
				movementBehaviour,
				collisionBehavioursFactory,
				wallCollisionBehaviour
			);
		
		PositionFactory positionFactory =
				injector.getInstance(PositionFactory.class);
		Position pos = positionFactory.create(1, 2, 1, 2);
		Velocity vel = velFactory.create(2, 1, 0, 1);
		
		factory.create(pos, vel);
		
		Assert.assertTrue(cb.containsTerminalWallCollisionBehaviour());
	}
	
	@Test
	public void testCreate_ShouldAddWallCollisionBehaviour() {
		Injector injector = setUpInjector();
		VelocityFactory velFactory =
				injector.getInstance(VelocityFactory.class);
		OverlappingBehaviour overlappingBehaviour =
				injector.getInstance(OverlappingBehaviour.class);
		MovementBehaviour movementBehaviour =
				injector.getInstance(MovementBehaviour.class);
		com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour wallCollisionBehaviour =
				injector.getInstance(com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour.class);
		
		CollisionBehavioursStub cb = new CollisionBehavioursStub();
		CollisionBehavioursFactory collisionBehavioursFactory =
				new CollisionBehavioursFactoryStub(cb);
		
		BallFactory factory = new BallFactoryImpl(
				velFactory,
				overlappingBehaviour,
				movementBehaviour,
				collisionBehavioursFactory,
				wallCollisionBehaviour
			);
		
		PositionFactory positionFactory =
				injector.getInstance(PositionFactory.class);
		Position pos = positionFactory.create(1, 2, 1, 2);
		Velocity vel = velFactory.create(2, 1, 0, 1);
		
		factory.create(pos, vel);
		
		Assert.assertTrue(cb.containsWallCollisionBehaviour());
	}
	
	private Injector setUpInjector() {
		Injector injector = Guice.createInjector(
				new PositionModule(),
				new VelocityModule(),
				new PlaceableModule(),
				new MovementModule(),
				new CollisionModule()
			);
		return injector;
	}
	
}
