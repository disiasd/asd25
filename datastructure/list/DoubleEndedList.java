package datastructure.list;

import java.util.NoSuchElementException;
import java.util.Iterator;
import java.lang.Iterable;

/**
 *  Double-ended Linked List implementation of the List, Stack and Queue data structures
 *  @param <D> type of the data collected in the data structure
 */
public class DoubleEndedList<D> implements List<D>,Stack<D>,Queue<D>,Iterable<D> {
    /** head node of the list */
    private Node<D> head;
    /** tail node of the list */
    private Node<D> tail;
    /** number of elements in the list */
    private int size;

    /**
     * Singly Linked list Node data type
     */
    private class Node<D> {
        D       data;
        Node<D> next;

        public Node(D data) {
            this.data = data;
            this.next = null;
        } 
    }     
    
    /**
     * Creates an empty List
     */
    public DoubleEndedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Returns a printable string representation of the double-ended list; Cost: &Theta;(n)
     * @return string representation of the double ended list
     */
    @Override
    public String toString() {
        String S;
        if(head == null) {
            S = "[]";
        } else {
            S = "[" + head.data.toString() +  "]";
            Node<D> tmp = head.next;
            while(tmp != null) {
                S = S + " -> [" + tmp.data.toString() +  "]";
                tmp = tmp.next;
            }
        }
        return S;
    }

    /**
     *  Returns true if the datastructure is empty; Cost: O(1)
     *  @return true if the list is empty
     */
    public boolean isempty() {
        return size == 0;
    }

    /**
     *  Returns the number of elements in the datastructure; Cost: O(1)
     *  @return number of elements in the list
     */
    public int size() {
        return size;
    }


/* *************************************************** *
                    LIST OPERATIONS
 * *************************************************** */
    
    /**
     *  Inserts <code>data</code> at the head of the list; Cost: O(1)
     *  @param data data to insert in the List
     */ 
    public void insert(D data) {
    }

    /**
     *  Inserts <code>data</code> at the tail of the list; Cost: O(1)
     *  @param data data to insert in the List
     */
    public void append(D data) {
    }

    /**
     *  Returns true if the list contains <code>data</code>; Cost: O(n)
     *  <p>
     *  Linear search on a liked list
     *  <ul>
     *  <li> Worst/Average-case cost: &Theta;(n)
     *  <li> Best-case cost: O(1) 
     *  </ul>
     *  @param data the data to search in the list
     *  @return true if the list contains parameter data
     */
    public boolean search(D data) {
        return false;
    }

    /** 
     *  Returns the data at position <code>i</code>; Cost: O(n)
     *  <p>
     *  Searching position <code>i</code> on a liked list requires traversing
     *  <code>i</code>-1 nodes.
     *  <ul>
     *  <li> Worst/Average-case cost: &Theta;(n)
     *  <li> Best-case cost: O(1)
     *  </ul>
     *  @param i index in the list
     *  @return the data at index i
     *  @throws IndexOutOfBoundsException if the index is out of range
     */
    public D get(int i) throws IndexOutOfBoundsException {
        return null;
    }


    /**
     *  Replaces the data at position <code>i</code> with <code>data</code>; Cost: O(n)
     *  <p>
     *  Searching position <code>i</code> on a liked list requires traversing
     *  <code>i</code>-1 nodes.
     *  <ul>
     *  <li> Worst/Average-case cost: &Theta;(n)
     *  <li> Best-case cost: O(1)
     *  </ul>
     *  @param i index in the list
     *  @param data data to be stored at the specified index
     *  @return the data previously at index i
     *  @throws IndexOutOfBoundsException if the index is out of range
     */
    public D set(int i, D data) throws IndexOutOfBoundsException {
        return null;
    }
 
    /**
     *  Removes the first occurrence of <code>data</code>; Cost: O(n)
     *  <p>
     *  Involves a linear search on the list. 
     *  <ul>
     *  <li> Worst/Average-case cost: &Theta;(n)
     *  <li> Best-case cost: O(1)
     *  </ul>
     *  @param data data to remove
     *  @return true if data is in the list and it has been removed
     */
    public boolean delete(D data) {
        return false;
    }


/* *************************************************** *
                    STACK OPERATIONS
 * *************************************************** */

    /**
     *  Pushes <code>data</code> on top of the stack; Cost: O(1)
     *  @param data the data to insert in the stack
     */
    public void push(D data) {
    }
    
    /**
     * Removes and returns the data on top of the stack; Cost: O(1)
     * @return data on top of the stack 
     * @throws NoSuchElementException if the stack is empty
     */
    public D pop() throws NoSuchElementException {
        return null;
    }

    /**
     *  Returns the data on top of the stack; Cost: O(1)
     *  @return data on top of the stack
     *  @throws NoSuchElementException if the stack is empty
     */
    public D top() throws NoSuchElementException {
        return null;
    }
    
/* *************************************************** *
                    QUEUE OPERATIONS
 * *************************************************** */

    /**
     *  Inserts <code>data</code> into the queue; Cost: O(1)
     *  @param data the data to insert
     */
    public void enqueue(D data) {
    }

    /** 
     * Removes and returns the first data in the queue; Cost: O(1)
     * @return the first data in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public D dequeue() throws NoSuchElementException {
        return null;
    }

    /**
     *  Returns the first data in the queue; Cost: O(1)
     *  @return the first data in the queue
     *  @throws NoSuchElementException if the queue is empty
     */
    public D first() throws NoSuchElementException {
        return null;
    }


/* *************************************************** *
                   ITERATOR 
 * *************************************************** */

    /**
     * Returns an iterator over the elements in the list; Cost: O(1)
     * <p>
     * Iterator operation costs:
     * <ul>
     * <li> <code>hasNext()</code>: O(1)
     * <li> <code>next()</code>: O(1)
     * <li> <code>remove()</code>: O(1) 
     * </ul>
     * @return iterator over the elements in the list
     */
    public Iterator<D> iterator() {
        return new DoubleEndedListIterator();
    }

    private class DoubleEndedListIterator implements Iterator<D> {
        /** Next node under iteration */
        private Node<D> next;
        /** Node preceding the next node: curr.next == next */
        private Node<D> curr;
        /** Node preceding the curr node: prev.next == curr */
        private Node<D> prev;
  
        public DoubleEndedListIterator() {
            next    = head;
            curr    = null;
            prev    = null;
        } 

        public boolean hasNext() {
            return next != null;
        } 
      
        public D next() throws NoSuchElementException { 
            if(next == null)
                throw new NoSuchElementException();
            D data = next.data;
            if(curr != null) // We update save only if curr has not been removed
                prev = curr;
            curr = next;
            next = next.next;
            return data;
        }
      
        public void remove() {
            // Goal: remove the node pointed by curr. We have that prev -> curr -> next
            if(curr == null) // next() has never been called or remove() has already been called for curr
                throw new IllegalStateException();
            if(curr == head) // curr points to the head of the list
                head = next;
            else             // curr points to some node in the middle of the list
                prev.next = next;
            if(curr == tail) // curr points to the tail node
                tail = prev;
            curr = null;     // If curr = null a second call to remove() will raise an exception
            size--;
        }   
    }
}       
