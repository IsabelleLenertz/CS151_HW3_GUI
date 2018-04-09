import java.io.IOException;
import java.io.Writer;

public class EncryptingWriter extends Writer {
	
	private Writer w;
	private final static int CYPHER_KEY = 3;
	
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
	public void write(char[] cbuf, int off, int len) throws IOException {
		char[] encrypted = new char[len];
		
		// Encrypt text to write and put it in a new array
		for(int i = 0; i < len; i++) {
			encrypted[i] = (char) (cbuf[i+off] + CYPHER_KEY);
		}
		
		w.write(encrypted, 0, len);
	}



}
