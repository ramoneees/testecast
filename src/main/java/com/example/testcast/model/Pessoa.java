package com.example.testcast.model;

import javax.persistence.Entity;

@Entity
public class Pessoa extends AbstractEntity {

	private String cpf;
	private String nome;
	private String tipoLogradouro;
	private String Logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefoneCelular;
	private String telefoneFixo;

	public Pessoa() {}

	public Pessoa(String cpf, String nome, String tipoLogradouro, String logradouro, String numero, String bairro,
			String cidade, String estado, String telefoneCelular, String telefoneFixo) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.tipoLogradouro = tipoLogradouro;
		Logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefoneCelular = telefoneCelular;
		this.telefoneFixo = telefoneFixo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

}
