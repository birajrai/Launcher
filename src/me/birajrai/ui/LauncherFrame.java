package me.birajrai.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
		
		URL fontUrl;
		try {
			fontUrl = new URL("");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream()).deriveFont(Font.BOLD, 30);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		frame = new JFrame("Neppixel Launcher");
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
