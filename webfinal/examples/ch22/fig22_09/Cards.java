// Fig. 22.9: Cards.java
// Using algorithm shuffle.
import java.util.*;

// class to represent a Card in a deck of cards
class Card {
   private String face;
   private String suit;

   // initialize a Card
   public Card( String initialface, String initialSuit )
   {
      face = initialface;
      suit = initialSuit;
   }

   // return face of Card
   public String getFace() 
   { 
      return face; 
   }

   // return suit of Card
   public String getSuit() 
   { 
      return suit; 
   }

   // return String representation of Card
   public String toString()
   {
      StringBuffer buffer = new StringBuffer( face + " of " + suit );
      buffer.setLength( 20 );

      return buffer.toString();
   }

} // end class Card

// class Cards declaration
public class Cards {
   private static final String suits[] = 
      { "Hearts", "Clubs", "Diamonds", "Spades" };
   private static final String faces[] = { "Ace", "Deuce", "Three",
      "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
      "Jack", "Queen", "King" };
   private List list;

   // set up deck of Cards and shuffle
   public Cards()
   {
      Card deck[] = new Card[ 52 ];

      for ( int count = 0; count < deck.length; count++ )
         deck[ count ] = new Card( faces[ count % 13 ],
            suits[ count / 13 ] );

      list = Arrays.asList( deck );   // get List
      Collections.shuffle( list );    // shuffle deck
   }

   // output deck
   public void printCards()
   {
      int half = list.size() / 2 - 1;

      for ( int i = 0, j = half + 1; i <= half; i++, j++ )
         System.out.println( list.get( i ).toString() + list.get( j ) );
   }

   public static void main( String args[] )
   {
      new Cards().printCards();
   }    
                                       
} // end class Cards

/**************************************************************************
 * (C) Copyright 1992-2003 by Deitel & Associates, Inc. and               *
 * Prentice Hall. All Rights Reserved.                                    *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
