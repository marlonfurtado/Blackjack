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
	
	public int ComparaJogador(Jogador jogador1, Jogador jogador2) {
        if (jogador1.getDinheiro() < jogador2.getDinheiro()) return -1;
        else if (jogador1.getDinheiro() > jogador2.getDinheiro()) return +1;
        else return 0;
    }
	
	public static ArrayList<Jogador> retornaListaDeJogadores(){
		
		return ConexaoDB.retornaJogadores();
		
	}
	
	
	public static void SalvaJogador(Jogador jogador){
	
		DeletaJogador(jogador);
		ConexaoDB.Salvar(jogador);
	
	}
	
	
	static void DeletaJogador(Jogador jogador){
		ConexaoDB.Deletar(jogador);
	}
	
	
	
	
	
}
