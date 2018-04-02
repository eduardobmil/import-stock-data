package br.org.emil.import_stock_date.business;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import br.org.emil.import_stock_date.entity.Cotacao;
import br.org.emil.import_stock_date.entity.EnumTipoOperacao;
import br.org.emil.import_stock_date.entity.Operacao;

public class OperationManager {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
	
	private HashMap<String, Operacao> mapCompras = new HashMap<>();
	
	public void verifiqueCompra(Cotacao cotacao) {
		if (cotacao.getIfr2() < 30 && !existeCompraDia(cotacao)) {
			Operacao operacao = createCompra(cotacao);
			mapCompras.put(getKey(cotacao), operacao);
			Transaction.save(operacao);
		}
	}
	
	private boolean existeCompraDia(Cotacao cotacao) {		
		return mapCompras.containsKey(getKey(cotacao));
	}
	
	private String getKey(Cotacao cotacao) {
		return dateFormat.format(cotacao.getData());
	}

	private Operacao createCompra(Cotacao cotacao) {
		Operacao operacao = new Operacao();
		operacao.setAtivo(cotacao.getAtivo());
		operacao.setIfr2(cotacao.getIfr2());
		operacao.setQuantidade(1);
		operacao.setTipoOperacao(EnumTipoOperacao.COMPRA);
		operacao.setEntrada(cotacao.getData());
		operacao.setValorEntrada(cotacao.getFech());
		operacao.setAlvo(cotacao.getAlvo());
		operacao.setStopLoss(getStopLoss(cotacao));
		return operacao;
	}
	
	protected Double getStopLoss(Cotacao cotacao) {
		return cotacao.getFech() * 0.95 - 0.01;
	}
}
