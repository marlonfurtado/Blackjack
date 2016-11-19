package App_Blackjack;

import java.util.ArrayList;
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


		System.out.println("\nFaça sua aposta: ");
		int aposta = in.nextInt();

		while(aposta <= 0 || aposta > 100){
			System.out.println("Valor invalido.");
			System.out.println("Faça sua aposta: ");
			aposta = in.nextInt();
		}

		// Passa para o jogador o nome e sua aposta
		// AINDA TEM QUE FAZER O VALOR DA APOSTA DIMINUIR
		// DO VALOR 'DEFAULT', QUE COMEÇA COM 100$ NA CLASSE 'Jogador'
		
		
		JogadorController jogador = new JogadorController(nome, aposta);
		Carta carta = new Carta();

		
		// MENU PROVISORIO, DEPOIS DA PARA CRIAR UM MÉTODO
		// SO PARA O MENU
		System.out.println("1 - Solicitar cartas");
		System.out.println("0 - Sair");
		System.out.println("Digite sua opção: ");
		int opcao = in.nextInt();

		
		// CONTADOR PARA DECIDIR QUAL RODADA ESTA O JOGADOR
		int i = 1;

		if(opcao == 1){

			System.out.println("\n--------------------");
			System.out.println("RODADA "+i+"\n");


			// VETOR PARA GUARDAR AS CARTAS DO JOGADO E DEALER
			// ESTAO NA CLASSE 'JogadorController'
			// AINDA FALTA FAZER AS SOMAS E DECIDIR SE O JOGADOR GANHOU OU PERDEU
			
			ArrayList<String> cartasJogador = new ArrayList<>(); 		
			ArrayList<String> cartasSistema = new ArrayList<>(); 		


			System.out.println("SUAS CARTAS: ");

			// NA CLASSE 'Carta' AS CARTAS SAO GERADAS DE FORMA 'RANDOM'
			// CADA VEZ Q CHAMAR O METODO 'gerarCarta', VAI VIR UMA CARTA DIFERENTE ALEATORIA
			// APOS CHAMAR O METODO 'gerarCarta', A CARTA E ADICIONADA NO VETOR
			// POR ISSO TEM Q CHAMAR E ADICIONAR NO VETOR
			// DEPOIS CHAMA O 'setCartasJogador' PARA MANDAR ESSE VETOR PRA CLASSE 'JogadorController'
			
			cartasJogador.add(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe());
			cartasJogador.add(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe());
			jogador.setCartasJogador(cartasJogador);


			// DEPOIS E SO CHAMAR A CLASSE 'JogadorController' COM A POSIÇAO
			// DA CARTA NO VETOR
			
			System.out.print(jogador.getCartasJogador().get(0));
			System.out.println(jogador.getCartasJogador().get(1));


			System.out.println("\nDEALER: ");

			// ADICIONANDO A CARTA PARA O DEALER
			
			cartasSistema.add(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe());
			
			System.out.print(cartasSistema.get(0));
			System.out.println("\n--------------------");


			
			// MENU PARA ENTRA NO 'SWITCH'
			
			System.out.println("1 - Mais uma carta");
			System.out.println("2 - Encerrar rodada");
			System.out.println("Digite sua opção: ");
			opcao = in.nextInt();

			do{
				switch(opcao){
				case 1:

					System.out.println("\n--------------------");
					System.out.println("RODADA "+i+"\n");

					//  ADICIONA MAIS UMA CARTA PARA O JOGADOR

					cartasJogador.add(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe());
					jogador.setCartasJogador(cartasJogador);


					System.out.println("SUAS CARTAS: ");
					
					// PRINTA AS CARTAS ANTIGAS, E A CARTA NOVA
					
					System.out.print(jogador.getCartasJogador().get(0));
					System.out.print(jogador.getCartasJogador().get(1));
					System.out.println(jogador.getCartasJogador().get(2));


					System.out.println("\nDEALER: ");
					System.out.print(cartasSistema.get(0));
					System.out.println("\n--------------------");

					// FALTA ARRUMAR, ELE NAO ENTRANDO AQUI DE NOVO
					// MENU GAMBIARRA QUE NAO TA FUNCIONANDO
					System.out.println("1 - Mais uma carta");
					System.out.println("2 - Encerrar rodada");
					System.out.println("Digite sua opção: ");


					opcao = in.nextInt();

					i++;

					break;
				case 2:

					// ENCERRAR RODADA
					// FAZER AS CONTAS
					// DECIDIR QUEM GANHOU

					break;
				}

			}while(opcao != 0);
		}
	}
}
