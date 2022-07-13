package com.golchin.layout.business.servise.repository;

import java.io.Serializable;

import com.golchin.layout.dao.jpa.RelCardTemplateElementJpa;
import com.golchin.layout.model.RelCardTemplateElementEntity;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import ws.safa.standardproject.business.essential.repository.RepoDto;

@SessionScoped
public class RelCardTemplateElementRepo extends RepoDto<RelCardTemplateElementEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private RelCardTemplateElementJpa jpa;

	@Override
	@PostConstruct
	public void setDao() {
		super.dao = jpa;
	}

	public RelCardTemplateElementRepo() {
		super(RelCardTemplateElementEntity.class);
	}

}
