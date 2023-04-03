package com.GeneralUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String readdataFromExcel(String SheetName,int RowNo,int columnNo) throws Throwable {
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(SheetName);
		String value=sh.getRow(RowNo).getCell(columnNo).getStringCellValue();
		return value;
	}
	public int getLastRowNo(String sheetName) throws Throwable {
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		return count;
		
	}
	public void writeDataIntoExcel(String SheetName,int RowNo,int columnNo,String data) throws Throwable {
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(SheetName);
		sh.getRow(RowNo).createCell(columnNo).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}
	public HashMap<String,String> readMultipleData(String SheetName) throws Throwable{
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(SheetName);
		int count=sh.getLastRowNum();
		HashMap<String,String> map=new HashMap<String,String>();
		for(int i=0;i<=count;i++) {
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
		
	}
	public Object[][] readdataproviderfromexcel(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetname);
	int lastrow=sh.getLastRowNum()+1;
	int lastcell=sh.getRow(0).getLastCellNum();
	Object[][] obj=new Object[lastrow][lastcell];
	for(int i=0;i<lastrow;i++) {
		for(int j=0;j<lastcell;j++) {
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
