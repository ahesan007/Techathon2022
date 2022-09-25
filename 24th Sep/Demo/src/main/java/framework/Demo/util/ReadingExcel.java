package framework.Demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.*;

public class ReadingExcel {
   
	
//	public File file; 
	public static FileInputStream fileInputStream;
	public static XSSFWorkbook workbook;
	
    public static String ExcelPathforAppointmentData=".\\ExcelData\\TestData.xlsx";
   
    public void ReadingExcelforScript1() throws IOException 
    {
    
    	fileInputStream = new FileInputStream(ExcelPathforAppointmentData); 
    	    	
    	workbook = new XSSFWorkbook(fileInputStream);
    }    
     
	
    public XSSFSheet getSheet()
    {
    	XSSFSheet sheet = workbook.getSheetAt(0);
    	return sheet;
    } 

    
    private Cell getCell(org.apache.poi.ss.usermodel.Sheet sheet , int rowIndex, int cellIndex) {
    	Row row = ((XSSFSheet) sheet).getRow(rowIndex);
    	Cell cell = row.getCell(cellIndex);
		return cell;
    }
    

    
    public String getCellValue(org.apache.poi.ss.usermodel.Sheet sheet, int rowIndex, int colIndex) 
    {
    	Cell cell = getCell(sheet, rowIndex, colIndex);
    	return getCellValueAsString(cell);
    }  
    
    private String getCellValueAsString(Cell cell) {
    	DataFormatter dataFormatter = new DataFormatter();
    	String cellValue = dataFormatter.formatCellValue(cell);
        return cellValue;
    }
    
    
}
