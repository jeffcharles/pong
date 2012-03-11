package com.beyondtechnicallycorrect.pong.ai;

import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;

public interface AIRunnerFactory {
	
	public AIRunner create(AppViewModel appViewModel);

}
