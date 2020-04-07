public interface Tree<E> {
    /**
     * Insert element e into the binary search tree.
     * Return true if the element is inserted successfully.
     */

    boolean insert(E element);

    /**
     * In-order traversal from the root
     */

    void inOrderDisplay();

    /**
     * Pre-order traversal from the root
     */

    void preOrderDisplay();

    /**
     * Post-order traversal from the root
     */

    void postOrderDisplay();

    /**
     * Get the number of nodes in the tree
     */

    int getSize();
}
