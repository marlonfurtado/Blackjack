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
		BaralhoPaus = new ArrayList<>();
		IniciaBaralho();
	}	
	
	public void IniciaBaralho(){
		
		for(int x = 0; x <= 12; x++){
			BaralhoOuros.add(new Carta(x,"Ouro"));
			BaralhoCopas.add(new Carta(x,"Copa"));
			BaralhoPaus.add(new Carta(x,"Paus"));
			BaralhoEspadas.add(new Carta(x,"Espeda"));
		}
		
	}
	
	
	
	
}
