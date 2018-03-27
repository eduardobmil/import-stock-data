package br.org.emil.import_stock_date.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "operacao")
public class Operacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tp_operacao")
	private EnumTipoOperacao tipoOperacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "entrada")
	private Date entrada;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "saida")
	private Date saida;
	
	@Column(name = "ativo")
	private String ativo;
	
	@Column(name = "quantidade")
	private int quantidade;
	
	@Column(name = "valor_entrada")
	private Double valorEntrada;
	
	@Column(name = "valor_saida")
	private Double valorSaida;
	
	@Column(name = "stop_loss")
	private Double stopLoss;
	
	@Column(name = "alvo")
	private Double alvo;
	
	@Column(name = "ifr2")
	private Double ifr2;
	
	@Column(name = "variacao")
	private Double variacaoPerc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EnumTipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(EnumTipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(Double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Double getValorSaida() {
		return valorSaida;
	}

	public void setValorSaida(Double valorSaida) {
		this.valorSaida = valorSaida;
	}

	public Double getStopLoss() {
		return stopLoss;
	}

	public void setStopLoss(Double stopLoss) {
		this.stopLoss = stopLoss;
	}

	public Double getAlvo() {
		return alvo;
	}

	public void setAlvo(Double alvo) {
		this.alvo = alvo;
	}

	public Double getIfr2() {
		return ifr2;
	}

	public void setIfr2(Double ifr2) {
		this.ifr2 = ifr2;
	}

	public Double getVariacaoPerc() {
		return variacaoPerc;
	}

	public void setVariacaoPerc(Double variacaoPerc) {
		this.variacaoPerc = variacaoPerc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alvo == null) ? 0 : alvo.hashCode());
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((entrada == null) ? 0 : entrada.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ifr2 == null) ? 0 : ifr2.hashCode());
		result = prime * result + quantidade;
		result = prime * result + ((saida == null) ? 0 : saida.hashCode());
		result = prime * result + ((stopLoss == null) ? 0 : stopLoss.hashCode());
		result = prime * result + ((tipoOperacao == null) ? 0 : tipoOperacao.hashCode());
		result = prime * result + ((valorEntrada == null) ? 0 : valorEntrada.hashCode());
		result = prime * result + ((valorSaida == null) ? 0 : valorSaida.hashCode());
		result = prime * result + ((variacaoPerc == null) ? 0 : variacaoPerc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operacao other = (Operacao) obj;
		if (alvo == null) {
			if (other.alvo != null)
				return false;
		} else if (!alvo.equals(other.alvo))
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (entrada == null) {
			if (other.entrada != null)
				return false;
		} else if (!entrada.equals(other.entrada))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ifr2 == null) {
			if (other.ifr2 != null)
				return false;
		} else if (!ifr2.equals(other.ifr2))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (saida == null) {
			if (other.saida != null)
				return false;
		} else if (!saida.equals(other.saida))
			return false;
		if (stopLoss == null) {
			if (other.stopLoss != null)
				return false;
		} else if (!stopLoss.equals(other.stopLoss))
			return false;
		if (tipoOperacao != other.tipoOperacao)
			return false;
		if (valorEntrada == null) {
			if (other.valorEntrada != null)
				return false;
		} else if (!valorEntrada.equals(other.valorEntrada))
			return false;
		if (valorSaida == null) {
			if (other.valorSaida != null)
				return false;
		} else if (!valorSaida.equals(other.valorSaida))
			return false;
		if (variacaoPerc == null) {
			if (other.variacaoPerc != null)
				return false;
		} else if (!variacaoPerc.equals(other.variacaoPerc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operacao [id=" + id + ", tipoOperacao=" + tipoOperacao + ", entrada=" + entrada + ", saida=" + saida
				+ ", ativo=" + ativo + ", quantidade=" + quantidade + ", valorEntrada=" + valorEntrada + ", valorSaida="
				+ valorSaida + ", stopLoss=" + stopLoss + ", alvo=" + alvo + ", ifr2=" + ifr2 + ", variacaoPerc="
				+ variacaoPerc + "]";
	}


	
}
