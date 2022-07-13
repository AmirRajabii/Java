package com.golchin.layout.model;

import com.golchin.layout.model.enums.EnumSide;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;
import ws.safa.standardproject.dao.essential.MainEntity;

@Entity
@Table(name = "PAGE")
@NamedQueries({

})
@NamedNativeQueries({

})
public class PageEntity extends MainEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "HEIGHT")
	private int height;

	@Column(name = "WIDTH")
	private int width;

	@Column(name = "PADDING_BOTTOM")
	private int paddingBottom;

	@Column(name = "PADDING_LEFT")
	private int paddingLeft;

	@Column(name = "PADDING_TOP")
	private int paddingTop;

	@Column(name = "PADDING_RIGHT")
	private int paddingRight;

	@Column(name = "ROW_COUNT")
	private int rowCount;

	@Column(name = "COLUMN_COUNT")
	private int columnCount;

	@Enumerated(EnumType.STRING)
	@Column(name = "ENUM_PAGE_TYPE")
	private EnumSide enumPageType;

	public PageEntity() {
		super();
	}

	public PageEntity(int height, int width, int paddingBottom, int paddingLeft, int paddingTop, int paddingRight,
			int rowCount, int columnCount, EnumSide enumPageType) {
		super();
		this.height = height;
		this.width = width;
		this.paddingBottom = paddingBottom;
		this.paddingLeft = paddingLeft;
		this.paddingTop = paddingTop;
		this.paddingRight = paddingRight;
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		this.enumPageType = enumPageType;
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

	public int getPaddingTop() {
		return paddingTop;
	}

	public void setPaddingTop(int paddingTop) {
		this.paddingTop = paddingTop;
	}

	public int getPaddingRight() {
		return paddingRight;
	}

	public void setPaddingRight(int paddingRight) {
		this.paddingRight = paddingRight;
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

	public EnumSide getEnumPageType() {
		return enumPageType;
	}

	public void setEnumPageType(EnumSide enumPageType) {
		this.enumPageType = enumPageType;
	}

}
