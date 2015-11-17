package hw4;

import java.io.*;
import java.util.*;

class FileStats{
	private Scanner input;
	private ArrayList <String> wordList=new ArrayList<String>();
	private HashSet <String> wordSet=new HashSet<String>();
	private ArrayList <Entry<String>> entryList=new ArrayList<Entry<String>>();
	private Map <String, Character> dictStr2Char=new TreeMap<String, Character>();
	private Map <Character, String> dictChar2Str=new TreeMap<Character, String>();
	
	private class Entry <T> implements Comparable<Entry<T>>{
		public T s;
		public int frequency;
		public Entry(T s, int f){
			this.s=s;
			frequency=f;
		}
		public int compareTo(Entry<T> e){
			// insert your code
			return 0; // stub
		}
	}

	public FileStats(String path) {

		/* insert your code here */
		/* open the file, named path */


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
		/* insert your code here */
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
}



