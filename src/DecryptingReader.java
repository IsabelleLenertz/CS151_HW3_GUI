import java.io.IOException;
import java.io.Reader;

public class DecryptingReader extends Reader {

	private Reader r;
	private final static int CYPHER_KEY = 3;
	
	public DecryptingReader(Reader reader) {
		r = reader;
	}
	
	@Override
	public void close() throws IOException {
		r.close();
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {

		return 0;
	}

}
