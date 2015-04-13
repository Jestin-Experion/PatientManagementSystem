package com.experion.pms.util;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

private static String dest = "D:\\PMS_SearchResult.xlsx";
private static XSSFWorkbook  myWorkBook = new XSSFWorkbook ();
private static XSSFSheet mySheet = myWorkBook.createSheet();
private static int rowSize=0;

public void insertData(int numRow,String name,String regNo,String gender){
	
            excelLog(rowSize, 0,name);
            excelLog(rowSize, 1,regNo);
            excelLog(rowSize++, 2,gender);           
   
    try {
        FileOutputStream out = new FileOutputStream(dest);
        myWorkBook.write(out);
        out.close();        
    } catch (Exception e) {
        e.printStackTrace();
    }
}


private void excelLog(int row, int col, String value) {
    XSSFRow myRow = mySheet.getRow(row);
    if (myRow == null)
        myRow = mySheet.createRow(row);

    XSSFCell myCell = myRow.createCell(col);
    myCell.setCellValue(value);
	}

}