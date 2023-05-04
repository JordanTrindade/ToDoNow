package com.app.todo.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;
	
	@Column(name = "COMPLETA")
	private Boolean completa = Boolean.FALSE;


	public Tarefa() {
		super();
	}

	public Tarefa(Long id, String descricao, Boolean completa) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.completa = completa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getCompleta() {
		return completa;
	}

	public void setCompleta(Boolean completa) {
		this.completa = completa;
	}
	
	
}
