package model;

public class ImageElement {
	private DocProperties docProperties;
	private String imagePath;
	private int photoHeight;
	private int phtoWidth;
	private int xLocationImage;
	private int yLocationTextImage;

	public ImageElement(String imagePath, int photoHeight, int phtoWidth, int xLocationImage, int yLocationTextImage) {
		super();
		this.imagePath = imagePath;
		this.photoHeight = photoHeight;
		this.phtoWidth = phtoWidth;
		this.xLocationImage = xLocationImage;
		this.yLocationTextImage = yLocationTextImage;
	}

	public ImageElement() {
		super();
	}

	public DocProperties getDocProperties() {
		return docProperties;
	}

	public void setDocProperties(DocProperties docProperties) {
		this.docProperties = docProperties;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getPhotoHeight() {
		return photoHeight;
	}

	public void setPhotoHeight(int photoHeight) {
		this.photoHeight = photoHeight;
	}

	public int getPhtoWidth() {
		return phtoWidth;
	}

	public void setPhtoWidth(int phtoWidth) {
		this.phtoWidth = phtoWidth;
	}

	public int getxLocationImage() {
		return xLocationImage;
	}

	public void setxLocationImage(int xLocationImage) {
		this.xLocationImage = xLocationImage;
	}

	public int getyLocationTextImage() {
		return yLocationTextImage;
	}

	public void setyLocationTextImage(int yLocationTextImage) {
		this.yLocationTextImage = yLocationTextImage;
	}

}
