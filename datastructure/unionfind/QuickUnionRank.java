package datastructure.unionfind;

/**
 * Implementation of a generic Union Find data structure composed of nodes of type 
 * QuickUnionRankNode containing <code>data</code> objects, based on Quick Union
 * with heuristic on the rank: the implementation of union avoids to improve the rank
 * when it is possible. In this way, the maximal length of a sequence of linked parents
 * is logarithmic in the number of elements in the data structure. In this way, even if
 * the implementation of the find operation is left unchanged with respect to the
 * usual Quick Union implementation, its complexity becomes O(log n), where n is the number 
 * of nodes in the data structure
 * @param <D> type of the data object 
 */	
public class QuickUnionRank<D> extends QuickUnion<D> {
			
	/**
	 * Creates an union find structure following the Quick Union implementation
	 * with heuristic on the rank
	 */		
	public QuickUnionRank() { }	
	
	/**
	 * Inserts a node with a given data object by creating a node which points to itslef 
	 * as parent, and initializing the rank to 1
   	 * @param data data to insert
	 * @return the inserted node
	 */
	@Override
	public UnionFindNode<D> makeSet(D data) {
		QuickUnionRankNode<D> n = new QuickUnionRankNode<D>(data);
		nodes.add(n);
		return n;
	}
	
	/**
	 * Performs the union of two sets represented by two nodes by using the heuristic
	 * on the rank: it checks the ranks of the representatives and avoids to increase
	 * the rank of the new set if possible
	 * (if the nodes are not representatives, or they are identical
	 * nothing is done); Cost: O(1) 
   	 * @param node1 the representative of the first set 
     * @param node2 the representative of the second set 
	 */		
	@Override
	public void union(UnionFindNode<D> node1, UnionFindNode<D> node2) {


	}

}
