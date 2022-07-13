package com.golchin.layout.dao.jpa;

import java.io.Serializable;

import com.golchin.layout.model.ImageElementEntity;

import jakarta.enterprise.context.SessionScoped;
import ws.safa.standardproject.dao.essential.JpaDao;

@SessionScoped
public class ImageElementJpa extends JpaDao<ImageElementEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	public ImageElementJpa() {
		super(ImageElementEntity.class);
	}

}
