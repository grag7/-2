
package com.mycompany.laba2.calculations;
import java.util.List;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class VarianceEstimationCalculator {
public double VarianceEstimation(List<Double> list) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : list) {
            stats.addValue(value);
        }
        return stats.getVariance();    }    
    
}
