
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	ArrayList<Card> usedCard;//the cards that been used 
	public int nUsed;//count cards that been used
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		
		for(int i =0;i<nDeck ; i++)  //N of decks
		{
			for (Card.Suit s : Card.Suit.values()) //4colors //update in HW3 enum
			{
				for (int y =1; y<=13 ;y++)  //13張
				{
					Card card = new Card(s,y);
					cards.add(card);
										
				}
			}
		}

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		int DC=1; //計算第幾副撲克牌的數量
		for(int i=0;i<cards.size();i++) {
			if(i%52==0) { //print deck number when a new deck start
				System.out.println("Deck-"+DC); //印出第DC副牌
				DC++;
				}
			cards.get(i).printCard();   //print所有牌
			}
		}
	public void shuffle() {
		Random rnd = new Random();  
		int j;
		Card a,b,temp=null;
		for(int i =0;i<cards.size();i++)
		{
			j = rnd.nextInt(cards.size());
			a=cards.get(i);
			b=cards.get(j);
			temp=a;
			a=b;
			b=temp;
		}
		 usedCard.clear();
		 nUsed=0;
	}
	public Card getOneCard() {
		
		Random rnd =new Random();
		usedCard=new ArrayList<Card>();
		
		int k =rnd.nextInt(cards.size());
		Card draw = cards.get(k);
		
		
		nUsed++; 
		usedCard.add(draw); 
		if(nUsed==cards.size()) 
			shuffle();
		return draw;
		
		
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
	
}
