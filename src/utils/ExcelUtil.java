package utils;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ExcelUtil {

	String inputFileName = "";
	private Workbook inputBook=null;
	private Sheet inputSheet=null;
	
	
	/**
	 * Mention the file you want to read
	 * 
	 * @author PSubramani33
	 * @param FileName
	 */
	public ExcelUtil(String inputFile, int sheetNo){
		inputFileName = inputFile;
		try{
			inputBook = Workbook.getWorkbook(new File(inputFileName));
			inputSheet = inputBook.getSheet(sheetNo);
		}
		catch(BiffException be){
			be.printStackTrace();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

	/**
	 * This method will return the content of the cell whose row and columns are passed 
	 * 
	 * @param row and column values
	 * @return the value of the cell
	 */
	public String getinput(int rowVal, int colVal) {
		return inputSheet.getCell(colVal, rowVal).getContents();	
	}
	
	/**
	 * This method will return the no. of rows in the file
	 * 
	 * @author PSubramani33
	 * @return
	 */
	public int getRows(){
		return inputSheet.getRows();
	}
	
	/**
	 * This method will close the file
	 * 
	 * @author PSubramani33
	 */
	public void close(){
		inputBook.close();
	}
	
}