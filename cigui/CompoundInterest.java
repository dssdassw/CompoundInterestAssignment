package cigui;
import cicalc.CompoundInterestCalculator;
import javax.swing.*;
import java.awt.*;

public class CompoundInterest extends JFrame {
	final int WIN_W = 400; //window width
	final int WIN_H = 600;
	public CompoundInterest() {
		setTitle("Compound Interest Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2)); //so the main JFrame is split into 2 halves down the horizontal centre
		JPanel lPanel = new JPanel();
		JPanel rPanel = new JPanel();
		//default layout of left panel is part A
		lPanel.setLayout(new GridLayout(6, 1)); //the left panel will contain formatting instructions, 4 input text boxes, and one button that says "Switch Modes"
		JTextField principal = new JTextField();
		JLabel pLabel        = new JLabel("Principal (Initial or current deposit)");
		JTextField annual    = new JTextField();
		JLabel cLabel        = new JLabel("Annual Deposit");
		JTextField years     = new JTextField();
		JTextField rate      = new JTextField();
		//unfinished
	}
}
