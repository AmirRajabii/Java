package model;

public class RelPageCardTemplate {
	private RelCardTemplateElement cardTemplate;
	private Page page;

	public RelPageCardTemplate() {
		super();
	}

	public RelPageCardTemplate(RelCardTemplateElement cardTemplate, Page page) {
		super();
		this.cardTemplate = cardTemplate;
		this.page = page;
	}

	public RelCardTemplateElement getCardTemplate() {
		return cardTemplate;
	}

	public void setCardTemplate(RelCardTemplateElement cardTemplate) {
		this.cardTemplate = cardTemplate;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
