package utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportBackUp {
	public static void takeBackUp() throws IOException, InterruptedException {
		
		File directory = new File(".");
		String oldPath = directory.getCanonicalPath() + "\\test-output\\";
		File oldfile = new File(oldPath);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		String oldPath1 = directory.getCanonicalPath() + "\\test-output";
		String new_name = oldPath1 + dateFormat.format(date);
		Thread.sleep(20000);
		File newfile = new File(new_name);
		oldfile.renameTo(newfile);
		String path=new_name+"\\index.html";
		File f=new File(path);
		System.out.println("opening file");
		Desktop.getDesktop().open(f);
	}
}
