
package com.mycompany.laba2.calculations;

import java.util.Collections;
import java.util.List;


public class RangeCalculator {
    public double Range(List<Double> list) {
        return (double) (Collections.max(list) - Collections.min(list));
    }
    
}
