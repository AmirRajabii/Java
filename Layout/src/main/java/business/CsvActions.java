package business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.ibm.icu.text.DecimalFormat.PropertySetter;

public class CsvActions {

	String filename;

	public CsvActions(String filename) {
		super();
		this.filename = filename;
	}

	public List<String[]> get() {
		List<String[]> data = new ArrayList<String[]>();
		String testRow;
		BufferedReader br;
		try {
			 br = new BufferedReader(new FileReader(filename));
			while ((testRow = br.readLine()) != null) {
				String[] line = parseCSVLine(testRow);
				data.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found " + filename);
		} catch (IOException e) {
			System.out.println("ERROR: Could not read " + filename);
		}
		return data;
	}

	private String[] parseCSVLine(String line) {
		// Create a pattern to match breaks
		Pattern pattern = Pattern.compile(",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");
		// Split input with the pattern
		String[] fields = pattern.split(line);
		for (int i = 0; i < fields.length; i++) {
			// Get rid of residual double quotes
			fields[i] = fields[i].replace("\"", "");
		}
		return fields;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
}
