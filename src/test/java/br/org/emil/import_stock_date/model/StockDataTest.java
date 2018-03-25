package br.org.emil.import_stock_date.model;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import br.org.emil.import_stock_date.csv.ImportCSVFile;

/**
 * Unit test for simple App.
 */
public class StockDataTest {
	
	@Test
	public void testImportFile() throws IOException, ParseException {
		ImportCSVFile csvFile = new ImportCSVFile();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("rsi_mt5.csv");
		ArrayList<Cotacao> dados = csvFile.saveQuotes(
				is);
		Assert.assertNotNull(dados);
		Assert.assertFalse(dados.isEmpty());
	}
}
