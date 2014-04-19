package utils;

public class TextUtil {
	public static int getAsciiVal(String text){
		char []textArr=text.toCharArray();
		return (int)textArr[0];
	}
	
	public static int getAsciiValue(char text){
		return (int)text;
	}
}


