package gui;
import java.awt.BorderLayout;

import java.awt.GridLayout;

import javax.swing.BorderFactory;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import model.Computer;

public class DisplayPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	JPanel container;
	JPanel panelReg;
	JPanel panelMem;
	JTextArea regLabel;
	JTextArea memLabel;
	private Computer myComputer;
	private JScrollPane pane;
	
	public DisplayPanel(Computer c) {
		super();
		myComputer = c;
		setLayout(new BorderLayout());
        
        container = new JPanel();
        panelReg = new JPanel();
        panelMem = new JPanel();
    	regLabel = new JTextArea();
    	memLabel = new JTextArea();
        
        setUpMemLabel();
        setUpRegLabel();

        container.setLayout(new GridLayout(1,2));
 
        container.add(panelReg);
        container.add(pane);
        
        this.add(container);
	}

	private void setUpRegLabel() {
		panelReg.setLayout(new BorderLayout());
		//panelReg.add(new JLabel("Registers"), BorderLayout.NORTH);
		
		
		regLabel.setText(myComputer.myRegister.toString());
		regLabel.setEditable(false);
		panelReg.add(regLabel);	
		panelReg.setBorder(BorderFactory.createTitledBorder("Registers"));
	}

	private void setUpMemLabel() {
		panelMem.setLayout(new BorderLayout());
		//panelMem.add(new JLabel("Memory"), BorderLayout.NORTH);
		
		memLabel.setText(myComputer.myMemory.toString());
		memLabel.setEditable(false);
		panelMem.add(memLabel);	
		
		panelMem.setBorder(BorderFactory.createTitledBorder("Memory"));
		pane = new JScrollPane(panelMem);
	}
	
	public void repaint() {
		try {
			memLabel.setText(myComputer.myMemory.toString());
			regLabel.setText(myComputer.myRegister.toString());
		} catch (Exception e) {
			return;
		}
	}

	public void reset() {
				
	}
}
