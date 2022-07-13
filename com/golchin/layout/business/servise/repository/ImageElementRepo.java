package com.golchin.layout.business.servise.repository;

import java.io.Serializable;

import com.golchin.layout.dao.jpa.ImageElementJpa;
import com.golchin.layout.model.ImageElementEntity;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import ws.safa.standardproject.business.essential.repository.RepoDto;

@SessionScoped
public class ImageElementRepo extends RepoDto<ImageElementEntity, Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private ImageElementJpa jpa;

	@Override
	@PostConstruct
	public void setDao() {
		super.dao = jpa;
	}

	public ImageElementRepo() {
		super(ImageElementEntity.class);
	}

}
