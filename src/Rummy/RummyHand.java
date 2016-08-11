package Rummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import GameComponents.*;

public class RummyHand extends Hand {

	String[] possibleWinCombinations = { "4333", "553", "544" };
	String possibleSequence = "AKQJT98765432A";
	int availableJokers = 0;

	HashMap<String, String> sequenceInSuit;
	ArrayList<String> setOfCards = new ArrayList<String>();

	ArrayList<String> sequences = new ArrayList<String>();
	ArrayList<String> setOf4 = new ArrayList<String>();
	ArrayList<String> setOf3 = new ArrayList<String>();
	ArrayList<String> setOf2 = new ArrayList<String>();
	ArrayList<String> single = new ArrayList<String>();

	public RummyHand() {
		cardsInHand = new ArrayList<>();
		sequenceInSuit = new HashMap<>();
	}

	public void sortCards() {
		Collections.sort(cardsInHand);
	}

	public void convertToSequenceMap() {
		String sequence;
		String initial = "**************";
		for (Card c : cardsInHand) {
			String suit = c.getSuit();
			String value = c.getDisplayValue();
			if (suit == "*")
				this.availableJokers++;
			else if (!sequenceInSuit.containsKey(suit)) {
				sequence = addToSequence(initial, value);
				sequenceInSuit.put(suit, sequence);
			} else {
				sequence = sequenceInSuit.get(suit);
				sequence = addToSequence(sequence, value);
				sequenceInSuit.put(suit, sequence);
			}
		}
	}

	public String addToSequence(String s, String v) {
		if(v=="A"){
			s = v+s.substring(1, s.length()-1)+v;
			return s;
		} else {
			int index = possibleSequence.indexOf(v);
			StringBuilder pattern = new StringBuilder(s);
			pattern.setCharAt(index, v.toCharArray()[0]);
			return pattern.toString();
		}
	}


	public void getSequences() {
		for (String suit : sequenceInSuit.keySet()) {
			String result = subString(possibleSequence, sequenceInSuit.get(suit));
			if (result.length() >= 3)
				sequences.add(suit + " " + result);
		}
	}

	public String subString(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();

		int[][] arr = new int[l1 + 1][l2 + 1];
		int len = 0, pos = -1;

		for (int x = 1; x < l1 + 1; x++) {
			for (int y = 1; y < l2 + 1; y++) {
				if (str1.charAt(x - 1) == str2.charAt(y - 1)) {
					arr[x][y] = arr[x - 1][y - 1] + 1;
					if (arr[x][y] > len) {
						len = arr[x][y];
						pos = x;
					}
				} else
					arr[x][y] = 0;
			}
		}

		return str1.substring(pos - len, pos);
	}

	public void convertToSet() {
		Set<String> list = new HashSet<>();

		for (Card c : cardsInHand) {
			String cardSuitAndValue = c.getDisplayValue() + " " + c.getSuit();
			if (setOfCards.contains(cardSuitAndValue))
				single.add(cardSuitAndValue);
			else
				setOfCards.add(cardSuitAndValue);
		}
		Collections.sort(setOfCards);
		System.out.println(setOfCards);
		getSet();
	}

	private void getSet() {
		// TODO Auto-generated method stub
		int count = 0;
		String set = setOfCards.get(0);
		for (int i = 0; i < setOfCards.size() - 1;) {

			if (setOfCards.get(i).charAt(0) == setOfCards.get(i + 1).charAt(0)) {
				// System.out.println("In If");
				set += "  " + setOfCards.get(i + 1);
				i++;
				count++;
				// System.out.println(count+" "+set);
			} else {
				// System.out.println("In else " +count);
				if (count == 3)
					setOf4.add(set);
				else if (count == 2)
					setOf3.add(set);
				else if (count == 1)
					setOf2.add(set);
				else
					single.add(set);

				// System.out.println(count+" "+set);
				i++;
				count = 0;
				set = setOfCards.get(i);
			}

			if (i == setOfCards.size() - 1) {
				if (count == 3)
					setOf4.add(set);
				else if (count == 2)
					setOf3.add(set);
				else if (count == 1)
					setOf2.add(set);
				else
					single.add(set);
			}
		}


	   System.out.println("Set of 4: ");
	   System.out.println(setOf4);
	   System.out.println("Set of 3: ");
	   System.out.println(setOf3);
	   System.out.println("Set of 2: ");
	   System.out.println(setOf2);
	   System.out.println("Singles: ");
	   System.out.println(single);
	  
	}

    public void assignJokers(Card Joker){
    	ArrayList<Card> valuesToRemove=new ArrayList<Card>(); // To avoid ConcurrentModificationException
    	for(Card c:cardsInHand){
    		if(c.isSameValue(Joker)){
    			valuesToRemove.add(c);
    			availableJokers++;
    		}
    	}
    	cardsInHand.removeAll(valuesToRemove);
    }
    
	public int evaluate(Card joker){
		assignJokers(joker);
		sortCards();
		convertToSequenceMap();
		getSequences();
		System.out.println(sequenceInSuit);
		for (String s : sequences)
			System.out.println(s);
		convertToSet();
		System.out.println("Joker Count: "+availableJokers);
		return 0;
	}
	
}
