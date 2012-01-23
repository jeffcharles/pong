package com.beyondtechnicallycorrect.pong.models.paddle;

import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviour;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehaviours;
import com.beyondtechnicallycorrect.pong.models.collision.CollisionBehavioursFactory;
import com.beyondtechnicallycorrect.pong.models.movement.MovementBehaviour;
import com.beyondtechnicallycorrect.pong.models.placeable.OverlappingBehaviour;
import com.beyondtechnicallycorrect.pong.models.position.Position;
import com.beyondtechnicallycorrect.pong.models.velocity.Velocity;
import com.beyondtechnicallycorrect.pong.models.velocity.VelocityFactory;
import com.beyondtechnicallycorrect.pong.models.wall.Wall;
import com.google.inject.Inject;

final class PaddleFactoryImpl implements PaddleFactory {

	private final VelocityFactory m_velocityFactory;
	private final OverlappingBehaviour m_overlappingBehaviour;
	private final MovementBehaviour m_movementBehaviour;
	private final CollisionBehavioursFactory m_collisionBehavioursFactory;
	private final com.beyondtechnicallycorrect.pong.models.collision.WallCollisionBehaviour m_wallCollisionBehaviour;
	
	@Inject
	public PaddleFactoryImpl(
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
	public Paddle create(
			PaddleInstructionGetter instruction,
			Position position
		) {
		
		Velocity zeroVelocity = m_velocityFactory.create(0, 1, 0, 1);
		
		InstructionToVelocityConverter converter =
				new InstructionToHorizontalVelocityConverter(
						m_velocityFactory
					);
		
		InternalPaddle internalPaddle = new InternalPaddleImpl(
				m_velocityFactory,
				m_overlappingBehaviour,
				m_movementBehaviour,
				converter,
				instruction,
				position,
				zeroVelocity
			);
		
		CollisionBehaviours collisionBehaviours =
				m_collisionBehavioursFactory.create();
		
		WallCollisionAdjustVelocityDelegate adjustVelocityDelegate =
				new WallCollisionAdjustVelocityDelegate();
		
		CollisionBehaviour<Wall> wallBehaviour =
				new WallCollisionBehaviour(
						m_wallCollisionBehaviour,
						adjustVelocityDelegate,
						internalPaddle
					);
		
		collisionBehaviours.addBehaviour(wallBehaviour);
		
		Paddle paddle = new PaddleImpl(internalPaddle, collisionBehaviours);
		
		return paddle;
	}

}
