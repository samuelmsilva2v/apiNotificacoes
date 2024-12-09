package com.example.demo.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class PessoaDto {

	private UUID id;
	private String nome;
	private String email;
	private String telefone;
}
