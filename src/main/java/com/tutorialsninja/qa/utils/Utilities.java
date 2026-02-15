package com.tutorialsninja.qa.utils;

import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Date;

public class Utilities {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public static String GenerateEmailWithTimeStamp() {
        Date dt = new Date();
        String timeStamp = dt.toString().replace(" ", "_").replace(":", "_");
        return "krshou" + timeStamp + "@gmail.com";
    }

    public static Object[][] getTestDataFormExcel() {
        try {
            FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\TutorialsNinjaTestData.xlsx");
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("Sheet1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int numRows = sheet.getLastRowNum();
        int numCols = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[numRows][numCols];

        for (int i = 1; i <= numRows; i++) {
            for (int j = 0; j < numCols ; j++) {
                CellType cellType = sheet.getRow(i).getCell(j).getCellType();
                switch (cellType) {
                    case STRING:
                        data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i-1][j] = Integer.toString((int) sheet.getRow(i).getCell(j).getNumericCellValue());
                        break;
                    case BOOLEAN:
                        data[i-1][j] = sheet.getRow(i).getCell(j).getBooleanCellValue();
                        break;
                }
            }
        }

        return data;

    }
}
