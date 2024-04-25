
package com.mycompany.laba2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.*;


public class ExcelWritter {
    public void saveToFile(File file, ArrayList<List<String>> outPut)
            throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Результаты расчёта");
        XSSFRow row;
        XSSFCell cell;
        String[] indicatorsInfo =
            {"Cреднее геометрическое:",
             "Среднее арифметическое:",
             "Оценка стандартного отклонения:",
             "Размах:",
             "Коэффициенты ковариации:",
             "Количество элементов",
             "Коэффициент вариации",
             "Доверительный интервал:",
             "Оценка дисперии:",
             "Минимум и максимум:"};

        
        for(int i=0; i < indicatorsInfo.length; i++) {
            row = sheet.createRow(i);
            
            cell = row.createCell(0);
            cell.setCellValue(indicatorsInfo[i]);
            for(int j=0; j < outPut.size(); j++){
                cell = row.createCell(j+1);
                cell.setCellValue(outPut.get(j).get(i));
                sheet.autoSizeColumn(j);
            }
            
        }
        
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        
    }
    
    
}
