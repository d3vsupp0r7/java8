package org.lba.comparator;

import java.util.Comparator;

public class StatusComparator implements Comparator<SampleObject> {
 
    @Override
    public int compare(SampleObject emp1, SampleObject emp2) {
        return emp1.getStatus().compareTo(emp2.getStatus());
    }

}
