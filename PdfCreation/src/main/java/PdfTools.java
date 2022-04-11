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
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.ArabicShapingException;
import com.ibm.icu.text.Bidi;

public class PdfTools {
	// file attributes
	private String fileName;
	private String filePath;
	private String fontPath;
	private int fileWidthSize;
	private int fileHeightSize;
	private int marginTop_Bot;
	private int marginLeft_Right;

	// file building
	private File file;
	private PDDocument doc;
	private PDPage Page;
	private PDPageContentStream Writer;

	public PdfTools(String fileName, String filePath, String fontPath, int fileWidthSize, int fileHeightSize,
			int marginTop_Bot, int marginLeft_Right) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
		this.fontPath = fontPath;
		this.fileWidthSize = fileWidthSize;
		this.fileHeightSize = fileHeightSize;
		this.marginTop_Bot = marginTop_Bot;
		this.marginLeft_Right = marginLeft_Right;

	}

	public void buildFile() throws IOException {
		file = new File(fontPath);
		doc = new PDDocument();
		Page = new PDPage(new PDRectangle(fileWidthSize, fileHeightSize));
		doc.addPage(Page);
		Writer = new PDPageContentStream(doc, Page);

	}

	public void closeFile() throws IOException {
		Writer.close();
		doc.save(new File(filePath + fileName + ".pdf"));
		doc.close();
	}

	public void addPhoto(String imagePath, int imagePosX, int imagePosY, int photoWidth, int photoHeight)
			throws IOException {
		resize(imagePath, imagePath, photoWidth, photoHeight);
		PDImageXObject imageXObject = PDImageXObject.createFromFile(imagePath, doc);
		Writer.drawImage(imageXObject, imagePosX, imagePosY);
	}

	public void addText(String text, int textPosX, int textPosY, String fontColor, int fontSize) throws IOException {
		if (textPosX + marginLeft_Right >= fileWidthSize - marginLeft_Right) {
			textPosX = fileWidthSize - marginLeft_Right * 2;
		}
		if (textPosY + marginTop_Bot >= fileHeightSize - marginTop_Bot) {
			textPosY = fileHeightSize - marginTop_Bot * 2;
		}

		Writer.beginText();
		Writer.setFont(PDType0Font.load(doc, file), fontSize);
		Writer.setNonStrokingColor(Color.decode(fontColor));
		Writer.newLineAtOffset(textPosX + marginLeft_Right, textPosY + marginTop_Bot);
		Writer.showText(bidiReorder(text));
		Writer.endText();
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

	// Resize Photo
	public static void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight)
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

	public void rotation(int valueOfRotation) {
		Page.setRotation(valueOfRotation);
	}
}
