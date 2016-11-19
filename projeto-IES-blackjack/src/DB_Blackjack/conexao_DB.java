package DB_Blackjack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class conexao_DB {

	public BufferedWriter salvarJogo;

	
	public conexao_DB(String jogoSalvo) throws IOException{
		salvarJogo = new BufferedWriter(new FileWriter(jogoSalvo));
	}
	
	public void salvarJogo() throws IOException{
		salvarJogo.flush();
		salvarJogo.close();
	}
	
}
