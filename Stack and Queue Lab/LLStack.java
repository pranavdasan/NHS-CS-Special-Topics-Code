/**
 * This class will use Nodes to form a linked list. It implements the LIFO
 * (Last In First Out) methodology to reverse the input string.
 * 
 * Learning: I learned how the Stack class works in Java 
 *           and how some of it's basic functions works as well
 * Challenges: Didn't face any technical difficulties
 **/

public class LLStack {

    private Node head;

    // Constructor with no parameters for outer class
    public LLStack() {
        // to do
        head = null;
    }

    // This is an inner class specifically utilized for LLStack class,
    // thus no setter or getters are needed
    private class Node {
        private Object data;
        private Node next;

        // Constructor with no parameters for inner class
        public Node() {
            data = null;
            next = null;
        }

        // Parameterized constructor for inner class
        public Node(Object newData, Node nextLink) {
            // Data part of Node is an Object
            data = newData;
            // Link to next node is a type Node
            next = nextLink;
        }
    }

    // Adds a node as the first node element at the start of the list with the
    // specified data.
    // Time Complexity: O(1)
    public void push(Object itemData) {
        // NOTE: the logic here could be implemented in a single line,
        // but not required to be a one liner.

        // Create a new head, and link it to the old head to add it to the "top" of the stack
        head = new Node(itemData, head);
    }

    // Removes the head node and returns the data Object being
    // deleted.
    // Returns null if the list is empty.
    // Time Complexity: O(1)
    public Object pop() {
        if (head == null) {
            return null;
        } else {
            // Make the next head  the top of the stack
            Node oldHead = head;
            head = head.next;
            
            // Returns the data of the old head
            return oldHead.data;
        }
    }

    // Returns the size of linked list by traversing the list
    // Time Complexity: O(N)
    public int size() {
        int stackSize = 0;
        Node currentHead = head;

        while (currentHead != null) {
            stackSize++;
            currentHead = currentHead.next;
        }
        return stackSize;
    }

    // Finds if there is match for the given object
    // Time Complexity: O(N)
    public boolean contains(Object item) {
        Node currentHead = head;

        // Iterates through the stack until it finds the item
        while (currentHead != null) {
            if (currentHead.data == item) {
                return true;
            }
            currentHead = currentHead.next;
        }
        return false;
    }

    // Finds the first node containing the target item, and returns a
    // reference to that node. Return null if target not found.
    // Time Complexity: O(N)
    private Node findData(Object target) {
        Node currentHead = head;

        // Iterates through the stack until it finds the target,
        // and returns the node the target is in
        while (currentHead != null) {
            if (currentHead.data == target) {
                return currentHead;
            }
            currentHead = currentHead.next;
        }
        return null;
    }

    // Time Complexity: O(N)
    public void outputList() {
        Node currentHead = head;
        
        // Iterates through the stack and prints the data for each node
        while (currentHead != null) {
            System.out.println(currentHead.data);
            currentHead = currentHead.next;
        }
    }

    // Time Complexity: O(N)
    public String toString() {
        String retValue = "";
        Node current = head;

        while (current != null) {
            retValue += current.data.toString() + " ";
            current = current.next;
        }
        return retValue;
    }
    
    // Time Complexity: O(1)
    public boolean isEmpty() {
        // Returns whether the head is null or not, if it is then the stack is empty
        return head == null;
    }

    // Time Complexity: O(1)
    public void clear() {
        // Clears it by making head null, meaning there's no reference to a node
        head = null;
    }

    // For two lists to be equal they must contain the same data items in
    // the same order. The equals method of T is used to compare data items.
    // Time Complexity: O(N)
    public boolean equals(Object otherObject) {
        // Check whether the otherlist is empty
        if (otherObject == null) {
            return false;
        } else if (!(otherObject instanceof LLStack)) { // Checks to make sure the list is a LLStack
            return false;
        } else {
            LLStack otherList = (LLStack) otherObject;
            
            // Checks if the 2 stacks have the same size
            if (size() != otherList.size()) {
                return false;
            }

            Node current = head;
            Node otherListHead = otherList.head;

            // Iterates through both stacks to make sure the values are the same
            while(current != null) {
                if (current.data != otherListHead.data) {
                    return false;
                }

                current = current.next;
                otherListHead = otherListHead.next;
            }  
        }

        return true;   
    }

    // There is no need to modify the driver
    public static void main(String[] args) {

        // input data for testing
        String target = "Somethings!";
        String palindrome = "a man a plan canal panama";

        LLStack list = new LLStack();
        // objects to be added to list
        Object object1 = (Character) target.charAt(4);
        Object object2 = (Character) target.charAt(1);
        Object object3 = (Character) target.charAt(2);
        Object object4 = (Character) target.charAt(9);
        Object object20 = (Character) target.charAt(6); // will not be added to list

        // add 4 objects to our linked list
        list.push(object1);
        list.push(object2);
        list.push(object3);
        list.push(object4);

        // make sure all are added
        System.out.println("My list has " + list.size() + " nodes.");
        // display the newly created list
        list.outputList();
        System.out.println("toString = " + list.toString());

        // test findData() here
        Node itemFound = list.findData(object1);
        System.out.println("Item found: " + itemFound.data);

        // Test contains() here
        if (list.contains(object1))
            System.out.println("Object1 found.");
        else
            System.out.println("There is NO object1.");

        if (list.contains(object20))
            System.out.println("Object20 found.");
        else
            System.out.println("There is NO object20.");

        // Creating a new linked list by iteration using different input
        LLStack linkedList = new LLStack();

        for (int i = 0; i < palindrome.length(); i++) {
            Object object = (Character) palindrome.charAt(i);
            linkedList.push(object);
        }
        // Display your list now
        linkedList.outputList();

        // More tests; size() and is Empty()
        System.out.println("This time my list has " + linkedList.size() + " nodes.");
        System.out.println("Is our linkedList empty? " + linkedList.isEmpty());

        // Creating an Object of different class to compare with Character class
        Object mismatchObject = (Integer) Character.getNumericValue(target.charAt(0));

        boolean areEqual = linkedList.equals(mismatchObject);
        System.out.println("Are the 2 objects equal? " + areEqual);

        boolean areEqualAgain = linkedList.equals(linkedList);
        System.out.println("Are the 2 objects equal? " + areEqualAgain);

        // test deleteHead()
        list.pop();
        if (list.contains(object4))
            System.out.println("Object4 found.");
        else
            System.out.println("Object4 has been deleted!");
        while (!list.isEmpty()) {
            list.pop();
        }
        System.out.println("Start of list:");
        list.outputList();
        System.out.println("End of list.");

        System.out.println("In the begining linkedList has " + linkedList.size() + " nodes");
        linkedList.clear();

        System.out.println("After testing clear(), linkedList has " + linkedList.size() + " nodes");
    }

}
