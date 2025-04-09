package com.felipesntos.fabcrud.fabsoftcrud.mapper;

import com.felipesntos.fabcrud.fabsoftcrud.dto.PersonagemDTO;
import com.felipesntos.fabcrud.fabsoftcrud.model.Personagem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonagemMapper {
    Personagem toPersonagem(PersonagemDTO dto);
    PersonagemDTO toPersonagemDTO(Personagem entity);
    List<Personagem> toPersonagemList(List<PersonagemDTO> dtos);
    List<PersonagemDTO> toPersonagemDTOList(List<Personagem> entities);
}
