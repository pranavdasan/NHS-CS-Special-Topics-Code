// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.

public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        // TO DO:
        overallRoot = null;
    }

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        // TO DO:
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    // Time Complexity: O(log(n))
    // Space Complexity: O(1) 

    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        // TO DO:
        if (root == null) {
            root = new SearchTreeNode(value);
        } else if (root.data.compareTo(value) > 0) {
            root.left = add(root.left, value);
        } else if (root.data.compareTo(value) < 0) {
            root.right = add(root.right, value);
        } // else it's a duplicate, so don't add it

        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        // TO DO:

        return contains(overallRoot, value);
    }

    // post: returns true if given tree contains value, returns false otherwise
    // Time Complexity: O(log(n))
    // Space Complexity: O(1)
    private boolean contains(SearchTreeNode<E> root, E value) {
        // TO DO:
        if (root != null) {
            if (root.data.compareTo(value) == 0) {
                return true;
            }
            if (root.data.compareTo(value) > 0) {
                contains(root.left, value);
            } else if (root.data.compareTo(value) < 0) {
                contains(root.right, value);
            }
        }

        return false;
    }

    // post: value removed from tree so as to preserve binary search tree
    public void remove(E value) {
        // TO DO:
        overallRoot = remove(overallRoot, value);
    }

    // post: value removed to tree so as to preserve binary search tree
    // Time Complexity: O(log(n))
    // Space Complexity: O(1)
    private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
        // TO DO:
        if (root == null) {
            return null;
        } else if (root.data.compareTo(value) > 0) { // Value to remove is on the left node of the subtree
            root.left = remove(root.left, value);
        } else if (root.data.compareTo(value) < 0) { // Value to remove is on the right node of the subtree
            root.right = remove(root.right, value);
        } else { // The root's data is the value we want to remove
            if (root.right == null) {
                return root.left; // There's no right node, so the removed node is being replaced by left node
            } else if (root.left == null) {
                return root.right; // There's no left node, so the removed node is being replaced by right node
            } else { // This means both nodes are there, so we have to replace the removed node with
                     // the minimum from the right substree
                root.data = findSmallest(root.right); // Makes replaces the value to remove the minimum of right subtree
                                                      // of the node
                root.right = remove(root.right, root.data); // Removes the minimum right node from the right subtree
            }
        }

        return root; // Return's the updated root

    }

    // post: return the smallest value in the binary search tree
    // Time Complexity: O(log(n))
    // Space Complexity: O(1)
    private E findSmallest(SearchTreeNode<E> root) {
        // TO DO:
        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }

    // post: prints the data of the tree, one per line
    public void print() {
        // TO DO:
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints the data of the tree using an inorder traversal
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private void printInorder(SearchTreeNode<E> root) {
        // TO DO:

        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    private static class SearchTreeNode<E> {
        public E data; // data stored in this node
        public SearchTreeNode<E> left; // left subtree
        public SearchTreeNode<E> right; // right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
