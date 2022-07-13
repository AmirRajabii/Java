package com.golchin.layout.dao.jpa;

import java.io.Serializable;

import com.golchin.layout.model.TextElementEntity;

import jakarta.enterprise.context.SessionScoped;
import ws.safa.standardproject.dao.essential.JpaDao;

@SessionScoped
public class TextElementJpa extends JpaDao<TextElementEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	public TextElementJpa() {
		super(TextElementEntity.class);
	}

}
