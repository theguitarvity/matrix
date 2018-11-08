package matrix;

public class Register {
	private long value = 0;
	private long newValue = -1;
	
	public Register() {
		this(0);
	}
	public Register(long v) {
		this.value = v;
		
	}
	public long getValue() {
		return value;
	}
	
	public void setValue(long newValue) {
		this.newValue = newValue;
	}

	public void tick() {
		if (newValue != -1) {
			value = newValue;
			newValue = -1;
		}
	}
}
