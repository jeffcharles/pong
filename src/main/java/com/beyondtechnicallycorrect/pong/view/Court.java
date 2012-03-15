package com.beyondtechnicallycorrect.pong.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import com.beyondtechnicallycorrect.pong.models.game.CourtViewModel;
import com.beyondtechnicallycorrect.pong.models.game.CourtViewModelSubscriber;
import com.beyondtechnicallycorrect.pong.models.game.Element;
import com.beyondtechnicallycorrect.pong.viewmodel.AppViewModel;

final class Court
	extends JComponent
	implements CourtViewModelSubscriber {
	
	private static final long serialVersionUID = 5354932447452837128L;
	
	private final int m_courtWidth;
	private final int m_courtHeight;
	
	private final AppViewModel m_appViewModel;
	
	public Court(
			AppViewModel appViewModel
		) {
		
		super();
		m_appViewModel = appViewModel;
		int rightMostWallBorder = 0;
		for(Element wall : m_appViewModel.getViewModel().getWalls()) {
			if(wall.getX2() > rightMostWallBorder) {
				rightMostWallBorder = wall.getX2();
			}
		}
		int wallThickness = getWallThickness();
		m_courtWidth = rightMostWallBorder - 2 * wallThickness;
		int bottomMostTerminalWallBorder = 0;
		for(Element terminalWall :
				m_appViewModel.getViewModel().getTerminalWalls()
			) {
			
			if(terminalWall.getY2() > bottomMostTerminalWallBorder) {
				bottomMostTerminalWallBorder = terminalWall.getY2();
			}
		}
		m_courtHeight = bottomMostTerminalWallBorder - 2 * wallThickness;
		
		this.setPreferredSize(new Dimension(m_courtWidth, m_courtHeight));
		this.setOpaque(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON
			);
		
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, m_courtWidth, m_courtHeight);
		g2.setColor(Color.BLACK);
		
		CourtViewModel viewModel = m_appViewModel.getViewModel();
		
		Element playerPaddle = viewModel.getPlayerPaddle();
		drawPaddle(g2, playerPaddle);
		
		Element opponentPaddle = viewModel.getOpponentPaddle();
		drawPaddle(g2, opponentPaddle);
		
		Element ball = viewModel.getBall();
		drawBall(g2, ball);
	}
	
	private void drawBall(Graphics g, Element ball) {
		int vmX = ball.getX1();
		int x = convertViewModelPositionToCourtPosition(vmX);
		int width = getWidth(ball);
		int vmY = ball.getY1();
		int y = convertViewModelPositionToCourtPosition(vmY);
		int height = getHeight(ball);
		g.fillOval(x, y, width - 1, height - 1);
	}
	
	private void drawPaddle(Graphics g, Element paddle) {
		int vmX = paddle.getX1();
		int x = convertViewModelPositionToCourtPosition(vmX);
		int width = getWidth(paddle);
		int vmY = paddle.getY1();
		int y = convertViewModelPositionToCourtPosition(vmY);
		int height = getHeight(paddle);
		final int ARC_WIDTH = 10;
		final int ARC_HEIGHT = 10;
		g.fillRoundRect(x, y, width + 1, height + 1, ARC_WIDTH, ARC_HEIGHT);
	}
	
	private int getWidth(Element elem) {
		int width = elem.getX2() - elem.getX1();
		return width;
	}
	
	private int getHeight(Element elem) {
		int height = elem.getY2() - elem.getY1();
		return height;
	}
	
	private int convertViewModelPositionToCourtPosition(
			int viewModelPosition
		) {
		
		int wallThickness = getWallThickness();
		int courtPosition = viewModelPosition - wallThickness;
		return courtPosition;
	}
	
	private int getWallThickness() {
		Element wall =
				m_appViewModel.getViewModel().getWalls().iterator().next();
		int wallThickness = wall.getX2() - wall.getX1();
		return wallThickness;
	}

	@Override
	public void onViewModelChange() {
		this.repaint(19);
	}

}
