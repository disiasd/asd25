package datastructure.list;

import java.util.NoSuchElementException;

/**
 * Interface for a generic Stack data structure
 * @param <D> type of the data collected in the stack
 */
public interface Stack<D> {

	/**
	 *  Pushes <code>data</code> on top of the stack
	 *  @param data the data to insert in the stack
	 */
	public void push(D data);

	/**
	 * Removes and returns the data on top of the stack
	 * @return data on top of the stack 
	 * @throws NoSuchElementException if the stack is empty
	 */
	public D pop() throws NoSuchElementException;

	/**
	 *  Returns the data on top of the stack
	 *  @return data on top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	public D top() throws NoSuchElementException;

	/**
	 *  Returns true if the stack is empty
	 *  @return true if the stack is empty
	 */
	public boolean isempty();

	/**
	 *  Returns the number of elements in the stack
	 *  @return number of elements in the stack
	 */
	public int size();
}
