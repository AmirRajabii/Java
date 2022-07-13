package model;

public class ImageElement extends Element {
	private String image;
	private int height;
	private int width;
	private String imageId;

	public ImageElement() {
		super();
	}

	public ImageElement(int xLocation, int yLocation, String image, int height, int width, String imageId) {
		super(xLocation, yLocation);
		this.image = image;
		this.height = height;
		this.width = width;
		this.imageId = imageId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

}
