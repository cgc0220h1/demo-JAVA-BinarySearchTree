public class Main {
    public static void main(String[] args) {
        //create a Binary Search Tree
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("John");
        tree.insert("Peter");
        tree.insert("Daniel");
        //traverse tree
        System.out.println("In-order (sorted by method compareTo of super class): ");
        tree.inOrder();
        System.out.println("The Number of node is: " + tree.getSize());

        //traverse tree preorder
        System.out.println("Pre-order: ");
        tree.preOrder();
        System.out.println("The Number of node is: " + tree.getSize());
    }
}
