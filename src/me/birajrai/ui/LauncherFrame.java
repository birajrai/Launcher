package me.birajrai.ui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LauncherFrame {

	public LauncherFrame() {
		initialize();
	}
	
	public JFrame frame;
	public JPanel panel;

	private void initialize() {
		
		frame = new JFrame("Neppixel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(760, 415, 600, 300);
		frame.setVisible(true);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 600, 300);
		panel.setBackground(new Color(44, 47, 51));
		panel.repaint();
		panel.setVisible(true);
		
		JLabel label = new JLabel();
		label.setText("Neppixel Launcher");
		label.setForeground(Color.white);
		label.setBounds(3, 3, 100, 100);
		label.setVisible(true);
		panel.add(label);
		
		
		frame.getContentPane().add(panel);
		
	}
}
