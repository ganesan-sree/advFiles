package com.spring.annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	private static final String FILE_PATTERN =
            "([^\\s]+(\\.(?i)(jpg|jpeg|png|flv|mpg|mpeg|mp4|avi|vob|mkv))$)";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("DD");


String REGEX = "\\..*$";
String INPUT = "in.png";
String REPLACE = ".mp4";


  Pattern p = Pattern.compile(REGEX);
  
  // get a matcher object
  Matcher m = p.matcher(INPUT); 
  INPUT = m.replaceAll(REPLACE);
  System.out.println(INPUT);
  
 System.out.println(isFileNameValid("1.jpgl"));
  
  
	}
	
	private static boolean isFileNameValid(String filename) {
		Pattern pattern = Pattern.compile(FILE_PATTERN);
		Matcher matcher = pattern.matcher(filename);
		return matcher.matches();
	}
	
	

}
