package datastructure.tree;

/**
 * AVL Tree implementation
 * @param <K> type of the key value
 * @param <D> type of the data object 
 */
public class AVLTree<K extends Comparable<K>,D> extends BinarySearchTree<K,D> implements Tree<K,D> {
	
	/**
	 * Creates an empty AVL Tree
	 */
	public AVLTree() {
		super();
	}
	
	/**
	 * Returns the data stored in the first node in the AVL Tree matching <code>key</code>; Cost: O(logn)
	 * <p>
	 * Search on a binary tree with a logarithmic height relative to the number of nodes.
	 * <ul>
	 * <li> Worst/Average-case cost: &Theta;(logn)
	 * <li> Best-case cost: O(1) 
	 * </ul>
	 * @param key key value to search
	 * @return the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the tree
	 */
	@Override
	public D search(K key) {
		return super.search(key);
	}

	/**
     * Inserts a node storing the mapping (<code>key</code>,<code>data</code>) into the AVL tree; Cost: &Theta;(logn)
	 * <p>
	 * <code>Null</code> key values are not allowed, while <code>null</code> data values are allowed.
	 * Rebalances the AVL Tree, if necessary, to maintain a logarithmic height.
     * @param key key value
     * @param data data associated to the key value
	 * @throws IllegalStateException if the <code>key</code> paramenter is <code>null</code>
     */
	@Override
	public void insert(K key, D data) throws IllegalStateException {
	}

	/**
	 * Deletes the first node matching <code>key</code>; Cost: &Theta;(logn)
	 * <p>
	 * Rebalances the AVL Tree, if necessary, to maintain a logarithmic height.
	 * @param key key value to search
	 * @return the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the tree
	 */
	@Override
	public D delete(K key) {
		return null;
	}

	/** 
	 * Class representing a node in an AVL Tree
	 */
	protected class AVLNode extends BTNode {
		/** height of the tree rooted at this node */
		protected int height;

		/**
		 * Constructs an AVL Tree node containing the pair (key,data)
		 * @param key key value
		 * @param data data associated to the key value
		 */
		public AVLNode(K key, D data) {
			super(key,data);
			height = 0;
		}

		private int leftHeight() {
			return left  != null ? ((AVLNode)left).height  : -1;
		}
		
		private int rightHeight() {
			return right != null ? ((AVLNode)right).height : -1;
		}

		/**
		 * Returns the balance factor of this node; Cost: O(1)
		 * @return balance factor of this node
		 */
		public int balanceFactor() {
			return leftHeight() - rightHeight();
		}

		/**
		 * Updates the height of this node; Cost: O(1)
		 */
		public void updateHeight() {
			int lh = leftHeight();
			int rh = rightHeight();
			height = Integer.valueOf(Math.max(lh,rh) + 1);
		}

		/**
		 * Performs a right rotation using this node as pivot; Cost: O(1)
		 * <p>
		 * Authomatically updates the heights of the nodes involved in the rotation
		 * @throws IllegalStateException if this node has not a left child 
		 */
		public void rightRotate() throws IllegalStateException {
			if(this.left == null)
				throw new IllegalStateException();
			AVLNode v = (AVLNode)this.left;
			this.left = v.right;
			v.right   = this;
			if(this.left != null)
				this.left.parent = this;
			v.parent = this.parent;
			if(this.parent == null)
				root = v;
			else if(this.isLeftChild())
				v.parent.left = v;
			else
				v.parent.right = v;
			this.parent = v;
			this.updateHeight();
			   v.updateHeight();
    }

		/**
		 * Performs a left rotation using this node as pivot; Cost: O(1)
		 * <p>
		 * Authomatically updates the heights of the nodes involved in the rotation
		 * @throws IllegalStateException if this node has not a right child 
		 */
		public void leftRotate() throws IllegalStateException {
			if(this.right == null)
				throw new IllegalStateException();
			AVLNode v  = (AVLNode)this.right;
			this.right = v.left;
			v.left     = this;
			if(this.right != null)
                this.right.parent = this;
			v.parent = this.parent;
			if(this.parent == null)
				root = v;
			else if(this.isLeftChild())
				v.parent.left = v;
			else
				v.parent.right = v;
			this.parent = v;
			this.updateHeight();
			   v.updateHeight();
    }

		/**
		 * If the balance factor of this node is 2 or -2, performs rotation to rebalance the AVL Tree; Cost: O(1)
		 */
		public void balance() {
    	int b = balanceFactor();
			if(b == 2) {
				AVLNode left = (AVLNode)this.left;
      	        if(left != null && left.balanceFactor() == -1)
					left.leftRotate();
				rightRotate();
			} else if(b == -2) {
				AVLNode right = (AVLNode)this.right;
				if(right != null && right.balanceFactor() == 1)
					right.rightRotate();
				leftRotate();
			}
		}

        /**
         * Returns a string summarizing the information stored into this node; Cost: O(1) 
         * <p>
         * The string has the format <code>X</code>[<code>key</code>,<code>data</code>,<code>height</code>,<code>balancefactor</code>], where
         * <ul>
         * <li> if the node is a left chid then <code>X = 'L'</code>
         * <li> if the node is a right child then <code>X = 'R'</code>
         * <li> if the node is the root node then <code>X = 'ROOT'</code>
         * </ul>
         * Null data is not shown
         */
		@Override
		public String toString() {
			String  tag  = (isLeftChild() ? "L" : isRightChild() ? "R" : "ROOT");
             if(this.data == null)
                return tag + "[" + key.toString() + "," + height + "," + balanceFactor() + "]";
            else
                return tag + "[" + key.toString() + "," + data.toString() +  "," + height + "," + balanceFactor() + "]";
		}

  }

}
