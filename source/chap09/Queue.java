//********************************************************************
//  Queue.java       Author: AP Committee, comments by
//                           Lewis/Loftus/Cocking
//
//  An interface defining a queue ADT.
//********************************************************************

public interface Queue
{
   //-----------------------------------------------------------------
   //  Return true if the queue has no elements, false otherwise.
   //-----------------------------------------------------------------
   boolean isEmpty ();

   //-----------------------------------------------------------------
   //  Add an element to the end of the queue.
   //-----------------------------------------------------------------
   void enqueue (Object obj);

   //-----------------------------------------------------------------
   //  Remove and return the element at the front of the queue.
   //-----------------------------------------------------------------
   Object dequeue ();

   //-----------------------------------------------------------------
   //  Return the element at the front of the queue without removing
   //  it.
   //-----------------------------------------------------------------
   Object peekFront();
}
