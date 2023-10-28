package _03_Hangman;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Dictionary;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Hangman implements KeyListener {
	public static JFrame frame;
	public static JPanel panel;
	public static JLabel label;
	public static String text;
	public static Stack<String>  asdf;
	public static Random ran;
	public static String dictionary;
	
	public static void main(String[] args) {
		new _03_Hangman.Hangman().run();

	}

	public void run() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		text = "Press enter to start";
		asdf = new Stack<String>();
		
		
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
		int keyCode = e.getKeyCode();

		if (keyCode == 10) {
			String bingus = JOptionPane.showInputDialog(null, "bingus type a number from 0 to 266");
			int bingusNumber = Integer.parseInt(bingus);
			if (bingusNumber <= 0 || bingusNumber >= 266) {
				// end program or something
				System.exit(0);

			} else {
				for(int i = 0; i < bingusNumber; i++) {
				//push words from the dictionary to this stack	asdf.push();
					//asdf.push(Utilities.readRandomLineFromFile();
				}
				//make something that detects if a character is matching a character in the chosen word
				
				
				
				
				
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
