package datastructure.list;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.lang.Iterable;

/**
 *  Dynamic Array implementation of the List data structure
 *  @param <D> type of the data collected in the data structure
 */
public class ArrayList<D> implements List<D>,Iterable<D> {
    private Object[] list;
    private int size;

    /**
     * Creates an empty list
     */
    public ArrayList() {
        list = new Object[1];
    }

    /**
     *  Inserts <code>data</code> at the head of the list; Cost: &Theta;(n)
     *  <p>
     *  Shifts the data currently at the head position and any subsequent data to the right. The
     *  insertion operation may require resizing the underlying array.
     *  <ul>
     *  <li> Worst/average/best-case cost: &Theta;(n)
     *  </ul>
     *  @param data data to insert in the List
     */
    public void insert(D data) {
        if(list.length == size)
            resize(2*list.length);
        rightshift(0);
        list[0] = data;
        size++;
    }
    
    /**
     *  Inserts <code>data</code> at the tail of the list; Amortized cost: O(1)
     *  <p>
     *  The insertion operation may require resizing the underlying array.
     *  <ul>
     *  <li> Worst-case cost: &Theta;(n)
     *  <li> Amortized/Best-case cost: O(1)
     *  </ul>
     *  @param data data to insert in the List
     */
    public void append(D data) {
        if(list.length == size)
            resize(2*list.length);
        list[size++] = data;
    }

    /**
     *  Returns true if the list contains <code>data</code>; Cost: O(n)
     *  <p>
     *  Linear search on an array
     *  <ul>
     *  <li> Worst/Average-case cost: &Theta;(n)
     *  <li> Best-case cost: O(1) 
     *  </ul>
     *  @param data the data to search in the list
     *  @return true if the list contains parameter data
     */
    public boolean search(D data) {
        for(int i = 0; i < size; i++)
            if(data.equals(list[i]))
                return true;
        return false;
    }

    /**
     *  Returns the data at position <code>i</code>; Cost: O(1)
     *  @param i index in the list
     *  @return the data at index i
     *  @throws IndexOutOfBoundsException if the index is out of range
     */
    public D get(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i >= size)
            throw new IndexOutOfBoundsException();
        @SuppressWarnings("unchecked")
        D data = (D)list[i];
        return data;
    }

    /**
     *  Replaces the data at position <code>i</code> with <code>data</code>; Cost: O(1)
     *  @param i index in the list
     *  @param data data to be stored at the specified index
     *  @return the data previously at index i
     *  @throws IndexOutOfBoundsException if the index is out of range
     */
    public D set(int i, D data) throws IndexOutOfBoundsException {
        if(i < 0 || i >= size)
            throw new IndexOutOfBoundsException();
        @SuppressWarnings("unchecked")
        D tmp = (D)list[i];
        list[i] = data;
        return tmp;
    }

    /**
     *  Removes the first occurrence of <code>data</code>; Cost: &Theta;(n)
     *  <p>
     *  Involves a linear search on the list. If <code>data</code> appears in the list,
     *  shifts any subsequent elements to the left.
     *  The deletion operation may require resizing the underlying array.
     *  <ul>
     *  <li> Worst/Average/Best-case cost: &Theta;(n)
     *  </ul>
     *  @param data data to remove
     *  @return true if data is in the list and it has been removed
     */
    public boolean delete(D data) {
        for(int i = 0; i < size; i++) 
            if(data.equals(list[i])) {
                leftshift(i);
                if(--size <= list.length/4)
                    resize(list.length/2);
                return true;
            }
        return false;
    }

    /**
     *  Returns true if the list is empty; Cost: O(1)
     *  @return true if the list is empty
     */
    public boolean isempty() {
        return size == 0;
    }

    /**
     *  Returns the number of elements in the list; Cost: O(1)
     *  @return number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in the list; Cost: O(1)
     * <p>
     * Iterator operation costs:
     * <ul>
     * <li> <code>hasNext()</code>: O(1)
     * <li> <code>next()</code>: O(1)
     * <li> <code>remove()</code>: O(n) 
     * </ul>
     * @return iterator over the elements in the list
     */
    public Iterator<D> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Returns a printable string representation of the dynamic-array list; Cost: &Theta;(n)
     * @return string representation of the dynamic-array list
     */
    @Override
    public String toString() {
        String S = "";
        if(size == 0) {
            S = "[]";
        } else {
            for(int i = 0; i < list.length; i++)
                S = S + "[" + (list[i] != null ? list[i].toString() : " ") + "]";
        }
        return S;
    }

    /* Resize only if the new length is large enough to contain all data */
    private void resize(int length) {
        if(length > 0 && length >= size)
            list = Arrays.copyOf(list,length);
    }

    private void rightshift(int i) {
        for(int j = size; j > i; j--)
            list[j] = list[j-1];
        list[i] = null;
    }

    private void leftshift(int i) {
        for(int j = i; j < size-1; j++)
            list[j] = list[j+1];
        list[size-1] = null;
    }

    private class ArrayListIterator implements Iterator<D> {
        private int     curr;
        private boolean removed; // Used to keep track of remove() execution

        public ArrayListIterator() {
            curr = 0;
        }

        public boolean hasNext() {
            return curr != size;
        }

        public D next() throws NoSuchElementException {
            if(curr == size)
                throw new NoSuchElementException();
            @SuppressWarnings("unchecked")
            D data  = (D)list[curr++];
            removed = false;
            return data;
        }

        public void remove() {
            // Goal: remove the data in the cell curr-1
            if(curr - 1 < 0 || curr - 1 >= size || removed)
                throw new IllegalStateException();
            leftshift(curr-1);
            curr--; // The current node is now in posizione curr-1
            size--;
            removed = true;
        }  
    }
}
