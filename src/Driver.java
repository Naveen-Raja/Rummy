import GameComponents.*;
import Rummy.*;

public class Driver {

	public static void main(String[] args) {

			RummyHand hand = new RummyHand();
			Deck deck = new Deck(2, true);
			deck.shuffle();
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
			
			hand.evaluate();
			System.out.println(hand);
	}

}
