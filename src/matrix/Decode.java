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
	private static final int SLL_FUNCT = 0x00;
	private static final int SRL_FUNCT = 0x02;
	private static final int SRA_FUNCT = 0x03;
	private static final int ADD_FUNCT = 0x20;
	
	private static final int SUB_FUNCT = 0x22;
	private static final int ORI = 0xD;
	private static final int XORI = 0xE;
	
	
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
	private long[] reg;
	private ALU alu;
	
	public Decode(ArrayList<Long> inst) {
		this.instructions = inst;
		this.registers = new RegisterFile();
		this.alu = new ALU();
		this.reg = new long[32];
		for(int i = 0; i<this.reg.length; i ++)
			this.reg[i] = 0x00;
		
	}
	/**
	 * Metodo responsavel pela decodificação da instrução e execução da mesma
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	public void decode() {
		//long inst = instructions.get(RegisterName.INSTRUCTION);
		for(int i = 0; i<instructions.size(); i++) {
			long inst = instructions.get(i);
			long opcode = ((inst&OPCODE_MASK)>>OPCODE_SHIFT);
			//System.out.printf("%x\n",opcode);
			switch((int)opcode) {
				case ARITH_OP_CODE:
					long rd = (inst&RD_MASK)>>RD_SHIFT;
					long rs = (inst&RS_MASK)>>RS_SHIFT;
					long rt = (inst&RT_MASK)>>RT_SHIFT;
					long funct = (inst&FUNCT_MASK)>>FUNCT_SHIFT;
					long shamt = (inst&SHAMT_MASK)>>SHAMT_SHIFT;
					
					
					
					switch((int)funct) {
						case ADD_FUNCT:
							reg[(int)rd] = alu.add(reg[(int) rs], reg[(int)rt]);
							break;
						case SUB_FUNCT:
							reg[(int)rd] = alu.sub(reg[(int) rs], reg[(int)rt]);
							break;
						case OR_FUNCT:
							reg[(int)rd] = alu.or(reg[(int) rs], reg[(int)rt]);
							break;
						case AND_FUNCT:
							reg[(int)rd] = alu.and(reg[(int) rs] , reg[(int)rt]);
							break;
						case NOR_FUNCT:
							reg[(int)rd] = ~(alu.or(reg[(int) rs] , reg[(int)rt]));
							break;
						case SLT_FUNCT:
							reg[(int)rd] = (reg[(int) rs] < reg[(int)rt])?1:0;
							break;
						case SLL_FUNCT:
							reg[(int)rd] = alu.sll(reg[(int)rt], shamt);
							break;
						case SRL_FUNCT:
							reg[(int)rd] = alu.srl(reg[(int)rt], shamt);
							break;
						
							
						
							
					}
					break;
				case ADDI:
					rt = (inst&RT_MASK)>>RT_SHIFT;
					rs = (inst&RS_MASK)>>RS_SHIFT;
					long immediate = (inst&IMMEDIATE_MASK)>>IMMEDIATE_SHIFT;
					reg[(int)rt] = (int) (reg[(int)rs] + immediate); 
					break;
				case ANDI:
					rt = (inst&RT_MASK)>>RT_SHIFT;
					rs = (inst&RS_MASK)>>RS_SHIFT;
					immediate = (inst&IMMEDIATE_MASK)>>IMMEDIATE_SHIFT;
					reg[(int)rt] = (int) (reg[(int)rs] & immediate); 
					break;
				case ORI:
					rt = (inst&RT_MASK)>>RT_SHIFT;
					rs = (inst&RS_MASK)>>RS_SHIFT;
					immediate = (inst&IMMEDIATE_MASK)>>IMMEDIATE_SHIFT;
					reg[(int)rt] = (int) (reg[(int)rs] | immediate); 
					break;
				case SLTI:
					rt = (inst&RT_MASK)>>RT_SHIFT;
					rs = (inst&RS_MASK)>>RS_SHIFT;
					immediate = (inst&IMMEDIATE_MASK)>>IMMEDIATE_SHIFT;
					reg[(int)rt] = (reg[(int)rs] <  immediate)?1:0;
					break;
				/*case BEQ:
					rt = (inst&RT_MASK)>>RT_SHIFT;
					rs = (inst&RS_MASK)>>RS_SHIFT;
					immediate = (inst&IMMEDIATE_MASK)>>IMMEDIATE_SHIFT;
					if(reg[(int)rt]==reg[(int)rs]) {
						
					}*/
					
					
					
			}
			
		}
		
	}
	public long[] regs() {
		return reg;
	}

}
