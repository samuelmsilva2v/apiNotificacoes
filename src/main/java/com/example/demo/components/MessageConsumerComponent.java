package com.example.demo.components;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.demo.dtos.PessoaDto;
import com.example.demo.entities.LogMensagem;
import com.example.demo.repositories.LogMensagemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MessageConsumerComponent {

	@Autowired
	private LogMensagemRepository logMensagemRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	String username;

	@RabbitListener(queues = "pessoas")
	public void receive(@Payload String data) throws Exception {

		var pessoa = objectMapper.readValue(data, PessoaDto.class);

		try {

			var message = javaMailSender.createMimeMessage();
			var helper = new MimeMessageHelper(message);

			helper.setFrom(username);
			helper.setTo(pessoa.getEmail());
			helper.setSubject("Seja bem-vindo ao sistema!");
			helper.setText("Olá, " + pessoa.getNome() + ". Seu cadastro foi feito com sucesso!");
			javaMailSender.send(message);

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		var log = new LogMensagem();
		log.setId(UUID.randomUUID());
		log.setDataHora(new Date());
		log.setPessoa(pessoa.getNome());
		log.setDescricao("Mensagem processada da fila com sucesso!");
		
		logMensagemRepository.save(log);

	}
}
