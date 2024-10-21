/*
 * This class implements a queue with linked list
 * Learning: I learned how the Queue interface works in Java 
 *           and how some of it's basic function works as well
 * Challenges: I didn't face too many challenges due to the fact this is 
 *             very similar to the LinkedList Lab. Though I had a bit of 
 *             trouble understanding how the front and back parts of the
 *             queue works, since that's what makes this unique from an
 *             LinkedList
 */

public class LLQueue {
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

        // Parametrized constructor for inner class
        public Node(Object newData, Node nextLink) {
            // Data part of Node is an Object
            data = newData;
            // Link to next node is a type Node
            next = nextLink;
        }
    }

    private Node front;
    private Node back;

    // Creates the queue
    public LLQueue() {
        front = new Node();
        back = front;
    }

    // offer(enqueue) adds the object at the back of the queue
    // Time Complexity: O(1)
    public void offer(Object o) {
        Node newNode = new Node(o, null);
        back.next = newNode;
        back = newNode;
    }

    // poll(dequeue): retrieves and removes the head of this queue,
    // or returns null if this queue is empty.
    // Time Complexity: O(1)
    public Object poll() {

        if (front == null) { // Checks if the queue is empty
            return null;
        } else { // Otherwise returns the heads data and updates the head
            Node oldFront = front;
            front = front.next;

            return oldFront.data;
        }

    }

    // Returns the size of linked list by traversing the list
    // Time Complexity: O(N)
    public int size() {
        int size = 0;
        Node q = front;

        // Iterates through the queue and gets the size
        if (front != null) {
            while (q.next != null) {
                size += 1;
                q = q.next;
            }
        } else {
            size = -1;
        }

        return size;
    }

    // peek: Retrieves, but does not remove, the head of this queue,
    // or returns null if this queue is empty.
    // Time Complexity: O(1)
    public Object peek() {
        // Returns the data of the front node if the queue is not empty
        if (front != null) {
            return front.data;
        } else {
            return null;
        }
    }

    // Returns whether the queue is empty or not
    // Time Complexity: O(1)
    public boolean isEmpty() {
        return front == null;
    }

    // For two lists to be equal they must contain the same data items in
    // the same order. The equals method of T is used to compare data items.
    // Returns whether the
    public boolean equals(Object otherObject) {
        if (otherObject == null)
            return false;

        else if (!(otherObject instanceof LLQueue)) {
            return false;
        } else {
            LLQueue otherList = (LLQueue) otherObject;

            // 1. check the size
            if (size() != otherList.size()) {
                return false;
            }

            // 2. check each element
            Node q = front;
            Node otherQ = otherList.front;
            while (q.next != null) {
                if (q.data != otherQ.data) {
                    return false;
                }

                q = q.next;
                otherQ = otherQ.next;
            }
            return true; // objects are the same
        }
    }

    // There is no need to modify the driver
    public static void main(String[] args) {
        // input data for testing
        String target = "Somethings!";
        String palindrome = "a man a plan canal panama";

        LLQueue list = new LLQueue();
        // objects to be added to list
        Object object1 = (Character) target.charAt(4);
        Object object2 = (Character) target.charAt(1);
        Object object3 = (Character) target.charAt(2);
        Object object4 = (Character) target.charAt(9);
        Object object20 = (Character) target.charAt(6); // will not be added to list

        // add 4 objects to our linked list
        list.offer(object1);
        list.offer(object2);
        list.offer(object3);
        list.offer(object4);

        // make sure all are added
        System.out.println("My list has " + list.size() + " nodes.");

        // testing equals
        LLQueue list2 = new LLQueue();
        // add 4 objects to the new linked list
        list2.offer(object1);// t
        list2.offer(object2);// o
        list2.offer(object3);// m
        list2.offer(object4);// s
        boolean isEqual2 = list.equals(list2);
        System.out.println("list2 is equal to list1? " + isEqual2);

        // add 4 objects to our linked list in a different order
        LLQueue list3 = new LLQueue();
        list3.offer(object3);// m
        list3.offer(object1);// t
        list3.offer(object2);// o
        list3.offer(object4);// s
        boolean isEqual3 = list.equals(list3);
        System.out.println("list3 is equal to list1? " + isEqual3);

        // testing isEmpty() and poll()
        while (!list.isEmpty()) {
            Object temp = list.poll();
            System.out.println("Polling " + temp);
        }

    }
}
