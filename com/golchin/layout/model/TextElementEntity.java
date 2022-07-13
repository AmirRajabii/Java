package com.golchin.layout.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;
import ws.safa.standardproject.dao.essential.MainEntity;

@Entity
@Table(name = "TEXT_ELEMENT", indexes = { @Index(columnList = "ID_FONT") })
@DiscriminatorValue("TEXT_ELEMENT")
@NamedQueries({

})
@NamedNativeQueries({

})
public class TextElementEntity extends MainEntity {
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FONT")
	private FontInfoEntity font;

	@Column(name = "MAX_WIDTH")
	private int maxWidth;

	@Column(name = "TEXT_VALUE")
	private String textValue;

	public TextElementEntity() {
		super();
	}

	public TextElementEntity(FontInfoEntity font, int maxWidth, String textValue) {
		super();
		this.font = font;
		this.maxWidth = maxWidth;
		this.textValue = textValue;
	}

	public FontInfoEntity getFont() {
		return font;
	}

	public void setFont(FontInfoEntity font) {
		this.font = font;
	}

	public int getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}

	public String getTextValue() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

}
