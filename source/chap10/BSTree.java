//********************************************************************
//  BSTree.java       Author: Lewis/Loftus/Cocking
//
//  Implements a binary search tree.
//********************************************************************


public class BSTree
{
   private BSTNode root;

   //-----------------------------------------------------------------
   //  Sets up an empty binary search tree.
   //-----------------------------------------------------------------
   public BSTree ()
   {
      root = null;
   }

   //-----------------------------------------------------------------
   //  Adds an element to the tree in its proper place.
   //-----------------------------------------------------------------
   public void add (Comparable obj)
   {
      BSTNode newNode = new BSTNode(obj);

      // If this is the first node to be added, make it the root.
      if (root == null)
         root = newNode;
      else
         addNode (root, newNode);
   }

   //-----------------------------------------------------------------
   //  Recursive procedure that adds a node to the binary search
   //  tree.
   //-----------------------------------------------------------------
   private void addNode (BSTNode current, BSTNode newNode)
   {
      if ( ((Comparable)(newNode.getValue())).compareTo (
           current.getValue()) < 0 )
      {
         if (current.getLeft() == null)
            current.setLeft(newNode);
         else
            addNode ((BSTNode)current.getLeft(), newNode);
      }
      else
      {
         if (current.getRight() == null)
            current.setRight(newNode);
         else
            addNode ((BSTNode)current.getRight(), newNode);
      }
   }

   //-----------------------------------------------------------------
   //  Returns a string representing this tree. The info contained
   //  in each node is listed in order, separated by newlines.
   //-----------------------------------------------------------------
   public String toString ()
   {
      return toString(root);
   }

   //-----------------------------------------------------------------
   //  Returns a string representing the subtree rooted at the
   //  given node. Recursively performs an inorder traversal.
   //-----------------------------------------------------------------
   private String toString (TreeNode current)
   {
      String str = "";

      if (current.getLeft() != null)
         str += toString(current.getLeft()) + "\n";

      str += current.getValue();

      if (current.getRight() != null)
         str += "\n" + toString(current.getRight());

      return str;
   }
}
