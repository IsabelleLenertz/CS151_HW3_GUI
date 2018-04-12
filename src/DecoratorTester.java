import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DecoratorTester {
	   public static void main(String[] args) throws IOException {
		   
		   EncryptingWriter e = new EncryptingWriter(new FileWriter("test.out"));
		      e.write("abcdefghijklmnopqrstuvwxyz1abcdefghijklmnopqrstuvwxyz", 20, 27);
		      e.write("ABCDEFGHIJKLMNOPQRSTUVWXYZ1ABCDEFGHIJKLMNOPQRSTUVWXYZ", 20, 27);

		      PrintWriter w = new PrintWriter(e, true);  // autoflush mode
		      w.println("abcdefghijkl2mnopqrstuvwxyz");
		      w.println("ABCDEFGHIJKL2MNOPQRSTUVWXYZ");

		      char inChars[] = 
		         "----------------------------------------------".toCharArray();

		      DecryptingReader r = new DecryptingReader(new FileReader("test.out"));
		      r.read(inChars, 10, 27);
		      System.out.println(inChars);
		      r.read(inChars, 10, 27);
		      System.out.println(inChars);


	   }

}
