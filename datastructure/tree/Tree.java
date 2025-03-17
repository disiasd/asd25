package datastructure.tree;

import datastructure.list.List;

/**
 * Interface for a generic Tree data structure
 * @param <K> type of the key value
 * @param <D> type of the data object
 */
public interface Tree<K,D> {
    /**
     *  Inserts a node storing the mapping (<code>key</code>,<code>data</code>) into the tree
     *  @param key key value
     *  @param data data mapped to the key value
     */
    public void insert(K key, D data);

    /** 
     *  Returns the data stored in the first node matching <code>key</code> 
     *  @param key key value to search
     *  @return the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the tree
     */
    public D search(K key);

    /**
     *  Deletes the first node matching <code>key</code> and returns the data mapped to it
     *  @param key key value to search
     *  @return the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the tree
     */
    public D delete(K key);

    /**
     * Returns the number of nodes in the tree
     * @return number of nodes in the tree
     */
    public int size();

    /**
     * Returns <code>true</code> if the tree is empty
     * @return <code>true</code> if the tree is empty
     */
    public boolean isEmpty();

    /**
     *  Returns a list of data in preorder traversal
     *  @return a list containing the data
     */
    public List<D> getPreorderData();

    /**
     *  Returns a list of data in postorder traversal
     *  @return a list containing the data
     */
    public List<D> getPostorderData();

    /**
     *  Returns a list of data in inorder traversal
     *  @return a list containing the data
     */
    public List<D> getInorderData();

    /**
     *  Returns the list of data in bfs traversal
     *  @return a list containing the data
     */
    public List<D> getBFSData();

    /**
     *  Returns a list of key values in preorder traversal
     *  @return a list containing the key values
     */
    public List<K> getPreorderKeys();

    /**
     *  Returns a list of key values in postorder traversal
     *  @return a list containing the key values
     */
    public List<K> getPostorderKeys();

    /**
     *  Returns a list of key values in inorder traversal
     *  @return a list containing the key values
     */
    public List<K> getInorderKeys();

    /**
     *  Returns the list of key values in bfs traversal
     *  @return a list containing the key values 
     */
    public List<K> getBFSKeys();

}
