package com.golchin.layout.business.servise.repository;

import java.io.Serializable;

import com.golchin.layout.dao.jpa.RelPageCardTemplateJpa;
import com.golchin.layout.model.RelPageCardTemplateEntity;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import ws.safa.standardproject.business.essential.repository.RepoDto;

@SessionScoped
public class RelPageCardTemplateRepo extends RepoDto<RelPageCardTemplateEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private RelPageCardTemplateJpa jpa;

	@Override
	@PostConstruct
	public void setDao() {
		super.dao = jpa;
	}

	public RelPageCardTemplateRepo() {
		super(RelPageCardTemplateEntity.class);
	}

}
