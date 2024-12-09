package com.example.demo.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class LogMensagem {

	@Id
	private UUID id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	private String pessoa;
	private String descricao;
}
