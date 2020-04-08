public class Main {
    public static void main(String[] args) {
        /*create a Binary Search Tree
                        George
                      /         \
                    Adam      Michael
                       \       /    \
                    Daniel   John   Tom
                                    /
                                  Peter
         */
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.insertRecursive("George");
        tree.insertRecursive("Michael");
        tree.insertRecursive("Tom");
        tree.insertRecursive("Adam");
        tree.insertRecursive("John");
        tree.insertRecursive("Peter");
        tree.insertRecursive("Daniel");
        tree.insertRecursive("John");
        tree.insertRecursive("Daniel");
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

        //Delete exist element
        System.out.println("Delete node George: ");
        tree.remove("George");
        tree.inOrderDisplay();
        System.out.println("The Number of node is: " + tree.getSize());
        System.out.println("-------------------------");

        //Delete non-exist element
        System.out.println("Delete node Nam: ");
        tree.remove("Nam");
        tree.inOrderDisplay();
        System.out.println("The Number of node is: " + tree.getSize());
        System.out.println("-------------------------");

        //Binary Search
        System.out.println("Binary Search");
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        System.out.println(BinarySearch.binarySearch(list, 2));  /* 0 */
        System.out.println(BinarySearch.binarySearch(list, 11)); /* 4 */
        System.out.println(BinarySearch.binarySearch(list, 79)); /*12 */
        System.out.println(BinarySearch.binarySearch(list, 1));  /*-1 */
        System.out.println(BinarySearch.binarySearch(list, 5));  /*-1 */
        System.out.println(BinarySearch.binarySearch(list, 80)); /*-1 */
    }
}
