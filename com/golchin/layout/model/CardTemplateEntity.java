package com.golchin.layout.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;
import ws.safa.standardproject.dao.essential.MainEntity;

@Entity
@Table(name = "CARD_TEMPLATE")
@NamedQueries({

})
@NamedNativeQueries({

})
public class CardTemplateEntity extends MainEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "HEIGHT")
	private int height;

	@Column(name = "WIDTH")
	private int width;

	@Lob
	@Column(name = "BACKGROUND")
	private byte[] background;

	public CardTemplateEntity() {
		super();
	}

	public CardTemplateEntity(int height, int width, byte[] background) {
		super();
		this.height = height;
		this.width = width;
		this.background = background;
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

	public byte[] getBackground() {
		return background;
	}

	public void setBackground(byte[] background) {
		this.background = background;
	}

}
