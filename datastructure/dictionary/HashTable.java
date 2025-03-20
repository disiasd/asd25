package datastructure.dictionary;

import java.util.Iterator;
import java.lang.Iterable;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
import java.lang.UnsupportedOperationException;

/**
 * Implementation of the Dictionary data structure using an underlying Hash Table, 
 * where collisions are handled using chaining (via a Singly Linked List).
 * 
 * <p>
 * The performance of a Hash Table is affected by two parameters: 
 * <i>capacity</i> and <i>load factor</i>. The <i>capacity</i> refers to the 
 * number of <i>buckets</i> in the Hash Table, while the <i>load factor</i> is 
 * a measure of how full the Hash Table is. If the <i>load factor</i> exceeds 
 * a certain threshold (default: 0.75), the <i>capacity</i> is increased 
 * (doubled) and the Hash Table is rehashed. Once increased, the 
 * <i>capacity</i> is never reduced.
 * @param <K> type of the key value
 * @param <D> type of the data object
 */
public class HashTable<K,D> implements Dictionary<K,D> {
    private static final int    DEFAULT_INITIAL_CAPACITY = 16;
    private static final int    MAXIMUM_CAPACITY         = Integer.MAX_VALUE;
    private static final double DEFAULT_LOAD_FACTOR      = 0.75f;
    private final double loadFactor;
    private int size;

    private Object[] T;

    /**
     * Constructs an empty Hash Table with the specified initial
     * capacity and the specified load factor.
     *
     * @param      initialCapacity   initial capacity of the HashTable
     * @param      loadFactor        load factor of the HashTable
     * @exception  IllegalArgumentException  if the initial capacity is less than zero, or if the load factor is nonpositive
     */
    public HashTable(int initialCapacity, double loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Double.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        this.loadFactor = loadFactor;
        T = new Object[initialCapacity];
        for(int i = 0; i < T.length; i++)
            T[i] = new LLDictionary<K,D>();
    }

    /**
     * Constructs an empty Hash Table with the specified initial capacity
     * and default load factor (0.75).
     *
     * @param     initialCapacity   initial capacity of the HashTable
     * @exception IllegalArgumentException if the initial capacity is less than zero
     */
    public HashTable(int initialCapacity) {
        this(initialCapacity,DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructs a new, empty Hash Table with the specified load factor
     * and default initial capacity (16).
     *
     * @param     loadFactor        load factor of the HashTable
     * @exception IllegalArgumentException if the load factor is non positive
     */
    public HashTable(double loadFactor) {
        this(DEFAULT_INITIAL_CAPACITY,loadFactor);
    }

    /**
     * Constructs an empty Hash Table with the default initial capacity (16)
     * and default load factor (0.75).
     */
    public HashTable() {
        this(DEFAULT_INITIAL_CAPACITY,DEFAULT_LOAD_FACTOR);
    }

    /** Inserts the mapping (<code>key</code>,<code>data</code>) into the Hash Table; Average cost: O(1).
     *  <p>
     *  Duplicate keys are not allowed: if the key already exists in the Hash Table, 
     *  the associated data is overwritten. 
     *  The underlying table is doubled in size and rehashed if the load factor 
     *  exceeds the threshold specified at construction. This ensures that the 
     *  amortized cost remains constant on average.
     *  @param key key value
     *  @param data data mapped to the key value
     *  @exception IllegalArgumentException if the key value is <code>null</code>
     */
    public void insert(K key, D data) throws IllegalArgumentException {
        if(key == null)
            throw new IllegalArgumentException("Illegal key value: " + key);
        @SuppressWarnings("unchecked")    
        LLDictionary<K,D> LL = (LLDictionary<K,D>)T[hash(key) % T.length];
        LL.insert(key,data);
        if(size > loadFactor*T.length)
            rehash();
    }

    /** Returns the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the Hash Table; Avergage cost: O(1)
     *  @param key the key value to search
     *  @return the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the Hash Table
     */
    public D search(K key) {
        if(key == null)
            return null;

        @SuppressWarnings("unchecked")
        LLDictionary<K,D> LL = (LLDictionary<K,D>)T[hash(key) % T.length];
        return LL.search(key);
    }
    
    /** Removes the mapping (<code>key</code>,<code>data</code>) from the Hash Table and
     *  returns the <code>data</code>; Average cost: O(1).
     *  <p>
     *  No action performed if the key is not in the Hash Table
     *  @param key the key value to search
     *  @return the data mapped to <code>key</code> or <code>null</code> if <code>key</code> is not in the Hash Table
     */
    public D delete(K key) {
        if(key == null)
            return null;
        @SuppressWarnings("unchecked")
        LLDictionary<K,D> LL = (LLDictionary<K,D>)T[hash(key) % T.length];
        return LL.delete(key);
    }
    
    /**
     * Returns the number of (<code>key</code>,<code>data</code>) mappings in the Hash Table; Cost: O(1)
     * @return number of key-data mappings in the Hash Table
     */
    public int size() {
        return size;
    }

    /**
     * Returns <code>true</code> if the Hash Table is empty; Cost: O(1)
     * @return <code>true</code> if the Hash Table is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the current load factor of the Hash Table; Cost: O(1)
     * @return current load factor of the Hash Table
     */
    public double loadFactor() {
        return 1.0*size/T.length;
    }

    private void rehash() {
        if(T.length < MAXIMUM_CAPACITY) {
            size = 0; // Reset size
            int N = T.length*2.0 > MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : T.length*2;
            Object[] H = new Object[N];
            for(int i = 0; i < H.length; i++)
                H[i] = new LLDictionary<K,D>();
            for(int i = 0; i < T.length; i++) {
                @SuppressWarnings("unchecked")
                LLDictionary<K,D> LL = (LLDictionary<K,D>)T[i];
                for(Node<K,D> node : LL) {
                    @SuppressWarnings("unchecked")
                    LLDictionary<K,D> HH = (LLDictionary<K,D>)H[hash(node.key) % H.length];
                    HH.insert(node.key,node.data);
                }
            }
            T = H;
        }
    }

    /**
     * Returns a printable string representation of the HashTable; Cost: &Theta;(m+n)
     * where m is the size of the underlying table and n is the number of stored elements
     * @return string representation of the HashTable
     */
    @Override
    public String toString() {
        String S = "Size: " + size + " Table Length: " + T.length + " Load Factor: " + loadFactor() + "\n";
        for(int i = 0; i < T.length; i++)  {
            @SuppressWarnings("unchecked")
            LLDictionary<K,D> LL = (LLDictionary<K,D>)T[i];
            S += "[" + i + "]\t -> " + LL + "\n";
        }
        return S;
    }

    /**
     * Maps negative to positive integers and null to zero  
     */
    static final int hash(Object key) {
        return (key == null) ? 0 : key.hashCode() & 0x7fffffff;
    }

    private class LLDictionary<K,D> implements Dictionary<K,D>, Iterable<Node<K,D>> {
        private LLNode<K,D> head;
        private int llsize;

        private class LLNode<K,D> extends Node<K,D> {
            LLNode<K,D> next;
            
            public LLNode(K key, D data) {
                super(key,data);
                next = null;
            }
        }

        public LLDictionary() {
            head   = null;
            llsize = 0;
        }
        
        public void insert(K key, D data) throws IllegalArgumentException {
            if(key == null)
                throw new IllegalArgumentException("The key value cannot be null");
    
            LLNode<K,D> node = searchNode(key);
            if(node != null)
                node.data = data;
            else
                insertNode(key,data); 
        }

        private void insertNode(K key, D data) {
            LLNode<K,D> node = new LLNode<>(key,data);
            node.next = head;
            head      = node;
            size++;
            llsize++;
        }

        public D search(K key) {
            LLNode<K,D> node = key != null ? searchNode(key) : null;
            return node != null ? node.data : null; 
        }

        private LLNode<K,D> searchNode(K key) {
            LLNode<K,D> tmp = head;
            while(tmp != null) {
                if(tmp.key.equals(key))
                    return tmp;
                tmp = tmp.next;
            }
            return null;
        }

        public D delete(K key) {
            LLNode<K,D> node = key != null && head != null ? deleteNode(key) : null;
            return node != null ? node.data : null;
        }

        private LLNode<K,D> deleteNode(K key) {
            LLNode<K,D> node = null;
            
            if(head.key.equals(key)) {
                node = head;
                head = head.next;
            } else {
                LLNode<K,D> tmp = head;
                while(tmp.next != null && !tmp.next.key.equals(key))
                    tmp = tmp.next;
                if(tmp.next != null) {
                    node     = tmp.next;
                    tmp.next = node.next;
                }
            }
            
            if(node != null) {
                node.next = null;
                size--;
                llsize--;
            }

            return node;
        }

        public int size() {
            return llsize;
        }

        public boolean isEmpty() {
            return llsize == 0;
        }

        public String toString() {
            if(head == null) {
                return "null";
            } else {
                String S = head.toString();
                LLNode<K,D> tmp = head.next;
                while(tmp != null) {
                    S += " -> " + tmp;
                    tmp = tmp.next;
                }
                return S;
            }
        }

        public Iterator<Node<K,D>> iterator() {
            return new LLDictionaryIterator();
        }

        private class LLDictionaryIterator implements Iterator<Node<K,D>> {
            private LLNode<K,D> curr;
            
            public LLDictionaryIterator() {
                curr = head;
            }

            public boolean hasNext() {
                return curr != null;
            } 

            public Node<K,D> next() throws NoSuchElementException {
                if(curr == null)
                    throw new NoSuchElementException();
                Node<K,D> node = curr;
                curr = curr.next;
                return node; 
            }

            public void remove() throws  UnsupportedOperationException {
                throw new UnsupportedOperationException();
            }
            
        }
    }   

    private class Node<K,D> {
        public final K key;
        public       D data;

        public Node(K key, D data) {
            this.key  = key;
            this.data = data;
        }

        @Override
        public String toString() {
            return key + ":" + data;
        }
    }

}
