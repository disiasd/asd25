package datastructure.priorityqueue;

/**
* Interface for the node of a generic Priority Queue data structure 
* containing pairs of <code>data</code> objects associated with a <code>key</code>
* @param <K> type of the key value
* @param <D> type of the data object
*/
public interface PriorityQueueNode<K,D> {
	/**
	* Returns the node key
	* @return the node key
	*/
	public K getKey();

	/**
	* Returns the node data object
	* @return the node data object
	*/
	public D getData();

}
