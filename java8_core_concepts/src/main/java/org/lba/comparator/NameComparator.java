package org.lba.comparator;

import java.util.Comparator;

public class NameComparator implements Comparator<SampleObject> {
 
    @Override
    public int compare(SampleObject emp1, SampleObject emp2) {
        return emp1.getName().compareTo(emp2.getName());
    }

}
