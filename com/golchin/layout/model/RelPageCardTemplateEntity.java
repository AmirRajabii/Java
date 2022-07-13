package com.golchin.layout.model;

import jakarta.persistence.CascadeType;
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

@Entity
@Table(name = "REL_PAGE_CARD_TEMPLATE", indexes = { @Index(columnList = "ID_CARD_TEMPLATE"),
		@Index(columnList = "ID_PAGE") })
@NamedQueries({

})
@NamedNativeQueries({

})
public class RelPageCardTemplateEntity extends MainEntity {
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARD_TEMPLATE")
	private RelCardTemplateElementEntity cardTemplate;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PAGE")
	private PageEntity page;

	public RelPageCardTemplateEntity() {
		super();
	}

	public RelPageCardTemplateEntity(RelCardTemplateElementEntity cardTemplate, PageEntity page) {
		super();
		this.cardTemplate = cardTemplate;
		this.page = page;
	}

	public RelCardTemplateElementEntity getCardTemplate() {
		return cardTemplate;
	}

	public void setCardTemplate(RelCardTemplateElementEntity cardTemplate) {
		this.cardTemplate = cardTemplate;
	}

	public PageEntity getPage() {
		return page;
	}

	public void setPage(PageEntity page) {
		this.page = page;
	}

	
}
