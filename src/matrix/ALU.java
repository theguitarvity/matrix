package matrix;

public class ALU implements AluOperations{
	private long[] hilo;
	
	public ALU() {
		hilo = new long[2];
		hilo[0] = 0x00;
		hilo[1] = 0x00;
	}

	@Override
	public long add(long a, long b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public long sub(long a, long b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public void div(long a, long b) {
		// TODO Auto-generated method stub
		hilo[0] = a%b;
		hilo[1] = a/b;
	}

	@Override
	public void mult(long a, long b) {
		// TODO Auto-generated method stub
		hilo[1] = a*b;
	}

	@Override
	public long and(long a, long b) {
		// TODO Auto-generated method stub
		return a & b;
	}

	@Override
	public long or(long a, long b) {
		// TODO Auto-generated method stub
		return a|b;
	}

	@Override
	public long mhi() {
		// TODO Auto-generated method stub
		return hilo[0];
	}

	@Override
	public long mlo() {
		// TODO Auto-generated method stub
		return hilo[1];
	}

	@Override
	public long sll(long a, long b) {
		// TODO Auto-generated method stub
		return a<<b;
	}

	@Override
	public long srl(long a, long b) {
		// TODO Auto-generated method stub
		return a>>b;
	}
	
	
}
