package datastructure.priorityqueue;

/**
* Interface for a generic Priority Queue data structure composed of nodes of type PriorityQueueNode
* containing pairs of <code>data</code> objects associated with a <code>key</code>
* @param <K> type of the key value
* @param <D> type of the data object
*/
public interface PriorityQueue<K,D> {

	/**
	*  Returns the datum with minimal key
	*  @return the <code>data</code> object with minimal <code>key</code>, or <code>null</code> if the queue is empty
	*/
	public D findMin();
	
	/**
	*  Inserts a new <code>key</code> / <code>data</code> pair and returns the new created node
	*  @param key key value
	*  @param data data associated to the key value
	*  @return the inserted node
	*/
	public PriorityQueueNode<K,D> insert(K key, D data);
	
	/**
	*  Deletes a given node 
	*  @param node the node to remove
	*/
	public void delete(PriorityQueueNode<K,D> node);

	/**
	*  Deletes the node containing the datum with minimal key
	*/
	public void deleteMin();

	/**
	*  Increases the key of a given node
	*  @param newKey the new value for the key
	*  @param node the node where the key should be increased
	*/	
	public void increaseKey(K newKey, PriorityQueueNode<K,D> node);
	
	/**
	*  Decreases the key of a given node
	*  @param newKey the new value for the key
	*  @param node the node where the key should be reduced
	*/
	public void decreaseKey(K newKey, PriorityQueueNode<K,D> node);
		
	/**
	*  Checks if the priority queue is empty
	*  @return <code>true</code> if the priority queue is empty
	*/
	public boolean isEmpty();

}
