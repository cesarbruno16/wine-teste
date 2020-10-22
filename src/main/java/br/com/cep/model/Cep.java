package br.com.cep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tcep")
public class Cep {

	@Id
	@Column(name = "cep", length = 10, nullable = false)
	@JsonProperty("cep")
	private String cep;

	@Column(name = "logradouro", length = 255, nullable = false)
	@JsonProperty("logradouro")
	private String logradouro;

	@Column(name = "complemento", length = 255, nullable = true)
	@JsonProperty("complemento")
	private String complemento;

	@Column(name = "bairro", length = 50, nullable = true)
	@JsonProperty("bairro")
	private String bairro;

	@ManyToOne
    @JoinColumn(name="ibge", nullable = false)
	private Cidade cidade;
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
