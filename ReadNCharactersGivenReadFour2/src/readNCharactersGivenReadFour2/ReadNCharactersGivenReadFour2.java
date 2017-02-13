package readNCharactersGivenReadFour2;

// LeetCode #158

// The API: int read4(char *buf) reads 4 characters at a time from a file.
// The return value is the actual number of characters read. For example, 
// it returns 3 if there is only 3 characters left in the file.

// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

// The read function may be called multiple times.

public class ReadNCharactersGivenReadFour2 extends Read4 {

	private int i4 = 0, n4 = 0;
	private char[] buf4 = new char[4];

	public int read(char[] buf, int n) {
		int i = 0;
		while (i < n && (i4 < n4 || (i4 = 0) < (n4 = read4(buf4))))
			buf[i++] = buf4[i4++];
		return i;
	}

	// Don't really understand what this question is asking.
}
