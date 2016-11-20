package App_Blackjack;


import java.io.IOException;
import java.util.Scanner;

import DB_Blackjack.ConexaoDB;
import RN_Blackjack.Banca;
import RN_Blackjack.Jogador;


public class App {

	public static void main(String[] args) {


		BlackJack blackjack = new BlackJack();

		Scanner in = new Scanner(System.in);

		try{
			new ConexaoDB();

			System.out.println("\nBem vindo ao Jogo 21 (Blackjack)");
			System.out.println("Entre com seu nome e faça sua aposta!");
			ConexaoDB.salvarJogo.write("\nBem vindo ao Jogo 21 (Blackjack)");
			ConexaoDB.salvarJogo.newLine();
			ConexaoDB.salvarJogo.write("Entre com seu nome e faça sua aposta!");


			System.out.print("Digite seu nome: ");
			String nome = in.next();
			//jogador
			Jogador jogador = new Jogador(nome);
			Banca banca = new Banca();

			System.out.println("\nOlá "+jogador.getNome()+" você possui R$"+jogador.getDinheiro() +" para apostas.\n");
			ConexaoDB.salvarJogo.newLine();
			ConexaoDB.salvarJogo.write("\nOlá "+jogador.getNome()+" você possui R$"+jogador.getDinheiro() +" para apostas.\n");
			ConexaoDB.salvarJogo.newLine();

			int opcao;
			do{

				System.out.println("1 - Iniciar rodada");
				System.out.println("0 - Sair");
				System.out.println("Digite sua op�ao: ");
				opcao = in.nextInt();

				if(opcao == 1){
					System.out.println("");
					double aposta = 0;
					System.out.println("\nDigite o valor da sua aposta: ");
					aposta = in.nextDouble();
					blackjack.criaRodada(aposta,jogador,banca);        
				}

			}while(opcao != 0);  
		
			ConexaoDB.salvarJogo();
			
		}catch(IOException e){
			e.getMessage();
		}
	
	}
}
