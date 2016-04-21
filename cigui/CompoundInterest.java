package cigui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

public class CompoundInterest extends JFrame {
	final int WIN_W = 575; //window width
	final int WIN_H = 300;
	private boolean state = false; //calculate future value mode (future value mode = False, f for future, annual deposit mode = true) 
	private JPanel mainP;
	private JLabel preface, result, cLabel;
	private JTextField principal, years, rate, annual;
	//RIP Java Event Queue
	public CompoundInterest() {
		setTitle("Compound Interest Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		buildPanel(); //builds the actual thing
		add(mainP);
		pack();
		setVisible(true);
		System.out.println("I finished...");
	} //new BigDecimal().setScale(2, BigDecimal.ROUND_HALF_UP);
	private void buildPanel() {
		mainP  = new JPanel();
		mainP.setLayout(new GridLayout(3, 1)); //top = inputs, mid = buttons, bottom = output
		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel botPanel = new JPanel();
		//default layout of left panel is part A
		//LEFT PANEL
		topPanel.setLayout(new GridLayout(2, 2)); //the top panel, containing the text input boxes and their labels
		topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel pp            = new JPanel();
		pp.setLayout(new GridLayout(2,1));
		JLabel pLabel        = new JLabel("Principal (Initial or current deposit)");
		pp.add(pLabel);
		principal            = new JTextField();
		pp.add(principal);
		JPanel rp            = new JPanel();
		rp.setLayout(new GridLayout(2,1));
		JLabel rLabel        = new JLabel("Rate of growth (Input percent without % sign");
		rp.add(rLabel);
		rate                 = new JTextField();
		rp.add(rate);
		JPanel yp            = new JPanel();
		yp.setLayout(new GridLayout(2,1));
		JLabel yLabel        = new JLabel("Years to mature");
		yp.add(yLabel);
		years                = new JTextField();
		yp.add(years);
		JPanel cp            = new JPanel();
		cp.setLayout(new GridLayout(2,1));
		cLabel               = new JLabel("Annual deposit"); //this breaks the regularity, but the CHEESE IS REAL
		cp.add(cLabel);
		annual               = new JTextField();
		cp.add(annual);
		topPanel.add(pp);
		topPanel.add(rp);
		topPanel.add(yp);
		topPanel.add(cp);
		//MIDDLE PANEL
		midPanel.setLayout(new GridLayout(1, 2));
		midPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		JButton switchBtn    = new JButton("Switch to calculate annual deposit mode");
		JButton calcBtn      = new JButton("CALCULATE");
		calcBtn.addActionListener(new calcBtnListener());
		switchBtn.addActionListener(new switchBtnListener());
		midPanel.add(calcBtn);
		midPanel.add(switchBtn);
		//BOTTOM PANEL
		botPanel.setLayout(new GridLayout(2, 1));
		botPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		preface              = new JLabel("Preface");
		result               = new JLabel("CRRRRAWWWWWWWLIING INNNN MYY SKIIIINNNN.");
		result.setFont(new Font("Generic Font", Font.PLAIN, 20));
		botPanel.add(preface);
		botPanel.add(result);
		System.out.println("Built panel");
		mainP.add(topPanel);
		mainP.add(midPanel);
		mainP.add(botPanel);
	}
	private void buildAnnualCalculationPanel() {
		//todo
	}
	private class calcBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.print("Responding to calcbutton press...");
			if (!state) { //does calculation in the future value mode, since !state is future value state
				System.out.println("How will actionEvent calculate this with values it can't see? Find out next time on Javavio!");
				try {
					BigDecimal p = new BigDecimal(principal.getText());
					BigDecimal r = new BigDecimal(rate.getText());
					BigDecimal y = new BigDecimal(years.getText());
					BigDecimal c = new BigDecimal(annual.getText()); //I take them in as BigDecimal so that the value isn't OP
					System.out.println("p = " + p.doubleValue() + "; r = " + r.doubleValue() + "; y = " + y.doubleValue() + "; c = " + c.doubleValue());
					preface.setText("The future value of an investment of $" + p + " with an annual deposit of $" + c + " in " + y + " years at a rate of " + r + "% annually is: ");
					result.setText(("$" + getFutureValue(p.doubleValue(), r.doubleValue(), y.doubleValue(), c.doubleValue()).toString()));
				} catch(java.lang.NullPointerException npe) {
					System.err.println("NullPointerException caught!: " + npe.getMessage() + " | " + npe.getCause());
					System.out.println("One or more text fields left unfilled!");
					result.setText("One or more text fields left unfilled!");
				} catch(java.lang.NumberFormatException nfe) {
					System.err.println("NumberFormatException caught!: " + nfe.getMessage() + " | " + nfe.getCause());
					System.out.println("The inputted value isn't a valid number.");
					result.setText("The inputted value isn't a valid number.");
				}
			}
			else {
				try {
					BigDecimal p = new BigDecimal(principal.getText());
					BigDecimal r = new BigDecimal(rate.getText());
					BigDecimal y = new BigDecimal(years.getText());
					BigDecimal d = new BigDecimal(annual.getText()); //the variable name is still annual, but it now represents the desired value.
					System.out.println("p = " + p.doubleValue() + "; r = " + r.doubleValue() + "; y = " + y.doubleValue() + "; d = " + d.doubleValue());
					result.setText(("$" + getFutureValue(p.doubleValue(), r.doubleValue(), y.doubleValue(), d.doubleValue()).toString()));
				} catch(java.lang.NullPointerException npe) {
					System.err.println("NullPointerException caught!: " + npe.getMessage() + " | " + npe.getCause());
					System.out.println("One or more text fields left unfilled!");
					result.setText("One or more text fields left unfilled!");
				} catch(java.lang.NumberFormatException nfe) {
					System.err.println("NumberFormatException caught!: " + nfe.getMessage() + " | " + nfe.getCause());
					System.out.println("The inputted value isn't a valid number.");
					result.setText("The inputted value isn't a valid number.");
				}
			}
		}
	}
	private class switchBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!state) {
				cLabel.setText("Desired value"); //THE IMMENSE AMOUNT OF CHEESE HOLY FUCK GET REKT
			}
			else {
				cLabel.setText("Annual deposit"); //in other words, I don't need to change anything about the text box at all. 
			} //I just need to change what I tell the user to put into it, and what the program does when you press calculate.
			state = !state; //whatever the case is, state is set equal to its inverse
		}
	}
	private static BigDecimal calcAnnual(double P, double r, double Y, double D) { //desired val = D (LOL)
		r = r/100;
		final double z = r + 1;  //memory in use to save... like 0 CPU resources :\
		System.out.println("IN CALCANNUAL: p = " + P + "; r = " + r + "; y = " + Y + "; D = " + D);
		return new BigDecimal(((z - 1) * (D - P * Math.pow(z, Y)))/(z*(Math.pow(z, Y) - 1))).setScale(2, BigDecimal.ROUND_HALF_UP);
	} //mum get the dank 4/20 brackets!!!! yo mlg af man doritos and mountain dew MONTAIN DEW MOUNTAIN DEW DORITOOOOOOOS
	private static BigDecimal getFutureValue(double P, double r, double Y, double c) { //maybe should use BigDecimal
		r = r/100;
		final double z = r + 1;
		System.out.println("IN GETFUTUREVALUE: p = " + P + "; r = " + r + "; y = " + Y + "; c = " + c);
		return new BigDecimal(P*Math.pow(z, Y) + c*((Math.pow(z, Y+1) - z)/(z-1))).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public static void main(String[] args) {
		new CompoundInterest();
	}
}
