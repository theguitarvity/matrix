package matrix;

import java.util.ArrayList;

public class InstructionMemory<T, I> implements MemoryInterface<T, I>{
	private ArrayList<T> memory;
	private int size;

	public InstructionMemory() {
		// TODO Auto-generated constructor stub
		this.memory = new ArrayList<T>(1024);
		this.size = memory.size();
	}
	@Override
	public void push(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void peek() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(I index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	

}
