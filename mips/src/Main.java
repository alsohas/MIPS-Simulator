import java.awt.EventQueue;

import gui.Mips;
import model.Computer;

//import view.Tetris;

public class Main {

	public static void main(String... args) {
		Computer computer = new Computer();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new Mips(computer);
	                
				} catch (final Exception e) {
					e.printStackTrace();
				}     
			}
		});
	}
}
//		computer.setRegister(4, 7);
//		computer.setRegister(1, 3);
//		computer.setRegister(2, 5);
//		//System.out.println(computer.toString());
//		computer.loadMemory(0, new Instruction("add $s5 $s1 $s0"));
//		//computer.loadMemory(1, new Instruction("sub $s6 $s1 $s2"));
//		//computer.loadMemory(2, new Instruction("or $s7 $s5 $s1"));
//		//computer.loadMemory(3, new Instruction("and $s4 $s1 $s0"));
//		//computer.loadMemory(1, new Instruction("sw $s0 16($s1)")); //MEM[$s + offset] = $t; advance_pc (4);
//		//computer.loadMemory(2, new Instruction("lw $s7 0($s4)"));	//	sw $t, offset($s)
//												//  1010 11ss ssst tttt iiii iiii iiii iiii
//		
//		
//		computer.step();
//		computer.step();
//		System.out.println(computer.toString());
//		computer.step();
//		System.out.println(computer.toString());
//		computer.step();
//		System.out.println(computer.toString());
//		
////		computer.step();
////		System.out.println(computer.toString());
////		computer.step();
////		System.out.println(computer.toString());
//	}
//}
