package crackingTheCodeInterviewExs_OOD;

import java.util.ArrayList;

public class IQ_7_1_DeckOfCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public enum Suit {
		Club (0), Diamon (1), Heart (2), Spade(3);
		private int value;
		private Suit(int v) { value = v;}
		public int getValue() { return value; }
		public static Suit getSuitFromValue(int value) {}
	}
	
	public class Deck <T extends Card>{
		private ArrayList<T> cards; // all cards, dealt or not
		private int dealtIndex = 0; // marks first undealt card
		
		public void setDeckOfCards(ArrayList<T> deckOfCards) {}
		
		public void shuffle() {}
		public int remainingCards() {
			return cards.size() - dealtIndex;
		}
		public T[] dealHand(int number) {}
		public T dealCard() {}
	}
	
	public abstract class Card {
		private boolean available = true;
		
		protected int faceValue;
		protected Suit suit;
		
		public Card(int c, Suit s) {
			faceValue = c;
			suit = s;
		}
		
		public abstract int value();
		public Suit suit() { return suit; }
		
		/* Check if the card is available to be given out to someone*/
		public boolean isAvailable() { return available; }
		public void markUnavailable() { available = false; }
		public void markAvailable() { available = true; }
	}
	
	public class Hand <T extends Card> {
		protected ArrayList<T> cards = new ArrayList<T>();
		
		public int score() {
			int score = 0;
			for (T card : cards) {
				score += card.value();
			}
			return score;
		}
		
		public void addCard(T card) {
			cards.add(card);
		}
	}
	
	public class BlackJackHand extends Hand<BlackJackCard> {
		
		public int score() {
			ArrayList<Integer> scores = possibleScores();
			int maxUnder = Integer.MIN_VALUE;
			int minOver = Integer.MAX_VALUE;
			for (int score : scores) {
				if (score > 21 && score < minOver) {
					minOver = score;
				} else if (score <= 21 && score > maxUnder) {
					maxUnder = score;
				}
			}
			return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
		}
		
		private ArrayList<Integer> possibleScores() {}
		
		public boolean busted() { return score() > 21; }
		public boolean is21() { return score() == 21; }
		public boolean isBlakcJack() {}
	}
	
	public class BlackJackCard extends Card {
		public BlackJackCard(int c, Suit s) { super(c, s); }
		public int value() {
			if (isAce()) return 1;
			else if (faceValue >= 11 && faceValue <= 13) return 10;
			else return faceValue;
		}
		
		public int minValue() {
			if (isAce()) return 1;
			else return value();
		}
		
		public int maxValue() {
			if (isAce()) return 11;
			else return value();
		}
		
		public boolean isAce() {
			return faceValue == 1;
		}
		
		public boolean isFaceCard() {
			return faceValue >= 11 && faceValue <= 13;
		}
	}

}
