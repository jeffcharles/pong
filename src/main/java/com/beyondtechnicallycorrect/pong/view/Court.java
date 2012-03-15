package com.beyondtechnicallycorrect.pong.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModel;
import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelSubscriber;
import com.beyondtechnicallycorrect.pong.models.game.Element;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;

final class Court
	extends JComponent
	implements CourtViewModelSubscriber {
	
	private static final long serialVersionUID = 5354932447452837128L;
	
	private final AppViewModel m_appViewModel;
	
	public Court(
			AppViewModel appViewModel
		) {
		
		super();
		m_appViewModel = appViewModel;
		this.setPreferredSize(new Dimension(1000, 750));
		this.setOpaque(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 750);
		g.setColor(Color.BLACK);
		
		CourtViewModel viewModel = m_appViewModel.getViewModel();
		
		Element playerPaddle = viewModel.getPlayerPaddle();
		drawElement(g, playerPaddle);
		
		Element opponentPaddle = viewModel.getOpponentPaddle();
		drawElement(g, opponentPaddle);
		
		Element ball = viewModel.getBall();
		drawBall(g, ball);
		
		for(Element wall : viewModel.getWalls()) {
			drawElement(g, wall);
		}
		
		for(Element terminalWall : viewModel.getTerminalWalls()) {
			drawElement(g, terminalWall);
		}
	}
	
	private void drawElement(Graphics g, Element elem) {
		int x = elem.getX1();
		int width = elem.getX2() - x;
		int y = elem.getY1();
		int height = elem.getY2() - y;
		g.fillRect(x, y, width, height);
	}
	
	private void drawBall(Graphics g, Element ball) {
		int x = ball.getX1();
		int width = ball.getX2() - x;
		int y = ball.getY1();
		int height = ball.getY2() - y;
		g.fillOval(x, y, width - 1, height - 1);
	}

	@Override
	public void onViewModelChange() {
		this.repaint(19);
	}

}
