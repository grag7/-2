
package com.mycompany.laba2.calculations;

import java.util.List;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class CoefficientOfVariationCalculator {
    public double Variance(List<Double> list) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : list) {
            stats.addValue(value);
        }
        double mean = stats.getMean();
        double standardDeviation = stats.getStandardDeviation();
        return (standardDeviation / mean) * 100;
        
    }
    
}
