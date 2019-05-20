import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket; 
import java.util.Random;

public class ServerLibraria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.MescolaBoard();
		for(int i=0; i < game.dimensioneBoard();i++)
		System.out.print(game.boardPublic()[i]+ " ");
		game.calcoloVincitore();

	}

}

class Game {
private int[] board = {
	    -1,-1,-1,-1,-1,
		0,0,0,0,0,
		1,1,1,1,1,
		2,2,2,2,2,
		3,3,3,3,3
    };

private int[] spigoli = {
	  0,0,0,0,0,0,
	  0,0,0,0,0,0,
	  0,0,0,0,0,0,
	  0,0,0,0,0,0,
	  0,0,0,0,0,0,
	  0,0,0,0,0,0,
};


/*private int[] spigoli = {
	  1,1,1,1,1,1,
	  1,1,1,1,1,1,
	  1,1,1,1,1,1,
	  2,2,2,2,2,2,
	  2,2,2,2,2,2,
	  2,2,2,2,2,2,
};
*/


public int[]  MescolaBoard() {
  
  Random rgen = new Random();  // Random number generator		
    int contatoreMescolate = 0;
  	while( contatoreMescolate <10)
	for (int i=0; i<board.length; i++) {
	    int randomPosition = rgen.nextInt(board.length);
	    int temp = board[i];
	    board[i] = board[randomPosition];
	    board[randomPosition] = temp;
	    contatoreMescolate++;
	}
	return board;   
  }

public int dimensioneBoard () {
	return board.length;
}

public int [] boardPublic(){
	return board;
	
}

// Player currentPlayer;

public void calcoloVincitore() {
	int punteggioPrimo = 0;
	int punteggioSecondo = 0;
	int spigoloAltoSinistro= 0;
	int primoSpigolo=0;
	int secondoSpigolo=0;
	int terzoSpigolo=0;
	int quartoSpigolo=0;
	int totaleSpigoli=0;
	
	for (int numeroPosizione=0;numeroPosizione<25;numeroPosizione++)
	{
	 spigoloAltoSinistro = numeroPosizione + numeroPosizione/5;
	 primoSpigolo   = spigoli[spigoloAltoSinistro];
	 secondoSpigolo = spigoli[spigoloAltoSinistro+1];
	 terzoSpigolo   = spigoli[spigoloAltoSinistro+6];
	 quartoSpigolo  = spigoli[spigoloAltoSinistro+7];
	 totaleSpigoli=primoSpigolo + secondoSpigolo + terzoSpigolo + quartoSpigolo;
	 switch(totaleSpigoli) {
	 case 4:
		 punteggioPrimo= punteggioPrimo + board[numeroPosizione];
		 if(board[numeroPosizione]== -1) punteggioPrimo = punteggioPrimo -1;
		 else punteggioPrimo= punteggioPrimo + 1;
		 break;
		 
	 case 5: punteggioPrimo= punteggioPrimo + board[numeroPosizione];
		 break;
		 
	 case 6:
		 break;
		 
	 case 7: punteggioSecondo= punteggioSecondo + board[numeroPosizione];
		 break;
		 
	 case 8:
		 punteggioSecondo= punteggioSecondo + board[numeroPosizione];
		 if(board[numeroPosizione]== -1) punteggioSecondo = punteggioSecondo -1;
		 else punteggioSecondo= punteggioSecondo + 1;
		 break;
	 default:
		 break;
	 }
	 }
	System.out.print("giocatore 1  " + punteggioPrimo + " giocatore 2  " + punteggioSecondo);
	
	}  
	
	
}



