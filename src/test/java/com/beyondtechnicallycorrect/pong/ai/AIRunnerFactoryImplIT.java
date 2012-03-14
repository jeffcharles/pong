package com.beyondtechnicallycorrect.pong.ai;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.ball.BallModule;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionModule;
import com.beyondtechnicallycorrect.pong.models.frame.FrameModule;
import com.beyondtechnicallycorrect.pong.models.game.GameModule;
import com.beyondtechnicallycorrect.pong.models.movement.MovementModule;
import com.beyondtechnicallycorrect.pong.models.paddle.PaddleModule;
import com.beyondtechnicallycorrect.pong.models.placeable.PlaceableModule;
import com.beyondtechnicallycorrect.pong.models.player.PlayerModule;
import com.beyondtechnicallycorrect.pong.models.position.PositionModule;
import com.beyondtechnicallycorrect.pong.models.terminalwall.TerminalWallModule;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityModule;
import com.beyondtechnicallycorrect.pong.models.wall.WallModule;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModelFactory;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModelModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public final class AIRunnerFactoryImplIT {
	
	@Test
	public void create_ShouldReturnNonNullAIRunner() {
		BallDestinationCalculator ballDestCalc =
				new BallDestinationCalculatorImpl();
		AIRunnerFactory factory = new AIRunnerFactoryImpl(ballDestCalc);
		Injector injector = getInjector();
		AppViewModelFactory appViewModelFactory =
				injector.getInstance(AppViewModelFactory.class);
		AppViewModel appViewModel = appViewModelFactory.create();
		
		AIRunner runner = factory.create(appViewModel);
		
		Assert.assertNotNull(runner);
	}
	
	private Injector getInjector() {
		Injector injector = Guice.createInjector(
				new AppViewModelModule(),
				new BallModule(),
				new CollisionModule(),
				new FrameModule(),
				new GameModule(),
				new MovementModule(),
				new PaddleModule(),
				new PlaceableModule(),
				new PlayerModule(),
				new PositionModule(),
				new TerminalWallModule(),
				new VelocityModule(),
				new WallModule()
			);
		return injector;
	}

}
