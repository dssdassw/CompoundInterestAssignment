package cigui;
import cicalc.CompoundInterestCalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

public class CompoundInterest extends JFrame {
	final int WIN_W = 575; //window width
	final int WIN_H = 300;
	boolean state = false; //calculate future value mode (future value mode = False, f for future, annual deposit mode = true) 
	private static CompoundInterest thisWindow;
	private JPanel mainP, lPanel, rPanel, pp, yp, rp, cp, northPanel, southPanel;
	private JLabel pLabel, yLabel, rLabel, cLabel, result;
	private JTextField principal, years, rate, annual;
	public CompoundInterest() {
		setTitle("Compound Interest Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(WIN_W, WIN_H)); 
		buildPanel();
		add(mainP);
		pack();
		setVisible(true);
		System.out.println("I finished");
	}
	private class calcBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.print("Responding to calcbutton press...");
			if (!state) {
				System.out.println("How will actionEvent calculate this with values it can't see? Find out next time on Javavio!");
				BigDecimal p = new BigDecimal(principal.getText());
				BigDecimal y = new BigDecimal(years.getText());
				BigDecimal r = new BigDecimal(rate.getText());
				BigDecimal c = new BigDecimal(annual.getText());
			}
		}
	}
	private void buildPanel() {
		JPanel mainP  = new JPanel();
		mainP.setLayout(new GridLayout(1, 2)); //so the main JFrame is split into 2 halves down the horizontal centre
		JPanel lPanel = new JPanel();
		JPanel rPanel = new JPanel();
		//default layout of left panel is part A
		//LEFT PANEL
		lPanel.setLayout(new GridLayout(6, 1)); //the left panel will contain formatting instructions, 4 input text boxes, and one button that says "Switch Modes".
		lPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JPanel pp            = new JPanel();
		pp.setLayout(new GridLayout(2,1));
		JLabel pLabel        = new JLabel("Principal (Initial or current deposit)");
		pp.add(pLabel);
		JTextField principal = new JTextField();
		pp.add(principal);
		JPanel yp            = new JPanel();
		yp.setLayout(new GridLayout(2,1));
		JLabel yLabel        = new JLabel("Years to mature");
		yp.add(yLabel);
		JTextField years     = new JTextField();
		yp.add(years);
		JPanel rp            = new JPanel();
		rp.setLayout(new GridLayout(2,1));
		JLabel rLabel        = new JLabel("Rate of growth (Input percent without % sign");
		rp.add(rLabel);
		JTextField rate      = new JTextField();
		JPanel cp            = new JPanel();
		cp.setLayout(new GridLayout(2,1));
		JLabel cLabel        = new JLabel("Annual deposit");
		cp.add(cLabel);
		JTextField annual    = new JTextField();
		cp.add(annual);
		JButton switchBtn    = new JButton("Switch to calculate annual deposit mode");
		rp.add(rate);
		JButton calcBtn      = new JButton("CALCULATE");
		calcBtn.addActionListener(new calcBtnListener());
		lPanel.add(pp);
		lPanel.add(cp);
		lPanel.add(yp);
		lPanel.add(rp);
		lPanel.add(new JLabel("- OR -"));
		lPanel.add(calcBtn);
		//RIGHT PANEL
		rPanel.setLayout(new GridLayout(2, 1));
		rPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 5, 5));
		JPanel northPanel    = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.add(calcBtn, BorderLayout.CENTER);
		//northPanel.add(calcBtn);
		JPanel southPanel    = new JPanel();
		southPanel.setLayout(new BorderLayout());
		JLabel result        = new JLabel("Crawling in my skin. These wounds they will not heal. Fear is how I fall, Confusing what is real. There's something inside me that pulls beneath the surface; Consuming, confusing. This lack of self-control, I fear is never ending. Controlling. I can't seem... [Bridge:] To find myself again My walls are closing in (without a sense of confidence and I'm convinced that there's just too much pressure to take) I've felt this way before So insecure [Chorus] Discomfort endlessly has pulled itself upon me Distracting, reacting Against my will I stand beside my own reflection It's haunting how I can't seem... [Bridge] [Chorus] [Chorus] There's something inside me that pulls beneath the surface consuming, Confusing what is real. This lack of self-control I fear is never ending controlling, Confusing what is real.");
		southPanel.add(result, BorderLayout.CENTER);
		//southPanel.add(result);
		rPanel.add(northPanel);
		rPanel.add(southPanel);
		System.out.println("Built panel");
		mainP.add(lPanel);
		mainP.add(rPanel);
	}
	public static void main(String[] args) {
		new CompoundInterest();
	}
}
