package com.ip.collections;

import com.google.common.collect.Sets;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static  org.hamcrest.Matchers.is;

/**
 * This test class is used to test
 * functions of SetUtility class.
 */
public class SetsUtilityTest {

    private static SetsUtility utility;

    @BeforeTest
    public void init() {
        utility = new SetsUtility();
    }

    @Test
    public void testDifference() {
        Sets.SetView<String> sv = utility.doDifference();
        assertThat(sv.contains("1"), is(true));
    }

    @Test
    public void testSymmetricDiff() {
        Sets.SetView<String> sv = utility.doSymmetricDifference();
        assertThat(sv.contains("1") && sv.contains("4"), is(true));
    }

    @Test
    public void testIntersection() {
        Sets.SetView<String> sv = utility.doIntersection();
        assertThat(sv.size() == 2 && sv.contains("2") && sv.contains("3"), is(true));
    }

    @Test
    public void testUnion() {
        Sets.SetView<String> sv = utility.doUnion();
        assertThat(sv.size() == 4 && sv.contains("1") && sv.contains("2") && sv.contains("3") && sv.contains("4"), is(true));
    }
}
