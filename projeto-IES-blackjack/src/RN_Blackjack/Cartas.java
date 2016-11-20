package RN_Blackjack;


import java.util.ArrayList;
import java.util.Collections;

public class Cartas {
        
        private ArrayList<Carta> baralho = new ArrayList<>();
        
        public void criaBaralho(){
            
            // Copas;
            for(int x = 2; x < 15; x++){
                String naipe = "♥";
                        
                        if(x < 11){
                           naipe += Integer.toString(x);
                        }
                        if(x == 11){
                            naipe = "J♥"; 
                        }
                        if(x == 12){
                            naipe = "Q♥"; 
                        }
                        if(x == 13){
                            naipe = "K♥"; 
                        }
                        if(x == 14){
                            naipe = "A♥"; 
                        }
                        
                        Carta carta = new Carta(x, naipe);
                        baralho.add(carta);
            }
            
            // Ouros;
            for(int x = 2; x < 15; x++){
                String naipe = "♦";
                        
                        if(x < 11){
                           naipe += Integer.toString(x);
                        }
                        if(x == 11){
                            naipe = "J♦"; 
                        }
                        if(x == 12){
                            naipe = "Q♦"; 
                        }
                        if(x == 13){
                            naipe = "K♦"; 
                        }
                        if(x == 14){
                            naipe = "A♦"; 
                        }
                        
                        Carta carta = new Carta(x, naipe);
                        baralho.add(carta);
            }
            
            // Paus;
            for(int x = 2; x < 15; x++){
                String naipe = "♣";
                        
                        if(x < 11){
                           naipe += Integer.toString(x);
                        }
                        if(x == 11){
                            naipe = "J♣"; 
                        }
                        if(x == 12){
                            naipe = "Q♣"; 
                        }
                        if(x == 13){
                            naipe = "K♣"; 
                        }
                        if(x == 14){
                            naipe = "A♣"; 
                        }
                        
                        Carta carta = new Carta(x, naipe);
                        baralho.add(carta);
            }
            
            // Espadas;
            for(int x = 2; x < 15; x++){
                String naipe = "♠";
                        
                        if(x < 11){
                           naipe += Integer.toString(x);
                        }
                        if(x == 11){
                            naipe = "J♠"; 
                        }
                        if(x == 12){
                            naipe = "Q♠"; 
                        }
                        if(x == 13){
                            naipe = "K♠"; 
                        }
                        if(x == 14){
                            naipe = "A♠"; 
                        }
                        
                        Carta carta = new Carta(x, naipe);
                        baralho.add(carta);
            }
              
        }
        
        public void resetaBaralho(){
            baralho.clear();
            criaBaralho();
        }
        
        public void misturaBaralho(){
            Collections.shuffle(baralho);
        }
        
        public void imprimeBaralho(){
            
            for(Carta carta : baralho){
                System.out.print(carta.toString());
            }
            
        }
     
        public Carta retiraPrimeiraCartaDoBaralho(){
            return baralho.remove(0);
        }
        
}

