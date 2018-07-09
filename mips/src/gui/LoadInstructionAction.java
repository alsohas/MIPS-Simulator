package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class LoadInstructionAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Mips myMips;

	public LoadInstructionAction(Mips m) {
		super("Load Instructions");
		myMips = m;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton load = new JButton("Load");
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Load Instruction");
		if (fc.showOpenDialog(load) == JFileChooser.APPROVE_OPTION) {
			
		}
		myMips.setInstructionPath(fc.getSelectedFile().getAbsolutePath());
	}

}
