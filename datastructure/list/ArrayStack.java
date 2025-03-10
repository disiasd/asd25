package datastructure.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *  Dynamic Array implementation of the Stack data structure
 *  @param <D> type of the data collected in the data structure
 */
public class ArrayStack<D> implements Stack<D> {
    private Object[] stack;
    private int size;
    private int top;

    /**
     * Creates an empty stack
     */
    public ArrayStack() {
        stack =  new Object[1];
        size  =  0;
        top   = -1;
    }

    /**
     *  Pushes <code>data</code> on top of the stack; Amortized cost: O(1)
     *  <p>
     *  The push operation may require resizing the underlying array. 
     *  <ul>
     *  <li> Worst-case cost: &Theta;(n)
     *  <li> Amortized and Best-case cost: O(1)
     *  </ul>
     *  @param data the data to insert in the stack
     */
    public void push(D data) {
        if(top == stack.length-1) 
            resize(2*stack.length);
        stack[++top] = data;    
        size++;
    }

    /**
     * Removes and returns the data on top of the stack; Amortized cost: O(1)
     * <p>
     * The pop operation may require resizing the underlying array.
     * <ul>
     * <li> Worst-case cost: &Theta;(n)
     * <li> Amortized and Best-case cost: O(1)
     * </ul>
     * @return data on top of the stack 
     * @throws NoSuchElementException if the stack is empty
     */
    public D pop() throws NoSuchElementException {
        D data       = top();
        stack[top--] = null;
        if(--size <= stack.length/4)
            resize(stack.length/2);     
        return data;
    }

    /**
     *  Returns the data on top of the stack; Cost: O(1)
     *  @return data on top of the stack
     *  @throws NoSuchElementException if the stack is empty
     */
    public D top() throws NoSuchElementException {
        if(top == -1)
            throw new NoSuchElementException();
        @SuppressWarnings("unchecked")
        D data = (D)stack[top];
        return data;
    }

    /**
     *  Returns true if the stack is empty; Cost: O(1)
     *  @return true if the stack is empty
     */
    public boolean isempty() {
        return size == 0;
    }

    /**
     *  Returns the number of elements in the stack; Cost: O(1)
     *  @return number of elements in the stack
     */
    public int size() {
        return size;
    }

    /* Resize only if the new length is large enough to contain all data */
    private void resize(int length) {
        if(length > 0 && length >= size)
            stack = Arrays.copyOf(stack,length);
    }

    /**
     * Returns a printable string representation of the stack; Cost: &Theta;(n)
     * @return string representation of the stack
     */
    @Override
    public String toString() {
        String S = "";
        for(int i = stack.length - 1 ; i >= 0; i--) {
            S = S + "[" + (stack[i] != null ? stack[i].toString() : "") + "]";
            if(i == top)
                S = S + "\t <- top";
            S = S + "\n";           
        }
        return S;
    }

}
