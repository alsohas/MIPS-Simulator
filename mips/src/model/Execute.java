package model;

public class Execute {

	public static void executeInstruction(Computer computer) {
		DecodedInstruction instruction = computer.decodedInstruction;
		
		if (instruction.getType() == 'r') {
			
			int destination = instruction.getDestination();
			int source1 = instruction.getSource1();
			int source2 = instruction.getSource2();
			//System.out.println("----------" + source1);
			int s1 = toDecimal(computer.myRegister.getRegisterContent(source1));
			int s2 = toDecimal(computer.myRegister.getRegisterContent(source2));
			
			if (instruction.getOperation() == 32) { //add
				//System.out.println("----------" + s1+s2);
				computer.setRegister(destination, s1 + s2);
			} else if (instruction.getOperation() == 34) { //sub
				computer.setRegister(destination, s1 - s2);
			} else if (instruction.getOperation() == 37) { //or
				computer.setRegister(destination, s1 | s2);
			} else if (instruction.getOperation() == 36){
				computer.setRegister(destination, s1 & s2);
			}
		} else if (instruction.getType() == 'i') {
			int offset = instruction.myOffset;
			int r1 = instruction.getDestination();
			int r2 = instruction.getSource1();
			int operation = instruction.getOperation();
			
			if (operation == 35) {//lw 	
				//System.out.println("r2 "+r2);
				int wordLocation = toDecimal(computer.myRegister.getRegisterContent(r2))+(offset/4);
				//System.out.println("word "+word);

				Binary word = computer.myMemory.getContent(wordLocation);
				//value += ;
				//System.out.println("loading to: " + r1 + " from" + word);
				computer.setRegister(r1, word);
			} else if (operation == 43) {//sw MEM[$s + offset] = $t; advance_pc (4);
				
				int destinationMem = toDecimal(computer.myRegister.getRegisterContent(r2)) + (offset/4);
				//value = toDecimal(computer.myRegister.getRegisterContent(value));
				//System.out.println("saving to: " + destinationMem + " from" + r2);
				computer.loadMemory(destinationMem, computer.myRegister.getRegisterContent(r1));
			}
		}
		
	}
	
	static int toDecimal(Binary value) {
		int number = 0;
		for (int i = 31; i >=0; i--) {
			try {
				if(value.myBinaryInstruction[i] == '1') {
					number += Math.pow(2, 31-i);
				}
			} catch (Exception e) {
				return 0;
			}
		}
		return number;
	}


}
