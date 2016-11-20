package DB_Blackjack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;

import RN_Blackjack.Jogador;

public class ConexaoDB{
	
	public static void Salvar(Jogador jogador) {
		String jogadorLinha = jogador.getNome()+";"+jogador.getDinheiro();
		try {
			FileWriter fw = new FileWriter("Jogador.txt", true);
			BufferedWriter conexao = new BufferedWriter(fw);
			conexao.write(jogadorLinha);
			conexao.newLine();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Editar(Jogador jogador){
		try{
			
		File inputFile = new File("Jogador.txt");
		File tempFile = new File("jogadoresTemp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = jogador.getNome();
		String currentLine;

		while((currentLine = reader.readLine()) != null) {
		    // trim newline when comparing with lineToRemove
		    String trimmedLine = currentLine.trim();
		    if(trimmedLine.contains(lineToRemove)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close(); 
		tempFile.renameTo(inputFile);
		inputFile.renameTo(tempFile);
		//boolean successful = tempFile.renameTo(inputFile);
		
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static ArrayList<Jogador> retornaJogadores(){
		
		ArrayList<Jogador> jogadores = new ArrayList<>();
	        
	        Path path = Paths.get("Jogador.txt");
			try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.forName("utf8")))) {
				sc.useDelimiter("[;\n]"); 
				sc.nextLine();
				while (sc.hasNext()) {
				    String nome, dinheiro;
				    nome = sc.next();
				    dinheiro  = sc.next();
				    double dinheiroJogador = Double.parseDouble(dinheiro);
				    Jogador jogadorBanco = new Jogador(nome, dinheiroJogador);
				    jogadores.add(jogadorBanco);
			  }
			} 
			catch (IOException x) {
			  System.err.format("Erro de E/S: %s%n", x);
			} catch (Exception e) {
				System.out.println("Não foi possível carregar arquivo Jogadores. Verifique!");
			}
			
			
			return jogadores;
	              
	}
	
	
	
	
	
	
}
