package com.beyondtechnicallycorrect.pong.models.terminalwall;

import org.junit.Assert;
import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.ball.BallModule;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehavioursFactory;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionModule;
import com.beyondtechnicallycorrect.pong.models.game.GameModule;
import com.beyondtechnicallycorrect.pong.models.game.MatchStatePublisher;
import com.beyondtechnicallycorrect.pong.models.movement.MovementModule;
import com.beyondtechnicallycorrect.pong.models.paddle.PaddleModule;
import com.beyondtechnicallycorrect.pong.models.placeable.PlaceableModule;
import com.beyondtechnicallycorrect.pong.models.player.Player;
import com.beyondtechnicallycorrect.pong.models.position.PositionFactory;
import com.beyondtechnicallycorrect.pong.models.position.PositionModule;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityModule;
import com.beyondtechnicallycorrect.pong.models.wall.WallModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public final class TerminalWallFactoryImplIT {
	
	@Test
	public void testCreate_ShouldSetPositionsCorrectly() {
		Injector injector = getInjector();
		PositionFactory posFactory = injector.getInstance(PositionFactory.class);
		CollisionBehavioursFactory cbFactory =
				injector.getInstance(CollisionBehavioursFactory.class);
		MatchStatePublisher publisher =
				injector.getInstance(MatchStatePublisher.class);
		TerminalWallFactory factory =
				new TerminalWallFactoryImpl(posFactory, cbFactory, publisher);
		
		final int X1 = 1;
		final int X2 = 2;
		final int Y1 = 3;
		final int Y2 = 4;
		Player player = new PlayerStub();
		TerminalWall wall = factory.create(X1, X2, Y1, Y2, player);
		
		Assert.assertEquals("X1 should be equal", X1, wall.getX1());
		Assert.assertEquals("X2 should be equal", X2, wall.getX2());
		Assert.assertEquals("Y1 should be equal", Y1, wall.getY1());
		Assert.assertEquals("Y2 should be equal", Y2, wall.getY2());
	}
	
	@Test
	public void testCreate_ShouldAddBallCollisionBehaviour() {
		Injector injector = getInjector();
		PositionFactory posFactory = injector.getInstance(PositionFactory.class);
		MatchStatePublisher publisher =
				injector.getInstance(MatchStatePublisher.class);
		
		CollisionBehavioursStub cb = new CollisionBehavioursStub();
		CollisionBehavioursFactory cbFactory = new CollisionBehavioursFactoryStub(cb);
		
		TerminalWallFactory factory =
				new TerminalWallFactoryImpl(posFactory, cbFactory, publisher);
		
		Player player = new PlayerStub();
		factory.create(0, 1, 0, 1, player);
		
		Assert.assertTrue(cb.containsBallCollisionBehaviour());
	}
	
	private Injector getInjector() {
		Injector injector = Guice.createInjector(
				new BallModule(),
				new PositionModule(),
				new CollisionModule(),
				new GameModule(),
				new MovementModule(),
				new PaddleModule(),
				new PlaceableModule(),
				new TerminalWallModule(),
				new VelocityModule(),
				new WallModule()
			);
		return injector;
	}

}
