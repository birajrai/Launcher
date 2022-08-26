package me.birajrai.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
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
		
		URL fontUrl = null;
		try {
			fontUrl = new URL("https://github.com/birajrai/Launcher/raw/main/libs/Magical%20Story.ttf");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream()).deriveFont(Font.BOLD, 30);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Font fontSmall = null;
		try {
			fontSmall = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream()).deriveFont(Font.BOLD, 18);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
		label.setBounds(3, 3, 0, 0);
		label.setVisible(true);
		label.setFont(font);
		panel.add(label);
		
		JButton button = new JButton();
		button.setFont(fontSmall);
		button.setText("Launch Neppixel");
		button.setBounds(250, 270, 350, 290);
		button.setBackground(new Color(114, 137, 218));
		button.setForeground(Color.WHITE);
		button.setVisible(true);
		panel.add(button);
		
		
		frame.getContentPane().add(panel);
		
	}
}
