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

import model.DocProperties;
import model.ImageElement;
import model.TextElement;

public class BuildPage {
	private static PDDocument doc;
	private static PDPage Page;
	private static PDPageContentStream writer;
	private static DocProperties docProperties;

	public static void buildFile(DocProperties docProperties) throws IOException {
		BuildPage.docProperties = docProperties;
		System.out.println("-----------Start-----------");
		doc = new PDDocument();
		Page = new PDPage(new PDRectangle(docProperties.getPageWidth(), docProperties.getPageHeight()));
		doc.addPage(Page);
		writer = new PDPageContentStream(doc, Page);
	}

	public static void closeFile() throws IOException {
		writer.close();
		doc.save(new File(docProperties.getPdfFullPath()));
		doc.close();
		System.out.println("-----------End-----------");
	}

	public void pageRotation(int valueOfRotation) {
		Page.setRotation(valueOfRotation);
	}

	// Resize Image and Replace on Old Image
	private static void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight)
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

	public static void addImage(ImageElement imgElement) throws Exception {
		resize(imgElement.getImagePath(), imgElement.getImagePath(), imgElement.getPhtoWidth(),
				imgElement.getPhotoHeight());
		PDImageXObject imageXObject = PDImageXObject.createFromFile(imgElement.getImagePath(), doc);
		writer.drawImage(imageXObject, imgElement.getxLocationImage(), imgElement.getyLocationTextImage());
	}

	public static void addText(TextElement txtElement) throws Exception {
		resizeTextFont(txtElement);
		writer.beginText();
		writer.setFont(PDType0Font.load(doc, txtElement.getFontFile()), txtElement.getTextSize());
		writer.setNonStrokingColor(Color.decode(txtElement.getTextColor()));
		writer.newLineAtOffset(txtElement.getxLocationText() + docProperties.getMarginLeftRight(),
				+txtElement.getyLocationText() + docProperties.getMarginTopDown());
		writer.showText(bidiReorder(txtElement.getText()));
		writer.endText();
	}

	// Resize Text Font and Set With Maximum Width
	private static void resizeTextFont(TextElement txtElement) throws Exception {
		PDFont font = PDType0Font.load(doc, txtElement.getFontFile());
		int fontsize = txtElement.getTextSize();
		float width = font.getStringWidth(txtElement.getText().substring(0, txtElement.getText().length())) / 1000
				* fontsize;
		while (width > txtElement.getMaxTextWidth()) {
			width = font.getStringWidth(txtElement.getText().substring(0, txtElement.getText().length())) / 1000
					* fontsize;
			fontsize--;
		}
		txtElement.setTextSize((int) fontsize);
	}

	// arabic typing
	private static String bidiReorder(String text) {
		try {
			Bidi bidi = new Bidi((new ArabicShaping(ArabicShaping.LETTERS_SHAPE)).shape(text), 127);
			bidi.setReorderingMode(0);
			return bidi.writeReordered(2);
		} catch (ArabicShapingException ase3) {
			return text;
		}
	}

//	public void addNewPage() throws Exception {
//		doc.addPage(Page);
//	}

}
