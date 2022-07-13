package business;

import model.CardTemplate;
import model.Page;

public class PageValidation {
	public static Page isValid(Page page, CardTemplate cardTemplate) throws Exception {
		if (page.getWidth() == 0 && page.getColumnCount() == 0) {
			throw new Exception("Error in calculation[Column and Width].");
		}
		if (page.getHeight() == 0 && page.getRowCount() == 0) {
			throw new Exception("Error in calculation.[Row and Height].");
		}

		if (page.getWidth() > 0 && page.getColumnCount() > 0) {
			// Calculate and checked is corrected.

			if (calculateSize(page.getColumnCount(), cardTemplate.getWidth(), page.getPaddingLeft(),
					page.getPaddingRight()) != page.getWidth()) {
				throw new Exception("Wrong Value [Column and Width].");
			}

		} else if (page.getWidth() == 0 && page.getColumnCount() > 0) {
			page.setWidth(calculateSize(page.getColumnCount(), cardTemplate.getWidth(), page.getPaddingLeft(),
					page.getPaddingRight()));

		} else if (page.getWidth() > 0 && page.getColumnCount() == 0) {
			page.setColumnCount(calculateColRow(page.getWidth(), cardTemplate.getWidth(), page.getPaddingLeft(),
					page.getPaddingRight()));
		}

		if (page.getHeight() > 0 && page.getRowCount() > 0) {
			// Calculate and checked is corrected.
			if (calculateSize(page.getRowCount(), cardTemplate.getHeight(), page.getPaddingBottom(),
					page.getPaddingTop()) != page.getHeight()) {
				throw new Exception("Wrong Value .[Row and Height].");
			}
		} else if (page.getHeight() == 0 && page.getRowCount() > 0) {
			page.setHeight(calculateSize(page.getRowCount(), cardTemplate.getHeight(), page.getPaddingBottom(),
					page.getPaddingTop()));
		} else if (page.getHeight() > 0 && page.getRowCount() == 0) {
			page.setRowCount(calculateColRow(page.getHeight(), cardTemplate.getHeight(), page.getPaddingBottom(),
					page.getPaddingTop()));
		}

		return page;
	}

	private static int calculateSize(int cardCount, int measure, int padding1, int padding2) {
		return (cardCount * measure) + padding1 + padding2;
	}

	private static int calculateColRow(int pageSize, int measure, int padding1, int padding2) {
		return (pageSize - padding1 - padding2) / measure;
	}
}
