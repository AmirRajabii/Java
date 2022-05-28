package model;

public class DocProperties {
	private int pageWidth;
	private int pageHeight;
	private String pdfFullPath;
	private int marginTopDown;
	private int marginLeftRight;

	public DocProperties(int pageWidth, int pageHeight, String pdfFullPath, int marginTopDown, int marginLeftRight) {
		super();
		this.pageWidth = pageWidth;
		this.pageHeight = pageHeight;
		this.pdfFullPath = pdfFullPath;
		this.marginTopDown = marginTopDown;
		this.marginLeftRight = marginLeftRight;
	}

	public DocProperties() {
		super();
	}

	public int getPageWidth() {
		return pageWidth;
	}

	public void setPageWidth(int pageWidth) {
		this.pageWidth = pageWidth;
	}

	public int getPageHeight() {
		return pageHeight;
	}

	public void setPageHeight(int pageHeight) {
		this.pageHeight = pageHeight;
	}

	public String getPdfFullPath() {
		return pdfFullPath;
	}

	public void setPdfFullPath(String pdfFullPath) {
		this.pdfFullPath = pdfFullPath;
	}

	public int getMarginTopDown() {
		return marginTopDown;
	}

	public void setMarginTopDown(int marginTopDown) {
		this.marginTopDown = marginTopDown;
	}

	public int getMarginLeftRight() {
		return marginLeftRight;
	}

	public void setMarginLeftRight(int marginLeftRight) {
		this.marginLeftRight = marginLeftRight;
	}

}
