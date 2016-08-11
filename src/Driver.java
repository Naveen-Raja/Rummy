import GameComponents.*;
import Rummy.*;

public class Driver {

	public static void main(String[] args) {

			RummyHand hand = new RummyHand();
			Deck deck = new Deck(2, true);
			Card joker;
			deck.shuffle();

//			for(int i=0;i<13;i++){
//				hand.addCard(deck.removeCardOnTop());
//			}	
			hand.addCard(new Card("2","SPADE"));
			hand.addCard(new Card("3","SPADE"));
			hand.addCard(new Card("4","SPADE"));
			hand.addCard(new Card("5","SPADE"));
			hand.addCard(new Card("5","HEART"));
			hand.addCard(new Card("5","DIAMOND"));
			hand.addCard(new Card("8","SPADE"));
			hand.addCard(new Card("6","CLUB"));
			hand.addCard(new Card("6","HEART"));
			hand.addCard(new Card("6","DIAMONS"));
			hand.addCard(new Card("7","SPADE"));
			hand.addCard(new Card("7","DIAMOND"));
			hand.addCard(new Card("Q","SPADE"));

			
			joker=deck.removeCardOnTop();
			//joker=new Card("7","hearts");
			System.out.println("Intial Set of Cards: "+hand);
			System.out.println("Joker Card: "+joker);
			hand.evaluate(joker);
			
			
	}

}
