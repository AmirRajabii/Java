package model;

public class TextElement extends Element {

	private FontInfo fontInfo;
	private String textValue;
	private int maxWidth;

	public TextElement() {
		super();
	}

	public TextElement(int xLocation, int yLocation, FontInfo fontInfo, String textValue, int maxWidth) {
		super(xLocation, yLocation);
		this.fontInfo = fontInfo;
		this.textValue = textValue;
		this.maxWidth = maxWidth;
	}



	public FontInfo getFontInfo() {
		return fontInfo;
	}

	public void setFontInfo(FontInfo fontInfo) {
		this.fontInfo = fontInfo;
	}

	public String getTextValue() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}

}
