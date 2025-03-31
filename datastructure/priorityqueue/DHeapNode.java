package datastructure.priorityqueue;

/**
* Implementation of the node of a d-heap implementation of a generic Priority Queue data structure 
* containing pairs of <code>data</code> objects associated with a <code>key</code>
* @param <K> type of the key value
* @param <D> type of the data object
*/
public class DHeapNode<K,D> implements PriorityQueueNode<K,D> {
	/** key value */
	protected K key;
	/** data object */
	protected D data;
	/** node index */
	protected int index;

	/**
	* Constructs a node containing the pair (key,data) with index i
	* @param key key value
	* @param data data associated to the key value  
	* @param i the node index  
	*/		
	public DHeapNode(K key, D data, int i) {
		this.data = data; this.key = key; this.index = i;
	}

	/**
	* Returns the node key
	* @return the node key
	*/
	public K getKey() {
		return this.key;
	}

	/**
	* Returns the node data object
	* @return the node data object
	*/
	public D getData() {
		return this.data;
	}

}
