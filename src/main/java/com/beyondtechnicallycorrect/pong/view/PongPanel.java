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
	
	private final String NEW_GAME_ACTION = "new game";
	
	private final AppViewModel m_appViewModel;
	private final JButton m_newGameButton;
	private final Court m_court;
	
	public PongPanel(
			AppViewModel appViewModel,
			CourtViewModelSubscription viewModelChangeSubscription,
			MatchStateSubscription matchStateSubscription
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
		
		matchStateSubscription.subscribe(this);
		
		this.setFocusable(true);
		this.addKeyListener(this);
		this.grabFocus();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(NEW_GAME_ACTION)) {
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
		m_newGameButton.setEnabled(false);
	}

	@Override
	public void matchEndingWithNoWinner() {
		m_newGameButton.setEnabled(true);
	}

	@Override
	public void matchEndingWithWinner(Player winningPlayer) {
		m_newGameButton.setEnabled(true);
	}

}
