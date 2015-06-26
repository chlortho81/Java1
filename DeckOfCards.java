
// Card shuffling and dealing program
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
/*
  <applet code="DeckOfCards" width=300 height=50>
  </applet>
*/


class Card {
   private String face;
   private String suit;

   public Card( String f, String s )
   {
      face = f;
      suit = s;
   }

   public String toString() { return face + " of " + suit; }
}

public class DeckOfCards extends Applet
             implements ActionListener {
   private Card deck[];
   private int currentCard;

   // GUI components
   private Button dealButton, shuffleButton;
   private TextField displayCard;

   public void init()
   {
      String faces[] = { "Ace", "Deuce", "Three", "Four", 
                         "Five", "Six", "Seven", "Eight", 
                         "Nine", "Ten", "Jack", "Queen",
                         "King" };
      String suits[] = { "Hearts", "Diamonds",
                         "Clubs", "Spades" };

      deck = new Card[ 52 ];
      currentCard = -1;
      
      for ( int i = 0; i < deck.length; i++ ) 
         deck[ i ] = new Card( faces[ i % 13 ],
                               suits[ i / 13 ] );

      dealButton = new Button( "Deal card" );
      dealButton.addActionListener( this );
      
	  shuffleButton = new Button( "Shuffle cards" );
      shuffleButton.addActionListener( this );
      
	  displayCard = new TextField( 30 );
      displayCard.setEditable( false );
      
	  add( dealButton );
      add( shuffleButton);
      add( displayCard );
   }

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == dealButton ) {
         Card dealt = dealCard();

         if ( dealt != null ) {
            displayCard.setText( dealt.toString() );
            showStatus( "Card #: " + currentCard );
         }
         else {
            displayCard.setText( "NO MORE CARDS TO DEAL" );
            showStatus( "Shuffle cards to continue" );
         }
      }
      else if ( e.getSource() == shuffleButton ) {  
         displayCard.setText( "SHUFFLING ..." );
         showStatus( "" );
         shuffle();
         displayCard.setText( "DECK IS SHUFFLED" );
      }
   }

   public void shuffle()
   {
      currentCard = -1;

      for ( int i = 0; i < deck.length; i++ ) {
         int j =  (int) ( Math.random() * 52 );
         Card temp = deck[ i ];   // swap
         deck[ i ] = deck[ j ];   // the
         deck[ j ] = temp;        // cards
      }

      dealButton.setEnabled( true );
   }

   public Card dealCard()
   {
      if ( ++currentCard < deck.length )
         return deck[ currentCard ];
      else {        
         dealButton.setEnabled( false );
         return null;
      }
   }
}





