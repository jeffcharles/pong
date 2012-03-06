package com.beyondtechnicallycorrect.pong.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModel;
import com.beyondtechnicallycorrect.pong.models.game.Element;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;

public final class Court extends JPanel {
	
	private static final long serialVersionUID = 5354932447452837128L;
	
	private final AppViewModel m_appViewModel;
	
	public Court(
			AppViewModel appViewModel
		) {
		
		m_appViewModel = appViewModel;
		this.setSize(1000, 1000);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		CourtViewModel viewModel = m_appViewModel.getViewModel();
		
		Element playerPaddle = viewModel.getPlayerPaddle();
		drawElement(g, playerPaddle);
		
		Element opponentPaddle = viewModel.getOpponentPaddle();
		drawElement(g, opponentPaddle);
		
		Element ball = viewModel.getBall();
		drawElement(g, ball);
		
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
		g.drawRect(x, y, width, height);
	}

}
