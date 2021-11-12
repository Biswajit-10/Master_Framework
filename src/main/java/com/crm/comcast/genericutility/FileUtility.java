package com.crm.comcast.genericutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Biswajit
 *
 */

	public class FileUtility {
		/**
		 * 
		 * @param key as url un pwd BROW
		 * @return value from property file url,un,pwd,BROW
		 * @throws IOException
		 */
		public String getPropertyData(String key) throws IOException {
			FileInputStream fis=new FileInputStream("./data/data.properties");
			Properties p=new Properties();
			p.load(fis);
			String data = p.getProperty(key);
			return data;		
		}
		/**
		 * 
		 * @param key property file name
		 * @return value from property file 
		 * @throws IOException
		 */
		public String getPropertyData(String key,String propertyFileName) throws IOException {
			FileInputStream fis=new FileInputStream("./data/"+propertyFileName+".properties");
			Properties p=new Properties();
			p.load(fis);
			String data = p.getProperty(key);
			return data;		
		}
		/**
		 * 
		 * @param sheetname 
		 * @param row
		 * @param cell
		 * @return value from excel file testdata.xlsx
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public String getExcelData(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream("./data/testdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
			return data;		
		}
		/**
		 * 
		 * @param excelFileName
		 * @param sheetname
		 * @param row
		 * @param cell
		 * @param value
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public String getExcelData(String excelFileName,String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
			File f=new File("./data/"+excelFileName+".xlsx");
			Workbook wb = WorkbookFactory.create(f);
			String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
			return data;
		}
		/**
		 * 
		 * @param excelFileName
		 * @param sheetname
		 * @param row
		 * @param cell
		 * @param value
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public void setExcelData(String excelFileName,String sheetname,int row,int cell,String value) throws EncryptedDocumentException, IOException {
			File f=new File("./data/"+excelFileName+".xlsx");
			Workbook wb = WorkbookFactory.create(f);
			wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(value);
			FileOutputStream fos=new FileOutputStream(f,true);
			wb.write(fos);
			wb.close();
		}
		/**
		 * 
		 * @param sheetName
		 * @return number of rows present in testdata excel sheet
		 * @throws Throwable
		 */
		public int getRowCount(String sheetName) throws Throwable {
			FileInputStream fis  = new FileInputStream("./data/testdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			return sh.getLastRowNum();
		}
		/**
		 * 
		 * @param sheetName
		 * @return
		 * @throws Throwable
		 */
		public int getColumnCount(String sheetName) throws Throwable {
			FileInputStream fis  = new FileInputStream("./data/testdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			return sh.getRow(0).getLastCellNum();
		}
		
	}

