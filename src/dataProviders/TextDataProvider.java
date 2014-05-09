package dataProviders;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import dto.DataObject;

public class TextDataProvider {
	
	@DataProvider

 static Iterator<Object[]> AddtoCartDataProvider(ITestContext context) {
		String inputFile = context.getCurrentXmlTest().getParameter("textFilePath");
			List<DataObject> testData = getTextFileContent(inputFile);
				List<Object[]> dataToBeReturned = new ArrayList<Object[]>();
				for (DataObject userData : testData) {
					dataToBeReturned.add(new DataObject[] { userData });
				}
		return dataToBeReturned.iterator();
	}

	private static List<DataObject> getTextFileContent(String filenamePath) {
		InputStream is;
		List<DataObject> lines = new ArrayList<DataObject>();
		try {
			is = new FileInputStream(new File(filenamePath));
			DataInputStream in = new DataInputStream(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				DataObject data=new DataObject();
				String dataArray[]=strLine.split("/");
				data.setUserName(dataArray[0]);
				data.setPassword(dataArray[1]);
				lines.add(data);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	/*@DataProvider
	public static Iterator<Object[]> TextFileDataProvider11(ITestContext context) {
		String inputFile = context.getCurrentXmlTest().getParameter("textFilePath1");
		List<DataObject> testData = getTextFileContent1(inputFile);
			List<Object[]> dataToBeReturned = new ArrayList<Object[]>();
			for (DataObject userData : testData) {
				dataToBeReturned.add(new DataObject[] { userData });
			}
	return dataToBeReturned.iterator();
	}
	
	private static List<DataObject> getTextFileContent1(String filenamePath) {
		InputStream is;
		List<DataObject> lines = new ArrayList<DataObject>();
		try {
			is = new FileInputStream(new File(filenamePath));
			DataInputStream in = new DataInputStream(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				CardDetails data=new CardDetails();
				String dataArray[]=strLine.split("/");
				data.setQty(dataArray[0]);
				data.setItemCode(dataArray[1]);
				data.setCardHolderName(dataArray[2]);
				data.setCardNumber(dataArray[3]);
				data.setCardExpMonth(dataArray[4]);
				data.setCardExpYear(dataArray[5]);
				lines.add(data);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}*/
	
}
