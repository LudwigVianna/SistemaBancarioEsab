package com.esab.academico.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class OperacaoRealizadaDTO extends DetalhesDTO {


	private BigDecimal valor = new BigDecimal(0);
	
	private BigDecimal saldo = new BigDecimal(0);
	

	public OperacaoRealizadaDTO(int status, String msg, String date, BigDecimal valor, BigDecimal saldo) {
		super(status, msg, date);
		this.valor = valor;
		this.saldo = saldo;
	}

}