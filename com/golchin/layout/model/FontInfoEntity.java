package com.golchin.layout.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;
import ws.safa.standardproject.dao.essential.MainEntity;

@Entity
@Table(name = "FONT_INFO", indexes = { @Index(columnList = "FONT_NAME") })
@NamedQueries({

})
@NamedNativeQueries({

})
public class FontInfoEntity extends MainEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "FONT_NAME")
	private String fontName;

	@Column(name = "FONT_SIZE")
	private String fontSize;

	@Column(name = "FONT_COLOR")
	private String fontColor;

	@Lob
	@Column(name = "FONT")
	private byte[] font;

	public FontInfoEntity() {
		super();
	}

	public FontInfoEntity(String fontName, String fontSize, String fontColor, byte[] font) {
		super();
		this.fontName = fontName;
		this.fontSize = fontSize;
		this.fontColor = fontColor;
		this.font = font;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public String getFontSize() {
		return fontSize;
	}

	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}

	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public byte[] getFont() {
		return font;
	}

	public void setFont(byte[] font) {
		this.font = font;
	}

}
