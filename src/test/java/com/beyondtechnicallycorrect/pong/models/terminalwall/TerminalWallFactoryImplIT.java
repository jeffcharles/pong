package com.beyondtechnicallycorrect.pong.models.terminalwall;

import org.junit.Assert;
import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehavioursFactory;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionModule;
import com.beyondtechnicallycorrect.pong.models.game.GameModule;
import com.beyondtechnicallycorrect.pong.models.game.MatchStatePublisher;
import com.beyondtechnicallycorrect.pong.models.player.Player;
import com.beyondtechnicallycorrect.pong.models.position.PositionFactory;
import com.beyondtechnicallycorrect.pong.models.position.PositionModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public final class TerminalWallFactoryImplIT {
	
	@Test
	public void testCreate_ShouldSetPositionsCorrectly() {
		Injector injector = Guice.createInjector(
				new PositionModule(),
				new CollisionModule(),
				new GameModule()
			);
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
		Injector injector = Guice.createInjector(
				new PositionModule(),
				new CollisionModule(),
				new GameModule()
			);
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

}
