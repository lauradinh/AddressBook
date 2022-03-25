
// --== CS400 File Header Information ==--
// Name: Laura Dinh
// Email: lmdinh@wisc.edu
// Team: ED
// TA: Keren
// Lecturer: Gary Dahl
// Notes to Grader: n/a
import java.util.LinkedList;

/**
 * Binary Search Tree implementation with a Node inner class for representing
 * the nodes within a binary search tree. You can use this class' insert method
 * to build a binary search tree, and its toString method to display the level
 * order (breadth first) traversal of values in that tree.
 */
public class RedBlackTree<T extends Comparable<T>> {

	/**
	 * This class represents a node holding a single value within a binary tree the
	 * parent, left, and right child references are always be maintained.
	 */
	protected static class Node<T> {
		public T data;
		public Node<T> parent; // null for root node
		public Node<T> leftChild;
		public Node<T> rightChild;
		public boolean isBlack;

		public Node(T data) {
			this.data = data;
			this.isBlack = false;
		}

		/**
		 * @return true when this node has a parent and is the left child of that
		 *         parent, otherwise return false
		 */
		public boolean isLeftChild() {
			return parent != null && parent.leftChild == this;
		}

		/**
		 * This method performs a level order traversal of the tree rooted at the
		 * current node. The string representations of each data value within this tree
		 * are assembled into a comma separated string within brackets (similar to many
		 * implementations of java.util.Collection).
		 * 
		 * @return string containing the values of this tree in level order
		 */
		@Override
		public String toString() { // display subtree in order traversal
			String output = "[";
			LinkedList<Node<T>> q = new LinkedList<>();
			q.add(this);
			while (!q.isEmpty()) {
				Node<T> next = q.removeFirst();
				if (next.leftChild != null)
					q.add(next.leftChild);
				if (next.rightChild != null)
					q.add(next.rightChild);
				output += next.data.toString();
				if (!q.isEmpty())
					output += ", ";
			}
			return output + "]";
		}
	}

	protected Node<T> root; // reference to root node of tree, null when empty

	/**
	 * Performs a naive insertion into a binary search tree: adding the input data
	 * value to a new node in a leaf position within the tree. After this insertion,
	 * no attempt is made to restructure or balance the tree. This tree will not
	 * hold null references, nor duplicate data values.
	 * 
	 * @param data to be added into this binary search tree
	 * @throws NullPointerException     when the provided data argument is null
	 * @throws IllegalArgumentException when the tree already contains data
	 */
	public void insert(T data) throws NullPointerException, IllegalArgumentException {
		// null references cannot be stored within this tree
		if (data == null)
			throw new NullPointerException("This RedBlackTree cannot store null references.");

		Node<T> newNode = new Node<>(data);
		if (root == null) {
			root = newNode;
		} // add first node to an empty tree
		else
			insertHelper(newNode, root); // recursively insert into subtree
		// RBT Specifications
		root.isBlack = true;
	}

	/**
	 * Recursive helper method to find the subtree with a null reference in the
	 * position that the newNode should be inserted, and then extend this tree by
	 * the newNode in that position.
	 * 
	 * @param newNode is the new node that is being added to this tree
	 * @param subtree is the reference to a node within this tree which the newNode
	 *                should be inserted as a descendant beneath
	 * @throws IllegalArgumentException when the newNode and subtree contain equal
	 *                                  data references (as defined by
	 *                                  Comparable.compareTo())
	 */
	private void insertHelper(Node<T> newNode, Node<T> subtree) {
		int compare = newNode.data.compareTo(subtree.data);
		// do not allow duplicate values to be stored within this tree
		if (compare == 0)
			throw new IllegalArgumentException("This RedBlackTree already contains that value.");

		// store newNode within left subtree of subtree
		else if (compare < 0) {
			if (subtree.leftChild == null) { // left subtree empty, add here
				subtree.leftChild = newNode;
				newNode.parent = subtree;
				// add RBT Specifications
				if (!newNode.isBlack)
					enforceRBTreePropertiesAfterInsert(newNode);
				// otherwise continue recursive search for location to insert
			} else
				insertHelper(newNode, subtree.leftChild);
		}

		// store newNode within the right subtree of subtree
		else {
			if (subtree.rightChild == null) { // right subtree empty, add here
				subtree.rightChild = newNode;
				newNode.parent = subtree;
				// add RBT Specifications
				if (!newNode.isBlack)
					enforceRBTreePropertiesAfterInsert(newNode);
				// otherwise continue recursive search for location to insert
				// otherwise continue recursive search for location to insert
			} else
				insertHelper(newNode, subtree.rightChild);
		}
	}

	/**
	 * This method performs a level order traversal of the tree. The string
	 * representations of each data value within this tree are assembled into a
	 * comma separated string within brackets (similar to many implementations of
	 * java.util.Collection, like java.util.ArrayList, LinkedList, etc).
	 * 
	 * @return string containing the values of this tree in level order
	 */
	@Override
	public String toString() {
		return root.toString();
	}

	/**
	 * Performs the rotation operation on the provided nodes within this BST. When
	 * the provided child is a leftChild of the provided parent, this method will
	 * perform a right rotation (sometimes called a left-right rotation). When the
	 * provided child is a rightChild of the provided parent, this method will
	 * perform a left rotation (sometimes called a right-left rotation). When the
	 * provided nodes are not related in one of these ways, this method will throw
	 * an IllegalArgumentException.
	 * 
	 * @param child  is the node being rotated from child to parent position
	 *               (between these two node arguments)
	 * @param parent is the node being rotated from parent to child position
	 *               (between these two node arguments)
	 * @throws IllegalArgumentException when the provided child and parent node
	 *                                  references are not initially (pre-rotation)
	 *                                  related that way
	 */
	private void rotate(Node<T> child, Node<T> parent) throws IllegalArgumentException {
		if (child.isLeftChild()) {
			if (parent.equals(root)) {
				root = child;
			} else if (parent.isLeftChild()) {
				parent.parent.leftChild = child;
			} else {
				parent.parent.rightChild = child;
			}
			Node<T> grandparent = parent.parent;
			Node<T> temp = child.rightChild;
			child.rightChild = parent;
			parent.leftChild = temp;
			parent.parent = child;
			child.parent = grandparent;
		} else {
			if (parent.equals(root)) {
				root = child;
			} else if (parent.isLeftChild()) {
				parent.parent.leftChild = child;
			} else {
				parent.parent.rightChild = child;
			}
			Node<T> grandparent = parent.parent;
			Node<T> temp = child.leftChild;
			child.leftChild = parent;
			parent.rightChild = temp;
			parent.parent = child;
			child.parent = grandparent;
		}

	}

	/**
	 * The job of this enforceRBTreePropertiesAfterInsert method is to resolve red
	 * child under red parent red black tree property violations that are introduced
	 * by inserting new nodes into a red black tree. While doing so, all other red
	 * black tree properties must also be preserved.
	 * 
	 * @param newNode reference to a newly added red node
	 */
	private void enforceRBTreePropertiesAfterInsert(Node<T> newNode) {
		if (newNode.parent.isBlack)
			return;
		else { // parent is red
			Node<T> parentNode = newNode.parent;
			Node<T> parentSiblingNode;
			Node<T> grandparentNode = parentNode.parent;
			if (parentNode.isLeftChild()) { // grabs parent sibling
				parentSiblingNode = grandparentNode.rightChild;
			} else {
				parentSiblingNode = grandparentNode.leftChild;
			}
			if (parentSiblingNode == null || parentSiblingNode.isBlack) { // uncle is black
				if ((!parentNode.isLeftChild() && newNode.isLeftChild())
						|| (parentNode.isLeftChild() && !newNode.isLeftChild())) { // uncle is same branch with child
					rotate(newNode, parentNode);
					enforceRBTreePropertiesAfterInsert(parentNode);
				} else { //uncle is opposite branch with child
					rotate(parentNode, grandparentNode);
					parentNode.isBlack = true;
					grandparentNode.isBlack = false;
				}
			} else { // uncle is red
				parentNode.isBlack = true;
				parentSiblingNode.isBlack = true;
				grandparentNode.isBlack = false;
				root.isBlack = true;
				enforceRBTreePropertiesAfterInsert(parentNode);
			}
		}
	}

	// For the next two test methods, review your notes from the Module 4: Red
	// Black Tree Insertion Activity. Questions one and two in that activity
	// presented you with an initial BST and then asked you to trace the
	// changes that would be applied as a result of performing different
	// rotations on that tree. For each of the following tests, you'll first
	// create the initial BST that you performed each of these rotations on.
	// Then apply the rotations described in that activity: the right-rotation
	// in the Part1 test below, and the left-rotation in the Part2 test below.
	// Then ensure that these tests fail if and only if the level ordering of
	// tree values dose not match the order that you came up with in that
	// activity.

//	@Test
//	public void week04ActivityTestPart1() {
//		// TODO: Implement this method to recreate the example from:
//		// Module 04: Red Black Tree Insert Activity - Step 1 (right rotation).
//		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
//		tree.insert(49);
//		tree.insert(25);
//		tree.insert(67);
//		tree.insert(16);
//		tree.insert(32);
//		tree.insert(57);
//		tree.insert(82);
//
//		Node<Integer> child = tree.root.leftChild;
//		Node<Integer> parent = tree.root;
//		tree.rotate(child, parent);
//		if (!tree.toString().equals("[25, 16, 49, 32, 67, 57, 82]"))
//			fail("This test has not been implemented.");
//	}

//	@Test
//	public void week04ActivityTestPart2() {
//		// TODO: Implement this method to recreate the example from:
//		// Module 04: Red Black Tree Insert Activity - Step 2 (left rotation).
//		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
//		tree.insert(49);
//		tree.insert(25);
//		tree.insert(67);
//		tree.insert(16);
//		tree.insert(32);
//		tree.insert(57);
//		tree.insert(82);
//
//		Node<Integer> child = tree.root.leftChild.rightChild;
//		Node<Integer> parent = tree.root.leftChild;
//		tree.rotate(child, parent);
//		if (!tree.toString().equals("[49, 32, 67, 25, 57, 82, 16]")) 
//			fail("This test has not been implemented.");
//	}

}
