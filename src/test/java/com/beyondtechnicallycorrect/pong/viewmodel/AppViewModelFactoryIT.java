package com.beyondtechnicallycorrect.pong.viewmodel;

import static org.mockito.Mockito.*;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.ball.BallModule;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionModule;
import com.beyondtechnicallycorrect.pong.models.frame.FrameModule;
import com.beyondtechnicallycorrect.pong.models.frame.FrameRunner;
import com.beyondtechnicallycorrect.pong.models.game.GameModule;
import com.beyondtechnicallycorrect.pong.models.game.MatchStatePublisher;
import com.beyondtechnicallycorrect.pong.models.game.MatchStateSubscription;
import com.beyondtechnicallycorrect.pong.models.movement.MovementModule;
import com.beyondtechnicallycorrect.pong.models.paddle.PaddleModule;
import com.beyondtechnicallycorrect.pong.models.placeable.PlaceableModule;
import com.beyondtechnicallycorrect.pong.models.player.PlayerModule;
import com.beyondtechnicallycorrect.pong.models.player.ScoringSubscriber;
import com.beyondtechnicallycorrect.pong.models.position.PositionModule;
import com.beyondtechnicallycorrect.pong.models.terminalwall.TerminalWallModule;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityModule;
import com.beyondtechnicallycorrect.pong.models.wall.WallModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public final class AppViewModelFactoryIT {
	
	@Test
	public void create_ShouldReturnNonNullAppViewModel() {
		Injector injector = getInjector();
		AppViewModelFactory factory =
				injector.getInstance(AppViewModelFactory.class);
		
		AppViewModel viewModel = factory.create();
		
		Assert.assertNotNull(viewModel);
	}
	
	@Test
	public void create_ShouldSubscribeFrameRunnerToMatchState() {
		Injector injector = getInjector();
		MatchStatePublisher publisher =
				injector.getInstance(MatchStatePublisher.class);
		MatchStateSubscription subscription =
				injector.getInstance(MatchStateSubscription.class);
		FrameRunner frameRunner = mock(FrameRunner.class);
		ScoringSubscriber scoringSubscriber = mock(ScoringSubscriber.class);
		AppViewModelFactory factory =
				new AppViewModelFactoryImpl(
						null,
						null,
						null,
						null,
						null,
						null,
						publisher,
						null,
						subscription,
						frameRunner,
						scoringSubscriber
					);
		
		AppViewModel viewModel = factory.create();
		viewModel.startMatch();
		
		verify(frameRunner).matchStarting();
	}
	
	@Test
	public void create_ShouldSubscribeScoringSubscriberToMatchState() {
		Injector injector = getInjector();
		MatchStatePublisher publisher =
				injector.getInstance(MatchStatePublisher.class);
		MatchStateSubscription subscription =
				injector.getInstance(MatchStateSubscription.class);
		FrameRunner frameRunner = mock(FrameRunner.class);
		ScoringSubscriber scoringSubscriber = mock(ScoringSubscriber.class);
		AppViewModelFactory factory =
				new AppViewModelFactoryImpl(
						null,
						null,
						null,
						null,
						null,
						null,
						publisher,
						null,
						subscription,
						frameRunner,
						scoringSubscriber
					);
		
		AppViewModel viewModel = factory.create();
		viewModel.startMatch();
		
		verify(scoringSubscriber).matchStarting();
	}
	
	private Injector getInjector() {
		Injector injector = Guice.createInjector(
				new AppViewModelModule(),
				new FrameModule(),
				new GameModule(),
				new BallModule(),
				new CollisionModule(),
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
