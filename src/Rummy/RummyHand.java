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
    
	public ArrayList<String> getSequences(){
		ArrayList<String> sequencesInHand=new ArrayList<String>();
		
	    ArrayList<String> sequenceOfThree=isSequence(3);	
		return null;
		
	}

	private ArrayList<String> isSequence(int n) {
		int start=0;
		ArrayList<String> seq=new ArrayList<String>();
		String subString="";
		for(int i=0;i<start+3;i++)
		   subString+=cardsInHand.get(i).getDisplayValue();
		
		if(possibleSequence.contains(subString)){
			
		}
		// TODO Auto-generated method stub
		return null;
	}
	
}
