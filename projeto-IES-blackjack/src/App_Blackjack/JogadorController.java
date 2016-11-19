package App_Blackjack;

import java.util.ArrayList;

import RN_Blackjack.Carta;
import RN_Blackjack.Jogador;

public class JogadorController extends Jogador {

	private ArrayList<String> cartasJogador;
	private ArrayList<String> cartasSistema;
	
	public JogadorController(String nome, int aposta) {
		super(nome, aposta);
		cartasJogador = new ArrayList<>();
		cartasSistema = new ArrayList<>();

	}

	public ArrayList<String> getCartasJogador() {
		return cartasJogador;
	}

	public void setCartasJogador(ArrayList<String> cartasJogador) {
		this.cartasJogador = cartasJogador;
	}

	
	
	public ArrayList<String> getCartasSistema() {
		return cartasSistema;
	}

	public void setCartasSistema(ArrayList<String> cartasSistema) {
		this.cartasSistema = cartasSistema;
	}
	
}
