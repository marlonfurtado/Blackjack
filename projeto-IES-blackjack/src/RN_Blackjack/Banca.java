package RN_Blackjack;


import java.util.ArrayList;


public class Banca {
    
    private ArrayList<Carta> cartasBanca;
    
    public Banca(){
        cartasBanca = new ArrayList<>();
    }
    
    public void adicionaCartaBanca(Carta carta){
            cartasBanca.add(carta);
    }

    public int retornaValorDasCartasBanca(){
            int valor = 0;
            for(Carta carta : cartasBanca){
                
                if(carta.getValor() < 11){
                    valor += carta.getValor();
                }else if(carta.getValor() > 10 && carta.getValor() < 15){
                    valor += 10;
                }
            }
            return valor;
        }
    
    public void imprimeCartasBanca(){
    if(cartasBanca != null){
                for(Carta carta : cartasBanca){
                    System.out.print(carta.toString() + " ");
                }                
            }
            System.out.println("");
    }
    
    public void LimpaCartas(){
        
            cartasBanca.clear();
        
    }
    
}
