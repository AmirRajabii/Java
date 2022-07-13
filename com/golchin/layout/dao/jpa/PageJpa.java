package com.golchin.layout.dao.jpa;

import java.io.Serializable;

import com.golchin.layout.model.PageEntity;

import jakarta.enterprise.context.SessionScoped;
import ws.safa.standardproject.dao.essential.JpaDao;

@SessionScoped
public class PageJpa extends JpaDao<PageEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	public PageJpa() {
		super(PageEntity.class);
	}

}
