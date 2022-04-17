import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CsvToArray {
	private String[][] array = new String[3][4];
	File f;

	public CsvToArray(String path) {
		super();
		f = new File(path);
	}

	public void addToArray(int pageNumber , int x, int y) throws Exception {
		String temp;
		int counter = 1;
		int i = (12*(pageNumber-1))+((x*2)+(y*3));
		BufferedReader bf = new BufferedReader(new FileReader(f));
		while ((temp= bf.readLine())!=null) {
			counter++;
			if(counter==i) {
				System.out.println( array[x][y]=temp);
			
			}
		}
	}
}
