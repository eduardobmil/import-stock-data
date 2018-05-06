package br.org.emil.import_stock_date.entity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "cotacao")
@NamedQueries({
    @NamedQuery(name="Cotacao.FIND_VENDA",
                query="FROM Cotacao c where c.data > :dtOperacao and c.ativo=:ativo and (c.alta >=:alvo or c.baixa <= :loss) order by c.id asc")    
}) 
public class Cotacao {

	public static final String FIND_VENDA = "Cotacao.FIND_VENDA";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "ativo")
	private String ativo;
	@Column(name = "dt_cotacao")
	private Date data;
	@Column(name = "abertura")
	private Double aber;
	@Column(name = "alta")
	private Double alta;
	@Column(name = "baixa")
	private Double baixa;
	@Column(name = "fechamento")
	private Double fech;
	@Column(name = "volume")
	private Double volume;
	@Transient
	private Double abertDiaAnt;
	@Transient
	private Double altaDiaAnt;
	@Transient
	private Double baixaDiaAnt;
	@Transient
	private Double fechDiaAnt;
	@Transient
	private Double volDiaAnt;
	@Column(name = "ifr2")
	private Double ifr2;
	@Transient
	private Double ifr2DiaAnt;
	@Column(name = "alvo")
	private Double alvo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getAber() {
		return aber;
	}

	public void setAber(Double aber) {
		this.aber = aber;
	}

	public Double getAlta() {
		return alta;
	}

	public void setAlta(Double alta) {
		this.alta = alta;
	}

	public Double getBaixa() {
		return baixa;
	}

	public void setBaixa(Double baixa) {
		this.baixa = baixa;
	}

	public Double getFech() {
		return fech;
	}

	public void setFech(Double fech) {
		this.fech = fech;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getAbertDiaAnt() {
		return abertDiaAnt;
	}

	public void setAbertDiaAnt(Double abertDiaAnt) {
		this.abertDiaAnt = abertDiaAnt;
	}

	public Double getAltaDiaAnt() {
		return altaDiaAnt;
	}

	public void setAltaDiaAnt(Double altaDiaAnt) {
		this.altaDiaAnt = altaDiaAnt;
	}

	public Double getBaixaDiaAnt() {
		return baixaDiaAnt;
	}

	public void setBaixaDiaAnt(Double baixaDiaAnt) {
		this.baixaDiaAnt = baixaDiaAnt;
	}

	public Double getFechDiaAnt() {
		return fechDiaAnt;
	}

	public void setFechDiaAnt(Double fechDiaAnt) {
		this.fechDiaAnt = fechDiaAnt;
	}

	public Double getVolDiaAnt() {
		return volDiaAnt;
	}

	public void setVolDiaAnt(Double volDiaAnt) {
		this.volDiaAnt = volDiaAnt;
	}

	public Double getIfr2() {
		return ifr2;
	}

	public void setIfr2(Double ifr2) {
		this.ifr2 = ifr2;
	}

	public Double getIfr2DiaAnt() {
		return ifr2DiaAnt;
	}

	public void setIfr2DiaAnt(Double ifr2DiaAnt) {
		this.ifr2DiaAnt = ifr2DiaAnt;
	}

	public Double getAlvo() {
		return alvo;
	}

	public void setAlvo(Double alvo) {
		this.alvo = alvo;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aber == null) ? 0 : aber.hashCode());
		result = prime * result + ((abertDiaAnt == null) ? 0 : abertDiaAnt.hashCode());
		result = prime * result + ((alta == null) ? 0 : alta.hashCode());
		result = prime * result + ((altaDiaAnt == null) ? 0 : altaDiaAnt.hashCode());
		result = prime * result + ((alvo == null) ? 0 : alvo.hashCode());
		result = prime * result + ((baixa == null) ? 0 : baixa.hashCode());
		result = prime * result + ((baixaDiaAnt == null) ? 0 : baixaDiaAnt.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((fech == null) ? 0 : fech.hashCode());
		result = prime * result + ((fechDiaAnt == null) ? 0 : fechDiaAnt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ifr2 == null) ? 0 : ifr2.hashCode());
		result = prime * result + ((ifr2DiaAnt == null) ? 0 : ifr2DiaAnt.hashCode());
		result = prime * result + ((volDiaAnt == null) ? 0 : volDiaAnt.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		Cotacao other = (Cotacao) obj;
		if (aber == null) {
			if (other.aber != null)
				return false;
		} else if (!aber.equals(other.aber))
			return false;
		if (abertDiaAnt == null) {
			if (other.abertDiaAnt != null)
				return false;
		} else if (!abertDiaAnt.equals(other.abertDiaAnt))
			return false;
		if (alta == null) {
			if (other.alta != null)
				return false;
		} else if (!alta.equals(other.alta))
			return false;
		if (altaDiaAnt == null) {
			if (other.altaDiaAnt != null)
				return false;
		} else if (!altaDiaAnt.equals(other.altaDiaAnt))
			return false;
		if (alvo == null) {
			if (other.alvo != null)
				return false;
		} else if (!alvo.equals(other.alvo))
			return false;
		if (baixa == null) {
			if (other.baixa != null)
				return false;
		} else if (!baixa.equals(other.baixa))
			return false;
		if (baixaDiaAnt == null) {
			if (other.baixaDiaAnt != null)
				return false;
		} else if (!baixaDiaAnt.equals(other.baixaDiaAnt))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (fech == null) {
			if (other.fech != null)
				return false;
		} else if (!fech.equals(other.fech))
			return false;
		if (fechDiaAnt == null) {
			if (other.fechDiaAnt != null)
				return false;
		} else if (!fechDiaAnt.equals(other.fechDiaAnt))
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
		if (ifr2DiaAnt == null) {
			if (other.ifr2DiaAnt != null)
				return false;
		} else if (!ifr2DiaAnt.equals(other.ifr2DiaAnt))
			return false;
		if (volDiaAnt == null) {
			if (other.volDiaAnt != null)
				return false;
		} else if (!volDiaAnt.equals(other.volDiaAnt))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cotacao [id=" + id + ", ativo=" + ativo + ", data=" + data + ", aber=" + aber + ", alta=" + alta
				+ ", baixa=" + baixa + ", fech=" + fech + ", volume=" + volume + ", abertDiaAnt=" + abertDiaAnt
				+ ", altaDiaAnt=" + altaDiaAnt + ", baixaDiaAnt=" + baixaDiaAnt + ", fechDiaAnt=" + fechDiaAnt
				+ ", volDiaAnt=" + volDiaAnt + ", ifr2=" + ifr2 + ", ifr2DiaAnt=" + ifr2DiaAnt + ", alvo=" + alvo + "]";
	}
	
	public LocalDate getLocalDate() {
		if (data != null) {
			return data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		}
		return null;
	}

	

}
