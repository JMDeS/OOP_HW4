package hw4;

import java.io.IOException;
import java.util.Map;

public class HW4_4590 {
	public static void main(String args[]) throws IOException{
		FileStats fs=new FileStats("basketball.txt");
		fs.printDictionary();

		Map <String, Character> m1=fs.getCompressDict();
		FileCompressor.compress("basketball.txt", "compressed.txt",m1);

		/* insert your code here */
			/* create another dictionary for decompress and name it m2 */
		Map <String, String> m2=fs.getDecompressDict();
		FileCompressor.decompress("compressed.txt", "decompressed.txt",m2);
	}

}
