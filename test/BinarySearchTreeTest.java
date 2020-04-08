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
        assertTrue(binarySearchTree.search("George"));
    }

    @DisplayName("Kiểm tra phần tử tồn tại trong tree tại sub-node")
    @Test
    void testSearchExistInTreeCase2() {
        assertTrue(binarySearchTree.search("John"));
    }

    @DisplayName("Kiểm tra phần tử không tồn tại trong tree")
    @Test
    void testSearchNotExistInTree() {
        assertFalse(binarySearchTree.search("Nam"));
    }

    @DisplayName("Kiểm tra size tăng lên sau khi thêm phần tử bằng thêm đệ quy ")
    @Test
    void testSizeIncreaseAfterInsertRecursive() {
        int sizePre = binarySearchTree.getSize();
        binarySearchTree.insertRecursive("Duc");
        int sizePost = binarySearchTree.getSize();
        assertEquals(sizePre + 1, sizePost);
    }

    @DisplayName("Xoá phần tử ở Node lá TH1 và size giảm sau khi xoá")
    @Test
    void testRemoveLeafNodeCase1() {
        int sizePre = binarySearchTree.getSize();
        binarySearchTree.remove("Daniel");
        int sizePost = binarySearchTree.getSize();
        assertFalse(binarySearchTree.search("Daniel"));
        assertEquals(sizePre - 1, sizePost);
    }

    @DisplayName("Xoá phần tử ở Node lá TH2 và size giảm sau khi xoá")
    @Test
    void testRemoveLeafNodeCase2() {
        int sizePre = binarySearchTree.getSize();
        binarySearchTree.remove("Peter");
        int sizePost = binarySearchTree.getSize();
        assertFalse(binarySearchTree.search("Peter"));
        assertEquals(sizePre - 1, sizePost);
    }

    @DisplayName("Xoá phần tử có 1 Node con và size giảm sau khi xoá")
    @Test
    void testRemoveNodeHas1Child() {
        int sizePre = binarySearchTree.getSize();
        binarySearchTree.remove("Tom");
        int sizePost = binarySearchTree.getSize();
        assertFalse(binarySearchTree.search("Tom"));
        assertEquals(sizePre - 1, sizePost);
    }

    @DisplayName("Xoá phần tử có 2 Node con")
    @Test
    void testRemoveNodeHas2Child() {
        binarySearchTree.remove("Michael");
        assertFalse(binarySearchTree.search("Michael"));
    }

    @DisplayName("Tìm phần tử tồn tại trong list bằng Đệ quy tìm kiếm nhị phân")
    @Test
    void testBinarySearchRecursiveExistData() {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        int valueToFind = 79;
        int expectedIndex = 12;
        assertEquals(expectedIndex, BinarySearch.binarySearchRecursive(list, valueToFind));
    }

    @DisplayName("Tìm phần tử không tồn tại trong list ở cuối list bằng Đệ quy tìm kiếm nhị phân")
    @Test
    void testBinarySearchRecursiveNonExistDataEnd() {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        int valueToFind = 80;
        int expectedIndex = -1;
        assertEquals(expectedIndex, BinarySearch.binarySearchRecursive(list, valueToFind));
    }

    @DisplayName("Tìm phần tử không tồn tại trong list ở vị trí giữa bằng Đệ quy tìm kiếm nhị phân")
    @Test
    void testBinarySearchRecursiveNonExistDataMiddle() {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        int valueToFind = 12;
        int expectedIndex = -1;
        assertEquals(expectedIndex, BinarySearch.binarySearchRecursive(list, valueToFind));
    }

    @DisplayName("Tìm phần tử không tồn tại trong list ở vị trí đầu bằng Đệ quy tìm kiếm nhị phân")
    @Test
    void testBinarySearchRecursiveNonExistDataBegin() {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        int valueToFind = 1;
        int expectedIndex = -1;
        assertEquals(expectedIndex, BinarySearch.binarySearchRecursive(list, valueToFind));
    }

    @DisplayName("Kiểm tra phần tử tồn tại trong tree tại root dùng tìm kiếm đệ quy")
    @Test
    void testSearchRecursiveExistInTreeCase1() {
        assertTrue(binarySearchTree.searchRecursive("George"));
    }

    @DisplayName("Kiểm tra phần tử tồn tại trong tree tại sub-node dùng tìm kiếm đệ quy")
    @Test
    void testSearchRecursiveExistInTreeCase2() {
        assertTrue(binarySearchTree.searchRecursive("John"));
    }

    @DisplayName("Kiểm tra phần tử không tồn tại trong tree dùng tìm kiếm đệ quy")
    @Test
    void testSearchRecursiveNotExistInTree() {
        assertFalse(binarySearchTree.searchRecursive("Nam"));
    }
}