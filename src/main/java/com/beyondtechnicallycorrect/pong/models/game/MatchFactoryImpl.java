package com.beyondtechnicallycorrect.pong.models.game;

import java.util.ArrayList;
import java.util.Collection;

import com.beyondtechnicallycorrect.pong.models.ball.Ball;
import com.beyondtechnicallycorrect.pong.models.ball.BallFactory;
import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.frame.FrameRunner;
import com.beyondtechnicallycorrect.pong.models.paddle.Paddle;
import com.beyondtechnicallycorrect.pong.models.paddle.PaddleFactory;
import com.beyondtechnicallycorrect.pong.models.paddle.PaddleInstructionHolder;
import com.beyondtechnicallycorrect.pong.models.player.Player;
import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.position.PositionFactory;
import com.beyondtechnicallycorrect.pong.models.terminalwall.TerminalWall;
import com.beyondtechnicallycorrect.pong.models.terminalwall.TerminalWallFactory;
import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityFactory;
import com.beyondtechnicallycorrect.pong.models.wall.Wall;
import com.beyondtechnicallycorrect.pong.models.wall.WallFactory;
import com.google.inject.Inject;

public final class MatchFactoryImpl implements MatchFactory {
	
	private final PositionFactory m_positionFactory;
	private final VelocityFactory m_velocityFactory;
	private final PaddleFactory m_paddleFactory;
	private final BallFactory m_ballFactory;
	private final WallFactory m_wallFactory;
	private final TerminalWallFactory m_terminalWallFactory;
	private final FrameRunner m_frameRunner;
	
	@Inject
	public MatchFactoryImpl(
			PositionFactory positionFactory,
			VelocityFactory velocityFactory,
			PaddleFactory paddleFactory,
			BallFactory ballFactory,
			WallFactory wallFactory,
			TerminalWallFactory terminalWallFactory,
			FrameRunner frameRunner
		) {
		
		m_positionFactory = positionFactory;
		m_velocityFactory = velocityFactory;
		m_paddleFactory = paddleFactory;
		m_ballFactory = ballFactory;
		m_wallFactory = wallFactory;
		m_terminalWallFactory = terminalWallFactory;
		m_frameRunner = frameRunner;
	}
	
	/* (non-Javadoc)
	 * @see com.beyondtechnicallycorrect.pong.models.game.MatchFactory#create(com.beyondtechnicallycorrect.pong.models.game.CourtViewModelInitializer, com.beyondtechnicallycorrect.pong.models.player.Player, com.beyondtechnicallycorrect.pong.models.player.Player, com.beyondtechnicallycorrect.pong.models.paddle.PaddleInstructionHolder, com.beyondtechnicallycorrect.pong.models.paddle.PaddleInstructionHolder)
	 */
	@Override
	public void create(
			CourtViewModelInitializer viewModel,
			Player player,
			Player opponent,
			PaddleInstructionHolder playerPaddleInstructionHolder,
			PaddleInstructionHolder opponentPaddleInstructionHolder
		) {
		
		final int MAX_RIGHT_BOUNDARY = 1000;
		final int MAX_BOTTOM_BOUNDARY = 1000;
		final int WALL_THICKNESS = 10;
		
		final int TOP_BORDER = WALL_THICKNESS;
		final int BOTTOM_BORDER = MAX_BOTTOM_BOUNDARY - WALL_THICKNESS;
		final int DISTANCE_FROM_BORDER = 5;
		
		final int PADDLE_LEFT_X = 485;
		final int PADDLE_RIGHT_X = 515;
		final int PADDLE_HEIGHT = 5;
		
		final int PLAYER_TOP = TOP_BORDER + DISTANCE_FROM_BORDER;
		final int PLAYER_BOTTOM = PLAYER_TOP + PADDLE_HEIGHT;
		Position playerPaddlePosition =
				m_positionFactory.create(
						PADDLE_LEFT_X,
						PADDLE_RIGHT_X,
						PLAYER_TOP,
						PLAYER_BOTTOM
					);
		Paddle playerPaddle =
				m_paddleFactory.create(
						playerPaddleInstructionHolder,
						playerPaddlePosition
					);
		
		final int OPPONENT_BOTTOM = BOTTOM_BORDER - DISTANCE_FROM_BORDER;
		final int OPPONENT_TOP = OPPONENT_BOTTOM - PADDLE_HEIGHT;
		Position opponentPaddlePosition =
				m_positionFactory.create(
						PADDLE_LEFT_X,
						PADDLE_RIGHT_X,
						OPPONENT_TOP,
						OPPONENT_BOTTOM
					);
		Paddle opponentPaddle =
				m_paddleFactory.create(
						opponentPaddleInstructionHolder,
						opponentPaddlePosition
					);
		
		final int BALL_LEFT_X = 495;
		final int BALL_RIGHT_X = 505;
		final int BALL_TOP_Y = 495;
		final int BALL_BOTTOM_Y = 505;
		Position ballPosition = m_positionFactory.create(
				BALL_LEFT_X,
				BALL_RIGHT_X,
				BALL_TOP_Y,
				BALL_BOTTOM_Y
			);
		final int BALL_X_AMOUNT = 0;
		final int BALL_X_FRAMES = 1;
		final int BALL_Y_AMOUNT = -2;
		final int BALL_Y_FRAMES = 1;
		Velocity ballVelocity = m_velocityFactory.create(
				BALL_X_AMOUNT,
				BALL_X_FRAMES,
				BALL_Y_AMOUNT,
				BALL_Y_FRAMES
			);
		Ball ball = m_ballFactory.create(ballPosition, ballVelocity);
		
		final int LEFT_BORDER = WALL_THICKNESS;
		final int RIGHT_BORDER = MAX_BOTTOM_BOUNDARY - WALL_THICKNESS;
		
		Collection<Collidable> walls = new ArrayList<Collidable>();
		Wall leftWall = m_wallFactory.create(
				0,
				LEFT_BORDER,
				0,
				MAX_BOTTOM_BOUNDARY
			);
		walls.add(leftWall);
		Wall rightWall = m_wallFactory.create(
				RIGHT_BORDER,
				MAX_RIGHT_BOUNDARY,
				0,
				MAX_BOTTOM_BOUNDARY
			);
		walls.add(rightWall);
		
		Collection<Collidable> terminalWalls = new ArrayList<Collidable>();
		TerminalWall opponentTerminalWall =
				m_terminalWallFactory.create(
						0,
						MAX_RIGHT_BOUNDARY,
						0,
						TOP_BORDER,
						opponent
					);
		terminalWalls.add(opponentTerminalWall);
		TerminalWall playerTerminalWall =
				m_terminalWallFactory.create(
						0,
						MAX_RIGHT_BOUNDARY,
						BOTTOM_BORDER,
						MAX_BOTTOM_BOUNDARY,
						player
					);
		terminalWalls.add(playerTerminalWall);
		
		viewModel.initialize(
				playerPaddle,
				opponentPaddle,
				ball,
				walls,
				terminalWalls
			);
		
		m_frameRunner.initialize(
				playerPaddle,
				opponentPaddle,
				ball,
				walls,
				terminalWalls
			);
	}

}
