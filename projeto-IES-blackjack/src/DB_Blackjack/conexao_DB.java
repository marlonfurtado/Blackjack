package DB_Blackjack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class conexao_DB {

	private BufferedWriter salvarJogo;

	
	public conexao_DB(String jogoSalvo) throws IOException{
		salvarJogo = new BufferedWriter(new FileWriter(jogoSalvo));
	}
	
	public void salvarJogo() throws IOException{
	
		System.out.println("Gravando jogo...");
		salvarJogo.write("TESTE");
		salvarJogo.newLine();
		salvarJogo.write("PRINTANDO");
		System.out.print(" OK");
		
		salvarJogo.flush();
		salvarJogo.close();
	}
	
}
