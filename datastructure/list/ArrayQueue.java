package datastructure.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *  Dynamic Circular Array implementation of the Queue data structure
 *  @param <D> type of the data collected in the data structure
 */
public class ArrayQueue<D> implements Queue<D> {
    private Object[] queue;
    private int head;
    private int tail;
    private int size;

    /**
     * Creates an empty queue
     */
    public ArrayQueue() {
        queue = new Object[1];
        head  = 0;
        tail  = 0;
        size  = 0;
    }

    /**
     *  Inserts <code>data</code> into the queue; Amortized cost: O(1)
     *  <p>
     *  The enqueue operation may require resizing the underlying array.
     *  <ul>
     *  <li> Worst-case cost: &Theta;(n);
     *  <li> Amoritzed and best-case cost: O(1);
     *  </ul>
     *  @param data the data to insert
     */
    public void enqueue(D data) {
        if(size == queue.length)
            resize(2*queue.length);
        
        queue[tail] = data;
        tail = (tail + 1) % queue.length;
        size++; 
    }

    /** 
     * Removes and returns the first data in the queue; Amortized cost: O(1)
     * <p>
     * The dequeue operation may require resizing the underlying array.
     * <ul>
     * <li> Worst-case cost: &Theta;(n);
     * <li> Amoritzed and best-case cost: O(1);
     * </ul>
     * @return the first data in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public D dequeue() throws NoSuchElementException {
        D data      = first();
        queue[head] = null;
        head        = (head + 1) % queue.length;
        if(--size <= queue.length/4)
            resize(queue.length/2);
        return data; 
    }

    /**
     *  Returns the first data in the queue; Cost: O(1)
     *  @return the first data in the queue
     *  @throws NoSuchElementException if the queue is empty
     */
    public D first() throws NoSuchElementException {
        if(size == 0)
            throw new NoSuchElementException();
        @SuppressWarnings("unchecked")
        D data = (D)queue[head];
        return data;
    }

    /**
     *  Returns true if the queue is empty; Cost: O(1)
     *  @return true if the queue is empty
     */
    public boolean isempty() {
        return size == 0;
    }

    /**
     *  Returns the number of elements in the queue; Cost: O(1)
     *  @return number of elements in the queue
     */
    public int size() {
        return size;
    }

    /* Resize only if the new length is large enough to contain all data */
    private void resize(int length) {
        if(length > 0 && length >= size) {
            Object buf[] = new Object[length];
            int i = head, j = 0;

            while(j < size) {
                buf[j++] = queue[i];
                i = (i + 1) % queue.length;
            }

            head  = 0;
            tail  = size;
            queue = buf;
        }
    }

    /**
     * Returns a printable string representation of the queue; Cost: &Theta;(n)
     * @return string representation of the stack
     */
    @Override
    public String toString() {
        String S = "";
        for(int i = 0; i < queue.length; i++) {
            S = S + "[" + (queue[i] != null ? queue[i].toString() : "") + "]";
            if(i == head && i == tail)
                S = S + "\t<- head/tail";
            else if (i == head)
                S = S + "\t<- head";
            else if (i == tail)
                S = S + "\t<- tail";
            S = S + "\n";
        }
        return S;
    }

}
