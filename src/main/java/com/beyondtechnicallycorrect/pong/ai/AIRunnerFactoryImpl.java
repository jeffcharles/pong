package com.beyondtechnicallycorrect.pong.ai;

import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;
import com.google.inject.Inject;

final class AIRunnerFactoryImpl implements AIRunnerFactory {
	
	private final BallDestinationCalculator m_ballDestCalculator;
	
	@Inject
	public AIRunnerFactoryImpl(
			BallDestinationCalculator ballDestCalculator
		) {
		
		m_ballDestCalculator = ballDestCalculator;
	}

	@Override
	public AIRunner create(AppViewModel appViewModel) {
		AIDecisionMaker decisionMaker =
				new AIDecisionMakerImpl(appViewModel, m_ballDestCalculator);
		AIRunner runner = new AIRunnerImpl(decisionMaker);
		return runner;
	}

}
