import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Tester for Decorator pattern
 * @author isabelle delmas
 *
 */
public class DecoratorTester {
	   public static void main(String[] args) throws IOException {
		   
		   EncryptingWriter e = new EncryptingWriter(new FileWriter("test.out"));
		      e.write("abcdefghijklmnopqrstuvwxyz", 0, 26);
		      e.write("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 0, 26);

		      PrintWriter w = new PrintWriter(e, true);  // autoflush mode
		      w.println("abcdefghijklmnopqrstuvwxyz");
		      w.println("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

		      e.close();
		      w.close();
		      char inChars[] = 
		         "----------------------------------------------".toCharArray();

		      System.out.println("Reading with decryption: ");
		      DecryptingReader r = new DecryptingReader(new FileReader("test.out"));
		      r.read(inChars, 10, 26);
		      System.out.println(inChars);
		      r.read(inChars, 10, 26);
		      System.out.println(inChars);
		      r.close();
		      
		      System.out.println("\nReading without decryption: ");
		      FileReader fr = new FileReader("test.out");
		      fr.read(inChars, 10, 26);
		      System.out.println(inChars);
		      fr.read(inChars, 10, 26);
		      System.out.println(inChars);
		      fr.close();
		      


	   }

}
