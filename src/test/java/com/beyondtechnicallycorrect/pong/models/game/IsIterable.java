package com.beyondtechnicallycorrect.pong.models.game;

import org.mockito.ArgumentMatcher;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;

public class IsIterable extends ArgumentMatcher<Iterable<Collidable>> {

	@Override
	public boolean matches(Object argument) {
		return argument instanceof Iterable<?>;
	}

}
