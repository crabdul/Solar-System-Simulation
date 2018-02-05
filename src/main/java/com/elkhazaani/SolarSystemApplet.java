package com.elkhazaani;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

public class SolarSystemApplet extends JApplet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SolarSystemGuiPanel panel;
	/** Create animation GUI panel and add to applet */
	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					panel = new SolarSystemGuiPanel();
					add(panel);
				} });
		}
		catch (Exception e) {
			System.err.println("Unable to initialize applet");
		}
	}
	/** Start animation when applet is started. */
	public void start() {panel.start();}
	/** Stop animation when applet is stopped. */
	public void stop() {panel.stop();}
}


