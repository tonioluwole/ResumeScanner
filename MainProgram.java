import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainProgram {
	
	public static void main(String[] args) {
		
		//list of filtered words
		String filtered_words = "the be to of and a in that have I it for not on with he as you do at this but his by from they we say her she or an will like is most use like "
								+ "! * @ # $ % ^ & ( ) () + = | } { { [ ] | '/ ? > < . , - ~ ` 1 2 3 4 5 6 7 8 9 ";
		String[] Filtered_words = filtered_words.split (" "); 
		List<String> f_words = Arrays.asList(Filtered_words);
		
		//Inputs
		Scanner keyboard = new Scanner(System.in);
	
		//Resume Input
		System.out.print("Please enter your resume:\n");

		List<String> resumeLines = new ArrayList<>();
		String resumeLine = null;
		while (!(resumeLine = keyboard.nextLine()).isEmpty()) {
			resumeLines.add(resumeLine);
		}
		
		StringBuilder String1 = new StringBuilder();
		for (String s : resumeLines) {
			String1.append(s);
			String1.append("\n");
		}
		
		String originalString1 = String1.toString();
		String resume = converter(originalString1);		
		
		//Job Description Input
	    System.out.print("\nPlease enter your job description:\n");
	    List<String> descriptionLines = new ArrayList<>();
		String descriptionLine = null;
		while (!(descriptionLine = keyboard.nextLine()).isEmpty()) {
			descriptionLines.add(descriptionLine);
		}
		
		StringBuilder String2 = new StringBuilder();
		for (String s :descriptionLines) {
			String2.append(s);
			String2.append("\n");
		}
		
		String originalString2 = String2.toString();
		String description = converter(originalString2);	
		
	    //Turning inputs to arrays
	    String[] unfiltered_resume = resume.split(" ");
	    String[] unfiltered_description = description.split (" ");
	    
	    //Filter out by converting to list then array then string
	    List<String> resumelist = new ArrayList<>();
	    Collections.addAll(resumelist, unfiltered_resume);
	    resumelist.removeAll(Arrays.asList(Filtered_words));
  
	    String[] r1 = new String[resumelist.size()];
	    for(int i = 0; i < resumelist.size(); i++) r1[i] = resumelist.get(i);
	    
	    //Test Filter
	    /*for (String words : r1 ) {
	    	System.out.println (words);
	    }*/
	    
	    //Filter out by converting to list then array then string
	    List<String> descriptionlist = new ArrayList<>();
	    Collections.addAll(descriptionlist, unfiltered_description);
	    descriptionlist.removeAll(Arrays.asList(Filtered_words));
	    
	    String[] d1 = new String[descriptionlist.size()];
	    for(int p = 0; p < descriptionlist.size(); p++) d1[p] = descriptionlist.get(p);
	    
	    //Test Filter
	   /* for (String words1 : d1 ) {
	    	System.out.println (words1);
	    }*/
	    
	    double matches = 0;
	  
	    //Count how many words match between both arrays
	   	for(String rwords: r1) {
	   		for (String dwords: d1) {
	   			if (rwords.equals(dwords)) {
	   				matches = matches + 1;
	   			}	
	   		} 		
	   	}
	    
	   	//View how many words match
	   	System.out.println("\n" + matches + " words match");
	    
	    double percentage = (matches/d1.length)*100;
	    
	    //Print percentage of words
	    System.out.println("\nYour resume matches with " + percentage + "% of the words in this part of the job description");
	    keyboard.close();
	}
	
	 public static String converter(String inputString){
	        String refinedString = inputString.replaceAll("\\s+"," ");
			return refinedString;
	    }
}

