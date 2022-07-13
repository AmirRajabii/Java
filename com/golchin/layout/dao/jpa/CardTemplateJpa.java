package com.golchin.layout.dao.jpa;

import java.io.Serializable;

import com.golchin.layout.model.CardTemplateEntity;

import jakarta.enterprise.context.SessionScoped;
import ws.safa.standardproject.dao.essential.JpaDao;

@SessionScoped
public class CardTemplateJpa extends JpaDao<CardTemplateEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	public CardTemplateJpa() {
		super(CardTemplateEntity.class);
	}

}
