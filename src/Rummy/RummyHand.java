package Rummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import GameComponents.*;

public class RummyHand extends Hand{
	
	String[] possibleWinCombinations = {"4333","553","544"};
	String possibleSequence = "AKQJT98765432A";
	int availableJokers = 0;
	
	HashMap<String,String> sequenceInSuit;
	
	
	public RummyHand(){
		cardsInHand = new ArrayList<>();
		sequenceInSuit = new HashMap<>();
	}
	
	public void sortCards(){
		Collections.sort(cardsInHand);
	}
	
	public void convertToSequenceMap(){
		String sequence = "";
		for(Card c: cardsInHand){
			String suit  = c.getSuit();
			String value = c.getDisplayValue();
			if(suit=="*")
				this.availableJokers++;
			else if(!sequenceInSuit.containsKey(suit))
				sequenceInSuit.put(suit, sequence+value);
			else {
				sequence = sequenceInSuit.get(suit);
				sequenceInSuit.put(suit, sequence+value);
			}
			sequence = "";
		}
	}
	
	public int evaluate(){
		sortCards();
		convertToSequenceMap();
		System.out.println(sequenceInSuit);
		return 0;
	}
	
}
