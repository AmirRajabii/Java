package model;

import java.io.File;

public class TextElement {

	private DocProperties docProperties;
	private String text;
	private int textSize;
	private String textColor;
	private String fontName;
	private File fontFile;
	private int maxTextWidth;
	private int xLocationText;
	private int yLocationText;

	public TextElement(String text, int textSize, String textColor, String fontName, int textWidth, int xLocation,
			int yLocation) {
		super();
		this.text = text;
		this.textSize = textSize;
		this.textColor = textColor;
		this.fontName = fontName;
		this.maxTextWidth = textWidth;
		this.xLocationText = xLocation;
		this.yLocationText = yLocation;
		setFontFile();
	}

	public TextElement() {
		super();
	}

	public DocProperties getDocProperties() {
		return docProperties;
	}

	public void setDocProperties(DocProperties docProperties) {
		this.docProperties = docProperties;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTextSize() {
		return textSize;
	}

	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public int getMaxTextWidth() {
		return maxTextWidth;
	}

	public void setMaxTextWidth(int textWidth) {
		this.maxTextWidth = textWidth;
	}

	public int getxLocationText() {
		return xLocationText;
	}

	public void setxLocationText(int xLocation) {
		this.xLocationText = xLocation;
	}

	public int getyLocationText() {
		return yLocationText;
	}

	public void setyLocationText(int yLocation) {
		this.yLocationText = yLocation;
	}

	public File getFontFile() {
		return fontFile;
	}

	public void setFontFile() {
		fontFile = new File(getFontName());
	}

}
