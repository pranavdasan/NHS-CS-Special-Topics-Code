//CS Special Topics
//LinkedList Lab

//Name - Pranav D.

import java.util.*;
import static java.lang.System.*;

public class ListFunHouseRunner {
	public static void main(String[] args) {
		ListNode z = new ListNode("go",
				new ListNode("on",
						new ListNode("at",
								new ListNode("34",
										new ListNode("2.1",
												new ListNode("-a-2-1",
														new ListNode("up",
																new ListNode("over", null))))))));

		out.println("Lab15b Test Code\n\n");

		out.println("Original list values\n");
		ListFunHouse.print(z);
		out.println("\n");

		out.println("num nodes = " + ListFunHouse.nodeCount(z));

		out.println("\nList values after calling nodeCount");
		ListFunHouse.print(z);
		out.println();

		ListFunHouse.doubleFirst(z);
		out.println("\nList values after calling doubleFirst");
		ListFunHouse.print(z);
		out.println();

		ListFunHouse.doubleLast(z);
		out.println("\nList values after calling doubleLast");
		ListFunHouse.print(z);
		out.println();

		ListFunHouse.removeXthNode(z, 2);
		out.println("\nList values after calling removeXthNode(2)");
		ListFunHouse.print(z);
		out.println();

		ListFunHouse.setXthNode(z, 2, "one");
		out.println("\nList values after calling setXthNode(2,one)");
		ListFunHouse.print(z);
		out.println();
	}
}