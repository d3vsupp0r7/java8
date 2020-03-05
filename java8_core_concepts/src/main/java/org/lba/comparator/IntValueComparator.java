package org.lba.comparator;

import java.util.Comparator;

public class IntValueComparator implements Comparator<SampleObject> {
 
    @Override
    public int compare(SampleObject emp1, SampleObject emp2) {
        return emp1.getSampleIntValue() - emp2.getSampleIntValue();
        
    }

}
