package App_Blackjack;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import RN_Blackjack.Banca;
import RN_Blackjack.Carta;
import RN_Blackjack.Cartas;
import RN_Blackjack.Jogador;
import RN_Blackjack.Jogadores;


public class BlackJack {
	  
	   private Cartas baralho; 
	   
	   public BlackJack(){
	       baralho = new Cartas();
	       baralho.criaBaralho();
	       baralho.imprimeBaralho();
	   }
	   
	   public void criaRodada(double aposta, Jogador jogador, Banca banca){
	        
	       baralho.resetaBaralho();
	       baralho.misturaBaralho();
	       jogador.LimpaCartas();
	       banca.LimpaCartas();
	       
	       jogador.retiraDinheiro(aposta);
	       
	       System.out.println("\n♥♦♣♠ -------- Rodada Iniciada !  -------- ♥♦♣♠");
	       System.out.println("Valor da aposta R$"+aposta);
	       System.out.println("A banca está distribuindo as cartas...\n");
	       
	       baralho.misturaBaralho();
	       
	       jogador.adicionaCartaJogador(baralho.retiraPrimeiraCartaDoBaralho());
	       jogador.adicionaCartaJogador(baralho.retiraPrimeiraCartaDoBaralho());
	       
	       System.out.println("Você somou "+ jogador.retornaValorDasCartasJogador() 
	                                        +" pontos com as seguintes cartas: ");
	       jogador.imprimeCartasJogador();
	       System.err.println("\n");
	       
	       banca.adicionaCartaBanca(baralho.retiraPrimeiraCartaDoBaralho());
	       System.out.println("A banca somou "+ banca.retornaValorDasCartasBanca()
	                                        +" pontos com a seguinte carta: ");
	       banca.imprimeCartasBanca();
	       
	                    int opcao;
	                    Scanner entrada = new Scanner(System.in);
	       
	                    do{
	                        
	                                System.out.println("\n1 - Receber outra carta.");
	                                System.out.println("0 - Finalizar rodada.");
	                                System.out.println("Digite sua opçao: ");
	                                
	                                opcao = entrada.nextInt();
	                            
	                        if(opcao == 1){
	                            System.out.println("");
	                            
	                            Carta novaCarta = baralho.retiraPrimeiraCartaDoBaralho();
	                            jogador.adicionaCartaJogador(novaCarta);
	                            System.out.println("Você recebeu a carta " + novaCarta.toString());
	                            System.out.println("E somou " + jogador.retornaValorDasCartasJogador()
	                                                + " com as cartas:");
	                            jogador.imprimeCartasJogador();                           
	                        }
	                        
	                        if(jogador.retornaValorDasCartasJogador() > 21){
	                        opcao = 0;
	                        }
	                                               
	                    }while(opcao != 0);
	       
	            //finaliza e confere rodada
	           if(jogador.retornaValorDasCartasJogador() < 22){
	           
	           Carta novaCartaBanca = baralho.retiraPrimeiraCartaDoBaralho();
	           banca.adicionaCartaBanca(novaCartaBanca);
	           System.out.println("A banca recebeu a carta "+novaCartaBanca.toString()
	                              +" e somou " +banca.retornaValorDasCartasBanca()+" pontos.");  
	           System.out.print("");
	           
	           if(banca.retornaValorDasCartasBanca() > 21){
	               double valor = aposta *2;
	               System.out.println(jogador.getNome()+" você venceu esta rodada e ganhou R$" + valor+"!!");
	               jogador.adicionaDinheiro(valor);
	           }else if(banca.retornaValorDasCartasBanca() >= jogador.retornaValorDasCartasJogador()){
	               
	               System.out.println("A banca ganhou com "+banca.retornaValorDasCartasBanca()+"pontos!");
	               
	           } else {
	               
	               double valor = aposta *2;
	               System.out.println(jogador.getNome()+" você venceu esta rodada e ganhou R$" + valor+"!!");
	               jogador.adicionaDinheiro(valor);
	               
	           }
	           
	           
	           
	           }else if(jogador.retornaValorDasCartasJogador() > 21){
	           
	               System.out.println("Você somou mais que 21 pontos, a Banca Ganhou!"); 
	               System.out.println(jogador.getNome()+" você possui R$"+jogador.getDinheiro() +" para apostas.\n");

	           }
	            
	            
	            System.out.println(jogador.getNome()+" você possui R$"+jogador.getDinheiro() +" para apostas.\n");
	           	
	       //imprimir situação jogador 
	   }
	   
	   public void NovoJogo(){
		   
		   Scanner in = new Scanner(System.in);
		   
		   	System.out.println("Entre com seu nome e faça sua aposta!");
			System.out.print("Digite seu nome: ");
			String nome = in.next();
			//jogador
			Jogador jogador = new Jogador(nome);
			Banca banca = new Banca();
       
       	System.out.println("\nOlá "+jogador.getNome()+" você possui R$"+jogador.getDinheiro() +" para apostas.\n");
       	
           int opcao;
           do{
        	   System.out.println("");
               System.out.println("1 - Iniciar rodada.");
               System.out.println("2 - Salvar jogo.");
               System.out.println("0 - Voltar Menu Inicial.");
               System.out.println("Digite sua opçao: ");
               opcao = in.nextInt();

               switch (opcao) {
				case 1:
					
					   System.out.println("");
					   int aposta = 0;
                       String valor;
                       
                       do {
                    	   
                    	   System.out.println("\nDigite o valor da sua aposta: ");
                           valor = in.next();
                           
                           	try {
                           		 aposta = Integer.parseInt(valor);
                        	} catch (NumberFormatException e) {
                        	      System.out.println("Somente numeros são aceitos!");
                        	      aposta = 0;
                        	}
                           
                           
                           if(aposta > jogador.getDinheiro()){
                        	   System.out.println("Você não tem dinheiro suficiente!");
                        	   System.out.println(jogador.getNome()+" você possui R$"+jogador.getDinheiro() +" para apostas.\n");
                           }else if(aposta < 0){
                        	   System.out.println("Aposta inválida!");
                           }
                           
                           
                       } while (aposta < 0 || aposta > jogador.getDinheiro() || aposta == 0);
                       
                       
                       
                       criaRodada(aposta,jogador,banca); 
					
					break;
					
				case 2:
						
						Jogadores.SalvaJogador(jogador);
						System.out.println("\nJogo Salvo "+jogador.getNome()+"!");
						System.out.println("");
					
					break;

				default:
					break;
				}
           }while(opcao != 0); 
		   
	   }
	   
	   public void CarregaJogo(Jogador jogador){
		   
		   	Scanner in = new Scanner(System.in);
		   
		   	System.out.println("\nOlá "+jogador.getNome()+" você possui R$"+jogador.getDinheiro() +" para apostas.\n");
	      	   	
			Banca banca = new Banca();
      
          int opcao;
          do{
        	  System.out.println("");
              System.out.println("1 - Iniciar rodada.");
              System.out.println("2 - Salvar jogo.");
              System.out.println("0 - Voltar Menu Inicial.");
              System.out.println("Digite sua opçao: ");
              opcao = in.nextInt();

              switch (opcao) {
				case 1:
					
					 	System.out.println("");
					 	
					 	int aposta = 0;
	                       String valor;
	                       
	                       do {
	                    	   
	                    	   System.out.println("\nDigite o valor da sua aposta: ");
	                           valor = in.next();
	                           
	                           	try {
	                           		 aposta = Integer.parseInt(valor);
	                        	} catch (NumberFormatException e) {
	                        	      System.out.println("Somente numeros são aceitos!");
	                        	      aposta = 0;
	                        	}
	                           
	                           
	                           if(aposta > jogador.getDinheiro()){
	                        	   System.out.println("Você não tem dinheiro suficiente!");
	                        	   System.out.println(jogador.getNome()+" você possui R$"+jogador.getDinheiro() +" para apostas.\n");
	                           }else if(aposta < 0){
	                        	   System.out.println("Aposta inválida!");
	                           }
	                           
	                           
	                       } while (aposta < 0 || aposta > jogador.getDinheiro() || aposta == 0);
	                       
                      
                      
                      criaRodada(aposta,jogador,banca); 
					
					break;
					
				case 2:
						
						Jogadores.SalvaJogador(jogador);
						System.out.println("\nJogo Salvo "+jogador.getNome()+"!");
						System.out.println("");
					
					break;

				default:
					break;
				}
          }while(opcao != 0); 
		   
		   
	   }
	   
	   public void ListaJogadoresSalvos(){
		   
		   ArrayList<Jogador> jogadores = Jogadores.retornaListaDeJogadores();
		   
		   if(!jogadores.isEmpty()){
		   System.out.println("---- Jogadores Salvos: ----\n");
			   
		   	   for(int x = 0; x < jogadores.size(); x++){
				   System.out.println(Integer.toString(x) +" "+ jogadores.get(x).toString());
			   }
			   System.out.println();
			   
			   int opcao;
			   Scanner in = new Scanner(System.in);
			   System.out.println("Selecione um jogador:");
			   opcao = in.nextInt();
			   
			   do {
				   
				   System.out.println("Você selecionou o jogador -> " +jogadores.get(opcao).getNome());
				   			   
				   				
			   } while (opcao < 0 || opcao > jogadores.size());
			   
			   CarregaJogo(jogadores.get(opcao));
			   
		   }else{
			   System.out.println("Nenhum jogo salvo!");
		   }
		   
		   
	   }
	   
	   public void imprimeTopCincoJogadores(){
		   
		  ArrayList<Jogador> jogadores = Jogadores.retornaListaDeJogadoresOrdenadaPorDinheiro();
		  
		  if(!jogadores.isEmpty()){
			  int tamanho = 5;
			  if(jogadores.size() < 5){
				  tamanho = jogadores.size();
			  }
			  
			  for(int x = 0; x < tamanho; x++){
				  
				  System.out.println(Integer.toString(x+1)+"º Lugar -> " + jogadores.get(x).toString());
				  
			  }
				  
			  
		  }
		   
		   
	   }
	   
	   
	}
