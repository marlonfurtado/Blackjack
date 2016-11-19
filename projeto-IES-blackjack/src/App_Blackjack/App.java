package App_Blackjack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import DB_Blackjack.conexao_DB;
import RN_Blackjack.Carta;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			String jogoSalvo = "src/DB_Blackjack/jogosalvo.txt";
			conexao_DB conexao = new conexao_DB(jogoSalvo);
			
			
			Scanner in = new Scanner(System.in);


			System.out.println("Bem vindo ao Jogo 21 (Blackjack)");
			conexao.salvarJogo.write("Bem vindo ao Jogo 21 (Blackjack)");
			conexao.salvarJogo.newLine();
			
			System.out.println("Entre com seu nome e faça sua aposta");
			conexao.salvarJogo.write("Entre com seu nome e faça sua aposta");
			conexao.salvarJogo.newLine();

			System.out.print("Seu nome: ");
			String nome = in.next();

			System.out.println("\nOlá "+nome+" você possui 100$ para apostas\n");
			conexao.salvarJogo.write("\nOlá "+nome+" você possui 100$ para apostas\n");
			conexao.salvarJogo.newLine();


			System.out.print("Faça sua aposta: ");
			int aposta = in.nextInt();
			System.out.println("");

			while(aposta <= 0 || aposta > 100){
				System.out.println("Valor invalido.");
				System.out.println("Faça sua aposta: ");
				aposta = in.nextInt();
			}

			// Passa para o jogador o 'nome' e sua 'aposta'
			// O VALOR 'DEFAULT' DA APOSTA COMEÇA COM 100$ NA CLASSE 'Jogador'
			// E DECREMENTA DO VALOR PASSADO POR PARAMETRO

			JogadorController jogador = new JogadorController(nome, aposta);
			Carta carta = new Carta();


			System.out.println("Seu dinheiro: "+jogador.getAposta()+"$");
			conexao.salvarJogo.write("Seu dinheiro: "+jogador.getAposta()+"$");
			conexao.salvarJogo.newLine();

			System.out.println("Valor da sua aposta: "+aposta+"$\n");
			conexao.salvarJogo.write("Valor da sua aposta: "+aposta+"$\n");
			conexao.salvarJogo.newLine();


			// MENU PROVISORIO, DEPOIS DA PARA CRIAR UM MÉTODO
			// SO PARA O MENU
			System.out.println("1 - Solicitar cartas");
			System.out.println("0 - Sair");
			System.out.println("Digite sua opção: ");
			int opcao = in.nextInt();


			// CONTADOR PARA DECIDIR QUAL RODADA ESTA O JOGADOR
			// TALVEZ NÃO SEJA MAIS NECESSARIO,
			// SO VAI TER UMA RODADA ?!
			int countRodada = 1;

			if(opcao == 1){

				System.out.println("\n--------------------");
				System.out.println("RODADA "+countRodada+"\n");
				conexao.salvarJogo.write("\n--------------------");
				conexao.salvarJogo.newLine();
				conexao.salvarJogo.write("RODADA "+countRodada+"\n");
				conexao.salvarJogo.newLine();


				// VETOR PARA GUARDAR AS CARTAS DO JOGADOR E DEALER
				// ESTAO NA CLASSE 'JogadorController'
				// AINDA FALTA FAZER AS SOMAS E DECIDIR SE O JOGADOR GANHOU OU PERDEU

				ArrayList<String> cartasJogador = new ArrayList<>(); 		
				ArrayList<String> cartasSistema = new ArrayList<>(); 		


				System.out.println("SUAS CARTAS: ");
				conexao.salvarJogo.write("SUAS CARTAS: ");
				conexao.salvarJogo.newLine();

				// NA CLASSE 'Carta' AS CARTAS SAO GERADAS DE FORMA 'RANDOM'
				// CADA VEZ Q CHAMAR O METODO 'gerarCarta', VAI VIR UMA CARTA DIFERENTE ALEATORIA
				// APOS CHAMAR O METODO 'gerarCarta', A CARTA É ADICIONADA NO VETOR
				// POR ISSO TEM Q CHAMAR E LOGO JA ADICIONAR NO VETOR
				// DEPOIS CHAMA O 'setCartasJogador' PARA MANDAR ESSE VETOR PRA CLASSE 'JogadorController'

				cartasJogador.add(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe());
				cartasJogador.add(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe());
				jogador.setCartasJogador(cartasJogador);


				// DEPOIS E SO CHAMAR A CLASSE 'JogadorController' COM A POSIÇAO
				// DA CARTA NO VETOR

				System.out.print(jogador.getCartasJogador().get(0));
				conexao.salvarJogo.write(jogador.getCartasJogador().get(0));
				conexao.salvarJogo.newLine();
				System.out.println(jogador.getCartasJogador().get(1));
				conexao.salvarJogo.write(jogador.getCartasJogador().get(1));
				conexao.salvarJogo.newLine();


				System.out.println("\nDEALER: ");
				conexao.salvarJogo.write("\nDEALER: ");
				conexao.salvarJogo.newLine();

				// ADICIONANDO A CARTA PARA O DEALER

				cartasSistema.add(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe());

				System.out.print(cartasSistema.get(0));
				System.out.println("\n--------------------");
				conexao.salvarJogo.write(cartasSistema.get(0));
				conexao.salvarJogo.newLine();
				conexao.salvarJogo.write("\n--------------------");
				conexao.salvarJogo.newLine();


				// MENU PARA ENTRAR NO 'SWITCH'

				System.out.println("1 - Mais uma carta");
				System.out.println("2 - Encerrar rodada");
				System.out.println("0 - Sair");
				System.out.println("Digite sua opção: ");
				opcao = in.nextInt();



				while(opcao != 0){
					switch(opcao){
					case 1:

						System.out.println("\n--------------------");
						conexao.salvarJogo.write("\n--------------------");
						conexao.salvarJogo.newLine();

						//  ADICIONA MAIS UMA CARTA PARA O JOGADOR

						cartasJogador.add(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe());
						jogador.setCartasJogador(cartasJogador);

						System.out.println("SUAS CARTAS: ");
						conexao.salvarJogo.write("\nSUAS CARTAS");
						conexao.salvarJogo.newLine();

						// PRINTA AS CARTAS ANTIGAS, E A CARTA NOVA
						for (String c : cartasJogador) {
							System.out.print(c);
							conexao.salvarJogo.write("c");
						}

						System.out.println("\nDEALER: ");
						System.out.print(cartasSistema.get(0));
						System.out.println("\n--------------------");
						conexao.salvarJogo.write("\nDEALER");
						conexao.salvarJogo.newLine();
						conexao.salvarJogo.write(cartasSistema.get(0));
						conexao.salvarJogo.newLine();
						conexao.salvarJogo.write("\n--------------------");


						System.out.println("1 - Mais uma carta");
						System.out.println("2 - Encerrar rodada");
						System.out.println("0 - Sair");
						System.out.println("Digite sua opção: ");


						opcao = in.nextInt();

						break;
					case 2:
						// ENCERRAR RODADA
						// FAZER AS CONTAS
						// DECIDIR QUEM GANHOU

						int somarCartasJogador = 0;
						int somarCartasSistema = 0;


						// ADICIONAR CARTAS PARA O SISTEMA
						for(int i = 0; i < cartasJogador.size(); i++){
							cartasSistema.add(carta.gerarCarta().getNumero() + carta.gerarCarta().getNaipe());
						}



						// 'FOR' PARA SOMAR AS CARTAS DO JOGADOR
						for (String c : cartasJogador) {

							c = Character.toString(c.charAt(0));
							int auxC = Integer.parseInt(c);

							somarCartasJogador += auxC;
						}

						// PRINTAR CARTAS DO SISTEMA
						System.out.print("Cartas do sistema:  ");
						conexao.salvarJogo.write("\nCartas do sistema: ");
						conexao.salvarJogo.newLine();

						for (String c : cartasSistema) {
							System.out.print(c);
							conexao.salvarJogo.write(c);
						}
						System.out.println();
						conexao.salvarJogo.newLine();

						// 'FOR' PARA SOMAR AS CARTAS DO SISTEMA
						for (String c : cartasSistema) {

							c = Character.toString(c.charAt(0));
							int auxC = Integer.parseInt(c);

							somarCartasSistema += auxC;
						}



						// EMPATE
						if (somarCartasJogador == somarCartasSistema || (somarCartasJogador > 21 && somarCartasSistema > 21)){
							System.out.println("\nSoma das cartas jogador: "+somarCartasJogador);
							System.out.println("Soma das cartas sistema: "+somarCartasSistema);
							System.out.println();

							conexao.salvarJogo.write("\nSoma das cartas jogador: "+somarCartasJogador);
							conexao.salvarJogo.newLine();
							conexao.salvarJogo.write("Soma das cartas sistema: "+somarCartasSistema);
							conexao.salvarJogo.newLine();

							System.out.println("EMPATE!");
							conexao.salvarJogo.write("EMPATE");
							conexao.salvarJogo.newLine();
							
							System.out.println("JOGADOR RECEBE DE VOLTA DINHEIRO DA APOSTA");
							System.out.println("AINDA FALTA ARRUMAR...");

							opcao = 0;
							break;
						}

						// JOGADOR GANHA COM 21
						else if (somarCartasJogador == 21){
							System.out.println("\nSoma das cartas jogador: "+somarCartasJogador);
							System.out.println("Soma das cartas sistema: "+somarCartasSistema);
							System.out.println();

							conexao.salvarJogo.write("\nSoma das cartas jogador: "+somarCartasJogador);
							conexao.salvarJogo.newLine();
							conexao.salvarJogo.write("Soma das cartas sistema: "+somarCartasSistema);
							conexao.salvarJogo.newLine();
							
							System.out.println("'GANHOU COM CARTA IGUAL A 21'");
							conexao.salvarJogo.write("'GANHOU COM CARTA IGUAL A 21'");
							conexao.salvarJogo.newLine();
							
							
							System.out.println("Parabens! Você ganhou");
							System.out.println("'FALTA ARRUMAR A MASCADA QUE ELE VAI RECEBER'");
							opcao = 0;
							break;
						}

						// JOGADOR GANHA COM CARTA MAIOR Q O SISTEMA
						else if(somarCartasJogador < 21 && (somarCartasJogador > somarCartasSistema)){
							System.out.println("\nSoma das cartas jogador: "+somarCartasJogador);
							System.out.println("Soma das cartas sistema: "+somarCartasSistema);
							System.out.println();

							conexao.salvarJogo.write("\nSoma das cartas jogador: "+somarCartasJogador);
							conexao.salvarJogo.newLine();
							conexao.salvarJogo.write("Soma das cartas sistema: "+somarCartasSistema);
							conexao.salvarJogo.newLine();
							
							System.out.println("'GANHOU COM CARTA MAIOR Q O SISTEMA'");
							conexao.salvarJogo.write("'GANHOU COM CARTA MAIOR Q O SISTEMA'");
							conexao.salvarJogo.newLine();
							
							System.out.println("Parabens! VOce ganhou");
							System.out.println("E ver o dinheiro das apostas");

							opcao = 0;
							break;
						}

						// JOGADOR PERDE PQ TEM CARTA MAIOR QUE 21
						else if (somarCartasJogador > 21 && somarCartasSistema <= 21){
							System.out.println("\nSoma das cartas jogador: "+somarCartasJogador);
							System.out.println("Soma das cartas sistema: "+somarCartasSistema);
							System.out.println();

							conexao.salvarJogo.write("\nSoma das cartas jogador: "+somarCartasJogador);
							conexao.salvarJogo.newLine();
							conexao.salvarJogo.write("Soma das cartas sistema: "+somarCartasSistema);
							conexao.salvarJogo.newLine();
							
							System.out.println("'PERDEU COM CARTA MAIOR Q 21'");
							conexao.salvarJogo.write("'PERDEU COM CARTA MAIOR Q 21'");
							conexao.salvarJogo.newLine();
							
							System.out.println("PERDEU DINHEIRO, O VALOR DO SEU DINHEIRO É: "+jogador.getAposta());
							opcao = 0;
							break;
						}

						// JOGADOR PERDE COM CARTA MENOR Q O SISTEMA
						else if((somarCartasJogador < 21 && somarCartasSistema <= 21) && (somarCartasJogador < somarCartasSistema)){
							System.out.println("\nSoma das cartas jogador: "+somarCartasJogador);
							System.out.println("Soma das cartas sistema: "+somarCartasSistema);
							System.out.println();

							conexao.salvarJogo.write("\nSoma das cartas jogador: "+somarCartasJogador);
							conexao.salvarJogo.newLine();
							conexao.salvarJogo.write("Soma das cartas sistema: "+somarCartasSistema);
							conexao.salvarJogo.newLine();
							
							System.out.println("'PERDEU COM CARTA MENOR Q O SISTEMA'");
							conexao.salvarJogo.write("'PERDEU COM CARTA MENOR Q O SISTEMA'");
							conexao.salvarJogo.newLine();
							
							System.out.println("PERDEU DINHEIRO, O VALOR DO SEU DINHEIRO É: "+jogador.getAposta());
							conexao.salvarJogo.write("PERDEU DINHEIRO, O VALOR DO SEU DINHEIRO É: "+jogador.getAposta());
							conexao.salvarJogo.newLine();
							opcao = 0;
							break;
						}


					case 0:
						System.out.println("SAIND DO JOGO NA GAMBIARRA.. TRATAR ISSO");
						break;

					default:
						System.out.println("VOCE ENTROU NO DEFAULT DO SWITCH!  'TRATAR ESSE ERRO'");
						break;
					}
				}

			}
			
			conexao.salvarJogo();
		
		}catch(IOException e){
			e.getMessage();
		}
	}
}
