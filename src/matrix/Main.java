package matrix;

import java.io.IOException;

public class Main {
	public Main(String[] args) throws IOException{
		
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
