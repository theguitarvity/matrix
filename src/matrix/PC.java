package matrix;

import java.util.ArrayList;

public class PC{
	private static final int FIRST_INSTRUCTION = 0x0000;
	private ArrayList<Long> instructions = new ArrayList<Long>();
	
	public PC(ArrayList<Long> inst) {
		this.instructions = inst;
		
	}
	
	public long next(int i) {
		return this.instructions.get(i);
	}
	public void setNext(int i, int j) {
		long atual = next(i);
		long next = next(j);
		
	}
	
	

}
