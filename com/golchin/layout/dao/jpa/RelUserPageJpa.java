package com.golchin.layout.dao.jpa;

import java.io.Serializable;

import com.golchin.layout.model.RelUserPageEntity;

import jakarta.enterprise.context.SessionScoped;
import ws.safa.standardproject.dao.essential.JpaDao;

@SessionScoped
public class RelUserPageJpa extends JpaDao<RelUserPageEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	public RelUserPageJpa() {
		super(RelUserPageEntity.class);
	}

}
