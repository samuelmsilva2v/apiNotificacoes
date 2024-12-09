package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LogMensagem;
import com.example.demo.services.LogMensagemService;

@RestController
@RequestMapping("/api/logs/mensagem")
public class LogMensagemController {

	@Autowired
	private LogMensagemService logMensagemService;
	
	@GetMapping
	public List<LogMensagem> getAll() {
		return logMensagemService.consultarLogs();
	}
}
