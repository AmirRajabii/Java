package com.golchin.layout.dao.jpa;

import java.io.Serializable;

import com.golchin.layout.model.ElementEntity;

import jakarta.enterprise.context.SessionScoped;
import ws.safa.standardproject.dao.essential.JpaDao;

@SessionScoped
public class ElementJpa extends JpaDao<ElementEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	public ElementJpa() {
		super(ElementEntity.class);
	}

}
