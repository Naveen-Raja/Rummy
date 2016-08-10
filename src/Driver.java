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
			hand.evaluate();
			System.out.println(hand);
	}

}
