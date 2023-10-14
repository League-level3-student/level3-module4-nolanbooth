package _03_Hangman;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Hangman implements KeyListener {
	public static JFrame frame;
	public static JPanel panel;
	public static JLabel label;
	public static String text;

	public static void main(String[] args) {
		new _03_Hangman.Hangman().run();

	}

	public void run() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		text = "Bingus";
		
		frame.add(panel);
		panel.add(label);
		label.setText(text);
		
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override 
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode =  e.getKeyCode();
		
		if(keyCode == 69) {
		JOptionPane.showMessageDialog(null, "sup bingus");
		}
		
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
