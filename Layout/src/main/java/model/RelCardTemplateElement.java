package model;

import java.util.List;

import model.enums.EnumSide;

public class RelCardTemplateElement {
	private CardTemplate cardTemplate;
	private List<Element> elements;
	private EnumSide enumSide;

	public RelCardTemplateElement() {
		super();
	}

	public RelCardTemplateElement(CardTemplate cardTemplate, List<Element> elements, EnumSide enumSide) {
		super();
		this.cardTemplate = cardTemplate;
		this.elements = elements;
		this.enumSide = enumSide;
	}

	public CardTemplate getCardTemplate() {
		return cardTemplate;
	}

	public void setCardTemplate(CardTemplate cardTemplate) {
		this.cardTemplate = cardTemplate;
	}

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	public EnumSide getEnumSide() {
		return enumSide;
	}

	public void setEnumSide(EnumSide enumSide) {
		this.enumSide = enumSide;
	}

	
}
