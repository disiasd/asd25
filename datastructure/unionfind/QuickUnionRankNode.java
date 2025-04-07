package datastructure.unionfind;

/**
 * Implementation of the node of a generic Union Find data structure containing 
 * <code>data</code> objects based on the Quick Union implementation with heuristic 
 * on the rank.
 * The node simply adds to the standard QuickUnionNode a field used to store inside the 
 * the representative of a set, the rank of the corresponding tree.
 * @param <D> type of the data object 
 */	
public class QuickUnionRankNode<D> extends QuickUnionNode<D> {
		
	/** the rank of the set, if the node is a representative */
	protected int rank;
	
	/**
	 * Constructs a node object and initializes its rank field
	 * @param data data to insert in the node
	 */		
	public QuickUnionRankNode (D data) {
		super(data);
		this.rank = 0;
	}
	
}

