package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.LogMensagem;
import com.example.demo.repositories.LogMensagemRepository;

@Service
public class LogMensagemService {

	@Autowired
	private LogMensagemRepository logMensagemRepository;
	
	public List<LogMensagem> consultarLogs() {
		return logMensagemRepository.findAll();
	}
}
