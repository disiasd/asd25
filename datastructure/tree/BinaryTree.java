package datastructure.tree;

import java.lang.IllegalStateException;
import datastructure.list.List;
import datastructure.list.Queue;
import datastructure.list.ArrayList;
import datastructure.list.ArrayQueue;
import datastructure.list.DoubleEndedList;

/**
 * This abstract class provides a skeletal implementation of the BinaryTree data structure in which
 * only the {@link BTNode BTNode.class} class and the traversal methods are implemented
 * @param <K> type of the key value
 * @param <D> type of the data object
 */
public abstract class BinaryTree<K,D> implements Tree<K,D>{
    /** root node of the Binary Tree */
    protected BTNode root;

    /**
     * Sole empty constructor
     */
    protected BinaryTree() {
    }
    
    public abstract void    insert(K key, D data);  

    public abstract D       search(K key);
    
    public abstract D       delete(K key);

    public abstract int     size();

    public abstract boolean isEmpty();

    
    private void getPreorderDataRec(BTNode T, List<D> L) {
        if(T != null) {
            L.append(T.data);
            getPreorderDataRec(T.left,L);
            getPreorderDataRec(T.right,L);
        }
    }

    /**
     *  Returns a list of data in preorder traversal; Cost: &Theta;(n)
     *  @return a list containing the data
     */
    public List<D> getPreorderData() {
        List<D> L = new ArrayList<>();
        getPreorderDataRec(root,L);
        return L;
    }

    private void getPreorderKeysRec(BTNode T, List<K> L) {
        if(T != null) {
            L.append(T.key);
            getPreorderKeysRec(T.left,L);
            getPreorderKeysRec(T.right,L);
        }
    }

    /**
     *  Returns a list of key values in preorder traversal; Cost: &Theta;(n)
     *  @return a list containing the data
     */
    public List<K> getPreorderKeys() {
        List<K> L = new ArrayList<>();
        getPreorderKeysRec(root,L);
        return L;
    }


    private void getPostorderDataRec(BTNode T, List<D> L) {
        if(T != null) {
            getPostorderDataRec(T.left,L);
            getPostorderDataRec(T.right,L);
            L.append(T.data);
        }
    }

    /**
     *  Returns a list of data in postorder traversal; Cost: &Theta;(n)
     *  @return a list containing the data
     */
    public List<D> getPostorderData() {
        List<D> L = new ArrayList<>();
        getPostorderDataRec(root,L);
        return L;
    }

    private void getPostorderKeysRec(BTNode T, List<K> L) {
        if(T != null) {
            getPostorderKeysRec(T.left,L);
            getPostorderKeysRec(T.right,L);
            L.append(T.key);
        }
    }

    /**
     *  Returns a list of data in postorder traversal; Cost: &Theta;(n)
     *  @return a list containing the data
     */
    public List<K> getPostorderKeys() {
        List<K> L = new ArrayList<>();
        getPostorderKeysRec(root,L);
        return L;
    }

    private void getInorderDataRec(BTNode T, List<D> L) {
        if(T != null) {
            getInorderDataRec(T.left,L);
            L.append(T.data);
            getInorderDataRec(T.right,L);
        }
    }

    /**
     *  Returns a list of data in inorder traversal; Cost: &Theta;(n)
     *  @return a list containing the data
     */
    public List<D> getInorderData() {
        List<D> L = new ArrayList<>();
        getInorderDataRec(root,L);
        return L;
    }

    private void getInorderKeysRec(BTNode T, List<K> L) {
        if(T != null) {
            getInorderKeysRec(T.left,L);
            L.append(T.key);
            getInorderKeysRec(T.right,L);
        }
    }

    /**
     *  Returns a list of key values in inorder traversal; Cost: &Theta;(n)
     *  @return a list containing the key values 
     */
    public List<K> getInorderKeys() {
        List<K> L = new ArrayList<>();
        getInorderKeysRec(root,L);
        return L;
    }


    /**
     *  Returns the list of data in bfs traversal; Cost: &Theta;(n)
     *  @return a list containing the data
     */
    public List<D> getBFSData() {
        List<D>     L = new ArrayList<>();
        Queue<BTNode> Q = new ArrayQueue<>();
  
        if(root != null)
            Q.enqueue(root); 

        while(!Q.isempty()) {
            BTNode x = Q.dequeue();
            L.append(x.data);
            if(x.left != null)
                Q.enqueue(x.left);
            if(x.right != null)
                Q.enqueue(x.right);
        }
      
        return L;
    }

    /**
     *  Returns the list of data in bfs traversal; Cost: &Theta;(n)
     *  @return a list containing the data
     */
    public List<K> getBFSKeys() {
        List<K>     L = new ArrayList<>();
        Queue<BTNode> Q = new ArrayQueue<>();
 
        if(root != null) 
            Q.enqueue(root);

        while(!Q.isempty()) {
            BTNode x = Q.dequeue();
            L.append(x.key);
            if(x.left != null) 
                Q.enqueue(x.left);
            if(x.right != null) 
                Q.enqueue(x.right);
        }

        return L;
  }

    /**
     * Returns a printable string representation of the Binary Tree; Cost: O(n<sup>2</sup>)
     * @return string representation of the Binary Tree
     */
    @Override
    public String toString() {
        String S = "[]";
        if(root != null) 
            S = root.toString() + "\n" + toStringRec(root.left,"") + toStringRec(root.right,"");
        return S;
    }

    private String getLine(BTNode T, String line) {
        if(T.isLeftChild() && T.hasBrother())
            return line + "├──── " + T.toString() + "\n";   
        else
            return line + "└──── " + T.toString() + "\n";
    }

    private String toStringRec(BTNode T,String line) {
        if(T == null) {
            return "";
        } else {
            String newline;
            if(T.isLeftChild() && T.hasBrother())
                newline = line + "│     ";
            else
                newline = line + "      ";
            return getLine(T,line) + toStringRec(T.left,newline) + toStringRec(T.right,newline);
        }   
    }

    /**
     * Class representing a node in a Binary Tree
     */
    public class BTNode {
        /** Key value */
        public K key;
        /** Data object */
        public D data;
        /** Left child of this node */
        public BTNode left;
        /** Right child of this node */
        public BTNode right;
        /** Parent of this node, if <code>null</code> this node is the root node */
        public BTNode parent;

        /**
         * Constructs a Binary Tree node storing the mapping (<code>key</code>,<code>data</code>)
         * @param key key value
         * @param data data mapped to the key value  
         */
        public BTNode(K key, D data) {
            this.key    = key;
            this.data   = data;
            this.left   = null;
            this.right  = null;
            this.parent = null;
        }

        /**
         * Returns true if this node is the root node; Cost: O(1)
         * @return true if this node is the root node
         */
        public boolean isRoot() {
            return parent == null;
        }

        /**
         * Returns true if this node is a leaf node; Cost: O(1)
         * @return true if this node is a leaf node
         */
        public boolean isLeaf() {
            return left == null && right == null;
        }

        /**
         * Returns true if this node is a left child; Cost: O(1)
         * @return true if this node is a left child 
         */
        public boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        /**
         * Returns true if this node is a right child; Cost: O(1)
         * @return true if this node is a right child
         */
        public boolean isRightChild() {
            return parent != null && parent.right == this;
        }

        /**
         * Returns true if this node has two children; Cost: O(1)
         * @return true if this node has two children
         */
        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        /**
         * Returns true if this node has exactly one child; Cost: O(1)
         * @return true if this node has exactly one child
         */
        public boolean hasOneChild() {
            return !hasTwoChildren() && !isLeaf();
        }

        /**
         * Returns true if this node has a brother; Cost: O(1)
         * @return true if this node has a brother
         */
        public boolean hasBrother() {
            return parent != null && parent.hasTwoChildren();
        }

        /**
         * Returns the leftmost node in the subtree rooted at this node; Cost: O(h)
         * <p>
         * Equivalent to a linear search on a node-leaf path
         * <ul>
         * <li> Worst-case cost: &Theta;(h)
         * <li> Best-case cost: O(1) 
         * </ul>
         * where h is the height of the Binary Tree
         * @return <code>null</code> or the the leftmost node in the subtree rooted at this node
         */
        public BTNode min() {
            BTNode T = this;
            while(T.left != null)
                T = T.left;
            return T;
        }

        /**
         * Returns the rightmost node in the subtree rooted at this node; Cost: O(h)
         * <p>
         * Equivalent to a linear search on a node-leaf path
         * <ul>
         * <li> Worst-case cost: &Theta;(h)
         * <li> Best-case cost: O(1) 
         * </ul>
         * where h is the height of the Binary Tree
         * @return <code>null</code> or the the rightmost node in the subtree rooted at this node
         */
        public BTNode max() {
            BTNode T = this;
            while(T.right != null)
                T = T.right;
            return T;
        }

        /**
         * Returns the predecessor of this node in a in-order visit; Cost: O(h)
         * <p>
         * The predecessor is searched on a root-leaf path
         * <ul>
         * <li> Worst-case cost: &Theta;(h)
         * <li> Best-case cost: O(1) 
         * </ul>
         * where h is the height of the Binary Tree
         * @return the predecessor of this node
         */
        public BTNode predecessor()  {
            BTNode T = this;
            if(T.left != null) {
                return T.left.max();
            } else {
                BTNode P = T.parent;
                while(P != null && T == P.left) {
                    T = P;
                    P = P.parent;
                }
                return P;
            }
        }

        /**
         * Returns the successor of this node in a in-order visit; Cost: O(h)
         * <p>
         * The successor is searched on a root-leaf path
         * <ul>
         * <li> Worst-case cost: &Theta;(h)
         * <li> Best-case cost: O(1) 
         * </ul>
         * where h is the height of the Binary Tree
         * @return the successor of this node
         */
        public BTNode successor()  {
            BTNode T = this;
            if(T.right != null) {
                return T.right.min();
            } else {
                BTNode P = T.parent;
                while(P != null && T == P.right) {
                    T = P;
                    P = P.parent;
                }
                return P;
            }
        }

        /**
         * Swaps key and data values of this node with those of the input node; Cost: O(1)
         * @param node a Binary Tree node
         * @throws IllegalStateException if the node passed as argument is <code>null</code>
         */
        public void swap(BTNode node) throws IllegalStateException {
            if(node == null)
                throw new IllegalStateException();
            K key       = this.key;
            D data      = this.data;
            this.key    = node.key;
            this.data   = node.data;
            node.key    = key;
            node.data   = data;
        }

        /**
         * Disconnects this node from the Binary Tree if it has only one child; Cost: O(1)
         * <p>
         * If this node is a leaf, it just disconnects it from the tree, while if it
         * has a child, its unique child is inerithed by his father (it becomes the new
         * root if this node is the root node)
         * @throws IllegalStateException if this node has two children
         */
        public void disconnect() throws IllegalStateException {
            if(hasTwoChildren())
                throw new IllegalStateException();

            BTNode child = right == null ? left : right;

            if(isLeftChild())
                parent.left = child;
            else if(isRightChild())
                parent.right = child;
            else
                root = child;
   
            if(child != null)
                child.parent = parent;
        }

        /**
         * Returns a string representing the mapping (<code>key</code>,<code>data</code>) stored in this node; Cost: O(1) 
         * <p>
         * The string has the format <code>X</code>[<code>key</code>,<code>data</code>], where
         * <ul>
         * <li> if the node is a left chid then <code>X = 'L'</code>
         * <li> if the node is a right child then <code>X = 'R'</code>
         * <li> if the node is the root node then <code>X = 'ROOT'</code>
         * </ul>
         * Null data is not printed
         */
        @Override
        public String toString() {
            String  tag  = (isLeftChild() ? "L" : isRightChild() ? "R" : "ROOT");
            if(this.data == null)
                return tag + "[" + key.toString() + "]";
            else
                return tag + "[" + key.toString() + "," + data.toString() +  "]";
        }

    }

}
