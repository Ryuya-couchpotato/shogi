package main;

import javax.swing.JFrame;

import piece.*;
import tool.Vector;

public class Main {
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10, 10, 510, 649);
		frame.setResizable(false);
		frame.setTitle("shogi");
		frame.setVisible(true);
	}
}
