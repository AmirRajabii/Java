package com.golchin.layout.business.servise.repository;

import java.io.Serializable;

import com.golchin.layout.dao.jpa.FontInfoJpa;
import com.golchin.layout.model.FontInfoEntity;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import ws.safa.standardproject.business.essential.repository.RepoDto;

@SessionScoped
public class FontInfoRepo extends RepoDto<FontInfoEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private FontInfoJpa jpa;

	@Override
	@PostConstruct
	public void setDao() {
		super.dao = jpa;
	}

	public FontInfoRepo() {
		super(FontInfoEntity.class);
	}

}
