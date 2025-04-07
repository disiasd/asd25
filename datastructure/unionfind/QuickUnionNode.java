package datastructure.unionfind;

/**
 * Implementation of the node of a generic Union Find data structure containing 
 * <code>data</code> objects based on the Quick Union implementation.
 * Besides the data object, the nodes contain the pointer to parent node.
 * Representative points to themselves while other nodes find their representative
 * by following the sequence of linked parents.
 * @param <D> type of the data object 
 */	
public class QuickUnionNode<D> implements UnionFindNode<D> {
		
	/** the data element */
	protected D elem;	
	
	/** the link to the parent node */
	protected QuickUnionNode<D> parent;
	
	/**
	 * Constructs a node object initializing the parent pointer to the node itself 
	 * @param data data to insert in the node
	 */	
	public QuickUnionNode (D data) {
		this.elem = data; this.parent = this;
	}
	
	/**
	 * Returns the node data
	 * @return the node data
	 */
	public D getData() {
		return this.elem;
	}
	
	/**
	 * Checks if a node is the representative of the set it belongs to by
	 * verifying whether its parent pointer points to itself
	 * @return true if the node is the representative of the set it belongs to
	 */
	public boolean isRepresentative() {
		return (this.parent == this);
	}
		
}