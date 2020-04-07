import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

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

    public boolean isContains(E element) {
        if (root.element == element) {
            return true;
        }
        return search(element) != null;
    }

    public TreeNode<E>[] search(E element) {
        TreeNode<E> current = root;
        TreeNode<E> parent = null;
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else return new TreeNode[]{parent, current};
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inOrderDisplay() {
        inOrderDisplay(root);
    }

    protected void inOrderDisplay(TreeNode<E> node) {
        if (node == null) return;
        inOrderDisplay(node.left);
        System.out.println(node.element + " ");
        inOrderDisplay(node.right);
    }

    public void preOrderDisplay() {
        preOrderDisplay(root);
    }

    protected void preOrderDisplay(TreeNode<E> node) {
        if (node == null) return;
        System.out.println(node.element + " ");
        preOrderDisplay(node.left);
        preOrderDisplay(node.right);
    }

    public void postOrderDisplay() {
        postOrderDisplay(root);
    }

    protected void postOrderDisplay(TreeNode<E> node) {
        if (node == null) return;
        postOrderDisplay(node.left);
        postOrderDisplay(node.right);
        System.out.println(node.element + " ");
    }

    public boolean delete(E value) {
        return deleteRecursively(root,value) != null;
    }

    public TreeNode<E> deleteRecursively(TreeNode<E> node, E element) {
        if (node == null)
            return null;
        if (element.compareTo(node.element) < 0) {
            node.left = deleteRecursively(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = deleteRecursively(node.right, element);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null)
                return node.left;
            node.element = findRightMost(node.left);
            node.left = deleteRecursively(node.left,node.element);
        }
        return node;
    }

    private E findRightMost(TreeNode<E> treeNode) {
        TreeNode<E> current = treeNode;
        while (current.right != null) {
            current = current.right;
        }
        return current.element;
    }
}