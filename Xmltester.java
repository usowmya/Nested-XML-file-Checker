import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Xmltester {
	
	//Method for generating the tab spaces.
	
	public static String  tabgenerator(int tc) {
		String t="";
		for(int i=0;i<tc;++i) {
			t += "\t";
			}
	    return t ;
	}
	
	// Main Program
	
	public static void main(String [] args) throws IOException
	   {
	     // declare variables
	     Queue queue = new LinkedList<>();
	     Stack stack = new Stack();
	     boolean valid_flag = false;
	     String str="";
	     int tab_count = 0;
	     
	     // Create a scanner object 
	     try {
	     Scanner in = new Scanner(System.in);
	     System.out.println("Please Enter your xml file path:");
	     String filePath = in.next();
	     //System.out.println(fileName);
         File xmlFile = new File(filePath);
	     StringBuilder stringBuilder = new StringBuilder();
	     Scanner inputFile = new Scanner(xmlFile); 
	    while (inputFile.hasNext())
	    {
	    	str = inputFile.nextLine();
	    	str = str.replaceAll("\\s+","");
	    	stringBuilder.append(str);
	       }
	    
	    //Check for an empty file
	    
	    if(str.isEmpty()) {
        	System.out.println("The File is empty");
        }else {
        	// Reads the content from the file and matches for tags"<"">" and opening tags are pushed to stack a.
	            String pageContent = stringBuilder.toString();
	            Pattern pattern = Pattern.compile("<([a-zA-Z0-9|/]+|/[a-zA-Z0-9|/]+)(.*?)>");
	            Matcher matcher = pattern.matcher(pageContent);
	            while (matcher.find()) {
	                String tagName = matcher.group(1);
	                queue.add(tagName);
	                String a = (String) queue.remove();
	         	    if(a.charAt(0)!='/') {
	         	    	if(a.charAt(a.length()-1)!='/') {
	         	    	String tb = tabgenerator(tab_count);
		         	    System.out.println(tb+a);
	         	    	tab_count ++;
	         	    	stack.push(a);
	         	    	}
	         	    	
	         	    	// Prints the properly nested tag names.
	         	    	
	         	    	else {
	         	    		String tb = tabgenerator(tab_count);
			         	    a = a.replace("/","");
	         	    		System.out.println(tb+a);
	         	    		valid_flag = true;
	         	    	}
	         	    }
	         	    else {
	         	    	if(a.equals("/"+(String) stack.pop())) {
	         	    		tab_count --;
	         	    		valid_flag = true;
	         	    	}else
	         	    	{
	         	    		valid_flag = false;
	         	    		break;
	         	    	}
	         	    	}
	         	    	}
	         	    }
	            if(valid_flag && stack.isEmpty()) {
	            	System.out.println("File is nested correctly!");
	            }
	            else {
	            	System.out.println("File is not nested correctly!");
	            }
	   
	     }catch(FileNotFoundException e) {
	    	 System.err.println("Exception caught - File does not exist!");
	     }catch(EmptyStackException e) {
	    	 System.err.println("File is not nested correctly!");
	     }
	   }
}
