package entity;

/**
 * 
 * 
 * 
 * @author mnguyen001
 *
 */
public class Card {

	private final static int heart = 0;
	private final static int diamond = 1;
	private final static int club = 2;
	private final static int spade = 3;
	
	private static String rank[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private int suit;
	private int value;
	private boolean faceUp;
	
	public Card(int s, int v ) {
		this.suit = s;
		this.value = v;
		this.setFaceUp(false);
	}
	
	/**
	 * Compare two cards method
	 * @param c the card compared to
	 * @return the difference of  the card
	 * 
	 */
	public int compareTo(Card c) {
		return (this.getValue() - c.getValue());
	}
	/**
	 * Flip the card
	 */
	public void flip(){
		this.setFaceUp(true);
	}
	/**
	 * @return the suit
	 */
	public int getSuit() {
		return suit;
	}
	/**
	 * @param suit the suit to set
	 */
	public void setSuit(int suit) {
		this.suit = suit;
	}
	
	/**
	 * Checks if card is a red suit
	 * 
	 */
	public boolean isRed() {
		return (this.getSuit() == 0 || this.getSuit() == 1);
	}
	
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the faceUp
	 */
	public boolean isFaceUp() {
		return faceUp;
	}
	/**
	 * @param faceUp the faceUp to set
	 */
	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}
	
	/**
	 * @return true if the card is the same suit
	 */
	public boolean isSameSuit(Card c) {
		return this.suit == c.getSuit();
	}

	/**
	 * Print out the cards
	 */
	public String toString() {
		String description;
		if (this.getSuit() == heart) {
			description = "heart";
		}
		else if (this.getSuit() == diamond){
			description = "diamond";
		}
		else if (this.getSuit() == spade){
			description = "spade";
		}
		else {
			description = "club";
		}

		description += " " + rank[this.getValue()] + " face up: " + faceUp;
		return description;
	}
	
}
