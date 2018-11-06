package matrix;

import java.util.ArrayList;

public class Decode {
	
	private static final int OPCODE_MASK = 0xFC000000;
	private static final int OPCODE_SHIFT = 26;
	private static final int RS_MASK = 0x3E00000;
	private static final int RS_SHIFT = 21;
	private static final int RT_MASK = 0x1F0000;
	private static final int RT_SHIFT = 16;
	private static final int RD_MASK = 0xF800;
	private static final int RD_SHIFT = 11;
	private static final int SHAMT_MASK = 0x7C0;
	private static final int SHAMT_SHIFT = 6;
	private static final int FUNCT_MASK = 0x3F;
	private static final int FUNCT_SHIFT = 0;
	private static final int ADDRESS_MASK = 0x3FFFFFF;
	private static final int ADDRESS_SHIFT = 0;
	private static final int IMMEDIATE_MASK = 0xFFFF;
	private static final int IMMEDIATE_SHIFT = 0;
	
	// functions and opcodes
	
	private static final int ARITH_OP_CODE = 0;
	private static final int ADD_FUNCT = 0x20;
	private static final int SUB_FUNCT = 0x22;
	private static final int ORI = 0xD;
	private static final int SLTI = 0xA;
	private static final int AND_FUNCT = 0x24;
	private static final int OR_FUNCT = 0x25;
	private static final int ADDI = 0x8;
	private static final int ANDI = 0xC;
	private static final int BEQ = 0x4;
	private static final int BNE = 0x5;
	private static final int NOR_FUNCT = 0x27;
	private static final int SLT_FUNCT = 0x2a;
	private static final int J = 0x2;
	private static final int JR_FUNCT = 0x8;
	private static final int LW = 0x23;
	private static final int SW = 0x2B;
	private static final int HLT = 0x3F;
	
	public static final int NOP = 0xFF;
	private ArrayList<Long> instructions;
	private RegisterFile registers;
	
	
	public Decode(ArrayList<Long> inst) {
		this.instructions = inst;
		
	}
	private void decode() {
		long inst = instructions.get(RegisterName.INSTRUCTION);
	}

}
