package datastructure.unionfind;

import java.util.ArrayList;

/**
 * Implementation of a generic Union Find data structure composed of nodes of type 
 * QuickUnionNode containing <code>data</code> objects, based on Quick Union.
 * Each node point to a parent node; a representative point to itself.
 * Find follow a sequence of linked parents until a representative.
 * Union simply updates the parent pointer of the second representative,
 * by pointing it to the first representative. 
 * The maximal length for one of the sequences of linked parents to follow is n-1,
 * where where n is the number of nodes in the data structure
 * @param <D> type of the data object 
 */	
public class QuickUnion<D> implements UnionFind<D> {
	
	/** ArrayList containing the union find nodes */ 
	protected ArrayList<UnionFindNode<D>> nodes;
	
	/**
	 * Creates an union find structure following the Quick Union implementation
	 */				
	public QuickUnion() { 
		nodes = new ArrayList<UnionFindNode<D>>();
	}	
	
	/**
	 * Inserts a node with a given data object (the parent pointer of the created 
	 * node points to itself)
   	 * @param data data to insert
	 * @return the inserted node
	 */
	public UnionFindNode<D> makeSet(D data) {


		return null;
	}
	
	/**
	 * Performs the union of two sets represented by two nodes, by pointing the
	 * parent pointer of the second representative to the first representative
	 * (if the nodes are not representatives, or they are identical
	 * nothing is done); Cost: O(1) 
   	 * @param node1 the representative of the first set 
     * @param node2 the representative of the second set 
	 */	
	public void union(UnionFindNode<D> node1, UnionFindNode<D> node2) {


	}
	
	/**
	 * Returns the representative of the set to which the node belongs to, by 
	 * following the sequence of linked parents; Cost: O(n), where n is the number 
	 * of nodes in the structure
	 * <ul>
	 * <li> Worst-case: &Theta;(n)
	 * <li> Best-case: O(1) 
	 * </ul>
   	 * @param node the node to consider 
     * @return the representative of the set to which the node belongs to
	 */
	public UnionFindNode<D> find(UnionFindNode<D> node) {


		return null;
	}
	
	/**
	 * Returns a printable string representation of Union Find structure. 
	 * For each node prints its contents and the corresponding representative. 
	 * Cost O(n<sup>2</sup>), where n is the number of nodes in the structure
	 * <ul>
	 * <li> Worst-case: &Theta;(n<sup>2</sup>)
	 * <li> Best-case: O(n) 
	 * </ul>
	 * @return string representation of the Union Find structure
	 */
	@Override
	public String toString() {
		StringBuilder S = new StringBuilder(nodes.size()*10);
		for (int i=0; i<nodes.size(); i++) {
			UnionFindNode<D> n = nodes.get(i);
			S = S.append(n.getData().toString()).append(" - ").append(find(n).getData().toString()).append("\n");
		}
		return S.toString();
	}
	
}
