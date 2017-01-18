//********************************************************************
//  SortGrades.java       Author: Lewis/Loftus/Cocking
//
//  Driver for testing the use of binary search trees in sorting.
//********************************************************************

public class SortGrades
{
   //-----------------------------------------------------------------
   //  Creates a binary search tree, adds grades to it, then prints
   //  the tree.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      BSTree tree = new BSTree();

      tree.add(new Integer(89));
      tree.add(new Integer(94));
      tree.add(new Integer(69));
      tree.add(new Integer(80));
      tree.add(new Integer(97));
      tree.add(new Integer(85));
      tree.add(new Integer(73));
      tree.add(new Integer(91));
      tree.add(new Integer(77));
      tree.add(new Integer(93));

      System.out.println (tree);
   }
}
