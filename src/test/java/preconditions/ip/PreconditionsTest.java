package preconditions.ip;

import com.ip.preconditions.PreconditionExample;
import org.testng.annotations.Test;

/**
 * This test class is used to operate an object
 * by passing valid value.
 */
public class PreconditionsTest {

    @Test
    public void testPreconditions() {
        String str = "open";
        PreconditionExample pre = new PreconditionExample(str);
        pre.updateCurrentIndexValue(4, 10);
        pre.doOperation();
    }
}
