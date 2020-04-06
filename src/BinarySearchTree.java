public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {
    private static class TreeNode<E> {
        private E element;
        private TreeNode<E> left;
        private TreeNode<E> right;
        private int size;

        public TreeNode(E element) {
            this.element = element;
        }
    }

    protected TreeNode<E> root;
    protected int size = 0;

    public BinarySearchTree() {
    }

    public BinarySearchTree(E[] objects) {
        for (int index = 0; index < objects.length; index++) {
            insert(objects[index]);
        }
    }

    protected TreeNode<E> createNewNode(E element) {
        return new TreeNode<>(element);
    }

    @Override
    public boolean insert(E element) {
        if (root == null) {
            root = createNewNode(element);
        } else {
            /*Locate the parent Node*/
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (element.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (element.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else return false; /*Duplicate node not inserted*/
            }
            if (element.compareTo(parent.element) < 0)
                parent.left = createNewNode(element);
            else
                parent.right = createNewNode(element);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    @Override
    public int getSize() {
        return size;
    }

    protected void inOrder(TreeNode<E> root) {
        if (root == null) return;
        inOrder(root.right);
        System.out.println(root.element + " ");
        inOrder(root.left);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    public boolean search(E element) {
        TreeNode<E> current = root;
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                current = current.right;
            } else return true;
        }
        return false;
    }


}