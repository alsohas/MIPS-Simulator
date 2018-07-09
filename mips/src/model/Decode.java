package model;
public class Decode {

	private Decode() {
		
	}
	
	public static DecodedInstruction decodeInstruction(Binary theInstruction) {
	//	System.out.println("bininstrc" + theInstruction.toString());
		DecodedInstruction decodedInstruction;
		if (theInstruction.getType() == 'r') {
			int operation = 0;
			int destination = 0;
			int source1 = 0;
			int source2 = 0;
			
			for (int i = 10; i > 5; i--) {
				if (theInstruction.myBinaryInstruction[i] == '1') {
					destination += Math.pow(2, (10-i));
				}
			}
			//System.out.println("dest " + destination);
			for (int i = 15; i > 10; i--) {
				if (theInstruction.myBinaryInstruction[i] == '1') {
					source1 += Math.pow(2, (15-i));
				}
			}
			//System.out.println("s1 " + source1);
			for (int i = 20; i > 15; i--) {
				if (theInstruction.myBinaryInstruction[i] == '1') {
					source2 += Math.pow(2, (20-i));
				}
			}
			//System.out.println("s2 " + source2);
			for (int i = 31; i > 25; i--) {
				if (theInstruction.myBinaryInstruction[i] == '1') {
					operation += Math.pow(2, (31-i));
				}
			}
			//System.out.println("op " + operation);
			decodedInstruction = new DecodedInstruction('r', destination, source1, source2, operation);
			
		} else if (theInstruction.getType() == 'i'){
			int destination = 0;
			int source = 0;
			int offset = 0;
			int operation = 0;
			//System.out.println(theInstruction.toString());
			for (int i = 5; i >= 0; i--) {
				if (theInstruction.myBinaryInstruction[i] == '1') {
					operation += Math.pow(2, (5-i));
				}
			}
			
			for (int i = 15; i > 10; i--) {//for (int i = 10; i > 5; i--) {
				if (theInstruction.myBinaryInstruction[i] == '1') {
					destination += Math.pow(2, (15-i));
				}
			}
			
			for (int i = 10; i > 5; i--) {//for (int i = 20; i > 15; i--) {
				if (theInstruction.myBinaryInstruction[i] == '1') {
					source += Math.pow(2, (10-i));
					//System.out.println(source);
				}
			}
			
			for (int i = 31; i > 15; i--) {
				if (theInstruction.myBinaryInstruction[i] == '1') {
					offset += Math.pow(2, (31-i));
				}
			}
			//System.out.println("---------------" + " " +destination  + " " +source + " " +offset + " "+ operation);
			decodedInstruction = new DecodedInstruction('i', destination, source, offset, operation);
			
		} else {
			int value = 0;
			for (int i = 31; i >= 0; i--) {
				if (theInstruction.myBinaryInstruction[i] == '1') {
					value += Math.pow(2, (31-i));
				}
			}
			decodedInstruction = new DecodedInstruction('0', value);
		}
		
		return decodedInstruction;
	}
	
}
