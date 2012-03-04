package com.beyondtechnicallycorrect.pong.viewmodel;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModel;
import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelGetter;

final class CourtViewModelGetterStub implements CourtViewModelGetter {

	private final CourtViewModel m_courtViewModelToReturn;
	
	public CourtViewModelGetterStub(
			CourtViewModel courtViewModelToReturn
		) {
		
		m_courtViewModelToReturn = courtViewModelToReturn;
	}
	
	@Override
	public CourtViewModel get() {
		return m_courtViewModelToReturn;
	}

}
