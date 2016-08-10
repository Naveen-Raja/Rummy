package Rummy;
//import java.util.ArrayList;
//
//public class Rummy {
//	ArrayList<Hand> players = null;
//	Deck deck = null;
//	final int NUM_OF_CARDS = 13;
//	
//	public Rummy(int numberOfPlayers) {
//		players = new ArrayList<>();
//		deck = new Deck(4, false);
//		deck.shuffle();
//		for(int i = 0; i < numberOfPlayers; i++) {
//			Hand player = new Hand();
//			for(int j = 0; j < NUM_OF_CARDS; j++) {
//				player.addCard(deck.removeCardOnTop());
//			}
//			players.add(player);
//		}
//	}
//	
//	public String toString() {
//		String s = "";
//		for(int i = 0; i < players.size(); i++) {
//			s += players.get(i);
//		}
//		return s;
//	}
//	
//}
