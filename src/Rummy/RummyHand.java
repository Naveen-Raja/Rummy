package Rummy;

import java.util.ArrayList;
import java.util.Collections;

import com.example.cardGame.Hand;

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

	public int rummyHandAssessment(Hand playerCardsInHand)
	{
		int numMethod1=method1(playerCardsInHand);
		int numMethod2=method2(playerCardsInHand);
		int numMethod3=method3(playerCardsInHand);
		int min=numMethod2;
		if(numMethod1<numMethod2){
			min=numMethod1;	
		}
		if(min>numMethod3)
		{
			min=numMethod3;
		}
		return min;
		
	}
	
	//Check for sequence 553
	public int method1(Hand h){
		
		
		return 0;
	}
	
	//Check for sequence 544
	public int method2(Hand h){
		
		return 0;
	}
	
	//Check for sequence4333
	public int method3(Hand h){
		
		return 0;
	}

	public int evaluate(){
		sortCards();
		
		return 0;
	}

	
}
