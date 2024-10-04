//CS Special Topics
//LinkedList Lab
/*
  Name -
  Date -
  Things learned -
  Challenges overcame - 
*/

import static java.lang.System.*;

public class ListFunHouse {
	// this method will print the entire list on the screen
	public static void print(ListNode list) {
				//Prints all the nodes but the last one
		while(list.getNext() != null) {
			System.out.print("["+list.getValue()+"] -> ");
			list = list.getNext();
		}

		// Prints the last node (is out of the loop for formating reasons)
		System.out.print("["+list.getValue()+"]");
	}

	// this method will return the number of nodes present in list
	public static int nodeCount(ListNode list) {
		int count = 0;

		while(list != null) {
			count++;
			list = list.getNext();
		}

		return count;
	}

	// this method will create a new node with the same value as the first node and
	// add this
	// new node to the list. Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list) {
		list.setNext(new ListNode(list.getValue(), list.getNext()));
	}

	// this method will create a new node with the same value as the last node and
	// add this
	// new node at the end. Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list) {
		Comparable lastValue = null;

		// Get the last value
		while (list.getNext() != null) {
			list = list.getNext();
		}

		lastValue = list.getValue();

		list.setNext(new ListNode(lastValue, null));
	}

	// method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list) {
	}

	// this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value) {
		int count = 1;

		while(list != null) {
			if (count % x == 0) {
				list.setValue(value);
			}

			count++;
			list = list.getNext();
		}
	}

	// this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x) {
		while(list.getNext().getNext() != null) {
			list.setNext(list.getNext().getNext());
			list = list.getNext();
		}

		list.setNext(null);
	}
}