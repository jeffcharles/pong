package com.beyondtechnicallycorrect.pong.models.game;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;

public final class TestCourtViewModelRepository {
	
	@Test
	public void initialize_ShouldSetPlayerPaddlePosition() {
		final int PLAYER_PADDLE_X1 = 2;
		
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorStub();
		
		MovableCollidable playerPaddle =
				new MovableCollidableStub(PLAYER_PADDLE_X1);
		MovableCollidable opponentPaddle =
				new MovableCollidableStub(0);
		MovableCollidable ball = new MovableCollidableStub(0);
		Collection<Collidable> walls = new ArrayList<Collidable>();
		Collidable wall = new CollidableStub(0);
		walls.add(wall);
		Collection<Collidable> terminalWalls = new ArrayList<Collidable>();
		Collidable terminalWall = new CollidableStub(0);
		terminalWalls.add(terminalWall);
		
		CourtViewModelRepository repo = new CourtViewModelRepository(adaptor);
		
		repo.initialize(
				playerPaddle,
				opponentPaddle,
				ball,
				walls,
				terminalWalls
			);
		CourtViewModel viewModel = repo.get();
		int playerPaddleX1 = viewModel.getPlayerPaddle().getX1();
		
		Assert.assertEquals(PLAYER_PADDLE_X1, playerPaddleX1);
	}
	
	@Test
	public void initialize_ShouldSetOpponentPaddlePosition() {
		final int OPPONENT_PADDLE_X1 = 2;
		
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorStub();
		
		MovableCollidable playerPaddle =
				new MovableCollidableStub(0);
		MovableCollidable opponentPaddle =
				new MovableCollidableStub(OPPONENT_PADDLE_X1);
		MovableCollidable ball = new MovableCollidableStub(0);
		Collection<Collidable> walls = new ArrayList<Collidable>();
		Collidable wall = new CollidableStub(0);
		walls.add(wall);
		Collection<Collidable> terminalWalls = new ArrayList<Collidable>();
		Collidable terminalWall = new CollidableStub(0);
		terminalWalls.add(terminalWall);
		
		CourtViewModelRepository repo = new CourtViewModelRepository(adaptor);
		
		repo.initialize(
				playerPaddle,
				opponentPaddle,
				ball,
				walls,
				terminalWalls
			);
		CourtViewModel viewModel = repo.get();
		int opponentPaddleX1 = viewModel.getOpponentPaddle().getX1();
		
		Assert.assertEquals(OPPONENT_PADDLE_X1, opponentPaddleX1);
	}
	
	@Test
	public void initialize_ShouldSetBallPosition() {
		final int BALL_X1 = 2;
		
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorStub();
		
		MovableCollidable playerPaddle =
				new MovableCollidableStub(0);
		MovableCollidable opponentPaddle =
				new MovableCollidableStub(0);
		MovableCollidable ball = new MovableCollidableStub(BALL_X1);
		Collection<Collidable> walls = new ArrayList<Collidable>();
		Collidable wall = new CollidableStub(0);
		walls.add(wall);
		Collection<Collidable> terminalWalls = new ArrayList<Collidable>();
		Collidable terminalWall = new CollidableStub(0);
		terminalWalls.add(terminalWall);
		
		CourtViewModelRepository repo = new CourtViewModelRepository(adaptor);
		
		repo.initialize(
				playerPaddle,
				opponentPaddle,
				ball,
				walls,
				terminalWalls
			);
		CourtViewModel viewModel = repo.get();
		int ballX1 = viewModel.getBall().getX1();
		
		Assert.assertEquals(BALL_X1, ballX1);
	}
	
	@Test
	public void initialize_ShouldSetWallPosition() {
		final int WALL_X1 = 2;
		
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorStub();
		
		MovableCollidable playerPaddle =
				new MovableCollidableStub(0);
		MovableCollidable opponentPaddle =
				new MovableCollidableStub(0);
		MovableCollidable ball = new MovableCollidableStub(0);
		Collection<Collidable> walls = new ArrayList<Collidable>();
		Collidable wall = new CollidableStub(WALL_X1);
		walls.add(wall);
		Collection<Collidable> terminalWalls = new ArrayList<Collidable>();
		Collidable terminalWall = new CollidableStub(0);
		terminalWalls.add(terminalWall);
		
		CourtViewModelRepository repo = new CourtViewModelRepository(adaptor);
		
		repo.initialize(
				playerPaddle,
				opponentPaddle,
				ball,
				walls,
				terminalWalls
			);
		CourtViewModel viewModel = repo.get();
		int wallX1 = viewModel.getWalls().iterator().next().getX1();
		
		Assert.assertEquals(WALL_X1, wallX1);
	}
	
	@Test
	public void initialize_ShouldSetTerminalWallPosition() {
		final int TERMINAL_WALL_X1 = 2;
		
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorStub();
		
		MovableCollidable playerPaddle =
				new MovableCollidableStub(0);
		MovableCollidable opponentPaddle =
				new MovableCollidableStub(0);
		MovableCollidable ball = new MovableCollidableStub(0);
		Collection<Collidable> walls = new ArrayList<Collidable>();
		Collidable wall = new CollidableStub(0);
		walls.add(wall);
		Collection<Collidable> terminalWalls = new ArrayList<Collidable>();
		Collidable terminalWall = new CollidableStub(TERMINAL_WALL_X1);
		terminalWalls.add(terminalWall);
		
		CourtViewModelRepository repo = new CourtViewModelRepository(adaptor);
		
		repo.initialize(
				playerPaddle,
				opponentPaddle,
				ball,
				walls,
				terminalWalls
			);
		CourtViewModel viewModel = repo.get();
		int terminalWallX1 =
				viewModel.getTerminalWalls().iterator().next().getX1();
		
		Assert.assertEquals(TERMINAL_WALL_X1, terminalWallX1);
	}
	
	@Test
	public void update_ShouldUpdatePositionOfPlayerPaddle() {
		final int STARTING_PLAYER_PADDLE_X1 = 2;
		final int UPDATED_PLAYER_PADDLE_X1 = 3;
		
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorStub();
		
		MovableCollidableStub playerPaddle =
				new MovableCollidableStub(STARTING_PLAYER_PADDLE_X1);
		MovableCollidable opponentPaddle =
				new MovableCollidableStub(0);
		MovableCollidable ball = new MovableCollidableStub(0);
		Collection<Collidable> walls = new ArrayList<Collidable>();
		Collidable wall = new CollidableStub(0);
		walls.add(wall);
		Collection<Collidable> terminalWalls = new ArrayList<Collidable>();
		Collidable terminalWall = new CollidableStub(0);
		terminalWalls.add(terminalWall);
		
		CourtViewModelRepository repo = new CourtViewModelRepository(adaptor);
		
		repo.initialize(
				playerPaddle,
				opponentPaddle,
				ball,
				walls,
				terminalWalls
			);
		playerPaddle.setX1(UPDATED_PLAYER_PADDLE_X1);
		repo.update();
		CourtViewModel viewModel = repo.get();
		int updatedPlayerPaddleX1 = viewModel.getPlayerPaddle().getX1();
		
		Assert.assertEquals(UPDATED_PLAYER_PADDLE_X1, updatedPlayerPaddleX1);
	}
	
	@Test
	public void update_ShouldUpdatePositionOfOpponentPaddle() {
		final int STARTING_OPPONENT_PADDLE_X1 = 2;
		final int UPDATED_OPPONENT_PADDLE_X1 = 3;
		
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorStub();
		
		MovableCollidable playerPaddle =
				new MovableCollidableStub(0);
		MovableCollidableStub opponentPaddle =
				new MovableCollidableStub(STARTING_OPPONENT_PADDLE_X1);
		MovableCollidable ball = new MovableCollidableStub(0);
		Collection<Collidable> walls = new ArrayList<Collidable>();
		Collidable wall = new CollidableStub(0);
		walls.add(wall);
		Collection<Collidable> terminalWalls = new ArrayList<Collidable>();
		Collidable terminalWall = new CollidableStub(0);
		terminalWalls.add(terminalWall);
		
		CourtViewModelRepository repo = new CourtViewModelRepository(adaptor);
		
		repo.initialize(
				playerPaddle,
				opponentPaddle,
				ball,
				walls,
				terminalWalls
			);
		opponentPaddle.setX1(UPDATED_OPPONENT_PADDLE_X1);
		repo.update();
		CourtViewModel viewModel = repo.get();
		int updatedOpponentPaddleX1 = viewModel.getOpponentPaddle().getX1();
		
		Assert.assertEquals(UPDATED_OPPONENT_PADDLE_X1, updatedOpponentPaddleX1);
	}
	
	@Test
	public void update_ShouldUpdatePositionOfBall() {
		final int STARTING_BALL_X1 = 2;
		final int UPDATED_BALL_X1 = 3;
		
		CollidableToElementAdaptor adaptor =
				new CollidableToElementAdaptorStub();
		
		MovableCollidable playerPaddle =
				new MovableCollidableStub(0);
		MovableCollidable opponentPaddle =
				new MovableCollidableStub(0);
		MovableCollidableStub ball = new MovableCollidableStub(STARTING_BALL_X1);
		Collection<Collidable> walls = new ArrayList<Collidable>();
		Collidable wall = new CollidableStub(0);
		walls.add(wall);
		Collection<Collidable> terminalWalls = new ArrayList<Collidable>();
		Collidable terminalWall = new CollidableStub(0);
		terminalWalls.add(terminalWall);
		
		CourtViewModelRepository repo = new CourtViewModelRepository(adaptor);
		
		repo.initialize(
				playerPaddle,
				opponentPaddle,
				ball,
				walls,
				terminalWalls
			);
		ball.setX1(UPDATED_BALL_X1);
		repo.update();
		CourtViewModel viewModel = repo.get();
		int updatedBallX1 = viewModel.getBall().getX1();
		
		Assert.assertEquals(UPDATED_BALL_X1, updatedBallX1);
	}

}
