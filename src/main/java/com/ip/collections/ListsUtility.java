package com.ip.collections;

import com.google.common.collect.Lists;
import com.ip.model.Persion;

import java.util.List;

/**
 * This class conatins partion of list of person.
 */
public class ListsUtility {

    public List<List<Persion>> doPartition(List<Persion> persionList, int noOfPartition) {
        if (persionList == null || persionList.isEmpty()) {
            throw new IllegalArgumentException("Persion list can't be null or empty");
        }
        return Lists.partition(persionList, noOfPartition);
    }
}
