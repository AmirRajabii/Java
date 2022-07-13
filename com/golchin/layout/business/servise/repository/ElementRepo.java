package com.golchin.layout.business.servise.repository;

import java.io.Serializable;

import com.golchin.layout.dao.jpa.ElementJpa;
import com.golchin.layout.model.ElementEntity;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import ws.safa.standardproject.business.essential.repository.RepoDto;

@SessionScoped
public class ElementRepo extends RepoDto<ElementEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ElementJpa jpa;

	@Override
	@PostConstruct
	public void setDao() {
		super.dao = jpa;
	}

	public ElementRepo() {
		super(ElementEntity.class);
	}

}
