public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {
    private static class TreeNode<E> {
        private E element;
        private TreeNode<E> left;
        private TreeNode<E> right;
        private int size;

        private TreeNode(E element) {
            this.element = element;
        }
    }

    private TreeNode<E> root;
    private int size = 0;

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
    public int getSize() {
        return size;
    }

    @Override
    public void inOrderDisplay() {
        inOrderDisplay(root);
    }

    private void inOrderDisplay(TreeNode<E> node) {
        if (node == null) return;
        inOrderDisplay(node.left);
        System.out.println(node.element + " ");
        inOrderDisplay(node.right);
    }

    public void preOrderDisplay() {
        preOrderDisplay(root);
    }

    private void preOrderDisplay(TreeNode<E> node) {
        if (node == null) return;
        System.out.println(node.element + " ");
        preOrderDisplay(node.left);
        preOrderDisplay(node.right);
    }

    public void postOrderDisplay() {
        postOrderDisplay(root);
    }

    private void postOrderDisplay(TreeNode<E> node) {
        if (node == null) return;
        postOrderDisplay(node.left);
        postOrderDisplay(node.right);
        System.out.println(node.element + " ");
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

    public void insertRecursive(E element) {
        if (root == null) {
            root = createNewNode(element);
        }
        insertRecursive(root,element);
    }

    private TreeNode<E> insertRecursive(TreeNode<E> treeNode, E element) {
        if (treeNode == null) {
            treeNode = createNewNode(element);
        }
        if (element.compareTo(treeNode.element) < 0) {
            treeNode.left = insertRecursive(treeNode.left,element);
        } else if (element.compareTo(treeNode.element) > 0) {
            treeNode.right = insertRecursive(treeNode.right,element);
        }
        return treeNode;
    }

    public boolean delete(E value) {
        return deleteRecursively(root,value) != null;
    }

    private TreeNode<E> deleteRecursively(TreeNode<E> root, E element) {
        if (root == null) return null;
        if (element.compareTo(root.element) < 0) {
            root.left = deleteRecursively(root.left, element);
        } else if (element.compareTo(root.element) > 0) {
            root.right = deleteRecursively(root.right, element);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null)
                return root.left;
            root.element = findRightMost(root.left);
            root.left = deleteRecursively(root.left,root.element);
        }
        return root;
    }

    private E findRightMost(TreeNode<E> treeNode) {
        TreeNode<E> current = treeNode;
        while (current.right != null) {
            current = current.right;
        }
        return current.element;
    }

    public boolean isContains(E element) {
        if (root.element == element) {
            return true;
        }
        return searchParent(element) != null;
    }

    public TreeNode<E> searchParent(E element) {
        TreeNode<E> current = root;
        TreeNode<E> parent = null;
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else return parent;
        }
        return null;
    }

    public boolean searchRecursive(E element) {
        return searchRecursive(root,element);
    }

    private boolean searchRecursive(TreeNode<E> root, E element) {
        if (root == null) {
            return false;
        }
        if (element.compareTo(root.element) > 0) {
            return searchRecursive(root.right,element);
        } else if (element.compareTo(root.element) < 0) {
            return searchRecursive(root.left,element);
        } else return true;
    }
}