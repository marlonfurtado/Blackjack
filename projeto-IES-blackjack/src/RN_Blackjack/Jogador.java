package RN_Blackjack;

import java.util.ArrayList;


public class Jogador {

	private String nome;
	private double dinheiro = 5000;
        private ArrayList<Carta> cartasJogador;

        public Jogador(String nome){
		this.nome = nome;
                cartasJogador = new ArrayList<>();
        }
	
		public Jogador(String nome, double dinheiro){
		this.nome = nome;
		this.dinheiro = dinheiro;
        cartasJogador = new ArrayList<>();
        }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

        public double getDinheiro() {
		return dinheiro;
	}
	public void adicionaDinheiro(double valor){
            dinheiro += valor;
        }
        public void retiraDinheiro(double valor){
            dinheiro -= valor;
        }
        
        public void adicionaCartaJogador(Carta carta){
            cartasJogador.add(carta);
        }
  
        public int retornaValorDasCartasJogador(){
            int valor = 0;
            for(Carta carta : cartasJogador){
                
                if(carta.getValor() < 11){
                    valor += carta.getValor();
                }else if(carta.getValor() > 10 && carta.getValor() < 15){
                    valor += 10;
                }
            }
            return valor;
        }
        
        public void imprimeCartasJogador(){
            if(cartasJogador != null){
                for(Carta carta : cartasJogador){
                    System.out.print(carta.toString() + " ");
                }                
            }
            
            System.out.println("");
        }
        
        public void LimpaCartas(){
            cartasJogador.clear();
        }
        
      
        
}

