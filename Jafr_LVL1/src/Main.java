import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] hrofAbjad = { "ا", "ب", "ج", "د", "ه", "و", "ز", "ح", "ط", "ی", "ک", "ل", "م", "ن", "س", "ع", "ف", "ص",
				"ق", "ر", "س", "ت", "ث", "خ", "ذ", "ض", "ظ", "غ" };
		String[] adadKabireAbjad = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "20", "30", "40", "50", "60",
				"70", "80", "90", "100", "200", "300", "400", "500", "600", "700", "800", "900", "1000" };
		System.out.print("Jomle Ra Vared Konid : ");
		String jomle = new Scanner(System.in).next();
		int sumAtash = 0;
		int sumKhak = 0;
		int sumHava = 0;
		int sumAb = 0;
		int locInArray = 0;
		for (int i = 0; i < jomle.length(); i++) {
			for (int j = 0; j < hrofAbjad.length; j++) {
				if (jomle.charAt(i) == hrofAbjad[j].charAt(0)) {
					locInArray = j;
					break;
				}
			}
			switch (hrofAbjad[locInArray]) {
			case "ا", "ه", "ط", "م", "ف", "ش", "ذ":
				sumAtash += Integer.parseInt(adadKabireAbjad[locInArray]) * 2;
				break;
			case "ب", "و", "ی", "ن", "ص", "ت", "ض":
				sumKhak += Integer.parseInt(adadKabireAbjad[locInArray]) * 2;
				break;
			case "ج", "ز", "ک", "س", "ق", "ث", "ظ":
				sumHava += Integer.parseInt(adadKabireAbjad[locInArray]) * 2;
				break;
			case "د", "ح", "ل", "ع", "ر", "خ", "غ":
				sumAb += Integer.parseInt(adadKabireAbjad[locInArray]) * 2;
				break;
			}
		}
		if (sumAtash / 28 == 0) {
			
		}

	}

}