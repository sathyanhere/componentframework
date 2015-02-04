package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTestResults {
	List<String> fileList;
	
 
	/*static String OUTPUT_ZIP_FILE = "D:\\workspace\\SVN\\AutomationResult.zip";
	static String SOURCE_FOLDER = new String("D:\\workspace\\SVN\\test-output");*/
	
	static String SOURCE_FOLDER =new String();
	static String OUTPUT_ZIP_FILE=new String(); 
    public ZipTestResults(String source, String dest){
    	OUTPUT_ZIP_FILE =dest;
    	SOURCE_FOLDER =source;
	fileList = new ArrayList<String>();
	
    }
 
    public static void main( String[] args ) throws IOException
    {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		String exeTime = dateFormat.format(date);
    	File directory = new File(".");
    	/*SOURCE_FOLDER = directory.getCanonicalPath() + "\\test-output\\";
    	OUTPUT_ZIP_FILE=directory.getCanonicalPath()+exeTime+".zip";*/
    	ZipTestResults appZip = new ZipTestResults("D:\\workspace\\SVN\\test-output","D:\\workspace\\SVN\\AutomationResult.zip");
    	appZip.generateFileList(new File(SOURCE_FOLDER));
    	appZip.zipIt(OUTPUT_ZIP_FILE);
    }
 
    /**
     * Zip it
     * @param zipFile output ZIP file location
     */
    public void zipIt(String zipFile){
 
     byte[] buffer = new byte[1024];
 
     try{
 
    	FileOutputStream fos = new FileOutputStream(zipFile);
    	ZipOutputStream zos = new ZipOutputStream(fos);
 
    	System.out.println("Output to Zip : " + zipFile);
 
    	for(String file : this.fileList){
 
    		System.out.println("File Added : " + file);
    		ZipEntry ze= new ZipEntry(file);
        	zos.putNextEntry(ze);
 
        	FileInputStream in = 
                       new FileInputStream(SOURCE_FOLDER + File.separator + file);
 
        	int len;
        	while ((len = in.read(buffer)) > 0) {
        		zos.write(buffer, 0, len);
        	}
 
        	in.close();
    	}
 
    	zos.closeEntry();
    	//remember close it
    	zos.close();
 
    	System.out.println("Done");
    }catch(IOException ex){
       ex.printStackTrace();   
    }
   }
 
    /**
     * Traverse a directory and get all files,
     * and add the file into fileList  
     * @param node file or directory
     */
    public void generateFileList(File node){
 
    	//add file only
	if(node.isFile()){
		fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
	}
 
	if(node.isDirectory()){
		String[] subNote = node.list();
		for(String filename : subNote){
			generateFileList(new File(node, filename));
		}
	}
 
    }
 
    /**
     * Format the file path for zip
     * @param file file path
     * @return Formatted file path
     */
    private String generateZipEntry(String file){
    	return file.substring(SOURCE_FOLDER.length()+1, file.length());
    }
}