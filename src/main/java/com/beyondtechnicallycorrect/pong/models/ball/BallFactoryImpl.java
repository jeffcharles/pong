package com.beyondtechnicallycorrect.pong.models.ball;

import com.beyondtechnicallycorrect.pong.models.collision.AdjustVelocityDelegate;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviours;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehavioursFactory;
import com.beyondtechnicallycorrect.pong.models.movement.MovementBehaviour;
import com.beyondtechnicallycorrect.pong.models.paddle.Paddle;
import com.beyondtechnicallycorrect.pong.models.placeable.OverlappingBehaviour;
import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.terminalwall.TerminalWall;
import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityFactory;
import com.beyondtechnicallycorrect.pong.models.wall.Wall;
import com.google.inject.Inject;

final class BallFactoryImpl implements BallFactory {

	private final VelocityFactory m_velocityFactory;
	private final OverlappingBehaviour m_overlappingBehaviour;
	private final MovementBehaviour m_movementBehaviour;
	private final CollisionBehavioursFactory m_collisionBehavioursFactory;
	private final com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour m_wallCollisionBehaviour;
	
	@Inject
	public BallFactoryImpl(
			VelocityFactory velocityFactory,
			OverlappingBehaviour overlappingBehaviour,
			MovementBehaviour movementBehaviour,
			CollisionBehavioursFactory collisionBehavioursFactory,
			com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour wallCollisionBehaviour
		) {
		
		m_velocityFactory = velocityFactory;
		m_overlappingBehaviour = overlappingBehaviour;
		m_movementBehaviour = movementBehaviour;
		m_collisionBehavioursFactory = collisionBehavioursFactory;
		m_wallCollisionBehaviour = wallCollisionBehaviour;
	}
	
	@Override
	public Ball create(
			Position position,
			Velocity velocity
		) {
		
		InternalBall internalBall =
				new InternalBallImpl(
						m_velocityFactory,
						m_overlappingBehaviour,
						m_movementBehaviour,
						position,
						velocity
					);
		
		CollisionBehaviours cb = m_collisionBehavioursFactory.create();
		CollisionBehaviour<Paddle> paddleBehaviour =
				new PaddleCollisionBehaviour(internalBall);
		AdjustVelocityDelegate del = new WallCollisionAdjustVelocityDelegate();
		CollisionBehaviour<Wall> wallBehaviour =
				new WallCollisionBehaviour(
						m_wallCollisionBehaviour,
						del,
						internalBall
					);
		CollisionBehaviour<TerminalWall> terminalWallBehaviour =
				new TerminalWallCollisionBehaviour(internalBall);
		cb.addBehaviour(paddleBehaviour);
		cb.addBehaviour(wallBehaviour);
		cb.addBehaviour(terminalWallBehaviour);
		
		Ball ball = new BallImpl(internalBall, cb);
		
		return ball;
	}

}
