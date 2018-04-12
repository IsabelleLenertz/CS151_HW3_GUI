import java.io.IOException;
import java.io.Reader;

/**
 * Decorator for Reader
 * @author isabelle delmas
 *
 */
public class DecryptingReader extends Reader {

	private Reader r;
	private final static int CYPHER_KEY = 3;
	static final int ALPHABET_SIZE = 26;

	/**
	 * Constructor
	 * @param reader appropriate reader
	 */
	public DecryptingReader(Reader reader) {
		r = reader;
	}
	
	@Override
	public void close() throws IOException {
		r.close();
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int result = r.read(cbuf, off, len);
		
		for (int i = off; i < len; i++) {
			cbuf[i] = (char) (cbuf[i] - CYPHER_KEY);
			if (!Character.isLetter(cbuf[i]))
				cbuf[i] = (char) ((int) cbuf[i] + ALPHABET_SIZE);
		}
		return result;
	}
	@Override
	public void mark(int readAheadLimit) throws IOException {
		r.mark(readAheadLimit);
	}
	@Override
	public boolean markSupported() {
		return r.markSupported();
	}
	@Override
	public int read() throws IOException {
		return r.read() - CYPHER_KEY;
	}
	@Override
	public int read (char[] cbuf) throws IOException {
		int result = r.read(cbuf);
		for (int i = 0; i < cbuf.length; i++) {
			cbuf[i] = (char) (cbuf[i] - CYPHER_KEY);
			if (!Character.isLetter(cbuf[i]))
				cbuf[i] = (char) ((int) cbuf[i] + ALPHABET_SIZE);
		}
		return result;
		
	}

}
