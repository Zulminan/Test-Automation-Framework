package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {
		
		File xlsxFile = new File(System.getProperty("user.dir")+"//testData//"+fileName);

		XSSFWorkbook xssfWorkbook = null;
		List<User> userList=null;
		try {
			
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
		
		userList = new ArrayList<User>();
		
		XSSFSheet xssfSheet = xssfWorkbook.getSheet("LoginTestData");
		
		Iterator<Row> rowIterator = xssfSheet.iterator();
		
		rowIterator.next(); //Here we are skipping the column name
		
		while(rowIterator.hasNext())
		{
			Row row = rowIterator.next();
			
			Cell firstCell = row.getCell(0);
			
			Cell secondCell = row.getCell(1);
			
			User user = new User(firstCell.toString(),secondCell.toString());
			
			userList.add(user);
		}
			xssfWorkbook.close();
	}
		
		catch (IOException | InvalidFormatException e) {
			
			e.printStackTrace();
		}
		return userList.iterator();
	}
	
	

}
