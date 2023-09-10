package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		// 1. Create a Stack of Doubles
		// Don't forget to import the Stack class
		Stack<Double> doubles = new Stack<Double>();
		// 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		Random rand = new Random(100);
		for (int i = 0; i < 100; i++) {
			double doubel = rand.nextDouble() * 100;
			doubles.push(doubel);
			// System.out.println(doubel);
		}

		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		String thing1 = JOptionPane
				.showInputDialog("Input two numbers between 0 and 100, not inclusive. First Number: ");
		String thing2 = JOptionPane
				.showInputDialog("Input two numbers between 0 and 100, not includive. Second Number: ");
		// 4. Pop all the elements off of the Stack. Every time a double is popped that
		// is
		// between the two numbers entered by the user, print it to the screen.
		double stringThingOne = Double.parseDouble(thing1);
		double stringThingTwo = Double.parseDouble(thing2);

		System.out.println(stringThingOne);
		System.out.println(stringThingTwo);
		double lowBound;
		double hiBound;
		if (stringThingOne >= stringThingTwo) {
			lowBound = stringThingTwo;
			hiBound = stringThingOne;

		} else {
			lowBound = stringThingOne;
			hiBound = stringThingTwo;
		}

		System.out.println("low: " + lowBound + "   hi: " + hiBound);

		bill: for (int i = 0; i < 100; i++) {
			double number = doubles.get(doubles.size() - 1);
			if (number > lowBound && number < hiBound) {
				System.out.println(doubles.pop());
			} else {
				System.out.println("next value is higher/lower than set limit");
				break bill;
			}

		}
		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75

		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}
}
