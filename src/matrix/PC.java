package matrix;

public class PC extends Register{
	private static final int FIRST_INSTRUCTION = 0x0000;
	
	public PC() {
		super(FIRST_INSTRUCTION);
	}
	
	public void next() {
		newValue = getValue()+4;
	}

}
