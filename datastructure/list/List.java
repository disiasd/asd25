package datastructure.list;

import java.lang.IndexOutOfBoundsException;
import java.lang.Iterable;
import java.util.Iterator;

/**
 * Interface for a generic List data structure
 * @param <D> type of the data collected in the List
 */ 
public interface List<D> extends Iterable<D> {

    /**
     *  Inserts <code>data</code> at the head of the list
     *  @param data data to insert in the List
     */ 
    public void insert(D data);

    /**
     *  Inserts <code>data</code> at the tail of the list
     *  @param data data to insert in the List
     */
    public void append(D data);

    /**
     *  Returns true if the list contains <code>data</code>
     *  @param data the data to search in the list
     *  @return true if the list contains parameter data
     */
    public boolean search(D data);

    /**
     *  Returns the data at position <code>i</code>
     *  @param i index in the list
     *  @return the data at index i
     *  @throws IndexOutOfBoundsException if the index is out of range
     */
    public D get(int i) throws IndexOutOfBoundsException;

    /**
     *  Replaces the data at position <code>i</code> with <code>data</code>
     *  @param i index in the list
     *  @param data data to be stored at the specified index
     *  @return the data previously at index i
     *  @throws IndexOutOfBoundsException if the index is out of range
     */
    public D set(int i, D data) throws IndexOutOfBoundsException;

    /**
     *  Removes the first occurrence of <code>data</code>
     *  @param data data to remove
     *  @return true if data is in the list and it has been removed
     */
    public boolean delete(D data);

    /**
     *  Returns true if the list is empty
     *  @return true if the list is empty
     */
    public boolean isempty();

    /**
     *  Returns the number of elements in the list
     *  @return number of elements in the list
     */
    public int size();

    /**
     * Returns an iterator over the elements in the list
     * @return iterator over the elements in the list
     */
    public Iterator<D> iterator();
}
