package App_Blackjack;

import java.util.ArrayList;

import RN_Blackjack.Carta;
import RN_Blackjack.Jogador;

public class JogadorController extends Jogador {

	private ArrayList<Carta> cartas;

	public JogadorController(String nome, int aposta) {
		super(nome, aposta);
		cartas = new ArrayList<>();
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

}
