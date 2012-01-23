package com.beyondtechnicallycorrect.pong.models.terminalwall;

import static org.mockito.Mockito.*;

import junit.framework.Assert;

import org.junit.Test;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviours;
import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;
import com.beyondtechnicallycorrect.pong.models.player.Player;
import com.beyondtechnicallycorrect.pong.models.position.Position;

public final class TestTerminalWallImpl {
	
	@Test
	public void testGetX1() {
		final int X1 = 1;
		Position pos = new PositionStub(X1, 2, 3, 4);
		Player player = new PlayerStub();
		CollisionBehaviours cb = new CollisionBehavioursStub();
		TerminalWall wall = new TerminalWallImpl(pos, player, cb);
		Assert.assertEquals(X1, wall.getX1());
	}
	
	@Test
	public void testGetX2() {
		final int X2 = 2;
		Position pos = new PositionStub(1, X2, 3, 4);
		Player player = new PlayerStub();
		CollisionBehaviours cb = new CollisionBehavioursStub();
		TerminalWall wall = new TerminalWallImpl(pos, player, cb);
		Assert.assertEquals(X2, wall.getX2());
	}
	
	@Test
	public void testGetY1() {
		final int Y1 = 3;
		Position pos = new PositionStub(1, 2, Y1, 4);
		Player player = new PlayerStub();
		CollisionBehaviours cb = new CollisionBehavioursStub();
		TerminalWall wall = new TerminalWallImpl(pos, player, cb);
		Assert.assertEquals(Y1, wall.getY1());
	}
	
	@Test
	public void testGetY2() {
		final int Y2 = 4;
		Position pos = new PositionStub(1, 2, 3, Y2);
		Player player = new PlayerStub();
		CollisionBehaviours cb = new CollisionBehavioursStub();
		TerminalWall wall = new TerminalWallImpl(pos, player, cb);
		Assert.assertEquals(Y2, wall.getY2());
	}
	
	@Test
	public void testGetPlayer() {
		final Player PLAYER = new PlayerStub();
		Position pos = new PositionStub(1, 2, 3, 4);
		CollisionBehaviours cb = new CollisionBehavioursStub();
		TerminalWall wall = new TerminalWallImpl(pos, PLAYER, cb);
		Assert.assertEquals(PLAYER, wall.getPlayer());
	}
	
	@Test
	public void testCollide() {
		Position pos = new PositionStub(1, 2, 3, 4);
		Player player = new PlayerStub();
		CollisionBehaviours cb = mock(CollisionBehaviours.class);
		TerminalWall wall = new TerminalWallImpl(pos, player, cb);
		Placeable model = new PlaceableStub();
		
		wall.collide(model);
		
		verify(cb).collide(model);
	}

}
