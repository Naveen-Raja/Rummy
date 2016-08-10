package Rummy;

import java.util.ArrayList;
import java.util.Collections;

import GameComponents.*;

public class RummyHand extends Hand{
	
	String[] possibleWinCombinations = {"4333","553","544"};
	String possibleSequence = "A23456789TJQKA";
	
	public RummyHand(){
		cardsInHand = new ArrayList<>();
	}
	
	public void sortCards(){
		Collections.sort(cardsInHand);
	}
	
	public int evaluate(){
		sortCards();
		
		return 0;
	}
	
}
