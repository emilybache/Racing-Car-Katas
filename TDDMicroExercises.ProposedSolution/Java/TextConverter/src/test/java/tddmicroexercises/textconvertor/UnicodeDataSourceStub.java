package tddmicroexercises.textconvertor;

import java.io.IOException;
import java.util.Stack;


public class UnicodeDataSourceStub implements UnicodeDataSource {

	private Stack<String> values = new Stack<String>();

	public String readLine() throws IOException {
		if(values.isEmpty()){
			return null;
		} else {
			return values.pop();
		}
	}

	public void setLine(String string) {
		values.push(string);
	}

}
