package filemanipulator;
import java.util.regex.*; 
import java.util.Scanner;
public class mobileValidator
{
	boolean isValid(String num)
	{
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
		Matcher m = p.matcher(num);
		return (m.matches()); 
	}
}
