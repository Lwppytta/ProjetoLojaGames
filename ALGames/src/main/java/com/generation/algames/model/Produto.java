package com.generation.algames.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Atributo obrigatório.")
	@Size(min = 2, max = 255)
	private String nomeProduto;

	@NotBlank(message = "Atributo obrigatório.")
	@Size(min = 10, max = 1000)
	private String descricaoProduto;

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull(message = "Preço obrigatório.")
	@Positive(message = "Preço deve ser maior que zero.")
	private BigDecimal precoProduto;

	@NotNull(message = "Classificação obrigatória.")
	@Positive(message = "Classificação deve ser maior que zero.")
	private int classificacaoProduto;
	
	@NotBlank(message = "Classificação obrigatória.")
	@Size(min = 2, max = 255)
	private String cooperativo;

	@UpdateTimestamp
	private LocalDateTime dataProduto;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public BigDecimal getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(BigDecimal precoProduto) {
		this.precoProduto = precoProduto;
	}

	public int getClassificacaoProduto() {
		return classificacaoProduto;
	}

	public void setClassificacaoProduto(int classificacaoProduto) {
		this.classificacaoProduto = classificacaoProduto;
	}

	public String getCooperativo() {
		return cooperativo;
	}

	public void setCooperativo(String cooperativo) {
		this.cooperativo = cooperativo;
	}

	public LocalDateTime getDataProduto() {
		return dataProduto;
	}

	public void setDataProduto(LocalDateTime dataProduto) {
		this.dataProduto = dataProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
