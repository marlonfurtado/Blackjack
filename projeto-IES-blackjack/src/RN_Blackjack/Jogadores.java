package RN_Blackjack;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import DB_Blackjack.ConexaoDB;

public class Jogadores {
	
	public static Jogador retornaJogador(String nome){
		ArrayList<Jogador> listaJogador = ConexaoDB.retornaJogadores();
		
		Jogador resultadoJogador;
		for(Jogador jogador : listaJogador){
			if(jogador.getNome().equalsIgnoreCase(nome)){
			
				resultadoJogador = jogador;
				return resultadoJogador;
			}
		}
		
		return null;
	}
	
	public static Jogador pesquisaJogador(String nome){
		ArrayList<Jogador> listaJogador = ConexaoDB.retornaJogadores();
		
		
		Jogador resultadoJogador;
		for(Jogador jogador : listaJogador){
			if(jogador.getNome().contains(nome)){
			
				resultadoJogador = jogador;
				return resultadoJogador;
			}
		}
		
		return null;
	}
	
	public static ArrayList<Jogador> retornaListaDeJogadores(){
		
		return ConexaoDB.retornaJogadores();
		
	}
	
	public static ArrayList<Jogador> retornaListaDeJogadoresOrdenadaPorDinheiro(){
		
		ArrayList<Jogador> jogadores = retornaListaDeJogadores();
		   
		Collections.sort(jogadores);
		
		return jogadores;
		
	}
	
	public static void SalvaJogador(Jogador jogador){
	
		DeletaJogador(jogador);
		ConexaoDB.Salvar(jogador);
	
	}
	
	
	static void DeletaJogador(Jogador jogador){
		ConexaoDB.Deletar(jogador);
	}
	
	
	
	
	
}
