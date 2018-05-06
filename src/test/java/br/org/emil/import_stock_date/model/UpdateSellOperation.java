package br.org.emil.import_stock_date.model;

import org.junit.Test;

import br.org.emil.import_stock_date.business.OperationManager;

public class UpdateSellOperation {
	@Test
	public void sellOperationTest() {
		OperationManager opManager = new OperationManager();
		opManager.marqueVendas();
	}
}
