package com.golchin.layout.business.servise.repository;

import java.io.Serializable;

import com.golchin.layout.dao.jpa.RelUserPageJpa;
import com.golchin.layout.model.RelUserPageEntity;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import ws.safa.standardproject.business.essential.repository.RepoDto;

@SessionScoped
public class RelUserPageRepo extends RepoDto<RelUserPageEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private RelUserPageJpa jpa;

	@Override
	@PostConstruct
	public void setDao() {
		super.dao = jpa;
	}

	public RelUserPageRepo() {
		super(RelUserPageEntity.class);
	}

}
