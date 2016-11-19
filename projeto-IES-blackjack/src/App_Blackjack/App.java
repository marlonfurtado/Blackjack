package App_Blackjack;

import java.util.Scanner;

import RN_Blackjack.Carta;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String salvarJogo = "src/DB_Blackjack/jogosalvo.txt";

		Scanner in = new Scanner(System.in);

		System.out.println("Bem vindo ao Jogo 21 (Blackjack)");
		System.out.println("Entre com seu nome e faça sua aposta");

		System.out.println("Seu nome: ");
		String nome = in.next();

		System.out.println("Olá "+nome+" você possui 100$ para apostas");


		System.out.println("Faça sua aposta: ");
		int aposta = in.nextInt();

		while(aposta <= 0 || aposta > 100){
			System.out.println("Valor invalido.");
			System.out.println("Faça sua aposta: ");
			aposta = in.nextInt();
		}

		JogadorController jogador = new JogadorController(nome, aposta);
		Carta carta = new Carta();

		System.out.println("1 - Solicitar cartas");
		System.out.println("0 - Sair");
		System.out.println("Digite sua opção: ");
		int opcao = in.nextInt();

		int i = 1;

		if(opcao == 1){
		
		System.out.println("\n--------------------");
		System.out.println("RODADA "+i+"\n");

		System.out.println("SUAS CARTAS: ");
		System.out.print(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe());
		System.out.println(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe());


		System.out.println("\nDEALER: ");
		System.out.print(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe() +" ");
		System.out.println("\n--------------------");


		System.out.println("1 - Mais uma carta");
		System.out.println("2 - Encerrar rodada");
		System.out.println("Digite sua opção: ");
		opcao = in.nextInt();

			switch(opcao){
			case 1:
				System.out.println("\n--------------------");
				System.out.println("RODADA "+i+"\n");

				System.out.println("SUAS CARTAS: ");
				System.out.print(carta.getNumero() + carta.getNaipe());
				System.out.println(carta.getNumero() + carta.getNaipe());
				System.out.println(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe());


				System.out.println("\nDEALER: ");
				System.out.print(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe() +" ");
				System.out.println("\n--------------------");

				System.out.println("1 - Mais uma carta");
				System.out.println("2 - Encerrar rodada");
				System.out.println("Digite sua opção: ");
				
				i++;
				
				opcao = in.nextInt();
				
				break;
			case 2:
				
				// ENCERRAR RODADA
				// DECIDIR QUEM GANHOU
				
				break;
			}
		}
	}

}
