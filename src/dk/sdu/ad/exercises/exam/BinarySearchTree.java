package dk.sdu.ad.exercises.exam;
// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

import dk.sdu.ad.exercises.exam.UnderflowException;
import org.w3c.dom.Node;

import java.awt.image.BandCombineOp;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 *
 * @author Mark Allen Weiss
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    /**
     * Construct the tree.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     *
     * @param x the item to insert.
     */
    public void insert(AnyType x) {
        root = insert(x, root);
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     *
     * @param x the item to remove.
     */
    public void remove(AnyType x) {
        root = remove(x, root);
    }

    /**
     * Find the smallest item in the tree.
     *
     * @return smallest item or null if empty.
     */
    public AnyType findMin() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        return findMin(root).element;
    }

    /**
     * Find the largest item in the tree.
     *
     * @return the largest item of null if empty.
     */
    public AnyType findMax() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        return findMax(root).element;
    }

    /**
     * Find an item in the tree.
     *
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    /**
     * Internal method to insert into a subtree.
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return new BinaryNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     *
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return t;   // Item not found; do nothing

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t != null)
            while (t.right != null)
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return false;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order.
     *
     * @param t the node that roots the subtree.
     */
    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    /**
     * Internal method to compute height of a subtree.
     *
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );
    }

    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType> {
        // Constructors
        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }


    /**
     * The tree root.
     */
    private BinaryNode<AnyType> root;

    private BinaryNode getRoot() {
        return this.root;
    }

    private static int findNumberOfTwigs(BinaryNode node) {
        int twigs = 0;
        if (node != null) {
            Queue<BinaryNode> nodes = new LinkedList<BinaryNode>();
            nodes.offer(node);
            int noOfC = 0;
            BinaryNode candidates[] = new BinaryNode[50];
            while (nodes.size() != 0) {
                BinaryNode currentNode = nodes.poll();

                if (currentNode.left == null && currentNode.right != null &&
                        hasOneChild(currentNode.right))
                    candidates[noOfC++] = currentNode.right;
                if (currentNode.left != null && currentNode.right == null &&
                        hasOneChild(currentNode.left))
                    candidates[noOfC++] = currentNode.left;

                if (currentNode.left != null) {
                    nodes.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    nodes.offer(currentNode.right);
                }
            }

            for (int i = 0; i < noOfC; i++) {
                if ((candidates[i].left != null && candidates[i].right == null &&
                        candidates[i].left.left != null && candidates[i].left.right != null
                        && isLeaf(candidates[i].left.left) && isLeaf(candidates[i].left.right))
                        ||
                        (candidates[i].left == null && candidates[i].right != null &&
                                candidates[i].right.left != null &&
                                candidates[i].right.right != null &&
                                isLeaf(candidates[i].right.left) &&
                                isLeaf(candidates[i].right.right)))
                    twigs++;

            }

        }
        return twigs;
    }

    private static boolean hasOneChild(BinaryNode node) {
        if (node.left == null && node.right == null)
            return false;
        else if (node.left != null && node.right != null)
            return false;
        else return true;
    }

    private static boolean isLeaf(BinaryNode node) {
        if (node.left == null && node.right == null)
            return true;
        else
            return false;
    }


    // Test program
    public static void main(String[] args) throws UnderflowException {
        // create a new BinarySearchTree object
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        int[] arr = new int[]{22,10,36,8,15,26,40,6,11,24,28,45,2,7,13,27,30,48,12,14,29,32,46,50};

        // insert nodes into the tree
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }

        // search for a value in the tree
        int height = tree.height(tree.getRoot());
        System.out.println(height);
        System.out.println(tree.getRoot().element);
//        tree.printTree();
        System.out.println(findNumberOfTwigs(tree.getRoot()));

    }
}
