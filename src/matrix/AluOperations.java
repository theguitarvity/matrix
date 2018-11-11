package matrix;

public interface AluOperations {
	public long add(long a, long b);
	public long sub(long a, long b );
	public void div(long a, long b);
	public void mult(long a, long b);
	public long and(long a, long b);
	public long or(long a, long b);
	public long sll(long a, long b);
	public long srl(long a, long b);
	public long mhi();
	public long mlo();
	
}
