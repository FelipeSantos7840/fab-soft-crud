package com.felipesntos.fabcrud.fabsoftcrud.mapper;

import com.felipesntos.fabcrud.fabsoftcrud.dto.ItemMagicoDTO;
import com.felipesntos.fabcrud.fabsoftcrud.model.ItemMagico;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMagicoMapper {
    ItemMagico toItemMagico(ItemMagicoDTO dto);
    ItemMagicoDTO toItemMagicoDTO(ItemMagico entity);
    List<ItemMagico> toItemMagicoList(List<ItemMagicoDTO> dtos);
    List<ItemMagicoDTO> toItemMagicoDTOList(List<ItemMagico> entities);
}
