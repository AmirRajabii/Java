package com.golchin.layout.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import ws.safa.standardproject.dao.essential.MainEntity;

@Entity
@Table(name = "IMAGE_ELEMENT", indexes = { @Index(columnList = "IMAGE_ID") }, uniqueConstraints = {
		@UniqueConstraint(columnNames = "IMAGE_ID") })
@DiscriminatorValue("IMAGE_ELEMENT")
@NamedQueries({

})
@NamedNativeQueries({

})
public class ImageElementEntity extends MainEntity {
	private static final long serialVersionUID = 1L;

	@Lob
	@Column(name = "IMAGE")
	private byte[] image;

	@Column(name = "HEIGHT")
	private int height;

	@Column(name = "WIDTH")
	private int width;

	@Column(name = "IMAGE_ID")
	private String imageID;

	public ImageElementEntity() {
		super();
	}

	public ImageElementEntity(byte[] image, int height, int width, String imageID) {
		super();
		this.image = image;
		this.height = height;
		this.width = width;
		this.imageID = imageID;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
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

	public String getImageID() {
		return imageID;
	}

	public void setImageID(String imageID) {
		this.imageID = imageID;
	}

}
