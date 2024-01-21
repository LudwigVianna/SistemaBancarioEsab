package com.esab.academico.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CLIENTE")
@Entity(name="CLIENTE")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo NOME é obrigatório, por favor, informe um nome!")
	@Length(max = 45, message = "O nome deverá ter no máximo {max} caracteres")
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cpf;
	
	@NotBlank(message = "O campo TELEFONE é obrigatório, por favor, informe um nome!")
	@Column(nullable = false)
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name="id_agencia")
	private Agencia agencia;
	
	public Cliente(Long id, String nome, String cpf, String telefone) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}
		
	

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ContaCorrente> contacorrente = new ArrayList<>();

}