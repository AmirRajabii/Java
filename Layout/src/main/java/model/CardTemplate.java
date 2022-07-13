package model;

public class CardTemplate {
	private int width;
	private int height;
	private String background;

	public CardTemplate() {
		super();
	}

	public CardTemplate(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public CardTemplate(int width, int height, String background) {
		super();
		this.width = width;
		this.height = height;
		this.background = background;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

}
