import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String [] num = new String[4];
		num[0]="1";
	for (int i = 1; i < num.length; i++) {
		
		num[i]= num[i-1] + num[i];
	}
	


}
}