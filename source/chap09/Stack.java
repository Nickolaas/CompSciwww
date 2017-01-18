//********************************************************************
//  Stack.java       Author: AP Committee, comments by
//                           Lewis/Loftus/Cocking
//
//  An interface defining a stack ADT.
//********************************************************************

public interface Stack
{
   //-----------------------------------------------------------------
   //  Return true if the stack has no elements, false otherwise.
   //-----------------------------------------------------------------
   boolean isEmpty ();

   //-----------------------------------------------------------------
   //  Push an element onto the stack.
   //-----------------------------------------------------------------
   void push (Object obj);

   //-----------------------------------------------------------------
   //  Pop an element off the stack and return it.
   //-----------------------------------------------------------------
   Object pop ();

   //-----------------------------------------------------------------
   //  Return the element on top of the stack without removing it.
   //-----------------------------------------------------------------
   Object peekTop();
}
