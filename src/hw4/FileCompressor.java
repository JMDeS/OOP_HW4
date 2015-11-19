package hw4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FileCompressor{
	private static final String path = "basketball.txt";
	private static Charset ENCODING = StandardCharsets.UTF_8;
	
	
	public static void compress(String src, String dest,
									Map<String, Character> dictionary){
		FileStats fs = new FileStats(path);
		ArrayList<String> wordList = fs.getWordList();			
		File outFile = null;
			      
	    try{	         
		  outFile = new File("compressed.txt");
	      outFile.createNewFile();
	      outFile.delete();
	      outFile.createNewFile();
	      
	      Set<String> keySet = fs.getCompressDict().keySet();
	    	for ( String word : wordList ) {
	    		for ( String key : keySet ) {
	 	    		if ( word.equals(key) ) {
	 	    			
	 	    		}
	    		}
		    }
	        writeToTextFile(wordList,"compressed.txt");
	    }catch(Exception e){
	       e.printStackTrace();
	    }

		
		
		

	}

	public static void decompress(String src, String dest,
									Map<Character, String> dictionary){

		/* insert your code here */

	}
	
	public static void writeToTextFile(List<String> wordList, String fileName)
			throws IOException{
		Path path = Paths.get(fileName);
		try (BufferedWriter writer = Files.newBufferedWriter(path,  ENCODING)) {
			for ( String word : wordList ) {
				writer.write(word);
			}
		}
		
	}
}
