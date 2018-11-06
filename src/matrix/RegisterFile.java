package matrix;

import java.util.HashMap;

public class RegisterFile {
	private HashMap<RegisterName, Register> registers;
	public RegisterFile() {
		this.registers = new HashMap<RegisterName, Register>();
	}
	public long getRegister(RegisterName reg) {
		return registers.get(reg).getValue();
		
	}
	public void setRegister(RegisterName reg, long value) {
		Register register = registers.get(reg);
		register.setValue(value);
	}
	public void  tick() {
		for(Register reg: registers.values())
			reg.tick();
	}
	

}
