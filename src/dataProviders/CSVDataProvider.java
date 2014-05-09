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

public class CSVDataProvider {

	@DataProvider
	public static Iterator<Object[]> CSVFileDataProvider(ITestContext context) {
		String inputFile = context.getCurrentXmlTest().getParameter(
				"CSVFilePath");
		List<DataObject> testData = getCSVFileContent(inputFile);
		List<Object[]> returnedData = new ArrayList<Object[]>();
		for (DataObject userData : testData) {
			returnedData.add(new Object[] { userData });
		}
		return returnedData.iterator();
	}

	private static List<DataObject> getCSVFileContent(String filenamePath) {
		InputStream is;
		List<DataObject> lines = new ArrayList<DataObject>();
		try {
			is = new FileInputStream(new File(filenamePath));
			DataInputStream in = new DataInputStream(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				DataObject data = new DataObject();
				String dataArray[] = strLine.split(",");
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

}
