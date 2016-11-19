package RN_Blackjack;

import java.util.ArrayList;

public class Cartas {

	private ArrayList<Carta> BaralhoOuros;
	private ArrayList<Carta> BaralhoCopas;
	private ArrayList<Carta> BaralhoPaus;
	private ArrayList<Carta> BaralhoEspadas;
	
	public Cartas(){
		BaralhoOuros = new ArrayList<>();
		BaralhoCopas = new ArrayList<>();
		BaralhoPaus = new ArrayList<>();
		BaralhoEspadas = new ArrayList<>();
	}
	
	public void IniciaBaralho(){
		for(int i = 0; i <= 12; i++){
//			BaralhoOuros.add(new Carta(i, "♦"));
//			BaralhoCopas.add(new Carta(i, "♥"));
//			BaralhoPaus.add(new Carta(i, "♣"));
//			BaralhoEspadas.add(new Carta(i, "♠"));
		}
	}

	public ArrayList<Carta> getBaralhoOuros() {
		return BaralhoOuros;
	}

	public ArrayList<Carta> getBaralhoCopas() {
		return BaralhoCopas;
	}

	public ArrayList<Carta> getBaralhoPaus() {
		return BaralhoPaus;
	}

	public ArrayList<Carta> getBaralhoEspadas() {
		return BaralhoEspadas;
	}
	
}
