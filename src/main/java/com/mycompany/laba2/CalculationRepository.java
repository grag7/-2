
package com.mycompany.laba2;

import com.mycompany.laba2.calculations.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class CalculationRepository {
    private final ArithmeticMeanCalculator arithmeticMeanCalculator;
    private final CoefficientOfVariationCalculator coefficientOfVariationCalculator;
    private final ConfidenceIntervalCalculator confidenceIntervalCalculator;
    private final CovarianceCalculator covarianceCalculator;
    private final ElementCountCalculator elementCountCalculator;
    private final GeometricMeanCalculator geometricMeanCalculator;
    private final MinMaxCalculator minMaxCalculator;
    private final RangeCalculator rangeCalculator;
    private final StandardDeviationCalculator standardDeviationCalculator;
    private final VarianceEstimationCalculator varianceEstimationCalculator;
    private ArrayList<List<String>> outPut = new ArrayList<>();
    
    
    
    public CalculationRepository() {
        arithmeticMeanCalculator = new ArithmeticMeanCalculator();
        coefficientOfVariationCalculator = new CoefficientOfVariationCalculator();
        confidenceIntervalCalculator = new ConfidenceIntervalCalculator();
        covarianceCalculator = new CovarianceCalculator();
        elementCountCalculator = new ElementCountCalculator();
        geometricMeanCalculator = new GeometricMeanCalculator();
        minMaxCalculator = new MinMaxCalculator();
        rangeCalculator = new RangeCalculator();
        standardDeviationCalculator = new StandardDeviationCalculator();
        varianceEstimationCalculator = new VarianceEstimationCalculator();   
    }
    
    public ArrayList<List<String>> start(ArrayList<Double[]> list){
        ArrayList<List<Double>> listNew = new ArrayList<>();
        outPut = new ArrayList<>(); // список списков результатов определенной выборке
        for(Double[] array: list){
               ArrayList<Double> sample = new ArrayList<>(Arrays.asList(array));
               sample.removeAll(Collections.singleton(null));
               listNew.add(sample);
               outPut.add(new ArrayList<>());
        }
        
        calculateItems(listNew);
        return outPut;

    }
    
    public void calculateItems(ArrayList<List<Double>> list) {
        int count = 0;
        
        for(List<Double> sample: list) {
            
            ArrayList<String> result = (ArrayList<String>) outPut.get(count);
            result.add(String.valueOf(geometricMeanCalculator.GeometricMean(sample)));
            result.add(String.valueOf(arithmeticMeanCalculator.ArithmeticMean(sample)));
            result.add(String.valueOf(standardDeviationCalculator.
                    calculateStandartDeviation(sample)));
            result.add(String.valueOf(rangeCalculator.Range(sample)));
            

            String covariance = "";
            int anotherCount = 0;
            for(List<Double> anotherSample: list) {
                if(anotherCount != count) {
                    covariance += String.valueOf(covarianceCalculator.
                            Covariance(sample, anotherSample)) + " ";
                }
                anotherCount++;
            }
            
            result.add(covariance);
            result.add(String.valueOf(elementCountCalculator.ElementCount(sample)));
            result.add(String.valueOf(coefficientOfVariationCalculator.Variance(sample)));
            result.add(String.valueOf(Arrays.toString(confidenceIntervalCalculator.
                    ConfidenceInterval(sample))));
            result.add(String.valueOf(varianceEstimationCalculator.VarianceEstimation(sample)));
            result.add(String.valueOf(Arrays.toString(minMaxCalculator.calculateMinMax(sample))));
            count += 1;
            Collections.replaceAll(result, "NaN", "Невычисляемо.");
        }
    }
   
}
