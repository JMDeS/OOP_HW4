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
	
	private static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static void compress(String src, String dest,
									Map<String, Character> dictionary){
		FileStats fileStats = new FileStats(src);
		ArrayList<String> wordList = fileStats.getWordList();			
		File outFile = null;
			      
	    try{	         
		    outFile = new File(dest);
	        outFile.createNewFile();
	        outFile.delete();
	        outFile.createNewFile();
	      
	        Set<String> keySet = dictionary.keySet();
			for ( String word : wordList ) {
				for ( String key : keySet ) {
					if ( word.equals(key) ) {
						wordList.set(  // replaces keyword instance with corresponding value
									wordList.indexOf(word),		// << index of word
									dictionary.get(word).toString());  
									// ^^ get value of keyWord ^^
					}
				}
			}
			writeToTextFile(wordList,dest);
	    }catch(Exception e){
	       e.printStackTrace();
	    }	
		

	}

	public static void decompress(String src, String dest,
									Map<String, String> m2){

		FileStats fileStats = new FileStats(src);
		ArrayList<String> wordList = fileStats.getWordList();			
		File outFile = null;
			      
	    try{	         
		    outFile = new File(dest);
	        outFile.createNewFile();
	        outFile.delete();
	        outFile.createNewFile();
	      
	        Set<String> keySet = m2.keySet();
			for ( String word : wordList ) {
				for ( String key : keySet ) {
					if ( word.equals(key) ) {
						wordList.set( // replaces keyword instance with corresponding value
										wordList.indexOf(word),	// << index of word
										m2.get(word).toString() 	);
									  //^ get value of keyword ^
					}
				}
			}
			writeToTextFile(wordList,dest);
	    }catch(Exception e){
	       e.printStackTrace();
	    }

	}
	
	public static void writeToTextFile(List<String> wordList, String fileName)
			throws IOException {
		Path path = Paths.get(fileName);
		try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
			for (String word : wordList) {
				if(word.equals("lineBreak")) {
					writer.newLine();
				} else {
					writer.write(word + " ");
				}
				
			}
		}
		
	}
}
