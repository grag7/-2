package com.mycompany.laba2.calculations;


import java.util.List;
import org.apache.commons.math3.stat.StatUtils;

public class ArithmeticMeanCalculator {
    public double ArithmeticMean(List<Double> list) {
        double[] data = new double[list.size()];
        int counter = 0;
        for(Double value:list ){
            data[counter++] = value;
        }
        return StatUtils.mean(data);
        
       
    }
}