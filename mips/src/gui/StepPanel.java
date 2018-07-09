package gui;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Computer;

public class StepPanel extends JPanel {
	
	
	private Mips myMips;
	private Computer myComputer;
	JButton myStepButton;

	public StepPanel(Computer c, Mips m) {
		super();
		myComputer = c;
		myMips = m;
		myStepButton = new JButton(new StepAction(myComputer, myMips));
		add(myStepButton);
	}
}
