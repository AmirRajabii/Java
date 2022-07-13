package view;

import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.util.Matrix;

import business.BuildDocument;
import business.CsvActions;
import model.CardTemplate;
import model.Element;
import model.FontInfo;
import model.ImageElement;
import model.Page;
import model.RelCardTemplateElement;
import model.RelUserPage;
import model.TextElement;
import model.enums.EnumPageType;
import model.enums.EnumSide;

public class Main {

	public static void main(String[] args) throws Exception {
		// CardTemplate cardTemplate = new CardTemplate(319, 505, "./cardTemp.png");
		long startTime = System.currentTimeMillis();
		Page page = new Page(2000, 3200, 50, 100, 5, 5, EnumPageType.BOOK);
		RelUserPage relUserPage = new RelUserPage("./Book.pdf", 100, page);
		BuildDocument bd = new BuildDocument(relUserPage);
		CsvActions ca = new CsvActions("./796Print.csv");
		int x = 0, y = 0, xBack = 0, yBack = 0;
		PDPageContentStream writer = null;
		CardTemplate card = new CardTemplate(505, 319, "./cardTemp.png");
		List<RelCardTemplateElement> cardFinals = new ArrayList<RelCardTemplateElement>();
		Matrix matrix;

		if (page.getEnumPageType() == EnumPageType.SINGLE) {
			for (int i = 1; i <= 48; i++) { // 40 = page.getRow * page.getCol ()
				if ((i - 1) % 24 == 0) { // 12 = page.getRow()
					if (writer != null) {
						bd.closeWriter(writer);
					}
					writer = bd.addNewPage();
					x = 0;
					y = 0;
				}
				RelCardTemplateElement relCardTemplateElement = new RelCardTemplateElement();
				relCardTemplateElement.setElements(new ArrayList<Element>());
				relCardTemplateElement.setCardTemplate(card);
				relCardTemplateElement.getElements().add(new TextElement((110 + x), (2960 + y),
						new FontInfo(30, "#ffffff", "./times new roman.ttf"), ca.get().get(i)[1], 200));
				relCardTemplateElement.getElements().add(new TextElement((100 + x), (2720 + y),
						new FontInfo(30, "#ff0000", "./times new roman.ttf"), ca.get().get(i)[2], 300));
				relCardTemplateElement.getElements().add(new TextElement((10 + x), (2765 + y),
						new FontInfo(30, "#00ff00", "./times new roman.ttf"), ca.get().get(i)[3], 300));
				cardFinals.add(relCardTemplateElement);
				relCardTemplateElement.getElements()
						.add(new ImageElement(30 + x, 2830 + y, "./user.jpg", 100, 100, "1"));
				relCardTemplateElement.getElements()
						.add(new ImageElement(400 + x, 2830 + y, "./user.jpg", 100, 100, "1"));

				bd.addItem(new RelCardTemplateElement(cardFinals.get(i - 1).getCardTemplate(),
						cardFinals.get(i - 1).getElements(), EnumSide.FRONT), writer, 1 + x, 2700 + y);

				if (i % 3 != 0) { // 3 = page.getCol()
					x += 510;
				} else if (i % 3 == 0) {
					x = 0;
					y -= 321;
				}

			}

		// ---------------------------------------------------------------------------------------------\

		} else if (page.getEnumPageType() == EnumPageType.BOOK) {
			CardTemplate cardBack = new CardTemplate(505, 319,"./cardTemp2.jpg");
			List<RelCardTemplateElement> cardFinalsBack = new ArrayList<RelCardTemplateElement>();
			for (int i = 1; i <= 48; i++) { // 40 = page.getRow * page.getCol ()
				if ((i - 1) % 12 == 0) { // 12 = page.getRow()
					if (writer != null) {
						bd.closeWriter(writer);
					}
					writer = bd.addNewPage();
					x = 0;
					y = 0;
					xBack = 0;
					yBack = 0;
				}

				RelCardTemplateElement relCardTemplateElement = new RelCardTemplateElement();
				relCardTemplateElement.setElements(new ArrayList<Element>());
				relCardTemplateElement.setCardTemplate(card);
				relCardTemplateElement.getElements().add(new TextElement((110 + x), (2960 + y),
						new FontInfo(30, "#ffffff", "./times new roman.ttf"), ca.get().get(i)[1], 200));
				relCardTemplateElement.getElements().add(new TextElement((100 + x), (2720 + y),
						new FontInfo(30, "#ff0000", "./times new roman.ttf"), ca.get().get(i)[2], 300));
				relCardTemplateElement.getElements().add(new TextElement((10 + x), (2765 + y),
						new FontInfo(30, "#00ff00", "./times new roman.ttf"), ca.get().get(i)[3], 300));
				relCardTemplateElement.getElements()
						.add(new ImageElement(30 + x, 2830 + y, "./user.jpg", 100, 100, "1"));
				relCardTemplateElement.getElements()
						.add(new ImageElement(400 + x, 2830 + y, "./user.jpg", 100, 100, "1"));
				cardFinals.add(relCardTemplateElement);

				bd.addItem(new RelCardTemplateElement(cardFinals.get(i - 1).getCardTemplate(),
						cardFinals.get(i - 1).getElements(), EnumSide.FRONT), writer, 1 + x, 2700 + y);

				if (i % 3 != 0) { // 3 = page.getCol()
					x += 510;
				} else if (i % 3 == 0) {
					x = 0;
					y -= 321;
				}
				
				matrix = Matrix.getRotateInstance(Math.toRadians(180), page.getWidth(), (card.getWidth() * 4));
				writer.transform(matrix);
				page.setPaddingLeft(page.getWidth()
						- (((card.getWidth() * 3) + ((510 - card.getWidth()) * 2)) + page.getPaddingLeft()));

				RelCardTemplateElement relCardTemplateElementBack = new RelCardTemplateElement();
				relCardTemplateElementBack.setElements(new ArrayList<Element>());
				relCardTemplateElementBack.setCardTemplate(cardBack);
				relCardTemplateElementBack.getElements().add(new TextElement((1130 + xBack), (1500 + yBack),
						new FontInfo(30, "#0000ff", "./times new roman.ttf"), ca.get().get(i)[4], 200));
				relCardTemplateElementBack.getElements().add(new TextElement((1120 + xBack), (1300 + yBack),
						new FontInfo(30, "#ff0000", "./times new roman.ttf"), ca.get().get(i)[6], 300));
				relCardTemplateElementBack.getElements().add(new TextElement((1030 + xBack), (1350 + yBack),
						new FontInfo(30, "#00ff00", "./times new roman.ttf"), ca.get().get(i)[7], 300));
				cardFinalsBack.add(relCardTemplateElementBack);

				bd.addItem(
						new RelCardTemplateElement(cardFinalsBack.get(i - 1).getCardTemplate(),
								cardFinalsBack.get(i - 1).getElements(), EnumSide.BACK),
						writer, 1021 + xBack, (card.getHeight() * 4) + yBack);

				matrix = Matrix.getRotateInstance(Math.toRadians(-180), page.getWidth(), (card.getWidth() * 4));
				writer.transform(matrix);
				page.setPaddingLeft(page.getWidth()
						- (((card.getWidth() * 3) + ((510 - card.getWidth()) * 2)) + page.getPaddingLeft()));
				if (i % 3 != 0) { // 3 = page.getCol()
					xBack += -510;
				} else if (i % 3 == 0) {
					xBack = 0;
					yBack += -321;
				}
			}

			// ---------------------------------------------------------------------------------------------\

		} else if (page.getEnumPageType() == EnumPageType.BOTH) {
			for (int i = 1; i <= 48; i++) { // 40 = page.getRow * page.getCol ()
				if ((i - 1) % 24 == 0) { // 12 = page.getRow()
					if (writer != null) {
						bd.closeWriter(writer);
					}
					writer = bd.addNewPage();
					x = 0;
					y = 0;
				}
				RelCardTemplateElement relCardTemplateElement = new RelCardTemplateElement();
				relCardTemplateElement.setElements(new ArrayList<Element>());
				relCardTemplateElement.setCardTemplate(card);
				relCardTemplateElement.getElements().add(new TextElement((110 + (card.getWidth() * 2) + x), (2960 + y),
						new FontInfo(30, "#ffffff", "./times new roman.ttf"), ca.get().get(i)[1], 200));
				relCardTemplateElement.getElements().add(new TextElement((100 + (card.getWidth() * 2) + x), (2720 + y),
						new FontInfo(30, "#ff0000", "./times new roman.ttf"), ca.get().get(i)[2], 300));
				relCardTemplateElement.getElements().add(new TextElement((10 + (card.getWidth() * 2) + x), (2765 + y),
						new FontInfo(30, "#00ff00", "./times new roman.ttf"), ca.get().get(i)[3], 300));
				cardFinals.add(relCardTemplateElement);
				relCardTemplateElement.getElements()
						.add(new ImageElement(30 + (card.getWidth() * 2) + x, 2830 + y, "./user.jpg", 100, 100, "1"));
				relCardTemplateElement.getElements()
						.add(new ImageElement(400 + (card.getWidth() * 2) + x, 2830 + y, "./user.jpg", 100, 100, "1"));

				bd.addItem(
						new RelCardTemplateElement(cardFinals.get(i - 1).getCardTemplate(),
								cardFinals.get(i - 1).getElements(), EnumSide.FRONT),
						writer, 1 + (card.getWidth() * 2) + x, 2700 + y);

				if (i % 3 != 0) { // 3 = page.getCol()
					x += -510;
				} else if (i % 3 == 0) {
					x = 0;
					y -= 321;
				}
			}
		}
		bd.closeWriter(writer);
		bd.closeFile();

		long endTime = System.currentTimeMillis();
		System.out.println((float) (endTime - startTime) / 1000 + " Second");
	}
}
