package datastructure.unionfind;

/**
 * Interface for the node of a generic Union Find data structure 
 * containing <code>data</code> objects
 * @param <D> type of the data object
 */
public interface UnionFindNode<D> {
	
	/**
	 * Returns the node data
	 * @return the node data
	 */
	public D getData();
	
	/**
	 * Checks if a node is the representative of the set it belongs to
	 * @return true if the node is the representative of the set it belongs to
	 */
	public boolean isRepresentative();

		
}
