package com.beyondtechnicallycorrect.pong.models.game;

import static org.mockito.Mockito.*;

import org.junit.Test;

public final class TestCourtViewModelChangeNotification {
	
	@Test
	public void subscribeAndViewModelChange_ChangeShouldCallOnChange() {
		CourtViewModelSubscriber subscriber =
				mock(CourtViewModelSubscriber.class);
		CourtViewModelChangeNotification changeNotifierService =
				new CourtViewModelChangeNotification();
		
		changeNotifierService.subscribe(subscriber);
		changeNotifierService.viewModelChange();
		
		verify(subscriber).onViewModelChange();
	}

}
