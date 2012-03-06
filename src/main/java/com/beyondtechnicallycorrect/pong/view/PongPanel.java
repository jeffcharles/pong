package com.beyondtechnicallycorrect.pong.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelSubscription;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;

public final class PongPanel
	extends JPanel
	implements ActionListener {
	
	private static final long serialVersionUID = -9201528908073199529L;
	
	private final String NEW_GAME_ACTION = "new game";
	
	private final AppViewModel m_appViewModel;
	private final JButton m_newGameButton;
	private final Court m_court;
	
	public PongPanel(
			AppViewModel appViewModel,
			CourtViewModelSubscription viewModelChangeSubscription
		) {
		
		super();
		
		m_appViewModel = appViewModel;
		
		this.setLayout(new BorderLayout());
		
		m_newGameButton = new JButton("New game");
		m_newGameButton.setMnemonic(KeyEvent.VK_N);
		m_newGameButton.setActionCommand(NEW_GAME_ACTION);
		m_newGameButton.addActionListener(this);
		this.add(m_newGameButton, BorderLayout.NORTH);
		
		m_court = new Court(appViewModel);
		viewModelChangeSubscription.subscribe(m_court);
		this.add(m_court, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(NEW_GAME_ACTION)) {
			m_newGameButton.setEnabled(false);
			m_appViewModel.startMatch();
		}
	}

}
