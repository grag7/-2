
package com.mycompany.laba2.calculations;
import java.util.Collections;
import java.util.List;


public class MinMaxCalculator {
    public Double[] calculateMinMax(List<Double> list) {
        return new Double[] {Collections.min(list),Collections.max(list)};
    }
}