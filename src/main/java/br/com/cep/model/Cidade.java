package br.com.cep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tcidade")
public class Cidade {

	@Id
	@Column(name = "ibge", length = 20, nullable = false)
	@JsonProperty("ibge")
	private String ibge;

	@Column(name = "uf", length = 2, nullable = false)
	@JsonProperty("uf")
	private String uf;

	@Column(name = "localidade", length = 100, nullable = false)
	@JsonProperty("localidade")
	private String localidade;

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

}
