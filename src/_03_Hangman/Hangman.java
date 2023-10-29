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

		if (keyCode == 10 && playingGame == false) {
			playingGame = true;

			String bingus = JOptionPane.showInputDialog(null,
					"bingus type a number from 0 to 266, how many times do you want to play");
			int bingusNumber = Integer.parseInt(bingus);

			if (bingusNumber <= 0 || bingusNumber >= 266) {
				// end program or something
				System.exit(0);

			} else {
				bill: for (int i = 0; i < bingusNumber; i++) {
					// push words from the dictionary to this stack asdf.push();
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
				// make something that detects if a character is matching a character in the
				// chosen word
				// asdf now has a BingusNumber amount of random words
				theWord = asdf.pop();

				 display = theWord.replaceAll("[a-zA-z]", "_");

				label.setText("The word is: " + theWord + " How it will look like: " + display);

				JOptionPane.showMessageDialog(null, "Start guessing letters");
				canGuess = true;
			}

		} else {
			if (canGuess == true) {
				String letter = e.getKeyChar() + "";

				System.out.println(letter);

				if (theWord.contains(letter)) {
					//all good
					
					for (int k = 0; k < theWord.length(); k++) {
						if(letter == (theWord.charAt(k)+"")) {
							System.out.println("the problem is not the if statemt");
							StringBuilder thing = new StringBuilder(display);
							char character = letter.charAt(0);
							thing.setCharAt(k, character);
							display = thing.toString();
							System.out.println("the word = " + display);
						}
					}

				} else {
					// take away lives
					System.out.println("Does not contain");
				}

			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
