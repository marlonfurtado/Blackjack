package RN_Blackjack;

import java.util.ArrayList;

public class Jogador {

	private String nome;
	private ArrayList<Carta> cartas;
	
	
	public Jogador(String nome){
		cartas = new ArrayList<>();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	
	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public String toString(){
		return "Jogador: " + nome;
	}
	
}
