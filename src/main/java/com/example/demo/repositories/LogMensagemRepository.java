package com.example.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.LogMensagem;

public interface LogMensagemRepository extends JpaRepository<LogMensagem, UUID> {

}
