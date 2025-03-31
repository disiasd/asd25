package datastructure.priorityqueue;

import java.util.ArrayList;

/**
* Implementation using d-heap of a generic Priority Queue data structure composed of nodes of 
* type DHeapNode containing pairs of <code>data</code> objects associated with a <code>key</code>
* @param <K> type of the key value
* @param <D> type of the data object 
*/	
public class DHeap<K extends Comparable<K>,D> implements PriorityQueue<K,D>{
	
	/** ArrayList containing the priority queue nodes */ 
	private ArrayList<DHeapNode<K,D>> nodes;

	/** Number of elements in the priority queue */
	private int n;

	/** Degree of the d-heap */	
	private int d;

	/**
	* Creates an empty d-heap (default value of the degree = 4)
	*/
	public DHeap(){
		this(4);
	}

	/**
	* Creates an empty d-heap; Cost: O(1)
	* @param d the degree of the d-heap
	*/
	public DHeap(int d){
		this.nodes = new ArrayList<DHeapNode<K,D>>();
		this.n = 0;
		this.d = d;
	}

	/**
	* Returns the datum with minimal key; Cost: O(1)
	* @return the <code>data</code> object with minimal <code>key</code>, or <code>null</code> if the queue is empty
	*/
	public D findMin() {


		return null;
	}

	/**
	* Inserts a new <code>key</code> / <code>data</code> pair and returns the new created node; 
	* Cost: O(log<sub>d</sub> n)
	* <ul>
	* <li> Worst-case: &Theta;(log<sub>d</sub> n)
	* <li> Best-case: O(1) 
	* </ul>
	* @param key key value
	* @param data data associated to the key value
	* @return the inserted node
	*/
	public PriorityQueueNode<K,D> insert(K key, D data) {


		return null;
	}

	/**
	* Deletes a given node; Cost: O(d log<sub>d</sub> n)
	* <ul>
	* <li> Worst-case: &Theta;(d log<sub>d</sub> n)
	* <li> Best-case: O(1) 
	* </ul> 
	* @param node the node to remove
	*/
	public void delete(PriorityQueueNode<K,D> node) {


	}

	/**
	* Deletes the node containing the datum with minimal key; Cost: O(d log<sub>d</sub> n)
	* <ul>
	* <li> Worst-case: &Theta;(d log<sub>d</sub> n)
	* <li> Best-case: O(1) 
	* </ul> 
	*/
	public void deleteMin() {


	}
	
	/**
	* Increases the key of a given node; Cost: O(d log<sub>d</sub> n)
	* <ul>
	* <li> Worst-case: &Theta;(d log<sub>d</sub> n)
	* <li> Best-cost: O(1) 
	* </ul> 
	*  @param newKey the new value for the key
	*  @param node the node where the key should be increased
	*/	
	public void increaseKey(K newKey, PriorityQueueNode<K,D> node) {


	}

	/**
	* Decreases the key of a given node; Cost: O(log<sub>d</sub> n)
	* <ul>
	* <li> Worst-case: &Theta;(log<sub>d</sub> n)
	* <li> Best-case: O(1) 
	* </ul> 
	* @param newKey the new value for the key
	* @param node the node where the key should be reduced
	*/
	public void decreaseKey(K newKey, PriorityQueueNode<K,D> node) {


	}

	/**
	*  Checks if the priority queue is empty; Cost: O(1)
	*  @return <code>true</code> if the priority queue is empty
	*/
	public boolean isEmpty() {


		return false;
	}
			
	/**
	* Adjust the d-heap moving up an ill-placed node
	*/
	private void moveUp(DHeapNode<K,D> v) {
		DHeapNode<K,D> f = father(v);
		while (v.index > 0 && (v.key).compareTo(f.key) < 0) {
			swap(v, f);
			f = father(v);
		}
	}

	/**
	* Adjust the d-heap moving down an ill-placed node
	*/
	private void moveDown(DHeapNode<K,D> v) {
		DHeapNode<K,D> min = minSon(v);
		while(min != null && (v.key).compareTo(min.key) > 0) {
			swap(v, min);
			min = minSon(v);			
		}
	}

	/**
	* Swaps the positions of two nodes in the ArrayList
	*/
	private void swap(DHeapNode<K,D> n1, DHeapNode<K,D> n2) {
		nodes.set(n1.index,n2);
		nodes.set(n2.index,n1);
		int temp = n1.index;
		n1.index = n2.index;
		n2.index = temp;
	}

	/**
	* Returns the father node of a given node, or null if the father does not exist
	*/	
	private DHeapNode<K,D> father(DHeapNode<K,D> v) {
		if (v.index == 0) return null;
		return nodes.get( (v.index-1)/d );
	}

	/**
	* Returns the node of the son with minimal key, or null if there are not son nodes
	*/	
	private DHeapNode<K,D> minSon(DHeapNode<K,D> v) {
		int f = (d * (v.index)) + 1;
		if (f >= n) return null;
		DHeapNode<K,D> min = nodes.get(f);
		for (int i=f+1; (i < f+d) && (i < n); i++) {
			if ( ((nodes.get(i)).key).compareTo(min.key) < 0 )
				min = nodes.get(i);
		}
		return min;
	}
	
	/**
	* Returns a printable string representation of the Priority Queue. For each node
	* in the queue reports the key and the data object; Cost &Theta;(n log<sub>d</sub> n)
	* @return string representation of the Priority Queue
	*/	
	@Override
	public String toString() {	
		if (n==0) return "";
		StringBuilder S = new StringBuilder(n*6);
		S.append(nodes.get(0).getKey() + " - " + nodes.get(0).getData() + "\n");
		for (int i=1; i <= d; i++) toStringRec(i,S,"");
		return S.toString();		
	}	
	
	private void toStringRec(int index, StringBuilder S, String line) {
		if (index >= n) return;
		S.append(line);
		String newline;
		if (index<n-1 && index%d!=0) {
			//has a brother
			S.append("├─");
			newline = line+"│ ";			
		} else {
			//has no brother
			S.append("└─");
			newline = line+"  ";			
		}
		S.append(" " + nodes.get(index).getKey() + " - " + nodes.get(index).getData() + "\n");
		for (int i=(d*index+1); i < (d*index+1)+d; i++) toStringRec(i,S,newline);
	}	

}
