package App_Blackjack;


import java.io.IOException;
import java.util.Scanner;

import DB_Blackjack.ConexaoDB;
import RN_Blackjack.Banca;
import RN_Blackjack.Jogador;
import RN_Blackjack.Jogadores;


public class App {
    
   	public static void main(String[] args) {

            
                	BlackJack blackjack = new BlackJack();
                
                	Scanner in = new Scanner(System.in);

                	System.out.println("\nBem vindo ao Jogo 21 (Blackjack)");
		
                	System.out.println("");
                	
                	int opcao1;
                	do {
                	     
                		 System.out.println("");
                		 System.out.println("1 - Novo jogo.");
                		 System.out.println("2 - Carregar jogo.");
                		 System.out.println("3 - Ranking de jogadores.");
                		 System.out.println("0 - Sair");
                         opcao1 = in.nextInt();
  
                		switch (opcao1) {
						case 1:
													
							blackjack.NovoJogo();
						
							break;

						case 2:
							
							blackjack.ListaJogadoresSalvos();
							
							break;
							
						case 3:
							
							blackjack.imprimeTopCincoJogadores();
							
							break;

						default:
							break;
						}
						
					} while (opcao1 != 0);
                	
                	
                	
                	
		
					               
        }
}
