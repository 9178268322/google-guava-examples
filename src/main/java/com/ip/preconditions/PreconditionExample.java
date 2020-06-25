package com.ip.preconditions;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * This class is used for to check condtions of a data
 * before proceding.
 */
public class PreconditionExample {

    private final transient String label;
    private final transient int[] values = new int[5];
    private static int currentIndex;
    private static final int VALUE_RANGE = 100;

    public PreconditionExample(String label) {
        //returns value of object if not null
        this.label = checkNotNull(label, "label can't be null");
    }

    public void updateCurrentIndexValue(int index, int valueToTest) {
        // check index valid first
        this.currentIndex = checkElementIndex(index, values.length, "Index out of bounds for values");
        // Validate value test
        checkArgument(valueToTest <= VALUE_RANGE, "Value can't be more than 100");
        values[this.currentIndex] = valueToTest;
    }

    public void doOperation() {
        checkState(validateObjectState(), "can't perform operation");
    }

    private boolean validateObjectState() {
        return this.label.equalsIgnoreCase("open") && values[this.currentIndex] == 10;
    }
}
