package com.beyondtechnicallycorrect.pong;


import javax.swing.JFrame;

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
import com.beyondtechnicallycorrect.pong.view.PongPanel;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModelFactory;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModelModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						setupGui();
					}
			});
	}
	
	private static void setupGui() {
		Injector injector = getInjector();
		AppViewModelFactory appViewModelFactory =
				injector.getInstance(AppViewModelFactory.class);
		AppViewModel appViewModel = appViewModelFactory.create();
		
		appViewModel.createMatch();
		
		JFrame frame = new JFrame("Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PongPanel pongPanel = new PongPanel(appViewModel);
		frame.getContentPane().add(pongPanel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private static Injector getInjector() {
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
