package model;

import java.io.File;

public class FontInfo {

	private int fontSize;
	private String fontColor;
	private String fontName;
	private File font;

	public FontInfo() {
		super();
	}

	public FontInfo(int fontSize, String fontColor, String fontName) {
		super();
		this.fontSize = fontSize;
		this.fontColor = fontColor;
		this.fontName = fontName;
		this.font = new File(getFontName());

	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public File getFont() {
		return font;
	}

	public void setFont(File font) {
		this.font = new File(getFontName());
	}

}
