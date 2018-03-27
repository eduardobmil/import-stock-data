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

import br.org.emil.import_stock_date.business.OperationManager;
import br.org.emil.import_stock_date.business.Transaction;
import br.org.emil.import_stock_date.entity.Cotacao;

public class ImportCSVFile {
	private CSVRecord record;

	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

	private OperationManager operManager = new OperationManager();

	private Cotacao anterior = null;
	private Cotacao atual = null;

	public ArrayList<Cotacao> readFile(InputStream is) throws IOException, ParseException {
		ArrayList<Cotacao> retorno = new ArrayList<Cotacao>();
		final Reader reader = new InputStreamReader(is, "UTF-16");
		final CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
		try {
			List<CSVRecord> records = parser.getRecords();

			for (int i = 1; i < records.size(); i++) {
				record = records.get(i);
				atual = readData();
				// Adiciona apenas a última cotação do dia
				if (anterior != null
						&& anterior.getLocalDate().getDayOfMonth() != atual.getLocalDate().getDayOfMonth()) {
					retorno.add(anterior);
				}
				operManager.verifiqueCompra(atual);
				anterior = atual;
			}
			if (anterior != null && anterior.getLocalDate().getDayOfMonth() != atual.getLocalDate().getDayOfMonth()) {
				retorno.add(atual);
			}
		} finally {
			parser.close();
			reader.close();
		}

		return retorno;
	}

	public ArrayList<Cotacao> saveQuotes(InputStream is) throws IOException, ParseException {
		ArrayList<Cotacao> cotacoes = readFile(is);
		try {
			Transaction.saveList(cotacoes);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} finally {
			Transaction.close();
		}
		return cotacoes;
	}

	private Cotacao readData() throws ParseException {
		Cotacao data = new Cotacao();
		data.setData(readDate("Data"));
		// Data,Aber,Alta,Baixa,Fech,Vol,Aber (ant),Alta (ant),Baixa (ant),Fech
		// (ant),Vol (ant),RSI,RSI (ant),Alvo
		data.setAber(readDouble("Aber"));
		data.setAlta(readDouble("Alta"));
		data.setBaixa(readDouble("Baixa"));
		data.setFech(readDouble("Fech"));
		data.setVolume(readDouble("Vol"));
		data.setAbertDiaAnt(readDouble("Aber (ant)"));
		data.setAltaDiaAnt(readDouble("Alta (ant)"));
		data.setBaixaDiaAnt(readDouble("Baixa (ant)"));
		data.setFechDiaAnt(readDouble("Fech (ant)"));
		data.setVolDiaAnt(readDouble("Vol (ant)"));
		data.setIfr2(readDouble("RSI"));
		data.setIfr2DiaAnt(readDouble("RSI (ant)"));
		// TODO Setar esta informação no arquivo
		data.setAtivo("BVMF3");
		return data;
	}

	public Date readDate(String fieldName) throws ParseException {
		String fieldValue = record.get(fieldName);
		if (fieldValue != null && !fieldValue.trim().equals("")) {
			fieldValue = fieldValue.trim();
			return dateTimeFormat.parse(fieldValue);
		}
		return null;
	}

	public Double readDouble(String fieldName) throws ParseException {
		String fieldValue = record.get(fieldName);
		if (fieldValue != null && !fieldValue.trim().equals("")) {
			fieldValue = fieldValue.trim();
			return Double.valueOf(fieldValue);
		}
		return null;
	}

	public String readString(String fieldName) throws ParseException {
		String fieldValue = record.get(fieldName);
		if (fieldValue != null && !fieldValue.trim().equals("")) {
			return fieldValue.trim();
		}
		return null;
	}
}
