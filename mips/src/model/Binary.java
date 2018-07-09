package model;
public class Binary {
	
	int SIZE = 32;
	char[] myBinaryInstruction = new char[SIZE];
	Instruction myInstruction;
		
	char myType;
	
	public Binary(Instruction theInstruction) {
		myInstruction = theInstruction;

		for (int i = 0; i < 32; i++) {
			myBinaryInstruction[i] = '0';
		}
		parseInstruction();
	}
	
	public Binary(int number) {
		myType = '0';
		myBinaryInstruction = toBinary(number);
		
	}

	private void parseInstruction() {
		//System.out.println(theInstruction.test);
		int destination = myInstruction.getDestination();

		char[] binArray = toBinary(destination);
		int binArrayIndex = binArray.length;
		for (int i = 10; i > 5; i--) {
			myBinaryInstruction[i] = binArray[binArrayIndex - 1];
			binArrayIndex -= 1;
		}
		
		if (myInstruction.getOPCode().equals("add") || 
				myInstruction.getOPCode().equals("sub") ||
				myInstruction.getOPCode().equals("or") ||
				myInstruction.getOPCode().equals("and")) {
			myType = 'r';
			
			for (int i = 0; i < 6; i++) {
				myBinaryInstruction[i] = '0';
			}
			int source1 = myInstruction.getSource();
			binArray = toBinary(source1);
			
			binArrayIndex = binArray.length;
			for (int i = 15; i > 10; i--) {
				myBinaryInstruction[i] = binArray[binArrayIndex - 1];
				binArrayIndex -= 1;
			}
			//int destination = myInstruction.getDestination();

//			char[] binArray = toBinary(destination);
//			int binArrayIndex = binArray.length;
//			for (int i = 10; i > 5; i--) {
//				myBinaryInstruction[i] = binArray[binArrayIndex - 1];
//				binArrayIndex -= 1;
//			}
			
//			int source1 = myInstruction.getSource();
//			//System.out.println("binary s1:" + source1);
//			binArray = toBinary(source1);
//			//System.out.println(source1);
//			
//			binArrayIndex = binArray.length;
//			for (int i = 15; i > 10; i--) {
//				myBinaryInstruction[i] = binArray[binArrayIndex - 1];
//				binArrayIndex -= 1;
//			}
//			
			int source2 = myInstruction.getSource2();
			binArray = toBinary(source2);
			binArrayIndex = binArray.length;
			for (int i = 20; i > 15; i--) {
				myBinaryInstruction[i] = binArray[binArrayIndex - 1];
				binArrayIndex -= 1;
			}			
			
			if (myInstruction.getOPCode().equals("add")) {
				//System.out.println("add");
				char[] functionCode = {'1', '0', '0', '0', '0', '0'};
				int functionCodeIndex = functionCode.length-1;
				for (int i = 31; i > 25; i--) {
					myBinaryInstruction[i] = functionCode[functionCodeIndex];
					functionCodeIndex -= 1;
				}
			} else if (myInstruction.getOPCode().equals("sub")) {
				char[] functionCode = {'1', '0', '0', '0', '1', '0'};
				int functionCodeIndex = functionCode.length-1;
				for (int i = 31; i > 25; i--) {
					myBinaryInstruction[i] = functionCode[functionCodeIndex];
					functionCodeIndex -= 1;
				}
			} else if (myInstruction.getOPCode().equals("or")) { //or
				char[] functionCode = {'1', '0', '0', '1', '0', '1'};
				int functionCodeIndex = functionCode.length-1;
				for (int i = 31; i > 25; i--) {
					myBinaryInstruction[i] = functionCode[functionCodeIndex];
					functionCodeIndex -= 1;
				}
			} else {//and
				char[] functionCode = {'1', '0', '0', '1', '0', '0'};
				int functionCodeIndex = functionCode.length-1;
				for (int i = 31; i > 25; i--) {
					myBinaryInstruction[i] = functionCode[functionCodeIndex];
					functionCodeIndex -= 1;
				}
			}
		} else if (myInstruction.getOPCode().equals("sw") ||
				(myInstruction.getOPCode().equals("lw"))) {
			myType = 'i';
			//System.out.println("op: " + myInstruction.getOPCode() + " dest: " + myInstruction.getDestination() + 
					//" source: " + myInstruction.getSource() + " offset " + myInstruction.getSource2());
			if (myInstruction.getOPCode().equals("lw")) {
				char[] functionCode = {'1', '0', '0', '0', '1', '1'};
				for (int i = 0; i < 6; i++) {
					myBinaryInstruction[i] = functionCode[i];
				}
			} else if (myInstruction.getOPCode().equals("sw")) {
				char[] functionCode = {'1', '0', '1', '0', '1', '1'};
				for (int i = 0; i < 6; i++) {
					myBinaryInstruction[i] = functionCode[i];
				}
			}
			int source1 = myInstruction.getSource();
			binArray = toBinary(source1);
			
			binArrayIndex = binArray.length;
			for (int i = 15; i > 10; i--) {
				myBinaryInstruction[i] = binArray[binArrayIndex - 1];
				binArrayIndex -= 1;
			}
			
			int source2 = myInstruction.getSource2();
			binArray = toBinary(source2);
			binArrayIndex = binArray.length;
			for (int i = 31; i > 15; i--) {
				myBinaryInstruction[i] = binArray[binArrayIndex - 1];
				binArrayIndex -= 1;
			}	
			
			
		}		
	}
	
	private char[] toBinary(int number) {
		char[] binArray = new char[32];
		if (number >= 0) { 
			
			int num = number;
			for (int i = binArray.length-1; i >= 0; i--) {
				if (num >=1 ) {
					binArray[i] = (char) ((num%2)+48);
					num /= 2;
				} else {
					binArray[i] = '0';
				}
			}
					
		} else {
			String s = Integer.toBinaryString(number);
			for (int i = 0; i < s.length(); i++){
			    binArray[i] = s.charAt(i);        
			}
		}
		return binArray;
	}

	public char getType() {
		return myType;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < myBinaryInstruction.length; i++) {
			if (i%4 == 0) {
				sb.append(" ");
			}
			sb.append(myBinaryInstruction[i]);
 		}
		return sb.toString();
	}

	public int getSize() {
		return SIZE;
	}
}
