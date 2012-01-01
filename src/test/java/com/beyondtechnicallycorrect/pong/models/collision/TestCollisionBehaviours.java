package com.beyondtechnicallycorrect.pong.models.collision;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.beyondtechnicallycorrect.pong.models.placeable.Placeable;

@RunWith(MockitoJUnitRunner.class)
public final class TestCollisionBehaviours {

	@Mock private CollisionBehaviour<PlaceableStub> m_behaviour;
	@Mock private CollisionBehaviour<PlaceableStub> m_otherBehaviour;
	@Mock private CollisionBehaviour<PlaceableStub2> m_behaviour2;
	
	@Before
	public void setUp() {
		Class<PlaceableStub> placeableStubClass = PlaceableStub.class;
		when(m_behaviour.getTypeCollidedWith()).thenReturn(placeableStubClass);
		
		when(m_otherBehaviour.getTypeCollidedWith()).thenReturn(placeableStubClass);
		
		Class<PlaceableStub2> placeableStubClass2 = PlaceableStub2.class;
		when(m_behaviour2.getTypeCollidedWith()).thenReturn(placeableStubClass2);
	}
	
	@Test
	public void testCollide_WhenCorrectTypeInCollection_ShouldCallCollide() {
		CollisionBehaviours cb = new CollisionBehavioursImpl();
		cb.addBehaviour(m_behaviour);
		Placeable pl = new PlaceableStub();
		
		cb.collide(pl);
		
		verify(m_behaviour).collide(pl);
	}
	
	@Test
	public void testCollide_WhenCorrectTypeNotInCollection_ShouldNotCallCollide() {
		CollisionBehaviours cb = new CollisionBehavioursImpl();
		cb.addBehaviour(m_behaviour2);
		Placeable pl = new PlaceableStub();
		
		cb.collide(pl);
		
		verify(m_behaviour2, never()).collide(pl);
	}
	
	@Test
	public void testCollide_WhenTwoCorrectTypesInCollection_ShouldCallCollideOnBoth() {
		CollisionBehaviours cb = new CollisionBehavioursImpl();
		cb.addBehaviour(m_behaviour);
		cb.addBehaviour(m_otherBehaviour);
		Placeable pl = new PlaceableStub();
		
		cb.collide(pl);
		
		verify(m_behaviour).collide(pl);
		verify(m_otherBehaviour).collide(pl);
	}
}
