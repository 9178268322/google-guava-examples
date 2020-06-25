package com.ip.collections;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.ip.model.Persion;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * This test class is used to test functions of
 * FluentIterableClassExamples class.
 */
public class FluentIterableClassExamplesTest {

    private static FluentIterableClassExamples fluent;
    private static List<Persion> listOfPersions;
    private static Iterable<Persion> filtered;
    private static List<String> transformedPersion;

    private static Persion persion1;
    private static Persion persion2;
    private static Persion persion3;
    private static Persion persion4;

    @BeforeTest
    public void init() {
        persion1 = new Persion("Wilma", "Flintstone", "F", 30);
        persion2 = new Persion("Fred", "Flintstone", "M", 32);
        persion3 = new Persion("Betty", "Rubble", "F", 31);
        persion4 = new Persion("Barney", "Rubble", "M", 33);
        listOfPersions = Lists.newArrayList(persion1, persion2, persion3, persion4);
        fluent = new FluentIterableClassExamples();
    }

    @Test
    public void testFileter() {
        filtered = fluent.doFilter(listOfPersions);

        assertThat(Iterables.contains(filtered, persion1), is(false));
        assertThat(Iterables.contains(filtered, persion2), is(true));
        assertThat(Iterables.contains(filtered, persion3), is(false));
        assertThat(Iterables.contains(filtered, persion4), is(true));
    }

    @Test
    public void testFileterWithNull() {
      assertThatIllegalArgumentException().isThrownBy(() -> fluent.doFilter(null));
    }

    @Test
    public void testFileterWithEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> fluent.doFilter(new ArrayList<>()));
    }

    @Test
    public void testTransform() {
        transformedPersion = fluent.doTransform(listOfPersions);

        assertThat(transformedPersion.get(0), is("Wilma#Flintstone#30"));
        assertThat(transformedPersion.get(1), is("Fred#Flintstone#32"));
        assertThat(transformedPersion.get(2), is("Betty#Rubble#31"));
        assertThat(transformedPersion.get(3), is("Barney#Rubble#33"));
    }

    @Test
    public void testTransformWithNull() {
       assertThatIllegalArgumentException().isThrownBy(() -> fluent.doTransform(null));
    }

    @Test
    public void testTransformWithEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> fluent.doTransform(new ArrayList<>()));
    }
}
