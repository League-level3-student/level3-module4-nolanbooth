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
	public static Stack<String> asdf;
	public static Random ran;
	public static String theWord;
	public static boolean playingGame = false;
	public static boolean canGuess = false;
	public static String display;
	public static int lives = 15;
	public static JLabel livesDisplay;

	public static void main(String[] args) {
		new _03_Hangman.Hangman().run();

	}

	public void run() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		text = "Press enter to start";
		asdf = new Stack<String>();
		livesDisplay = new JLabel();

		frame.add(panel);
		panel.add(livesDisplay);
		panel.add(label);
		label.setText(text);
		livesDisplay.setText("Lives: " + lives +"   :::::   ");

		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		String bingus = JOptionPane.showInputDialog(null, "Type a number from 0 - 266");
		int bingusNumber = Integer.parseInt(bingus);
		if (bingusNumber <= 0 || bingusNumber >= 266) {
			System.exit(0);
		} else {
			bill: for (int i = 0; i < bingusNumber; i++) {
				String word = Utilities.readRandomLineFromFile("dictionary.txt");
				if (asdf.contains(word)) {
					i -= 1;
				} else {
					asdf.push(word);
				}
				if (asdf.size() == bingusNumber) {
					break bill;
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();

		if (keyCode == 10 && playingGame == false) {
			playingGame = true;

			// make something that detects if a character is matching a character in the
			// chosen word
			// asdf now has a BingusNumber amount of random words
			theWord = asdf.pop();

			display = theWord.replaceAll("[a-zA-z]", "_");

			label.setText("The word is: " + theWord + " How it will look like: " + display);

			JOptionPane.showMessageDialog(null, "Start guessing letters");
			canGuess = true;
		}

		else {
			if (canGuess == true) {
				String letter = e.getKeyChar() + "";

				System.out.println(letter);

				if (theWord.contains(letter)) {
					// all good

					for (int k = 0; k < theWord.length(); k++) {
						if (letter.equals(theWord.charAt(k) + "")) {

							StringBuilder thing = new StringBuilder(display);
							char character = letter.charAt(0);
							thing.setCharAt(k, character);
							display = thing.toString();
							System.out.println("the word = " + display);
						}
					}
					label.setText("The word is: " + theWord + " How it will look like: " + display);
					if (display.contains("_")) {
						System.out.println("it contains _");
					} else {
						System.out.println("it does not contain _ - you won!");
						if (asdf.size() != 0) {
							playingGame = false;
							canGuess = false;
							JOptionPane.showMessageDialog(null, "press enter to play again");
						}else {
							JOptionPane.showMessageDialog(null, "Games finished!");
							System.exit(0);
						}
					}
				} else {
					// take away lives
					JOptionPane.showMessageDialog(null, "Word does not contain letter");
					lives--;
					livesDisplay.setText("Lives: " + lives + "   :::::   ");
					if(lives == 0 || lives  < 0) {
						JOptionPane.showMessageDialog(null, "You ran out of lives");
						System.exit(0);
					}
				}

			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
