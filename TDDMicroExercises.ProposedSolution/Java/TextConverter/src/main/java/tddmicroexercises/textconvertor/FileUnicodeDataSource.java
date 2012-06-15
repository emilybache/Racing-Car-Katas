package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUnicodeDataSource implements UnicodeDataSource {
	
	private BufferedReader reader;

	public FileUnicodeDataSource(String fullFilenameWithPath) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(fullFilenameWithPath));
	}

	public String readLine() throws IOException {
		return reader.readLine();
	}

}
