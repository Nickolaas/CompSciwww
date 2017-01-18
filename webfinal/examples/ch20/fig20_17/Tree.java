// Fig. 20.17: Tree.java
// Definition of class TreeNode and class Tree.
package com.deitel.jhtp5.ch20;

// class TreeNode definition
class TreeNode {

   // package access members
   TreeNode leftNode;   
   int data;        
   TreeNode rightNode;  

   // initialize data and make this a leaf node
   public TreeNode( int nodeData )
   { 
      data = nodeData;              
      leftNode = rightNode = null;  // node has no children
   }

   // locate insertion point and insert new node; ignore duplicate values
   public synchronized void insert( int insertValue )
   {
      // insert in left subtree
      if ( insertValue < data ) {

         // insert new TreeNode
         if ( leftNode == null )
            leftNode = new TreeNode( insertValue );

         else // continue traversing left subtree
            leftNode.insert( insertValue ); 
      }

      // insert in right subtree
      else if ( insertValue > data ) {

         // insert new TreeNode
         if ( rightNode == null )
            rightNode = new TreeNode( insertValue );

         else // continue traversing right subtree
            rightNode.insert( insertValue ); 
      }

   } // end method insert

} // end class TreeNode

// class Tree definition
public class Tree {
   private TreeNode root;

   // construct an empty Tree of integers
   public Tree() 
   { 
      root = null; 
   }

   // insert a new node in the binary search tree
   public synchronized void insertNode( int insertValue )
   {
      if ( root == null )
         root = new TreeNode( insertValue ); // create the root node here

      else
         root.insert( insertValue ); // call the insert method
   }

   // begin preorder traversal
   public synchronized void preorderTraversal()
   { 
      preorderHelper( root ); 
   }

   // recursive method to perform preorder traversal
   private void preorderHelper( TreeNode node )
   {
      if ( node == null )
         return;

      System.out.print( node.data + " " ); // output node data
      preorderHelper( node.leftNode );     // traverse left subtree
      preorderHelper( node.rightNode );    // traverse right subtree
   }

   // begin inorder traversal
   public synchronized void inorderTraversal()
   { 
      inorderHelper( root ); 
   }

   // recursive method to perform inorder traversal
   private void inorderHelper( TreeNode node )
   {
      if ( node == null )
         return;

      inorderHelper( node.leftNode );      // traverse left subtree
      System.out.print( node.data + " " ); // output node data
      inorderHelper( node.rightNode );     // traverse right subtree
   }

   // begin postorder traversal
   public synchronized void postorderTraversal()
   { 
      postorderHelper( root ); 
   }

   // recursive method to perform postorder traversal
   private void postorderHelper( TreeNode node )
   {
      if ( node == null )
         return;
  
      postorderHelper( node.leftNode );    // traverse left subtree
      postorderHelper( node.rightNode );   // traverse right subtree
      System.out.print( node.data + " " ); // output node data
   }

} // end class Tree

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
