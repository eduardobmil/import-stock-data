package br.org.emil.import_stock_date.csv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import br.org.emil.import_stock_date.business.Transaction;
import br.org.emil.import_stock_date.model.Cotacao;

public class ImportCSVFile {
	private CSVRecord record;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	
	public ArrayList<Cotacao> readFile(InputStream is) throws IOException, ParseException {
		ArrayList<Cotacao> retorno = new ArrayList<Cotacao>();
		final Reader reader = 
				new InputStreamReader(is, "UTF-16");
		final CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
		try {
			List<CSVRecord> records = parser.getRecords();			
		    for (int i=1;i<records.size();i++) {
		    	record = records.get(i);
		    	retorno.add(readData());
		    }
		} finally {
		    parser.close();
		    reader.close();
		}
		
		return retorno;
	}
	
	public ArrayList<Cotacao> saveQuotes(InputStream is) throws IOException, ParseException {
		ArrayList<Cotacao> cotacoes = readFile(is);
		Transaction.saveList(cotacoes);
		return cotacoes;
	}
	
	private Cotacao readData() throws ParseException {
		Cotacao data = new Cotacao();
		data.setData(parseDate("Data")); 
		return data;
	}
	
	public Date parseDate(String fieldName) throws ParseException {
		String fieldValue = record.get(fieldName);
		if (fieldValue != null && !fieldValue.trim().equals("")) {
			fieldValue = fieldValue.trim();
			return dateFormat.parse(fieldValue);
		}
		return null;
	}
}
