package RN_Blackjack;

public class Jogador {

	private String nome;
	private int aposta = 100;

	public Jogador(String nome, int aposta){
		this.nome = nome;
		this.aposta -= aposta;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAposta() {
		return aposta;
	}

	public void setAposta(int aposta) {
		this.aposta = aposta;
	}
	
}
