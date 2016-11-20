package DB_Blackjack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.filechooser.FileSystemView;

public class ConexaoDB{

	public static BufferedWriter salvarJogo;
	private Date data = new Date(System.currentTimeMillis());
	
	
	public ConexaoDB(){
		data = new Date(System.currentTimeMillis());
		FileSystemView system = FileSystemView.getFileSystemView();
		String caminho = system.getHomeDirectory().getPath() + File.separator + "jogosalvo_"+data+".txt";
		
		try{
			
		// Salvando na pasta pessoal
		// Exemplo (linux):  '/home/marlonfurtado/jogosalvo_Sun Nov 20 16:23:38 BRST 2016.txt'
			
		//salvarJogo = new BufferedWriter(new FileWriter(caminho));
		
		// Para executar somente na IDE (Eclipse):
		// Descomente o codigo abaixo, e comente o codigo acima
		
		salvarJogo = new BufferedWriter(new FileWriter("src/DB_Blackjack/jogosalvo_"+data+".txt"));
		
		}catch(IOException e){
			System.out.println("ERRO");
			e.getMessage();
		}
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
