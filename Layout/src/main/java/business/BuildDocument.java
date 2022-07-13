package business;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.ArabicShapingException;
import com.ibm.icu.text.Bidi;

import model.CardTemplate;
import model.ImageElement;
import model.RelCardTemplateElement;
import model.RelUserPage;
import model.TextElement;

public class BuildDocument {
	private PDDocument doc;
	private RelUserPage relUserPage;
	private CardTemplate cardTemplate;

	public BuildDocument(RelUserPage relUserPage) {
		super();
		System.out.println("-----------Start-----------");
		this.relUserPage = relUserPage;
		doc = new PDDocument();
	}

	public void closeFile() throws IOException {
		doc.save(new File(relUserPage.getName()));
		doc.close();
		System.out.println("-----------End-----------");
	}

	public void pageRotation(int valueOfRotation, PDPage page) {
		page.setRotation(valueOfRotation);
	}

	public void setCardTemplate(CardTemplate cardTemplate) {
		this.cardTemplate = cardTemplate;
	}

	// Resize Image and Replace on Old Image
	private void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight)
			throws IOException {
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);
		BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
		g2d.dispose();
		String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);
		ImageIO.write(outputImage, formatName, new File(outputImagePath));
	}

	public void addItem(RelCardTemplateElement cardTemplateElement, PDPageContentStream writer, int xBackground,
			int yBackground) throws Exception {
		if (cardTemplate == null) {
			cardTemplate = cardTemplateElement.getCardTemplate();
		}

		if (cardTemplate != null) {
			addCardBackground(new ImageElement(xBackground, yBackground, cardTemplate.getBackground(),
					cardTemplate.getHeight(), cardTemplate.getWidth(), "11"), writer);
		}

		for (int i = 0; i < cardTemplateElement.getElements().size(); i++) {

			if (cardTemplateElement.getElements().get(i) instanceof TextElement) {
				addText((TextElement) cardTemplateElement.getElements().get(i), writer);
			} else if (cardTemplateElement.getElements().get(i) instanceof ImageElement) {
				addImage((ImageElement) cardTemplateElement.getElements().get(i), writer);
			}
		}
	}

	private void addCardBackground(ImageElement imgElement, PDPageContentStream writer) throws Exception {
		if (imgElement.getImage() == null) {
			return;
		}

		PDImageXObject imageXObject = PDImageXObject.createFromFile(imgElement.getImage(), doc);
		writer.drawImage(imageXObject, imgElement.getxLocation() + relUserPage.getPage().getPaddingLeft(),
				imgElement.getyLocation() + relUserPage.getPage().getPaddingBottom());
	}

	private void addImage(ImageElement imgElement, PDPageContentStream writer) throws Exception {
		resize(imgElement.getImage(), imgElement.getImage(), imgElement.getWidth(), imgElement.getHeight());
		PDImageXObject imageXObject = PDImageXObject.createFromFile(imgElement.getImage(), doc);
		writer.drawImage(imageXObject, imgElement.getxLocation() + relUserPage.getPage().getPaddingLeft(),
				imgElement.getyLocation() + relUserPage.getPage().getPaddingBottom());
	}

	private void addText(TextElement txtElement, PDPageContentStream writer) throws Exception {
		resizeTextFont(txtElement);
		writer.beginText();
		writer.setFont(PDType0Font.load(doc, txtElement.getFontInfo().getFont()),
				txtElement.getFontInfo().getFontSize());
		writer.setNonStrokingColor(Color.decode(txtElement.getFontInfo().getFontColor()));
		writer.newLineAtOffset(txtElement.getxLocation() + relUserPage.getPage().getPaddingLeft(),
				+txtElement.getyLocation() + relUserPage.getPage().getPaddingBottom());
		writer.showText(bidiReorder(txtElement.getTextValue()));
		writer.endText();
	}

	// Resize Text Font and Set With Maximum Width
	private void resizeTextFont(TextElement txtElement) throws Exception {
		PDFont font = PDType0Font.load(doc, txtElement.getFontInfo().getFont());
		int fontsize = txtElement.getFontInfo().getFontSize();
		float width = font.getStringWidth(txtElement.getTextValue().substring(0, txtElement.getTextValue().length()))
				/ 1000 * fontsize;
		while (width > txtElement.getMaxWidth()) {
			width = font.getStringWidth(txtElement.getTextValue().substring(0, txtElement.getTextValue().length()))
					/ 1000 * fontsize;
			fontsize--;
		}
		txtElement.getFontInfo().setFontSize((int) fontsize);
	}

	// arabic typing
	private String bidiReorder(String text) {
		try {
			Bidi bidi = new Bidi((new ArabicShaping(ArabicShaping.LETTERS_SHAPE)).shape(text), 127);
			bidi.setReorderingMode(0);
			return bidi.writeReordered(2);
		} catch (ArabicShapingException ase3) {
			return text;
		}
	}

	public PDPageContentStream addNewPage() throws Exception {
		PDPage page = new PDPage(new PDRectangle(relUserPage.getPage().getWidth(), relUserPage.getPage().getHeight()));
		doc.addPage(page);
		return new PDPageContentStream(doc, page);
	}

	public void closeWriter(PDPageContentStream writer) throws Exception {
		writer.close();
	}

}
