package com.ip.collections;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.ip.model.Persion;

import java.util.List;

/**
 * This class contains some functions which does
 * filter and transfrom list of object.
 */
public class FluentIterableClassExamples {

    public Iterable<Persion> doFilter(List<Persion> persionList) {
        if (persionList == null || persionList.isEmpty()) {
            throw new IllegalArgumentException("Person list can't be null or empty");
        }
        Iterable<Persion> persionsFilteredByAge = FluentIterable.from(persionList).filter(new Predicate<Persion>() {
            @Override
            public boolean apply(Persion input) {
                return input.getAge() > 31;
            }
        });
        return persionsFilteredByAge;
    }

    public List<String> doTransform(List<Persion> persionList) {
        if (persionList == null || persionList.isEmpty()) {
            throw new IllegalArgumentException("Person list can't be null or empty");
        }
        List<String> transFormedPersionList = FluentIterable.from(persionList).transform(new Function<Persion, String>() {
            @Override
            public String apply(Persion input) {
                return Joiner.on("#").join(input.getFirstName(), input.getLastName(), input.getAge());
            }
        }).toList();
        return transFormedPersionList;
    }
}
