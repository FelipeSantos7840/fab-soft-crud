package com.felipesntos.fabcrud.fabsoftcrud.service;

import com.felipesntos.fabcrud.fabsoftcrud.dto.ItemMagicoDTO;
import com.felipesntos.fabcrud.fabsoftcrud.mapper.ItemMagicoMapper;
import com.felipesntos.fabcrud.fabsoftcrud.model.ItemMagico;
import com.felipesntos.fabcrud.fabsoftcrud.repository.ItemMagicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.felipesntos.fabcrud.fabsoftcrud.service.util.ValidateService.validateOptional;

@Service
public class ItemMagicoService {

    @Autowired
    ItemMagicoRepository itemMagicoRepository;
    @Autowired
    ItemMagicoMapper itemMagicoMapper;

    public List<ItemMagicoDTO> findAll() {
        return itemMagicoMapper.toItemMagicoDTOList(itemMagicoRepository.findAll());
    }

    public ItemMagicoDTO findById(Long id){
        return itemMagicoMapper.toItemMagicoDTO(validateOptional(itemMagicoRepository.findById(id)));
    }

    public ItemMagicoDTO create(ItemMagicoDTO dto){
        ItemMagico response = itemMagicoRepository.save(itemMagicoMapper.toItemMagico(dto));
        return itemMagicoMapper.toItemMagicoDTO(response);
    }

    public ItemMagicoDTO update(Long id, ItemMagicoDTO dto){
        ItemMagicoDTO itemEntityDTO = findById(id);

        itemEntityDTO.setNome(dto.getNome());
        itemEntityDTO.setTipo(dto.getTipo());
        itemEntityDTO.setDefesa(dto.getDefesa());
        itemEntityDTO.setForca(dto.getForca());

        itemMagicoRepository.save(itemMagicoMapper.toItemMagico(itemEntityDTO));
        return itemEntityDTO;
    }

    public void deleteById(Long id){
        ItemMagicoDTO dto = findById(id);
        itemMagicoRepository.deleteById(dto.getId());
    }

}
