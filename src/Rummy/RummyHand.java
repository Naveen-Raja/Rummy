package Rummy;

import java.util.ArrayList;
import java.util.Collections;

import GameComponents.*;

public class RummyHand extends Hand{
	
	public RummyHand(){
		cardsInHand = new ArrayList<>();
	}
	
	public void sortCards(){
		Collections.sort(cardsInHand);
	}
	
	
}
