package com.ip.collections;

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
 * This test class is used to test the functiond
 * of ListUtility class.
 */
public class ListsUtilityTest {

    private static ListsUtility utility;
    private static List<Persion> persionList;
    private static final int NO_OF_PARTITION = 2;

    private static Persion persion1;
    private static Persion persion2;
    private static Persion persion3;
    private static Persion persion4;

    @BeforeTest
    public void init() {
        utility = new ListsUtility();

        persion1 = new Persion("Wilma", "Flintstone", "F", 30);
        persion2 = new Persion("Fred", "Flintstone", "M", 32);
        persion3 = new Persion("Betty", "Rubble", "F", 31);
        persion4 = new Persion("Barney", "Rubble", "M", 33);
        persionList = Lists.newArrayList(persion1, persion2, persion3, persion4);
    }

    @Test
    public void testPartition() {
        List<List<Persion>> sublist = utility.doPartition(persionList, NO_OF_PARTITION);
        assertThat(sublist.size() == 2 && sublist.get(0).contains(persion1) && sublist.get(0).contains(persion2),
                is(true));
        assertThat(sublist.size() == 2 && sublist.get(1).contains(persion3) && sublist.get(1).contains(persion4),
                is(true));
    }

    @Test
    public void testPartitionWithNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> utility.doPartition(null, NO_OF_PARTITION));
    }

    @Test
    public void testPartitionWithEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> utility.doPartition(new ArrayList<>(), NO_OF_PARTITION));
    }
}
