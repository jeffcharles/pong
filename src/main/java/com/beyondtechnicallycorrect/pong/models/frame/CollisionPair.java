package com.beyondtechnicallycorrect.pong.models.frame;

final class CollisionPair implements Comparable<CollisionPair> {
	
	private final FrameElement m_first;
	private final FrameElement m_second;
	
	public CollisionPair(
			FrameElement first,
			FrameElement second
		) {
		
		m_first = first;
		m_second = second;
	}
	
	public FrameElement getFirst() {
		return m_first;
	}
	
	public FrameElement getSecond() {
		return m_second;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof CollisionPair)) {
			return false;
		}
		CollisionPair other = (CollisionPair)o;
		boolean sameOrder =
				m_first == other.getFirst() && m_second == other.getSecond();
		boolean oppositeOrder =
				m_first == other.getSecond() && m_second == other.getFirst();
		return sameOrder || oppositeOrder;
	}

	@Override
	public int compareTo(CollisionPair o) {
		if(equals(o)) {
			return 0;
		}
		int firstHash = m_first.hashCode();
		int secondHash = m_second.hashCode();
		int firstOtherHash = o.getFirst().hashCode();
		int secondOtherHash = o.getSecond().hashCode();
		if(firstHash > firstOtherHash) {
			return 1;
		}
		if(firstHash < firstOtherHash) {
			return -1;
		}
		if(secondHash > secondOtherHash) {
			return 1;
		}
		return -1;
	}

}
