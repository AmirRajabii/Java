package model;

import model.enums.EnumPageType;

public class Page {
	private int width;
	private int height;
	private int paddingBottom;
	private int paddingLeft;
	private int paddingRight;
	private int paddingTop;
	private EnumPageType enumPageType;
	private int rowCount;
	private int columnCount;

	public Page() {
		super();
	}

	public Page(int width, int height, int paddingBottom, int paddingLeft, int paddingRight, int paddingTop,
			EnumPageType enumPageType, int rowCount, int columnCount) {
		super();
		this.width = width;
		this.height = height;
		this.paddingBottom = paddingBottom;
		this.paddingLeft = paddingLeft;
		this.paddingRight = paddingRight;
		this.paddingTop = paddingTop;
		this.enumPageType = enumPageType;
		this.rowCount = rowCount;
		this.columnCount = columnCount;
	}

	public Page(int paddingBottom, int paddingLeft, int paddingRight, int paddingTop, EnumPageType enumPageType,
			int rowCount, int columnCount) {
		super();
		this.paddingBottom = paddingBottom;
		this.paddingLeft = paddingLeft;
		this.paddingRight = paddingRight;
		this.paddingTop = paddingTop;
		this.enumPageType = enumPageType;
		this.rowCount = rowCount;
		this.columnCount = columnCount;
	}

	public Page(int width, int height, int paddingBottom, int paddingLeft, int paddingRight, int paddingTop,
			EnumPageType enumPageType) {
		super();
		this.width = width;
		this.height = height;
		this.paddingBottom = paddingBottom;
		this.paddingLeft = paddingLeft;
		this.paddingRight = paddingRight;
		this.paddingTop = paddingTop;
		this.enumPageType = enumPageType;
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

	public int getPaddingBottom() {
		return paddingBottom;
	}

	public void setPaddingBottom(int paddingBottom) {
		this.paddingBottom = paddingBottom;
	}

	public int getPaddingLeft() {
		return paddingLeft;
	}

	public void setPaddingLeft(int paddingLeft) {
		this.paddingLeft = paddingLeft;
	}

	public int getPaddingRight() {
		return paddingRight;
	}

	public void setPaddingRight(int paddingRight) {
		this.paddingRight = paddingRight;
	}

	public int getPaddingTop() {
		return paddingTop;
	}

	public void setPaddingTop(int paddingTop) {
		this.paddingTop = paddingTop;
	}

	public EnumPageType getEnumPageType() {
		return enumPageType;
	}

	public void setEnumPageType(EnumPageType enumPageType) {
		this.enumPageType = enumPageType;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

}
