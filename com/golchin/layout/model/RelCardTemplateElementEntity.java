package com.golchin.layout.model;

import java.util.List;

import com.golchin.layout.model.enums.EnumSide;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;
import ws.safa.standardproject.dao.essential.MainEntity;

@Entity
@Table(name = "REL_CARD_TEMPLATE_ELEMENT", indexes = { @Index(columnList = "ID_CARD_TEMPLATE"),
		@Index(columnList = "ID_ELEMENTS") })
@NamedQueries({

})
@NamedNativeQueries({

})
public class RelCardTemplateElementEntity extends MainEntity {
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CARD_TEMPLATE")
	private CardTemplateEntity cardTemplate;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ELEMENTS")
	private List<ElementEntity> elements;

	@Enumerated(EnumType.STRING)
	@Column(name = "ENUM_SIDE")
	private EnumSide enumSide;

	public RelCardTemplateElementEntity() {
		super();
	}

	public RelCardTemplateElementEntity(CardTemplateEntity cardTemplate, List<ElementEntity> elements,
			EnumSide enumSide) {
		super();
		this.cardTemplate = cardTemplate;
		this.elements = elements;
		this.enumSide = enumSide;
	}

	public CardTemplateEntity getCardTemplate() {
		return cardTemplate;
	}

	public void setCardTemplate(CardTemplateEntity cardTemplate) {
		this.cardTemplate = cardTemplate;
	}

	public List<ElementEntity> getElements() {
		return elements;
	}

	public void setElements(List<ElementEntity> elements) {
		this.elements = elements;
	}

	public EnumSide getEnumSide() {
		return enumSide;
	}

	public void setEnumSide(EnumSide enumSide) {
		this.enumSide = enumSide;
	}
	
}
