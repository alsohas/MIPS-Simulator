package gui;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;

import model.Computer;

public class LoadRegisterAction extends AbstractAction {


	private static final long serialVersionUID = 1L;
	Mips myMips;
	private List<RegisterBox> myBoxes;
	private Computer myComputer;
	

	public LoadRegisterAction(String string, Computer c, Mips m, List<RegisterBox> boxes) {
		
		super(string);
		myMips = m;
		myBoxes = boxes;
		myComputer = c;
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < myBoxes.size(); i++) {
			int value = myBoxes.get(i).getValue();
			myBoxes.get(i).setEditable(false);
			myComputer.setRegister(i, value);
			myMips.setLoaded(true);
			myMips.myDisplayPanel.repaint();
		}
		
	}

}
