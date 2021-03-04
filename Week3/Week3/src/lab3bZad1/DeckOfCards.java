package lab3bZad1;
// DeckOfCards class represents a deck of playing cards.
import java.util.Random;

public class DeckOfCards
{
   private String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
      "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
   private String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };
   private Card deck[]; // array of Card objects
   private int currentCard; // the index of next Card to be dealt
   private final int NUMBER_OF_CARDS = 52; // constant number of cards
   private Random randomNumbers; // random number generator

   // constructor fills deck of cards
   public DeckOfCards()
   {
      deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
      currentCard = 0; // initialize currentCard 
      randomNumbers = new Random(); // create random number generator

      // populate deck with Card objects
      for ( int count = 0; count < deck.length; count++ ) 
         deck[ count ] = 
            new Card( faces[ count % 13 ], suits[ count / 13 ] );
   } // end DeckOfCards constructor

   // shuffle deck of cards with one-pass algorithm
   public void shuffle()
   {
      currentCard = 0; // reinitialize currentCard

      // for each card, pick another random card and swap them
      for ( int first = 0; first < deck.length; first++ ) 
      {
         // select a random number between 0 and 51
         int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );

         // swap current Card with randomly selected Card
         Card temp = deck[ first ];        
         deck[ first ] = deck[ second ];   
         deck[ second ] = temp;            
      } // end for
   } // end method shuffle

   // deal one card
   public Card dealCard()
   {
      // determine whether cards remain to be dealt
      if ( currentCard < deck.length )
         return deck[ currentCard++ ]; // return current Card in array
      else        
         return null; // return null to indicate that all cards were dealt
   } // end method dealCard

   // tally the number of each face card in hand
   private int[] totalHand( Card hand[] )
   {
      int numbers[] = new int[ faces.length ]; // store number of face

      // initialize all elements of numbers[] to zero
      for ( int i = 0; i < faces.length; i++ )
         numbers[ i ] = 0;

      // compare each card in the hand to each element in the faces array
      for ( int h = 0; h < hand.length; h++ )
      {
         for ( int f = 0; f < faces.length; f++ )
         {
            if ( hand[ h ].getFace().equals(faces[ f ]) )
               ++numbers[ f ];
         } // end for
      } // end for

      return numbers;
   } // end method totalHand

   // determine if hand contains pairs
   public int pairs( Card hand[] )
   {
      int couples = 0;
      int numbers[] = totalHand( hand );

      // count pairs
      for ( int k = 0; k < numbers.length; k++ )
      {
         if ( numbers[ k ] == 2 ) 
         {
            System.out.printf( "Pair of %s\n", faces[ k ] );
            ++couples;
         } // end if
	   } // end for

      return couples;
   } // end method pairs

   // determine if hand contains a three of a kind
   public int threeOfAKind( Card hand[] )
   {
      int triples = 0;
      int numbers[] = totalHand( hand );
      
      // count three of a kind
      for ( int k = 0; k < numbers.length; k++ )
      {
         if ( numbers[ k ] == 3 ) 
         {
            System.out.printf( "Three %s\n", faces[ k ] );
            ++triples;
            break;
         } // end if
      } // end for

      return triples;
      /*
      int numbers[] = totalHand( hand );

      // count three of a kind
      for ( int k = 0; k < numbers.length; k++ )
      {
         if ( numbers[ k ] == 3 )
         {
            System.out.printf( "Three %s\n", faces[ k ] );
            return 1;
         } // end if
      } // end for

      return 0;
       */
   } // end method threeOfAKind

   // determine if hand contains a four of a kind
   public void fourOfAKind( Card hand[] )
   {
      int numbers[] = totalHand( hand );

      for ( int k = 0; k < faces.length; k++ )
      {
         if ( numbers[ k ] == 4 ) {
            System.out.printf("Four %s\n", faces[k]);
            return;
         }
      } // end for
   } // end fourOfAKind

   // determine if hand contains a flush
   public void flush( Card hand[] )
   {
      String theSuit = hand[ 0 ].getSuit();

      for ( int s = 1; s < hand.length; s++ )
      {
         if ( !hand[ s ].getSuit().equals(theSuit) )
            return;   // not a flush
      } // end for

      System.out.printf( "Flush in %s\n", theSuit );
   } // end method flush

   // determine if hand contains a straight
   public void straight( Card hand[] )
   {
      int locations[] = new int[ 5 ];
      int z = 0;
      int numbers[] = totalHand( hand );

      for ( int y = 0; y < numbers.length; y++ )
      {
         if ( numbers[ y ] == 1 )
            locations[ z++ ] = y;
      } // end for

      int faceValue = locations[ 0 ];

      if ( faceValue == 0 ) // special case, faceValue is Ace
      {
         faceValue = 13;
  
         for ( int m = locations.length - 1; m >= 1; m-- ) 
         {
            if ( faceValue != locations[ m ] + 1 )
               return; // not a straight
            else
               faceValue = locations[ m ];
         } // end if
      } // end if
      else
      {
         for ( int m = 1; m < locations.length; m++ ) 
         {
            if ( faceValue != locations[ m ] - 1 )
               return; // not a straight
            else
               faceValue = locations[ m ];
         } // end if
      } // end else

      System.out.println( "Straight" );
   } // end method straight

   // determine if hand contains a full house
   public void fullHouse( int couples, int triples )
   {
      if ( couples == 1 && triples == 1 ) 
         System.out.println( "\nFull House!" );
   } // end method fullHouse

   // determine if hand contains two pairs
   public void twoPairs( int couples )
   {
      if ( couples == 2 ) 
         System.out.println( "\nTwo Pair!" );
   } // end method twoPair
} // end class DeckOfCards

