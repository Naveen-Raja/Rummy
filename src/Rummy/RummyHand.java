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
			Set<String> result = subString(possibleSequence, sequenceInSuit.get(suit));
			for(String s:result){
				if(s.length()>=2)
					sequences.add(suit + " " + s);
			}
		}
	}

	public void removeFromList(String s){
		
	}
	
	public static Set<String> subString(String s, String t) {
		int[][] table = new int[s.length()][t.length()];
		int longest = 0;
		Set<String> result = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < t.length(); j++) {
				if (s.charAt(i) != t.charAt(j)) {
					continue;
				}

				table[i][j] = (i == 0 || j == 0) ? 1
						: 1 + table[i - 1][j - 1];
				if (table[i][j] > longest) {
					longest = table[i][j];
					result.clear();
				}
				if (table[i][j] == longest) {
					result.add(s.substring(i - longest + 1, i + 1));
				}
			}
		}
		return result;
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

		completeSets();
	}

	public void completeSets(){
		
		//setOf2.add("5 DIAMOND 5 HEART");
		for(String set:setOf2){
			
			System.out.println("Completing Set : "+set);
			
			for(String seq:sequences){
				String splitSeq[]=seq.split("\\s");
				int posInSeq=splitSeq[1].indexOf(set.charAt(0));
				
				System.out.println(splitSeq[0]+" "+splitSeq[1]+" "+posInSeq);
				if((posInSeq-0) >=3){
					if(!set.contains(splitSeq[0])){
						String newSeq =splitSeq[0]+" "+splitSeq[1].substring(0,posInSeq-1);
						setOf2.remove(set);
						set+=" "+splitSeq[1].charAt(posInSeq)+" "+splitSeq[0];
						sequences.remove(seq);
						sequences.add(newSeq);
						setOf3.add(set);
						
						System.out.println(newSeq);
						System.out.println(set);
						
						
					}
				}
				else if((splitSeq[1].length()-1)-posInSeq >= 3){
					if(!set.contains(splitSeq[0])){
						String newSeq = splitSeq[1].substring(posInSeq+1,splitSeq[1].length());
						setOf2.remove(set);
						set+=" "+splitSeq[1].charAt(posInSeq)+" "+splitSeq[0];
						sequences.remove(seq);
						sequences.add(newSeq);
						setOf3.add(set);
						
						System.out.println(newSeq);
						System.out.println(set);
						
					} 
				}
			}
		}
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
		System.out.println("Sequences: ");
		for (String s : sequences)
			System.out.println(s);
		convertToSet();
		System.out.println("Joker Count: "+availableJokers);
		return 0;
	}

}
