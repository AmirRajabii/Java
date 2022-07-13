package com.golchin.layout.dao.jpa;

import java.io.Serializable;

import com.golchin.layout.model.RelPageCardTemplateEntity;

import jakarta.enterprise.context.SessionScoped;
import ws.safa.standardproject.dao.essential.JpaDao;

@SessionScoped
public class RelPageCardTemplateJpa extends JpaDao<RelPageCardTemplateEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	public RelPageCardTemplateJpa() {
		super(RelPageCardTemplateEntity.class);
	}

}
