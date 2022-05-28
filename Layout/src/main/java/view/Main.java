package view;

import business.BuildPage;
import business.CsvActions;
import model.DocProperties;
import model.ImageElement;
import model.TextElement;

public class Main {

	public static void main(String[] args) throws Exception {
		BuildPage.buildFile(new DocProperties(3320, 4704, "./test.pdf", 50, 50));
		CsvActions ca = new CsvActions("./796Print.csv");
		int x = 0, y = 0;
		boolean book = true;
		for (int i = 1; i < 25; i++) {
			BuildPage.addText(new TextElement(ca.get().get(i)[1], 30, "#000000", "./times new roman.ttf", 300, 320 + x,
					4320 + y));
			BuildPage.addText(new TextElement(ca.get().get(i)[3], 30, "#ff0000", "./times new roman.ttf", 300, 320 + x,
					4380 + y));
			BuildPage.addText(new TextElement(ca.get().get(i)[2], 30, "#0000ff", "./times new roman.ttf", 300, 700 + x,
					4495 + y));
			BuildPage.addImage(new ImageElement("./user.jpeg", 200, 200, 900 + x, 4300 + y));

			if (i % 3 != 0) {
				x += 900;
			} else if (i % 3 == 0) {
				x = 0;
				y -= 570;
			}
			if (i % 12 == 0 && !book) {
				x = 0;
				y = 0;
			} else if (book && i % 24 == 0) {
				x = 0;
				y = 0;
			}
		}
		BuildPage.closeFile();

	}
}
