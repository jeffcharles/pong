package com.beyondtechnicallycorrect.pong;

import javax.swing.JFrame;

public class App {

	public static void main( String[] args ) {
		javax.swing.SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						setupGui();
					}
			});
	}
	
	private static void setupGui() {
		JFrame frame = new JFrame("Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
}
