package matrix;

import java.io.IOException;

public class Main {
	public Main(String[] args) throws IOException{
		InstructionMemory im  = new InstructionMemory(args[0]);
		DataMemory dm = new DataMemory(args[1]);
		Decode dec = new Decode(im.data());
		dec.decode();
		for(int i = 0; i < dec.regs().length; i++)
			System.out.printf("R%d:%d\n",i,dec.regs()[i]);
	
		System.out.println("************MEM************");
		for(Long i : dm.data())
			System.out.printf("0x%08x\n",i);
			
			
		
	}
	private void run() {
		
		
	}

	public static void main(String[] args) {
		if(args.length<2)
			System.out.println("Aponte o arquivo binário de dados e o arquivo binario de texto");
		try {
			Main matrix = new Main(args);
			matrix.run();
		}
		catch (IOException e) {
			// TODO: handle exception
			System.out.println("Erro ao abrir os arquivos: "+args[0]+" e "+args[1]);
		}
	}

	

}
