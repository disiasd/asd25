package datastructure.list;

import java.util.NoSuchElementException;

/**
 * Interface for a generic Queue data structure
 * @param <D> type of the data collected in the Queue
 */
public interface Queue<D> {

    /**
     *  Inserts <code>data</code> into the queue
     *  @param data the data to insert
     */
    public void enqueue(D data);

    /** 
     * Removes and returns the first data in the queue
     * @return the first data in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public D dequeue() throws NoSuchElementException;

    /**
     *  Returns the first data in the queue
     *  @return the first data in the queue
     *  @throws NoSuchElementException if the queue is empty
     */
    public D first() throws NoSuchElementException;

    /**
     *  Returns true if the queue is empty
     *  @return true if the queue is empty
     */
    public boolean isempty();

    /**
     *  Returns the number of elements in the queue
     *  @return number of elements in the queue
     */
    public int size();
}
