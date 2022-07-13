package com.golchin.layout.dao.jpa;

import java.io.Serializable;

import com.golchin.layout.model.FontInfoEntity;

import jakarta.enterprise.context.SessionScoped;
import ws.safa.standardproject.dao.essential.JpaDao;

@SessionScoped
public class FontInfoJpa extends JpaDao<FontInfoEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	public FontInfoJpa() {
		super(FontInfoEntity.class);
	}

}
