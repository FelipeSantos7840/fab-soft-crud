package com.felipesntos.fabcrud.fabsoftcrud.repository;

import com.felipesntos.fabcrud.fabsoftcrud.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepository extends JpaRepository<Personagem,Long> {
}
