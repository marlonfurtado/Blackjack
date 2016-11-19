package RN_Blackjack;

import java.util.Random;

public class Carta {
	
	private int numero;
	private String naipe;
	
	public Carta(){
		this.numero = 0;
		this.naipe = "";
	}
	
	public Carta gerarCarta(){
		Random r = new Random();
		Carta carta = new Carta();
		String aux = "♦♥♣♠";
		char auxNaipe = aux.charAt(r.nextInt(4));
		
		carta.numero = r.nextInt(10)+1;
		carta.naipe = Character.toString(auxNaipe);
		
		return carta;
	}
	
	public String getNaipe() {
		return naipe;
	}
	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
