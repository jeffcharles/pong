package com.beyondtechnicallycorrect.pong.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelSubscription;
import com.beyondtechnicallycorrect.pong.models.game.MatchStateSubscriber;
import com.beyondtechnicallycorrect.pong.models.game.MatchStateSubscription;
import com.beyondtechnicallycorrect.pong.models.player.Player;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;

public final class PongPanel
	extends JPanel
	implements ActionListener, KeyListener, MatchStateSubscriber {
	
	private static final long serialVersionUID = -9201528908073199529L;
	
	private final String START_MATCH_ACTION = "start match";
	
	private final AppViewModel m_appViewModel;
	private final JButton m_startMatchButton;
	private final Court m_court;
	
	public PongPanel(
			AppViewModel appViewModel,
			CourtViewModelSubscription viewModelChangeSubscription,
			MatchStateSubscription matchStateSubscription
		) {
		
		super();
		
		m_appViewModel = appViewModel;
		
		this.setLayout(new BorderLayout());
		
		m_startMatchButton = new JButton("Start match");
		m_startMatchButton.setMnemonic(KeyEvent.VK_N);
		m_startMatchButton.setActionCommand(START_MATCH_ACTION);
		m_startMatchButton.addActionListener(this);
		this.add(m_startMatchButton, BorderLayout.NORTH);
		
		m_court = new Court(appViewModel);
		viewModelChangeSubscription.subscribe(m_court);
		this.add(m_court, BorderLayout.CENTER);
		
		matchStateSubscription.subscribe(this);
		
		this.setFocusable(true);
		this.addKeyListener(this);
		this.grabFocus();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(START_MATCH_ACTION)) {
			m_appViewModel.startMatch();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char keyPressed = e.getKeyChar();
		if(keyPressed == 'j') {
			m_appViewModel.movePlayerPaddleLeft();
		}
		if(keyPressed == 'l') {
			m_appViewModel.movePlayerPaddleRight();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		char keyPressed = e.getKeyChar();
		if(keyPressed == 'j' || keyPressed == 'l') {
			m_appViewModel.stopMovingPlayerPaddle();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Do nothing
	}

	@Override
	public void matchStarting() {
		m_startMatchButton.setEnabled(false);
	}

	@Override
	public void matchEndingWithNoWinner() {
		m_startMatchButton.setEnabled(true);
	}

	@Override
	public void matchEndingWithWinner(Player winningPlayer) {
		m_startMatchButton.setEnabled(true);
	}

}
