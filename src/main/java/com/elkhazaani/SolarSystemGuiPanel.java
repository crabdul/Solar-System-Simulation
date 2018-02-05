package com.elkhazaani;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * JPanel with animation panel, title, and buttons
 */
public class SolarSystemGuiPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SolarSystemAnimationPanel solarPanel;
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;
	private JLabel title;
	/** Create JPanel containing animation panel and buttons. */
	public SolarSystemGuiPanel() {
		super();
		setPreferredSize(new Dimension(1300,800)); // GUI dimensions
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		title = new JLabel("The Wild Wild Solar System"); // GUI title
		solarPanel = new SolarSystemAnimationPanel(1000, 700); // Animation dimension
		startButton = new JButton("Start"); // Animation start 
		stopButton  = new JButton("Stop"); // Animation stop
		exitButton = new JButton("Exit"); // Animation exit
		/* Action when buttons pressed */
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		/* Add buttons to button panel */
		buttonPanel.setLayout(new BoxLayout(
				buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(exitButton);
		/* Add components to main panel */
		add(title, BorderLayout.PAGE_START);
		add(solarPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.LINE_END);
	}

	/** Respond to button clicks */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) start();
		else if (e.getSource()==stopButton) stop();
		else if (e.getSource()==exitButton) System.exit(0);
	}
	/** Start animation when applet is started */
	public void start() {solarPanel.start();}
	/** Stop animation when applet is stopped */
	public void stop() {solarPanel.stop();}

}
