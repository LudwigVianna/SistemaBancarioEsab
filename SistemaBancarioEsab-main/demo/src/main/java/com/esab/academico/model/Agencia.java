package com.esab.academico.model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="AGENCIA")
@Entity(name="AGENCIA")
public class Agencia implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAgencia;

	@NotBlank(message = "O campo NOME é obrigatório, por favor, informe um nome!")
	@Column(nullable = false)
	private String nomeAgencia;

	private String endereco;

	private String telefone;
	
	
	@OneToMany(mappedBy = "agencia", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Cliente> cliente = new ArrayList<>();




}