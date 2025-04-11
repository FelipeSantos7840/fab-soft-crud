package com.felipesntos.fabcrud.fabsoftcrud.repository;

import com.felipesntos.fabcrud.fabsoftcrud.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonagemRepository extends JpaRepository<Personagem,Long> {

}
