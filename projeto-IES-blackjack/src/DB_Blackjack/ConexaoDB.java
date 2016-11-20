package DB_Blackjack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ConexaoDB{

	public static BufferedWriter salvarJogo;
	private Date data = new Date(System.currentTimeMillis());
	
	public ConexaoDB() throws IOException{
		salvarJogo = new BufferedWriter(new FileWriter("src/DB_Blackjack/jogosalvo_"+data+".txt"));
	}

	
	public static void salvarJogo(){
		try{
			salvarJogo.flush();
			salvarJogo.close();
		}
		catch(IOException e){
			e.getMessage();
		}
	}

}
