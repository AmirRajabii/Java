package view;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import business.BuildDocument;
import business.CsvActions;
import model.DocProperties;
import model.ImageElement;
import model.TextElement;

public class Main {

	public static void main(String[] args) throws Exception {
		long startTime = System.currentTimeMillis();

		BuildDocument bd = new BuildDocument(new DocProperties(3320, 4704, "./test.pdf", 50, 50));
		CsvActions ca = new CsvActions("./796Print.csv");
		int x = 0, y = 0;
		boolean book = false;

		PDPageContentStream writer = null;
		for (int i = 1; i <= 30; i++) {

			if (!book && (i - 1) % 12 == 0) {
				if (writer != null) {
					bd.closeWriter(writer);
				}
				writer = bd.addNewPage();
				x = 0;
				y = 0;
			} else if (book && (i - 1) % 24 == 0) {
				if (writer != null) {
					bd.closeWriter(writer);
				}
				writer = bd.addNewPage();
				x = 0;
				y = 0;
			}

			bd.addText(
					new TextElement(ca.get().get(i)[1], 30, "#000000", "./times new roman.ttf", 300, 320 + x, 4320 + y),
					writer);
			bd.addText(
					new TextElement(ca.get().get(i)[3], 30, "#ff0000", "./times new roman.ttf", 300, 320 + x, 4380 + y),
					writer);
			bd.addText(
					new TextElement(ca.get().get(i)[2], 40, "#0000ff", "./times new roman.ttf", 350, 700 + x, 4495 + y),
					writer);
			bd.addImage(new ImageElement("./user.jpeg", 200, 200, 900 + x, 4300 + y), writer);

			if (i % 3 != 0) {
				x += 900;
			} else if (i % 3 == 0) {
				x = 0;
				y -= 570;
			}
		}
		bd.closeWriter(writer);
		bd.closeFile();

		long endTime = System.currentTimeMillis();
		System.out.println((float) (endTime - startTime) / 1000 + " Second");
	}
}
