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

public class BuildDocument {
	private PDDocument doc;
	// private PDPageContentStream writer;
	private DocProperties docProperties;

	public BuildDocument(DocProperties docProperties) {
		super();
		this.docProperties = docProperties;
		doc = new PDDocument();
	}

	public void closeFile() throws IOException {
		// writer.close();
		doc.save(new File(docProperties.getPdfFullPath()));
		doc.close();
		System.out.println("-----------End-----------");
	}

	public void pageRotation(int valueOfRotation, PDPage page) {
		page.setRotation(valueOfRotation);
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

	public void addImage(ImageElement imgElement, PDPageContentStream writer) throws Exception {
		resize(imgElement.getImagePath(), imgElement.getImagePath(), imgElement.getPhtoWidth(),
				imgElement.getPhotoHeight());
		PDImageXObject imageXObject = PDImageXObject.createFromFile(imgElement.getImagePath(), doc);
		writer.drawImage(imageXObject, imgElement.getxLocationImage(), imgElement.getyLocationTextImage());
	}

	public void addText(TextElement txtElement, PDPageContentStream writer) throws Exception {
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
	private void resizeTextFont(TextElement txtElement) throws Exception {
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
		PDPage page = new PDPage(new PDRectangle(docProperties.getPageWidth(), docProperties.getPageHeight()));
		doc.addPage(page);
		return new PDPageContentStream(doc, page);
	}

	public void closeWriter(PDPageContentStream writer) throws Exception {
		writer.close();
	}

}
