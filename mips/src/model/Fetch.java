package model;

public class Fetch {
	
	private Fetch() {
	}
	
	public static void step(Computer theComputer) {
		int PC = theComputer.getPC()+1;
		theComputer.setPC(PC);
		//System.out.println(theComputer.myMemory.getContent(PC));
		theComputer.setCurrentInstruction(theComputer.myMemory.getContent(PC));	
	}

}
