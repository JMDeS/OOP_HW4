package hw4;

import java.io.*;
import java.util.*;

class FileStats{
	
	private Scanner input; 
	private ArrayList <String> wordList=new ArrayList<String>();
	private HashSet <String> wordSet=new HashSet<String>();
	private ArrayList <Entry<String>> entryList=new ArrayList<Entry<String>>();
	private Map <String, Character> dictStr2Char=new TreeMap<String, Character>();
	private Map <String, String> dictChar2Str=new HashMap<String, String>();
	private String lineBreak = "lineBreak"; 
	private char[] symbols = { '%' , '$' , '#' , '*' };
	
	private class Entry <T> implements Comparable<Entry<T>>{
		public T s;
		public int frequency;
		public Entry(T s, int f){
			this.s=s;
			frequency=f;
		}
		public int compareTo(Entry<T> e){
			return e.frequency - this.frequency;
		}
	}

	public FileStats(String path) {
		try {
			input = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			System.out.println("Error openning file..");
			System.exit(1);
		}
		try {
			String line;
			
			while ((line = input.nextLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreTokens()){
					String nextWord = st.nextToken().toLowerCase();
					wordList.add(nextWord);
					wordSet.add(nextWord);
				
				} // end inner while
				wordList.add(lineBreak);
			} // end outer while
		} catch (NoSuchElementException e) {
			// no more lines in the file
			// no handler is necessary
		}
		
		count();
		setupDicts();
		
	}

	/*
	 * This method is supposed to
	 * 1. find the frequency of each word in the file.
	 * 2. display the four most frequent words and their frequencies.
	 * 3. construct the dictionary that four key-value pairs. The keys
	 *    are the most frequent words and the values are the characters,
	 *    used to represent the words.
	 */
	private void count() {
	
		for ( String word : wordSet ) {
			int freq = Collections.frequency(wordList,  word);
			Entry entry = new Entry(word,freq);
			entryList.add(entry);
		}
	}

	public Map<String, Character> getCompressDict(){
		return dictStr2Char;
	}
	public Map<String, String> getDecompressDict(){
		return dictChar2Str;
	}
	
	/*	DO SOMETHING  */
	public void printDictionary(){ 
		System.out.println("Compression Dictionary");
		for (String key : dictStr2Char.keySet() ) {
			System.out.println(key + " : " + dictStr2Char.get(key));
		}
		System.out.println("\nDecompression Dictionary");
		for (String key : dictChar2Str.keySet() ) {
			System.out.println(key + " : " + dictChar2Str.get(key));
		}
	}
	
	private void setupDicts(){
		
		Collections.sort(entryList);
		
		for (int i = 0; i < 4; i++) {
			dictStr2Char.put(entryList.get(i).s, symbols[i]);
			dictChar2Str.put(Character.toString(symbols[i]) , entryList.get(i).s);
		}
	}
	
	ArrayList<String> getWordList(){
		return wordList;
	}
}



