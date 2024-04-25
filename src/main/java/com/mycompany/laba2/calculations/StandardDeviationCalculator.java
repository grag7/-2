
package com.mycompany.laba2.calculations;
import java.util.List;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class StandardDeviationCalculator {
    public double calculateStandartDeviation(List<Double> list){
        DescriptiveStatistics statistics = new DescriptiveStatistics();
        for(Double d: list) {
            statistics.addValue(d);
        }
        
        return statistics.getStandardDeviation();
    }
}
