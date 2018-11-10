package matrix;

public class PC extends Register{
	private static final int FIRST_INSTRUCTION = 0x0000;
	
	
	public PC() {
		super(FIRST_INSTRUCTION);
	}
	
	public long next(long[] v, int i) {
		return v[i+1];
	}
	
	

}
