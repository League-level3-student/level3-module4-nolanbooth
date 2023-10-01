package _00_IntroToStacks;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class _02_TextUndoRedo implements KeyListener, ActionListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 */
	public static JFrame frame;
	public static JPanel panel;
	public static JLabel label;
	public static JButton testButton;
	public static String text;
	public static Stack<Character> characters = new Stack<Character>();
	
	public static void main(String[] args) {
		new _02_TextUndoRedo().run();

	}

	public void run() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		text = "";
		// testButton = new JButton();

		// panel.add(testButton);
		frame.add(panel);
		panel.add(label);

		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label.setText(text);

		frame.addKeyListener(this);
		// testButton.addActionListener(this);

	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		
		int key = e.getKeyCode();
		//backspace char code is 8
		if(key!=8&&key!=16) {
		

		char newChar = e.getKeyChar();
		// System.out.println("value of newCharacter = " + newCharacter[0]);


		characters.push(newChar);
		char c = characters.pop();
		//System.out.println("value of first element of characters: " + characters.firstElement());
		text = text + c;
		label.setText(text);
		
		
		
		}if(key == 8) {
			//find out how to delete the last text added to text
			String temp = text.substring(0, text.length()-1);
			System.out.println(temp);
			text = temp;
			label.setText(text);
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}

}
