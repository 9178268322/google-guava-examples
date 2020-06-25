package com.ip.collections;

import com.ip.model.Book;
import com.ip.service.BookService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.ip.service.BookService.getService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * This test class is used to test
 * functions of MapsUtility class.
 */
public class MapsUtilityTest {

    private static final BookService service = getService();
    private static MapsUtility utility;
    private static List<Book> bookList;

    private static final int KEY_1 = 1234;
    private static final int KEY_2 = 5463;
    private static final int KEY_3 = 8971;
    private static final int KEY_4 = 5590;
    private static final int KEY_5 = 6661;

    @BeforeTest
    public void init() {
        utility = new MapsUtility();
        bookList = service.getListBooks();
    }

    @Test
    public void test() {
        Map<Integer, Book> bookMap = utility.doBookStore(bookList);
        assertThat(bookMap).containsOnlyKeys(KEY_1, KEY_2, KEY_3, KEY_4, KEY_5);
    }

    @Test
    public void testUniqueIndex() {
        Map<Integer, Book> bookMap = utility.doUniquesIndex(bookList);
        assertThat(bookMap).containsOnlyKeys(KEY_1, KEY_2, KEY_3, KEY_4, KEY_5);
    }

    @Test
    public void testUniqueIndexWithNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> utility.doUniquesIndex(null));
    }

    @Test
    public void testUniqueIndexWithEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> utility.doUniquesIndex(new ArrayList<>()));
    }
}
