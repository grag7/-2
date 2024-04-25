/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laba2.calculations;

import java.util.List;
import org.apache.commons.math3.stat.correlation.Covariance;


public class CovarianceCalculator {
    public double Covariance(List<Double> listOne, List<Double> listTwo) {
        if(listTwo.size() != listOne.size()) throw new IllegalArgumentException();
        double[] oneArray = new double[listOne.size()];
        double[] twoArray = new double[listTwo.size()];
        Covariance covariance = new Covariance();
        

        for(int i=0; i < listOne.size(); i++) {
            oneArray[i] = listOne.get(i);
            twoArray[i] = listTwo.get(i);
            
        }
        
        return covariance.covariance(oneArray,  twoArray);
    
}
}
