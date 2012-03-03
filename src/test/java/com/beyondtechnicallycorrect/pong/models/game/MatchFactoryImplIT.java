package com.beyondtechnicallycorrect.pong.models.game;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.ball.BallModule;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionModule;
import com.beyondtechnicallycorrect.pong.models.movement.MovementModule;
import com.beyondtechnicallycorrect.pong.models.paddle.PaddleInstructionHolder;
import com.beyondtechnicallycorrect.pong.models.paddle.PaddleModule;
import com.beyondtechnicallycorrect.pong.models.placeable.PlaceableModule;
import com.beyondtechnicallycorrect.pong.models.player.Player;
import com.beyondtechnicallycorrect.pong.models.player.PlayerModule;
import com.beyondtechnicallycorrect.pong.models.position.PositionModule;
import com.beyondtechnicallycorrect.pong.models.terminalwall.TerminalWallModule;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityModule;
import com.beyondtechnicallycorrect.pong.models.wall.WallModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public final class MatchFactoryImplIT {
	
	@Test
	public void create_ShouldPlaceThingsInTheRightPosition() {
		Injector injector = Guice.createInjector(
				new GameModule(),
				new BallModule(),
				new CollisionModule(),
				new MovementModule(),
				new PaddleModule(),
				new PlaceableModule(),
				new PositionModule(),
				new TerminalWallModule(),
				new VelocityModule(),
				new WallModule(),
				new PlayerModule()
			);
		CollidableToElementAdaptor adaptor =
				injector.getInstance(CollidableToElementAdaptor.class);
		CourtViewModelChangePublisher changePublisher =
				injector.getInstance(CourtViewModelChangePublisher.class);
		CourtViewModelRepository viewModelRepo =
				new CourtViewModelRepository(adaptor, changePublisher);
		MatchFactory factory = injector.getInstance(MatchFactory.class);
		Player player = injector.getInstance(Player.class);
		Player opponent = injector.getInstance(Player.class);
		PaddleInstructionHolder playerPaddleInstructionHolder =
				injector.getInstance(PaddleInstructionHolder.class);
		PaddleInstructionHolder opponentPaddleInstructionHolder =
				injector.getInstance(PaddleInstructionHolder.class);
		factory.create(
				viewModelRepo,
				player,
				opponent,
				playerPaddleInstructionHolder,
				opponentPaddleInstructionHolder
			);
		CourtViewModel viewModel = viewModelRepo.get();
		Element wall = viewModel.getWalls().iterator().next();
		Assert.assertEquals("Top should be 0", 0, wall.getY1());
		Assert.assertEquals("Bottom should be 1000", 1000, wall.getY2());
		Element terminalWall = viewModel.getTerminalWalls().iterator().next();
		Assert.assertEquals("Left should be 0", 0, terminalWall.getX1());
		Assert.assertEquals("Right should be 1000", 1000, terminalWall.getX2());
	}

}
