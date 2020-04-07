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
        tree.inOrderDisplay();
        System.out.println("The Number of node is: " + tree.getSize());
        System.out.println("-------------------------");

        //traverse tree preorder
        System.out.println("Pre-order: ");
        tree.preOrderDisplay();
        System.out.println("The Number of node is: " + tree.getSize());
        System.out.println("-------------------------");

        //traverse tree postorder
        System.out.println("Post-order: ");
        tree.postOrderDisplay();
        System.out.println("The Number of node is: " + tree.getSize());
        System.out.println("-------------------------");

        //Delete 1 element
        System.out.println("Delete node: ");
        tree.delete("George");
        tree.inOrderDisplay();
        System.out.println("-------------------------");
    }
}
