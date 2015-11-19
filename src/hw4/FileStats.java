package hw4;

import java.io.*;
import java.util.*;

class FileStats{
	
	private Scanner input; 
	private ArrayList <String> wordList=new ArrayList<String>();
	private ArrayList <Character> punctuation=new ArrayList<Character>();
	private HashSet <String> wordSet=new HashSet<String>();
	private ArrayList <Entry<String>> entryList=new ArrayList<Entry<String>>();
	private Map <String, Character> dictStr2Char=new TreeMap<String, Character>();
	private Map <Character, String> dictChar2Str=new HashMap<Character, String>();
	private String lineBreak = "lineBreak"; 
	
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
		setupPunctuationList();
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
		
		setupDicts();
		count();
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
		
		Collections.sort(entryList);
		
		for (int i = 0; i < 4; i++) {
			System.out.println(entryList.get(i).s + " appears "
					+ entryList.get(i).frequency + " time(s).");
		}
	}

	public Map<String, Character> getCompressDict(){
		return dictStr2Char;
	}
	public Map<Character, String> getDecompressDict(){
		return dictChar2Str;
	}
	
	/*	DO SOMETHING  */
	public int printDictionary(){ 
		return 0; // stub
	}
	
	private void setupPunctuationList() {
		punctuation.add('.');
		punctuation.add('\'');
		punctuation.add(',');
		punctuation.add('?');
		punctuation.add(';');
	}
	
	private void setupDicts(){
		dictStr2Char.put("and", '#');
		dictStr2Char.put("basketball", '$');
		dictStr2Char.put("is", '*');
		dictStr2Char.put("the", '%');
		
		dictChar2Str.put('#', "and");
		dictChar2Str.put('$', "basketball");
		dictChar2Str.put('*', "is");
		dictChar2Str.put('%', "the");
	}
	
	ArrayList<String> getWordList(){
		return wordList;
	}
}



