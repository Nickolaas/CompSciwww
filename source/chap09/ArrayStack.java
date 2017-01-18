//********************************************************************
//  ArrayStack.java       Author: Lewis/Loftus/Cocking
//
//  Implements a stack data structure.
//********************************************************************

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayStack implements Stack
{
   private ArrayList elements;

   //-----------------------------------------------------------------
   //   Sets up an initially empty stack.
   //-----------------------------------------------------------------
   public ArrayStack ()
   {
      elements = new ArrayList();
   }

   //-----------------------------------------------------------------
   //  Pushes an element onto the stack.
   //-----------------------------------------------------------------
   public void push(Object obj)
   {
      elements.add(obj);
   }

   //-----------------------------------------------------------------
   //  Removes the top element from the stack and returns it.
   //-----------------------------------------------------------------
   public Object pop()
   {
      if (isEmpty())
         throw new NoSuchElementException();

      return elements.remove(elements.size()-1);
   }

   //-----------------------------------------------------------------
   //  Returns the top element on the stack without removing it.
   //-----------------------------------------------------------------
   public Object peekTop()
   {
      if (isEmpty())
         throw new NoSuchElementException();

      return elements.get(elements.size()-1);
   }

   //-----------------------------------------------------------------
   //  Returns true if the stack has no elements, false otherwise.
   //-----------------------------------------------------------------
   public boolean isEmpty()
   {
      return (elements.size() == 0);
   }
}
