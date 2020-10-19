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
	public void flip(boolean f){
		this.setFaceUp(f);
	}
	/**
	 * Get the suit of the card
	 * @return the suit
	 */
	public int getSuit() {
		return suit;
	}
	/**
	 * Set the suit of the card
	 * @param suit the suit to set
	 */
	public void setSuit(int suit) {
		this.suit = suit;
	}
	
	/**
	 * Checks if card is a red suit
	 * @return True if the suit is a red suit
	 */
	public boolean isRed() {
		return (this.getSuit() == 0 || this.getSuit() == 1);
	}
	
	/**
	 * Get the value of the card
	 * @return the value
	 */
	public int getValue() {
		return this.value;
	}
	/**
	 * Set the value of the card
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * Check if the card is face up
	 * @return the faceUp
	 */
	public boolean isFaceUp() {
		return faceUp;
	}
	/**
	 * Set the face up status of the card
	 * @param faceUp the faceUp to set
	 */
	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}
	

	/**
	 * Print out the cards
	 * @return a string include the information of the card
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
	
		description += " " + rank[this.getValue()] + " face up: " + this.isFaceUp();
		
		return description;
	}
	
}
