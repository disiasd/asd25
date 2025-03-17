package datastructure.dictionary;

/**
 * Interface for a Dictionary data structure that maps keys to data values. 
 * A map cannot contain duplicate keys: each key can map to at most one value.
 * @param <K> type of the key value
 * @param <D> type of the data object
 */
public interface Dictionary<K,D> {
    
    /** Inserts the mapping (<code>key</code>,<code>data</code>) into the dictionary
     *  <p>
     *  Duplicated keys are not allowed: if key is already
     *  in the dictionary, the associated data is overwritten
     *  @param key key value
     *  @param data data mapped to the key value
     */
    public void insert(K key, D data);
    
    /** Returns the <code>data</code> mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the dictionary
     *  @param key the key value to search
     *  @return the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the Dictionary
     */
    public D search(K key);

    /** Removes the mapping (<code>key</code>,<code>data</code>) from the dictionary and
     *  returns the <code>data</code>.  No action performed if the key is not in the dictionary
     *  @param key the key value to search
     *  @return the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the Dictionary
     */
    public D delete(K key);

    /**
     * Returns the number of (<code>key</code>,<code>data</code>) mappings in the dictionary
     * @return number of key-data mappings in the tree
     */
    public int size();

    /**
     * Returns <code>true</code> if the dictionary is empty
     * @return <code>true</code> if the dictionary is empty
     */
    public boolean isEmpty();

}
