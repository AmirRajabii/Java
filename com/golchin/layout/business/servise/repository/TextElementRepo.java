package com.golchin.layout.business.servise.repository;

import java.io.Serializable;

import com.golchin.layout.dao.jpa.TextElementJpa;
import com.golchin.layout.model.TextElementEntity;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import ws.safa.standardproject.business.essential.repository.RepoDto;

@SessionScoped
public class TextElementRepo extends RepoDto<TextElementEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private TextElementJpa jpa;

	@Override
	@PostConstruct
	public void setDao() {
		super.dao = jpa;
	}

	public TextElementRepo() {
		super(TextElementEntity.class);
	}

}
