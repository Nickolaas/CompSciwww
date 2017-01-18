//********************************************************************
//  Searches.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the linear and binary search algorithms.
//********************************************************************

public class Searches
{
   //-----------------------------------------------------------------
   //  Searches the array of integers for the specified element using
   //  a linear search. The index where the element was found is
   //  returned, or -1 if the element is not found.
   //-----------------------------------------------------------------
   public static int linearSearch (int[] numbers, int key)
   {
      for (int index = 0; index < numbers.length; index++)
         if (key == numbers[index])
            return index;
      return -1;
   }

   //-----------------------------------------------------------------
   //  Searches the array of integers for the specified element using
   //  a binary search. The index where the element was found is
   //  returned, or -1 if the element is not found.
   //  NOTE: The array must be sorted!
   //-----------------------------------------------------------------
   public static int binarySearch (int[] numbers, int key)
   {
      int low = 0, high = numbers.length-1, middle = (low + high) / 2;

      while (numbers[middle] != key && low <= high)
      {
         if (key < numbers[middle])
            high = middle - 1;
         else
            low = middle + 1;
         middle = (low + high) / 2;
      }

      if (numbers[middle] == key)
         return middle;
      else
         return -1;
   }
}
