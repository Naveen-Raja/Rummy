import GameComponents.*;
import Rummy.*;

public class Driver {

	public static void main(String[] args) {

			RummyHand hand = new RummyHand();
			Deck deck = new Deck(2, true);
			Card joker;
			deck.shuffle();
<<<<<<< HEAD
//			for(int i=0;i<13;i++){
//				hand.addCard(deck.removeCardOnTop());
//			}	
			hand.addCard(new Card("A","SPADE"));
			hand.addCard(new Card("K","SPADE"));
			hand.addCard(new Card("Q","SPADE"));
			hand.addCard(new Card("J","SPADE"));
			hand.addCard(new Card("T","HEART"));
			hand.addCard(new Card("T","DIAMOND"));
			hand.addCard(new Card("5","SPADE"));
			hand.addCard(new Card("6","CLUB"));
			hand.addCard(new Card("6","HEART"));
			hand.addCard(new Card("6","DIAMONS"));
			hand.addCard(new Card("7","SPADE"));
			hand.addCard(new Card("7","DIAMOND"));
			hand.addCard(new Card("Q","SPADE"));
=======
			for(int i=0;i<13;i++){
				hand.addCard(deck.removeCardOnTop());
			}	
//			hand.addCard(new Card("2","SPADE"));
//			hand.addCard(new Card("3","SPADE"));
//			hand.addCard(new Card("4","SPADE"));
//			hand.addCard(new Card("T","SPADE"));
//			hand.addCard(new Card("T","HEART"));
//			hand.addCard(new Card("T","DIAMOND"));
//			hand.addCard(new Card("5","SPADE"));
//			hand.addCard(new Card("5","CLUB"));
//			hand.addCard(new Card("5","HEART"));
//			hand.addCard(new Card("5","DIAMONS"));
//			hand.addCard(new Card("7","SPADE"));
//			hand.addCard(new Card("7","DIAMOND"));
//			hand.addCard(new Card("Q","SPADE"));
>>>>>>> 74543080ed81ce375d4fa803cc6e714404af2e7a
			
			joker=deck.removeCardOnTop();
			//joker=new Card("7","hearts");
			System.out.println("Intial Set of Cards: "+hand);
			System.out.println("Joker Card: "+joker);
			hand.evaluate(joker);
			
			
	}

}
