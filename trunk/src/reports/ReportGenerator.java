package reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class ReportGenerator {

	public static void generateHTML(ArrayList<String> logMessage, String status) {
		StringBuffer FileContent = new StringBuffer();
		System.out.println("status is " + status);
		String initial = "<html><title> Test Report</title><body><table bgcolor='#1A9200' border = \"true\" align=\"center\"><tr><td colspan=4 align='center'><h3>Test Report</h3></td></tr><tr><td><b>Test Case No.</td><td><b>Test Case Description</td><td><b>Test Case Status</td><td><b>Attachment</td></tr>";
		String openRow = "<tr>";
		String closeRow = "</tr>";
		String openCell = "<td align='center'>";
		String closeCell = "</td>";
		String ScreenShotInitial = "<a href=\"file:///C:/Temp/";
		String ScreenShotEnd = ".png\"> SCREEN SHOT </a>";
		String endFile = "</body></html>";
		FileContent = FileContent.append(initial);
		int size = logMessage.size();
		for (int i = 0; i < size; i++) {
			FileContent.append(openRow);
			FileContent.append(openCell);
			FileContent.append((i + 1) + ".");
			FileContent.append(closeCell);
			FileContent.append(openCell);
			if (i != logMessage.size()) {
				FileContent.append(logMessage.get(i));
			} else
				FileContent.append(logMessage.get(i));
			FileContent.append(closeCell);
			FileContent.append(openCell);
			if (i == (size - 1) && "fail".equals(status))
				FileContent.append(status);
			else
				FileContent.append("Pass");
			FileContent.append(closeCell);
			FileContent.append(openCell);
			if (i == (size - 1) && "fail".equals(status))
				FileContent.append(ScreenShotInitial + "screenshotNegative"
						+ ScreenShotEnd);
			else
				FileContent.append(ScreenShotInitial + (i + 1) + ScreenShotEnd);

			FileContent.append(closeCell);
		}
		FileContent.append(closeRow);
		FileContent.append(endFile);
		try {
			writeFile(FileContent);
		} catch (IOException exception) {
			System.out.println("there is some problem in writing the file");
		}
	}

	public static void generateHTML1(ArrayList<String> logMessage) {
		StringBuffer FileContent = new StringBuffer();
		String initial = "<html><title> Test Report</title><body><table bgcolor='#1A9200' border = \"true\" align=\"center\"><tr><td colspan=4 align='center'><h3>Test Report</h3></td></tr><tr><td><b>Test Case No.</td><td><b>Test Case Description</td><td><b>Test Case Status</td><td><b>Attachment</td></tr>";
		String openRow = "<tr>";
		String closeRow = "</tr>";
		String openCell = "<td align='center'>";
		String openFailedCell = "<td align='center' bgcolor='red'>";
		String closeCell = "</td>";
		String ScreenShotInitial = "<a href=\"file:///C:/Temp/";
		String ScreenShotEnd = ".png\"> SCREEN SHOT </a>";
		String endFile = "</body></html>";
		FileContent = FileContent.append(initial);
		int size = logMessage.size();
		for (int i = 0; i < size; i++) {
			FileContent.append(openRow);
			FileContent.append(openCell);
			FileContent.append((i + 1) + ".");
			FileContent.append(closeCell);
			String[] individualContent = logMessage.get(i).split(",,");
			int length = individualContent.length;
			for (int j = 0; j < length; j++) {
				if (individualContent[j].equals("Fail"))
					FileContent.append(openFailedCell);
				else
					FileContent.append(openCell);
				if (j == length - 1) {
					FileContent.append(ScreenShotInitial);
					FileContent.append(individualContent[j]);
					FileContent.append(ScreenShotEnd);
				} else
					FileContent.append(individualContent[j]);
				FileContent.append(closeCell);
			}
		}
		FileContent.append(closeRow);
		FileContent.append(endFile);
		try {
			writeFile(FileContent);
		} catch (IOException exception) {
			System.out.println("there is some problem in writing the file");
		}
	}

	public static void writeFile(StringBuffer fileContent) throws IOException {
		Writer output = null;
		File file = new File("c:/Temp/TestReport.html");
		output = new BufferedWriter(new FileWriter(file));
		output.write(fileContent.toString());
		output.close();
	}
}
