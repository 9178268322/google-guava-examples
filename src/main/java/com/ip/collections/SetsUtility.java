package com.ip.collections;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * This class contains some functions which does
 * difference, symmetric diff, intersection and union.
 */
public class SetsUtility {

    private static final String NUM_1 = "1";
    private static final String NUM_2 = "2";
    private static final String NUM_3 = "3";
    private static final String NUM_4 = "4";

    public Sets.SetView<String> doDifference() {
        Set<String> set1 = Sets.newHashSet(NUM_1, NUM_2, NUM_3);
        Set<String> set2 = Sets.newHashSet(NUM_3, NUM_2, NUM_4);
        return Sets.difference(set1, set2);
    }

    public Sets.SetView<String> doSymmetricDifference() {
        Set<String> set1 = Sets.newHashSet(NUM_1, NUM_2, NUM_3);
        Set<String> set2 = Sets.newHashSet(NUM_3, NUM_2, NUM_4);
        return Sets.symmetricDifference(set1, set2);
    }

    public Sets.SetView<String> doIntersection() {
        Set<String> set1 = Sets.newHashSet(NUM_1, NUM_2, NUM_3);
        Set<String> set2 = Sets.newHashSet(NUM_3, NUM_2, NUM_4);
        return Sets.intersection(set1, set2);
    }

    public Sets.SetView<String> doUnion() {
        Set<String> set1 = Sets.newHashSet(NUM_1, NUM_2, NUM_3);
        Set<String> set2 = Sets.newHashSet(NUM_3, NUM_2, NUM_4);
        return Sets.union(set1, set2);
    }

}
