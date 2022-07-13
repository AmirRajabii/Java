package com.golchin.layout.business.servise.repository;

import java.io.Serializable;

import com.golchin.layout.dao.jpa.PageJpa;
import com.golchin.layout.model.PageEntity;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import ws.safa.standardproject.business.essential.repository.RepoDto;

@SessionScoped
public class PageRepo extends RepoDto<PageEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private PageJpa jpa;

	@Override
	@PostConstruct
	public void setDao() {
		super.dao = jpa;
	}

	public PageRepo() {
		super(PageEntity.class);
	}

}
