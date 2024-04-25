
package com.mycompany.laba2.calculations;

import java.util.List;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class ConfidenceIntervalCalculator {
    public double[] ConfidenceInterval(List<Double> list) {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        for (double value : list) {
            stats.addValue(value);
        }
        
        double mean = stats.getMean();
        double stdDeviation = stats.getStandardDeviation() / Math.sqrt(stats.getN());
        NormalDistribution normalDistribution = new NormalDistribution();
        double z = normalDistribution.inverseCumulativeProbability(1 - (1 - 0.95) / 2);

        double lowerBound = mean - z * stdDeviation;
        double upperBound = mean + z * stdDeviation;

        return new double[]{lowerBound, upperBound};
    }
     
    
}
