package hw4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class FileCompressor{
	private static final String path = "basketball.txt";
	
	public static void compress(String src, String dest,
									Map<String, Character> dictionary){
		FileStats fs = new FileStats(path);
		ArrayList<String> wordList = fs.getWordList();
		
		try {
			FileWriter out = new FileWriter("compressed.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for ( String word : wordList ) {
			/* insert your code here */
		}
		
		

	}

	public static void decompress(String src, String dest,
									Map<Character, String> dictionary){

		/* insert your code here */

	}
}
