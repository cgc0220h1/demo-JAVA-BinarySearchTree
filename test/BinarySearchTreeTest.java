import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();

    @BeforeEach
    void createTree() {
        binarySearchTree.insert("George");
        binarySearchTree.insert("Michael");
        binarySearchTree.insert("Tom");
        binarySearchTree.insert("Adam");
        binarySearchTree.insert("John");
        binarySearchTree.insert("Peter");
        binarySearchTree.insert("Daniel");
    }

    @DisplayName("Kiểm tra phần tử tồn tại trong tree tại root")
    @Test
    void testSearchExistInTreeCase1() {
        assertTrue(binarySearchTree.isContains("George"));
    }

    @DisplayName("Kiểm tra phần tử tồn tại trong tree tại sub-node")
    @Test
    void testSearchExistInTreeCase2() {
        assertTrue(binarySearchTree.isContains("John"));
    }

    @DisplayName("Kiểm tra phần tử không tồn tại trong tree")
    @Test
    void testSearchNotExistInTree() {
        assertFalse(binarySearchTree.isContains("Nam"));
    }

    @DisplayName("Xoá phần tử ở Node lá TH1")
    @Test
    void testRemoveLeafNodeCase1() {
        binarySearchTree.delete("Daniel");
        assertFalse(binarySearchTree.isContains("Daniel"));
    }

    @DisplayName("Xoá phần tử ở Node lá")
    @Test
    void testRemoveLeafNodeCase2() {
        binarySearchTree.delete("Peter");
        assertFalse(binarySearchTree.isContains("Peter"));
    }


    @DisplayName("Xoá phần tử có 1 Node con")
    @Test
    void testRemoveNodeHas1Child() {
        binarySearchTree.delete("Tom");
        assertFalse(binarySearchTree.isContains("Tom"));
    }

    @DisplayName("Xoá phần tử có 2 Node con")
    @Test
    void testRemoveNodeHas2Child() {
        assertTrue(binarySearchTree.delete("Michael"));
    }

    @DisplayName("Tìm phần tử tồn tại trong list bằng Đệ quy tìm kiếm nhị phân")
    @Test
    void testBinarySearchRecursiveExistData() {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        int valueToFind = 79;
        int expectedIndex = 12;
        assertEquals(expectedIndex,BinarySearch.binarySearchRecursive(list,valueToFind));
    }

    @DisplayName("Tìm phần tử không tồn tại trong list ở cuối list bằng Đệ quy tìm kiếm nhị phân")
    @Test
    void testBinarySearchRecursiveNonExistDataEnd() {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        int valueToFind = 80;
        int expectedIndex = -1;
        assertEquals(expectedIndex,BinarySearch.binarySearchRecursive(list,valueToFind));
    }

    @DisplayName("Tìm phần tử không tồn tại trong list ở vị trí giữa bằng Đệ quy tìm kiếm nhị phân")
    @Test
    void testBinarySearchRecursiveNonExistDataMiddle() {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        int valueToFind = 12;
        int expectedIndex = -1;
        assertEquals(expectedIndex,BinarySearch.binarySearchRecursive(list,valueToFind));
    }

    @DisplayName("Tìm phần tử không tồn tại trong list ở vị trí đầu bằng Đệ quy tìm kiếm nhị phân")
    @Test
    void testBinarySearchRecursiveNonExistDataBegin() {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        int valueToFind = 1;
        int expectedIndex = -1;
        assertEquals(expectedIndex,BinarySearch.binarySearchRecursive(list,valueToFind));
    }
}