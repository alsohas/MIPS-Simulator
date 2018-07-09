package gui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LoadInstructionPanel extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton myLoadButton;
	String instructionFilePath;
	Mips myMips;

	public LoadInstructionPanel(Mips m) {
		super();
		myMips = m;		
		myLoadButton = new JButton(new LoadInstructionAction(myMips));
		add(myLoadButton);
	}

}
