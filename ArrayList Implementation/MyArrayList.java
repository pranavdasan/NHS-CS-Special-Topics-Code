import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of MyList with an array (a longer exercise would be to
 * implement the List interface as is done in the class java.util.ArrayList: the
 * source of the ArrayList class is available from Sun. Check it out).
 */

public class MyArrayList<E> implements MyList<E> {

	// Use an array for the implementation
	private E[] elements; 

	// Default capacity of the array
	private static final int DEFAULT_CAPACITY = 10;

	// Number of elements in the array
	private int numElems;

	/**
	 * Constructs a MyArrayList with a specified capacity
	 */
	public MyArrayList(int initialCapacity) {
		elements = (E[]) new Object[initialCapacity];
		numElems = 0;
	}

	/**
	 * Constructs a MyArrayList with a default capacity
	 */
	public MyArrayList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Returns the number of elements in this list.
	 * Big O: O(1)
	 */
	public int size() {
		return numElems;
	}

	/**
	 * Returns true if this list contains no elements.
	 * Big O: O(1)
	 */
	public boolean isEmpty() {
		return this.size() == 0;
	}

	/**
	 * Appends the specified element to the end of this list
	 * Big O: O(1)
	 */
	public boolean add(E o) {
		/* If there is no room in the array items
		Make room for the new element 
		*/
		if (numElems < 0) {
			throw new IndexOutOfBoundsException();
		}

		if (numElems >= elements.length) {
			ensureExtraCapacity(1);
		}

		// add the new element
		elements[numElems] = o;
		numElems++;

		return true;
	}

	/* 
	 * Big O: O(n)
	 */
	private void ensureExtraCapacity(int spaceToAdd){
		if(numElems + spaceToAdd > elements.length){
			int newAddedCapacity = elements.length * 2 + spaceToAdd;
			E[] newElements = (E[]) new Object[newAddedCapacity];

			// Copy values from old elements to newElements
			for (int i = 0; i < numElems; i++) {
				newElements[i] = elements[i];
			}

			elements = newElements;
		} 
	}

	/**
	 * Empties this List
	 * Big O: O(n)
	 */
	public void clear() {
		for (int i = 0; i < numElems; i++) {
			elements[i] = null;
		}

		numElems = 0;
	}

	/**
	 * Returns the element at the specified position in this list.
	 * Big O: O(1)
	 */
	public E get(int index) {
		if(index < 0 || index >= numElems) {
			throw new IndexOutOfBoundsException();
		}

		return (E) elements[index];
	}

	/**
	 * Returns the index of the specified element (-1 if there is no match)
	 * Big O: O(n)
	 */
	public int indexOf(Object o) {
		// If o is null (look for a null element in the array)
		for (int i = 0; i < numElems; i++) {
			E element = this.get(i);

			if (o == null && element == null) {
				return i;
			}

			if(element.equals(o)) {
				return i;
			}
		}

		// If we get here, o is not in the list
		return -1;
	}

	/**
	 * Returns true if this list contains the specified element.
	 * Big O: O(1)
	 */
	public boolean contains(Object o) {
		// easy with indexOf
		return this.indexOf(o) != -1;
	}

	/**
	 * Removes the element in the List at position index
	 * Big O: O(n)
	 */
	public boolean remove(int index) {
		// Check if index is out of bounds
		if (index < 0  || index >= numElems) {
			throw new IndexOutOfBoundsException();
		}
		
		for (int i = index+1; i < numElems; i++) {
			elements[i-1] = elements[i];
		}

		// let gc do its work
		elements[numElems-1] = null;

		numElems--;
		return true;
	}

	/**
	 * Removes the element in the List at position index
	 * Big O: O(n)
	 */
	public boolean remove(Object o) {
		// easy with indexOf and remove
		int removeIndex = this.indexOf(o);

		if(removeIndex != -1) {
			remove(removeIndex);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Adds the specified object at the specified location
	 * Big O: O(n)
	 */
	public boolean add(int index, E o) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		// Adds space if needed
		if (numElems >= elements.length) {
			ensureExtraCapacity(1);
		}

		// Creates space for new element by sliding the rest to the right
		for (int i = numElems-1; i >= index; i--) {
			elements[i+1] = elements[i];
		}
		
		numElems++;

		// Adds element to space created
		elements[index] = o;

		return true;
	}

	/**
	 * Is this List equal to the specified object?
	 * Big O: O(n)
	 */
	public boolean equals(Object o) {
        if (o  instanceof MyArrayList) {
            // o is an ArrayList
			MyArrayList otheArrayList = (MyArrayList<E>) o;

            // if the number of elements is not the same, this and o are not the
			// same
			if (otheArrayList.size() != this.size()) {
				return false;
			} 

            // Check the elements one by one
			for(int i = 0; i < numElems; i++) {
				E element = this.get(i);
				E otherArrayElement = (E) otheArrayList.get(i);

				// Checks for null values (and handles edge case)
				if(element == null && otherArrayElement != null) {
					return false;
				} else if (!element.equals(otherArrayElement)) {
					return false;
				}
			}
			

            // At this point, the lists are equal
			return true;

        }
		else {
			return false;
	    }
	}

	/**
	 * An inner class to define the iterator
	 */
	private class MyIterator implements Iterator<E> {
		private int index = 0;

		private MyArrayList<E> list;

		private int lastIndex = -1; // index of the object most recently visited

		// by next

		/**
		 * Create an iterator for a MyArrayList
		 * Big O: O(1)
		 */
		public MyIterator(MyArrayList<E> list) {
			this.list = list;
		}

		/**
		 * Any element left in the list?
		 */
		public boolean hasNext() {
			return index < numElems;
		}

		/**
		 * Returns the current element in the list and move to the next element
		 * Big O: O(1)
		 */
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}

			lastIndex = index;
			E element = list.get(lastIndex);
			index++;

			return element;
		}

		/**
		 * Removes the last object returned by next
		 * Big O: O(n)
		 */
		public void remove() {
			if (lastIndex == -1) {
				throw new IllegalStateException();
			}
			
			list.remove(lastIndex);
			index = lastIndex; 
			lastIndex = -1; // Reset lastIndex to indicate no element is removable
		}
	}

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * 
	 * @return an iterator over the elements in this list in proper sequence.
	 */
	public Iterator<E> iterator() {
		return new MyIterator(this);
		
	}
}

	
