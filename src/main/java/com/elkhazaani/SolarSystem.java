package com.elkhazaani;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/*
 * App representing the solar system with start, stop buttons
 */

public class SolarSystem {

	private static void createAndDisplayGui() {
		JFrame frame = new JFrame("The Wild Wild Solar System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SolarSystemGuiPanel panel = new SolarSystemGuiPanel(); 

		frame.add(panel);       // Add panel to frame
		frame.pack();           // Set component sizes and layout
		frame.setVisible(true); // Display the resulting frame
	}
	/** Respond to button clicks */
	public void actionPerformed(ActionEvent e) {
		
	}
	/** Call method to create and display GUI. */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndDisplayGui();
			}
		}); 
	}
}
