import java.util.Arrays;
import java.util.NoSuchElementException;

// Implements a priority queue of comparable objects using a
// min-heap represented as an array.
public class HeapPriorityQueue<E extends Comparable<E>> {
    private E[] elementData;
    private int size;
    
    // Constructs an empty queue.
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue() {
        elementData = (E[])new Comparable[10];
        size = 0;
    }
    
    /**
     *  Adds the given element to this queue.
     *  
     * Time Complexity: O(log n) or O(height of tree)
     */ 
    
    public void add(E value) {
        if (size + 1 == elementData.length) {
            elementData = Arrays.copyOf(elementData, size*2);
        }

        // Step 1: Add to the rightmost possible node
        int index = size + 1;
        
        elementData[index] = value;

        // Step 2: Bubble up to maintain min-heap order
        while (hasParent(index) && value.compareTo(elementData[parent(index)]) < 0) {
            swap(elementData, index, parent(index));
            index = parent(index);        
        }

        size++;
    }
    
    /**
     *  Returns true if there are no elements in this queue.
     *  
     * Time Complexity: O(1)
     */ 
    public boolean isEmpty() {
    	// TO DO
    	return size == 0;
    }
    
    /**
     * Returns the minimum value in the queue without modifying the queue.
     * If the queue is empty, throws a NoSuchElementException.
     * 
     * Time Complexity: O(1)
     * @return Minimum value in the queue
     */
    public E peek() {
    	// TO DO
    	return elementData[1];
    }
    
    
    /**
     * Removes and returns the minimum value in the queue.
     * If the queue is empty, throws a NoSuchElementException.
     * 
     * Time Complexity: O(log n) or O(height of tree)
     * @return Minimum value of the queue
     */
    public E remove() {
    	// TO DO
    	E minNum = elementData[1];
        elementData[1] = elementData[size]; // Last  node becomes the root node
        size--;

        //Bubble Down
        int i = 1;
        boolean found = false;

        while(!found && hasLeftChild(i)) {
            int leftNodeIndex = leftChild(i);
            int rightNodeIndex = rightChild(i);
            int swapIndex = leftNodeIndex;
            
            if (hasRightChild(i) && elementData[rightNodeIndex].compareTo(elementData[leftNodeIndex]) < 0) {
                swapIndex = rightNodeIndex;
            }

            if (elementData[i].compareTo(elementData[swapIndex]) > 0) {
                swap(elementData, i, swapIndex);
                i = swapIndex;
            } else {
                found = true;
            }
        }

        return minNum;
    }
    
    /**
     * Returns the number of elements in the queue.
     * 
     * Time Complexity: O(1)
     * @return Number of elements in the queue.
     */
    public int size() {
    	// TO DO
        return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += elementData[1];
            for (int i = 2; i <= size; i++) {
                result += ", " + elementData[i];
            }
        }
        return result + "]";
    }
    
    
    // Helpers for navigating indexes up/down the tree
    // All of them have Time Complexity of O(1)
    private int parent(int index) {
    	// TO DO
        return index / 2;
    }

    private int leftChild(int index) {
    	// TO DO
        return 2 * index;
    }

    private int rightChild(int index) {
    	// TO DO
        return 2 * index + 1;
    }
    

    /**
     * Returns true if the node at the given index has a parent (is not the root)
     * Time Complexity: O(1)
     * 
     * @return Whether the node at index given has a parent.
     */
    private boolean hasParent(int index) {
    	// TO DO
        return parent(index) > 0;
    }
    
    /**
     * Returns true if the node at the given index has a non-empty left child
     * Time Complexity: O(1)
     * 
     * @return Whether the node at index given has a left child.
     */
    private boolean hasLeftChild(int index) {
    	// TO DO
        return leftChild(index) <= size;
    }
    

    /**
     * Returns true if the node at the given index has a non-empty right child
     * Time Complexity: O(1)
     * 
     * @return Whether the node at index given has a right child.
     */
    private boolean hasRightChild(int index) {
    	// TO DO
        return rightChild(index) <= size;
    }
    
    /**
     * Switches the values at the two given indexes of the given array
     * Time Complexity: O(1)
     */
    private void swap(E[] a, int index1, int index2) {
    	E temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
