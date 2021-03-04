package lab3bZad1;
// Card shuffling and dealing application.

public class DeckOfCardsTest
{
   // execute application
   public static void main( String args[] )
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle(); // place Cards in random order
      
      Card[] hand = new Card[ 5 ]; // store five cards
      while (true) {
      	System.out.println( "\nNew hand deal: \n" );
        // get first five cards
        for ( int i = 0; i < 5; i++ )
        {
           hand[ i ] = myDeckOfCards.dealCard(); // get next card
           if (hand[i] != null)
              System.out.println( hand[ i ] );
           else
               return; // exit the application
        } // end for

        // display result
        System.out.println( "\nHand contains:" );

        //if couples and triples = 1 -> flush; else check for three, check for 2 pairs, check for 1 pair
        int couples = myDeckOfCards.pairs( hand ); // a pair
        myDeckOfCards.twoPairs( couples ); // two pairs
        int triples = myDeckOfCards.threeOfAKind( hand ); // three of a kind
        myDeckOfCards.fourOfAKind( hand ); // four of a kind
        myDeckOfCards.flush( hand ); // a flush
        myDeckOfCards.straight( hand ); // a straight
        myDeckOfCards.fullHouse( couples, triples ); // a full house
    }
   } // end main
} // end class DeckOfCardsTest

