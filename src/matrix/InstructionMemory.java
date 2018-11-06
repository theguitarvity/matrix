package matrix;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class InstructionMemory{
	private ArrayList<Long> memory = new ArrayList<Long>();
	private int size;

	
	public ArrayList<Long> data(){
		return this.memory;
	}
	public InstructionMemory() {
		// TODO Auto-generated constructor stub
		//this.memory = new ArrayList<Long>();
		this.size = memory.size();
		
	}
	public InstructionMemory(String filename)throws IOException {
		this();
		FileInputStream input = new FileInputStream(filename);
		byte[] bytes = new byte[4];
		while(input.read(bytes)!=-1) {
			long word = getUnsigned(bytes[0]);
			word+=getUnsigned(bytes[1])<<8;
			word+=getUnsigned(bytes[2])<<16;
			word+=getUnsigned(bytes[3])<<24;
			memory.add(word);
			//push(word);
		}
		
	}
	private long getUnsigned(byte b) {
		// TODO Auto-generated method stub
		if(b>=0)
			return b;
		return 256+b;
		
	}
	

	


	
	

}
