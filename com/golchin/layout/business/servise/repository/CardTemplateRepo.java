package com.golchin.layout.business.servise.repository;

import java.io.Serializable;

import com.golchin.layout.dao.jpa.CardTemplateJpa;
import com.golchin.layout.model.CardTemplateEntity;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import ws.safa.standardproject.business.essential.repository.RepoDto;

@SessionScoped
public class CardTemplateRepo extends RepoDto<CardTemplateEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private CardTemplateJpa jpa;

	@Override
	@PostConstruct
	public void setDao() {
		super.dao = jpa;
	}

	public CardTemplateRepo() {
		super(CardTemplateEntity.class);
	}

}
