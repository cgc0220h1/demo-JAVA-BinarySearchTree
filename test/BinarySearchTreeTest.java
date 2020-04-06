import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<String> tree = new BinarySearchTree<>();

    @BeforeEach
    void createTree() {
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("John");
        tree.insert("Peter");
        tree.insert("Daniel");
    }

    @DisplayName("Kiểm tra phần tử tồn tại trong tree tại root")
    @Test
    void testSearchExistInTreeCase1() {
        assertTrue(tree.search("George"));
    }

    @DisplayName("Kiểm tra phần tử tồn tại trong tree tại sub-node")
    @Test
    void testSearchExistInTreeCase2() {
        assertTrue(tree.search("John"));
    }

    @DisplayName("Kiểm tra phần tử không tồn tại trong tree")
    @Test
    void testSearchNotExistInTree() {
        assertFalse(tree.search("Nam"));
    }
}