package datastructure.unionfind;

/**
 * Implementation of the node of a generic Union Find data structure containing 
 * <code>data</code> objects based on the Quick Find implementation with heuristic 
 * on the size.
 * The node simply adds to the standard QuickFindNode a field used to store inside the 
 * head of a list, i.e. the representative of the corresponding set, the size of the list.
 * @param <D> type of the data object 
 */	
public class QuickFindSizeNode<D> extends QuickFindNode<D> {
		
	/** the size of the set, if the node is a representative */
	protected int size;
	
	/**
	 * Constructs a node object and initializes its size field
	 * @param data data to insert in the node
     */		
	public QuickFindSizeNode (D data) {
		super(data);
		this.size = 1;
	}
	
}

