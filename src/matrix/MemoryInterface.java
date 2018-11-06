package matrix;

public interface MemoryInterface<Long> {
	public void push(Long item);
	public Long pop();
	public void peek();
	public Long get(int index);
	public int size();

}
