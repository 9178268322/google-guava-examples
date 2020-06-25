package preconditions.ip;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * This test class contains some useful
 * classes and functions to simplify our requirment easily.
 */
public class GuavaTest {

    /**
     * This test used Joiner class.
     */
    @Test
    public void testMapJoiner() {

        String expectedString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        LinkedHashMap<String, String> testMap = new LinkedHashMap<>();
        testMap.put("Washington D.C", "Redskins");
        testMap.put("New York City", "Giants");
        testMap.put("Philadelphia", "Eagles");
        testMap.put("Dallas", "Cowboys");

        String returnedString = Joiner.on("#").withKeyValueSeparator("=").join(testMap);
        assertThat(returnedString, is(expectedString));
    }

    /**
     * This test used CharMatcher class.
     */
    @Test
    public void testRemoveWhiteSpace() {
        String tabsAndSpaces = "String with     spaces and          tabs";
        String expected = "String with spaces and tabs";
        String scrubed = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, ' ');
        assertThat(expected, is(scrubed));
    }

    /**
     * This test used CharMatcher class.
     */
    @Test
    public void testTrimRemoveWhiteSpace() {
        String tabsAndSpaces = "     String with     spaces and          tabs";
        String expected = "String with spaces and tabs";
        String scrubed = CharMatcher.WHITESPACE.trimAndCollapseFrom(tabsAndSpaces, ' ');
        assertThat(expected, is(scrubed));
    }

    /**
     * This test used CharMatcher class.
     */
    @Test
    public void testRetainFrom() {
        String lettersAndNumbers = "foo989yxbar234";
        String expected = "989234";
        String retained = CharMatcher.JAVA_DIGIT.retainFrom(lettersAndNumbers);
        assertThat(retained, is(expected));
    }
}
