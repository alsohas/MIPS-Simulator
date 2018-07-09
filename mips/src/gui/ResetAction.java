package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Computer;

public class ResetAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Computer myComputer;
	private Mips myMips;
	private RegisterPane myRegisterPanel;
	private DisplayPanel myDisplayPanel;

	public ResetAction(Computer c, Mips m, RegisterPane rp, DisplayPanel dp)  {
		super("Reset");
		myComputer = c;
		myMips = m;
		myRegisterPanel = rp;
		myDisplayPanel = dp;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		myMips.setLoaded(false);
		myRegisterPanel.myLoadRegistersButton.setEnabled(true);
		myRegisterPanel.reset();
		myComputer.reset();
		myDisplayPanel.repaint();
		myMips.repaint();
	}

}
