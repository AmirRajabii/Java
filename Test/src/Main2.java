import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		System.out.print("Enter a String : ");
		String name = new Scanner(System.in).next();
		int num=name.length();
		fncFor(num,name);
	}

	private static void fncFor(int num,String name) {
		for (int i = 0; i < num; i++) {
			fncSpace(num + 1 - i);
			fncUnderFor(i, num,name);
			System.out.println();
		}
		for (int i = num - 2; i >= 0; i--) {
			fncSpace(num + 1 - i);
			fncUnderFor(i, num,name);
			System.out.println();
		}
	}

	private static void fncUnderFor(int i, int num,String name) {
		int u = 0;
		for (int j = 0; j <= i; j++) {
			System.out.print( name.charAt(j) );
			u = j;
		}
		for (int p = u - 1; p >=0 ; p--) {
			System.out.print( name.charAt(p) );
		}
	}

	private static void fncSpace(int space) {
		for (int i = 1; i < space; i++) {
			System.out.print(" ");

		}
	}
}
