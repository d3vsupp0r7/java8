package org.lba.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SampleObjectChainComparator implements Comparator<SampleObject> {
 
    private List<Comparator<SampleObject>> listComparators;
 
    @SafeVarargs
    public SampleObjectChainComparator(Comparator<SampleObject>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(SampleObject emp1, SampleObject emp2) {
        for (Comparator<SampleObject> comparator : listComparators) {
            int result = comparator.compare(emp1, emp2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

}
