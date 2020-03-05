package org.lba.comparator;

import java.util.Comparator;

public class BooleanComparator implements Comparator<SampleObject> {
 
    @Override
    public int compare(SampleObject emp1, SampleObject emp2) {
        return emp1.getIsValue().compareTo(emp2.getIsValue());
    }

}
