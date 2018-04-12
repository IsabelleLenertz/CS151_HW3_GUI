import java.io.IOException;
import java.io.Writer;

/**
 * Decorator for Writer class adding cypher encyption
 * @author isabelle delmas
 *
 */
public class EncryptingWriter extends Writer {
	
	private Writer w;
	private final static int CYPHER_KEY = 3;
	static final int ALPHABET_SIZE = 26;


	/**
	 * Constructor
	 * @param writer appropriate writer
	 */
	public EncryptingWriter(Writer writer) {
		w = writer;
	}

	@Override
	public void close() throws IOException {
		w.close();
	}

	@Override
	public void flush() throws IOException {
		w.flush();
	}
	
	@Override
	public void write(char[] cbuf) throws IOException {
		
		char[] encrypted = new char[cbuf.length];
		
		// Encrypt text to write and put it in a new array
		for(int i = 0; i < cbuf.length; i++) {
			encrypted[i] = (char) (cbuf[i] + CYPHER_KEY);
            if (!Character.isLetter(encrypted[i]))
            	encrypted[i] = (char) ((int) encrypted[i] - ALPHABET_SIZE);

		}
		
		w.write(encrypted);
	}
	
	@Override
	public void write(int c) throws IOException {
		w.write(c + CYPHER_KEY);
	}
	@Override
	public void write(String str) throws IOException {
		String encrypted = "";
		
		// Encrypt text to write and put it in a new array
		for(int i = 0; i < str.length(); i++) {
			char c = (char) (str.charAt(i) + CYPHER_KEY);
            if (!Character.isLetter(c))
            	c = (char) ((int) c - ALPHABET_SIZE);

            encrypted += "" + c;
		}
		
		w.write(encrypted);
	}
	@Override
	public void write(String str, int off, int len) throws IOException {
		String encrypted = "";
		
		if (len > str.length()) {
			throw new IOException("out of bound");
		}
		
		// Encrypt text to write and put it in a new array
		for(int i = 0; i < len; i++) {
			char c = (char) (str.charAt(i) + CYPHER_KEY);
            if (!Character.isLetter(c))
            	c = (char) ((int) c - ALPHABET_SIZE);

            encrypted += "" + c;

		}
		
		w.write(encrypted);

	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		char[] encrypted = new char[len];
		
		if (len > cbuf.length) {
			throw new IOException("out of bound");
		}
		
		// Encrypt text to write and put it in a new array
		for(int i = 0; i < len; i++) {
			encrypted[i] = (char) (cbuf[i+off] + CYPHER_KEY);
            if (!Character.isLetter(encrypted[i]))
            	encrypted[i] = (char) ((int) encrypted[i] - ALPHABET_SIZE);

		}
	
		
		w.write(encrypted, 0, len);
	}



}
