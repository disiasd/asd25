package datastructure.unionfind;

/**
 * Implementation of the node of a generic Union Find data structure containing 
 * <code>data</code> objects based on the Quick Find implementation.
 * Besides the data object, the nodes contain the pointer to the next node in the
 * list representing the set to which the node belongs to, and a pointer to the
 * root of the list. The root has the pointers to the head and tail nodes of the list.
 * @param <D> type of the data object 
 */	
public class QuickFindNode<D> implements UnionFindNode<D> {
	
	/** the data element */
	protected D elem;	

	/** the root of the root at its creation time */
	protected Root<D> root;
	
	/** the link to the next node in the list */
	protected QuickFindNode<D> next;
			
	/**
   	 * Constructs a node object and its initial root
   	 * @param data data to insert in the node
	 */	
	public QuickFindNode (D data) {
		this.elem = data; 
		this.root = new Root<D>(this,this); 
		this.next = null; 
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
	 * verifying whether such node is the head of its list
	 * @return true if the node is the representative of the set it belongs to
	 */
	public boolean isRepresentative() {
		return (this.root.head == this);
	}
	
	/**
	 * The root poointing to a list of nodes containing <code>data</code> objects 
	 * belonging to the same set
     * @param <D> type of the data object 	
	 */	
	protected class Root<D> {
		
		/** the head of the list associated to the root */
		protected QuickFindNode<D> head;	
		
		/** the tail of the list associated to the root */
		protected QuickFindNode<D> tail;
		
		/** Constructs a root pointing to a given head and a given tail node 
      	 * @param head the head of the list pointed by the root
      	 * @param tail the tail of the list pointed by the root			
		 */
		public Root (QuickFindNode<D> head, QuickFindNode<D> tail) {
			this.head = head; this.tail = tail;
		}	
		
	}	
	
}	
