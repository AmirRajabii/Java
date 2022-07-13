package com.golchin.layout.dao.jpa;

import java.io.Serializable;

import com.golchin.layout.model.RelCardTemplateElementEntity;

import jakarta.enterprise.context.SessionScoped;
import ws.safa.standardproject.dao.essential.JpaDao;

@SessionScoped
public class RelCardTemplateElementJpa extends JpaDao<RelCardTemplateElementEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	public RelCardTemplateElementJpa() {
		super(RelCardTemplateElementEntity.class);
	}

}
