package com.beyondtechnicallycorrect.pong.models.game;

import java.util.ArrayList;
import java.util.Collection;

import com.beyondtechnicallycorrect.pong.models.collision.Collidable;
import com.beyondtechnicallycorrect.pong.models.collision.MovableCollidable;
import com.google.inject.Inject;

final class CourtViewModelRepository implements CourtViewModelGetter,
		CourtViewModelInitializer, CourtViewModelUpdater {
	
	private final CollidableToElementAdaptor m_adaptor;
	
	private MovableCollidable m_playerPaddle;
	private MovableCollidable m_opponentPaddle;
	private MovableCollidable m_ball;
	private Iterable<Collidable> m_walls;
	private Iterable<Collidable> m_terminalWalls;
	
	private CourtViewModel m_currentViewModel;
	
	@Inject
	public CourtViewModelRepository(
			CollidableToElementAdaptor adaptor
		) {
		
		m_adaptor = adaptor;
	}

	@Override
	public void update() {
		assert(m_playerPaddle != null);
		assert(m_opponentPaddle != null);
		assert(m_ball != null);
		assert(m_walls != null);
		assert(m_terminalWalls != null);
		
		MovableElement playerPaddleElem =
				m_adaptor.getMovableElementFromMovableCollidable(m_playerPaddle);
		MovableElement opponentPaddleElem =
				m_adaptor.getMovableElementFromMovableCollidable(m_opponentPaddle);
		MovableElement ballElem =
				m_adaptor.getMovableElementFromMovableCollidable(m_ball);
		Collection<Element> wallElems = new ArrayList<Element>();
		for(Collidable wall : m_walls) {
			Element wallElem = m_adaptor.getElementFromCollidable(wall);
			wallElems.add(wallElem);
		}
		Collection<Element> terminalWallElems = new ArrayList<Element>();
		for(Collidable terminalWall : m_terminalWalls) {
			Element terminalWallElem =
					m_adaptor.getElementFromCollidable(terminalWall);
			terminalWallElems.add(terminalWallElem);
		}
		m_currentViewModel = new CourtViewModelImpl(
				playerPaddleElem,
				opponentPaddleElem,
				ballElem,
				wallElems,
				terminalWallElems
			);
	}

	@Override
	public CourtViewModel get() {
		assert(m_currentViewModel != null);
		
		return m_currentViewModel;
	}

	@Override
	public void initialize(
			MovableCollidable playerPaddle,
			MovableCollidable opponentPaddle,
			MovableCollidable ball,
			Iterable<Collidable> walls,
			Iterable<Collidable> terminalWalls
		) {
		
		m_playerPaddle = playerPaddle;
		m_opponentPaddle = opponentPaddle;
		m_ball = ball;
		m_walls = walls;
		m_terminalWalls = terminalWalls;
		
		update();
	}

}
