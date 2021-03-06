package com.beyondtechnicallycorrect.pong.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
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
	private final String SCORE_FORMAT = "Player: %d   Opponent: %d";
	
	private final char MOVE_LEFT = 'a';
	private final char MOVE_RIGHT = 'd';
	
	private final AppViewModel m_appViewModel;
	private final JLabel m_score;
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
		
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new BorderLayout());
		
		m_score = new JLabel(String.format(SCORE_FORMAT, 0, 0));
		upperPanel.add(m_score, BorderLayout.LINE_START);
		
		m_startMatchButton = new JButton("Start match");
		m_startMatchButton.setMnemonic(KeyEvent.VK_N);
		m_startMatchButton.setActionCommand(START_MATCH_ACTION);
		m_startMatchButton.addActionListener(this);
		upperPanel.add(m_startMatchButton, BorderLayout.LINE_END);
		
		this.add(upperPanel, BorderLayout.PAGE_START);
		
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
			m_appViewModel.createMatch();
			m_appViewModel.startMatch();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char keyPressed = Character.toLowerCase(e.getKeyChar());
		if(keyPressed == MOVE_LEFT) {
			m_appViewModel.movePlayerPaddleLeft();
		}
		if(keyPressed == MOVE_RIGHT) {
			m_appViewModel.movePlayerPaddleRight();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		char keyPressed = Character.toLowerCase(e.getKeyChar());
		if(keyPressed == MOVE_LEFT || keyPressed == MOVE_RIGHT) {
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
		int playerScore = m_appViewModel.getPlayerScore();
		int opponentScore = m_appViewModel.getOpponentScore();
		m_score.setText(
				String.format(SCORE_FORMAT, playerScore, opponentScore));
	}

}
