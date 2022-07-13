package com.golchin.layout.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import ws.safa.standardproject.dao.essential.MainEntity;
import ws.safa.standardproject.model.UserEntity;

@Entity
@Table(name = "REL_USER_PAGE", indexes = { @Index(columnList = "ID_USER"), @Index(columnList = "ID_PAGE") })
@NamedQueries({

})
@NamedNativeQueries({

})
public class RelUserPageEntity extends MainEntity {
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USER")
	private UserEntity user;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CREATION_DATE")
	private long creationDate;

	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PAGE")
	private PageEntity page;

	public RelUserPageEntity() {
		super();
	}

	public RelUserPageEntity(UserEntity user, String name, long creationDate, PageEntity page) {
		super();
		this.user = user;
		this.name = name;
		this.creationDate = creationDate;
		this.page = page;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}

	public PageEntity getPage() {
		return page;
	}

	public void setPage(PageEntity page) {
		this.page = page;
	}

}
