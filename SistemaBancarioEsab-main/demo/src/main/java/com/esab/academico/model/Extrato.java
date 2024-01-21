package com.esab.academico.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="EXTRATO")
@Entity(name="EXTRATO")
public class Extrato implements Serializable {


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExtrato;
	

	
	private String dataHoraMovimento;
	
	private String OperacaoTipo;
	

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_contacorrente")
	@JsonIgnore
	private ContaCorrente conta;
	
	private BigDecimal valorOperacao = new BigDecimal(0);
}