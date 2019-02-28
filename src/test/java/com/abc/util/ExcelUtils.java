package com.abc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExcelUtils
{
    WebDriver driver;
    WebDriverWait wait;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static XSSFCell cell;

     @Test
     public static Object[][] readData(String sheetLocation, String sheetName) throws IOException
     {
         DataFormatter formatter = new DataFormatter();
         // Import excel sheet.
         File src=new File(sheetLocation);

         // Load the file.
         FileInputStream finput = new FileInputStream(src);

         // Load the workbook.
         workbook = new XSSFWorkbook(finput);

         // Load the sheet  in which data is stored.
         sheet= workbook.getSheet(sheetName);
         int RowNum = sheet.getPhysicalNumberOfRows();// count my number of Rows
         System.out.println("Number of rows is " +RowNum);

         int ColNum = sheet.getRow(0).getPhysicalNumberOfCells();
         System.out.println("Number of columns is " +ColNum);

         String Data[][]= new String[RowNum][ColNum];

         for (int i = 0; i < RowNum; i++) 
            {
             //System.out.println("First for loop entered");   
             XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < ColNum; j++) 

                {
                    //System.out.println("Second for loop entered");
                    if (row == null) {
                        Data[i][j] = "";
                    System.out.println("row = null entered");
                    }
                    else {
                        XSSFCell cell = row.getCell(j);                 
                        if (cell == null) {
                            Data[i][j] = ""; 
                        System.out.println("Cell = null entered");
                        }
                        else {
                            String value = formatter.formatCellValue(cell);
                            Data[i][j] = value.trim();                        
                        }
                    }


                }
                }       
                return Data;
          } 
     public static void main(String[] args) throws IOException {
    	 //ExcelUtils exceldata = new ExcelUtils();
    	 readData ("data.xlsx", "Sheet1");
     }
    }