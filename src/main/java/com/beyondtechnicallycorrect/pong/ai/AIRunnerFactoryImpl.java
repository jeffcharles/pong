package com.beyondtechnicallycorrect.pong.ai;

import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;

final class AIRunnerFactoryImpl implements AIRunnerFactory {

	@Override
	public AIRunner create(AppViewModel appViewModel) {
		AIDecisionMaker decisionMaker = new AIDecisionMakerImpl(appViewModel);
		AIRunner runner = new AIRunnerImpl(decisionMaker);
		return runner;
	}

}
