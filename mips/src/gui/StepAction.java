package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import model.Computer;

public class StepAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5940352528383609844L;
	private Mips myMips;
	private Computer myComputer;

	public StepAction(Computer c, Mips m) {
		super("Step");
		myComputer = c;
		myMips = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!myMips.isLoaded()) {
			JOptionPane.showMessageDialog(myMips, "Please initialize registers");
			return;
		}
		
		myComputer.step();
		myMips.repaint();
		
	}

}
