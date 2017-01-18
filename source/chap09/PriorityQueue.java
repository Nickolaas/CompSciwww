//********************************************************************
//  PriorityQueue.java       Author: AP Committee, comments by
//                                   Lewis/Loftus/Cocking
//
//  An interface defining a priority queue ADT.
//********************************************************************

public interface PriorityQueue
{
   //-----------------------------------------------------------------
   //  Return true if the queue has no elements, false otherwise.
   //-----------------------------------------------------------------
   boolean isEmpty ();

   //-----------------------------------------------------------------
   //  Add an element to the priority queue.
   //-----------------------------------------------------------------
   void add (Object obj);

   //-----------------------------------------------------------------
   //  Remove and return the smallest (i.e., highest priority)
   //  element in the queue.
   //-----------------------------------------------------------------
   Object removeMin ();

   //-----------------------------------------------------------------
   //  Return the smallest element in the queue without removing
   //  it.
   //-----------------------------------------------------------------
   Object peekMin();
}
