
package com.mycompany.laba2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Mediator {
private final ExcelReader excelReader = new ExcelReader();
private final ExcelWritter excelWritter = new ExcelWritter();
private final CalculationRepository calculationRepository = new CalculationRepository();
private ArrayList<Double[]> samples = new ArrayList<>();
private ArrayList<List<String>> outPut;

public void getDataFromFile(String sheetName) throws IOException{
    samples = excelReader.readDataFromSheet(sheetName);
}
public ExcelReader getExcelReader() {
        return excelReader;
    } 
 public void writeToFile(File file) throws IOException {
        excelWritter.saveToFile(file, outPut);
    }
    
 public void  Calculation(){
        outPut = calculationRepository.start( samples);
    }
}
