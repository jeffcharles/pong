package com.beyondtechnicallycorrect.pong.models.game;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

public final class TestCourtViewModelImpl {
	
	@Test
	public void testGetPlayerPaddle() {
		MovableElement playerPaddle = new MovableElementStub();
		CourtViewModel cvm =
				new CourtViewModelImpl(playerPaddle, null, null, null, null);
		Assert.assertSame(playerPaddle, cvm.getPlayerPaddle());
	}
	
	@Test
	public void testGetOpponentPaddle() {
		MovableElement opponentPaddle = new MovableElementStub();
		CourtViewModel cvm =
				new CourtViewModelImpl(null, opponentPaddle, null, null, null);
		Assert.assertSame(opponentPaddle, cvm.getOpponentPaddle());
	}
	
	@Test
	public void testGetBall() {
		MovableElement ball = new MovableElementStub();
		CourtViewModel cvm =
				new CourtViewModelImpl(null, null, ball, null, null);
		Assert.assertSame(ball, cvm.getBall());
	}
	
	@Test
	public void testGetWalls() {
		Collection<Element> walls = new ArrayList<Element>();
		Element wall = new ElementStub();
		walls.add(wall);
		CourtViewModel cvm =
				new CourtViewModelImpl(null, null, null, walls, null);
		Assert.assertSame(walls, cvm.getWalls());
	}
	
	@Test
	public void testGetTerminalWalls() {
		Collection<Element> terminalWalls = new ArrayList<Element>();
		Element terminalWall = new ElementStub();
		terminalWalls.add(terminalWall);
		CourtViewModel cvm =
				new CourtViewModelImpl(null, null, null, null, terminalWalls);
		Assert.assertSame(terminalWalls, cvm.getTerminalWalls());
	}
}
