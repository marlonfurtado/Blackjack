package App_Blackjack;


import java.util.Scanner;

import RN_Blackjack.Banca;
import RN_Blackjack.Carta;
import RN_Blackjack.Cartas;
import RN_Blackjack.Jogador;


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
   
   
   
   
}
