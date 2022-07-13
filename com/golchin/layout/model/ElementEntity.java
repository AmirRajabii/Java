package com.golchin.layout.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;
import ws.safa.standardproject.dao.essential.MainEntity;

@Entity
@Table(name = "ELEMENT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({

})
@NamedNativeQueries({

})
public class ElementEntity extends MainEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "X_LOCATION")
	private int xLocation;

	@Column(name = "Y_LOCATION")
	private int yLocation;

	public ElementEntity() {
		super();
	}

	public ElementEntity(int xLocation, int yLocation) {
		super();
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}

	public int getxLocation() {
		return xLocation;
	}

	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	public int getyLocation() {
		return yLocation;
	}

	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}

}
