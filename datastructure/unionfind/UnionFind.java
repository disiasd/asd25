package datastructure.unionfind;

/**
 * Interface for a generic Union Find data structure composed of nodes of type UnionFindNode
 * containing <code>data</code> objects 
 * @param <D> type of the data object
 */
public interface UnionFind<D> {

	/**
	 * Inserts a node with a given data object that initially populates a singleton
   	 * @param data data to insert
	 * @return the inserted node
	 */
	public UnionFindNode<D> makeSet(D data);
	
	/**
	 * Performs the union of two sets represented by two nodes.
	 * If the nodes are not representatives, or they are identical
	 * nothing is done.
   	 * @param node1 the representative of the first set 
     * @param node2 the representative of the second set 
	 */	
	public void union(UnionFindNode<D> node1, UnionFindNode<D> node2);

	/**
	 * Returns the representative of the set to which a node belongs to
   	 * @param node the node to consider 
     * @return the representative of the set to which the node belongs to
	 */		
	public UnionFindNode<D> find(UnionFindNode<D> node);
	
}
