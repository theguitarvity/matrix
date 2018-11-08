package matrix;

public interface MemoryInterface<T, I> {
	public void push(T item);
	public T pop();
	public void peek();
	public T get(I index);
	public int size();

}
