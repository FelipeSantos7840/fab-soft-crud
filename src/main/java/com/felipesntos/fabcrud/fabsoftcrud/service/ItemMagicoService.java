package com.felipesntos.fabcrud.fabsoftcrud.service;

import com.felipesntos.fabcrud.fabsoftcrud.dto.ItemMagicoDTO;
import com.felipesntos.fabcrud.fabsoftcrud.mapper.ItemMagicoMapper;
import com.felipesntos.fabcrud.fabsoftcrud.model.ItemMagico;
import com.felipesntos.fabcrud.fabsoftcrud.model.enumerator.TipoItem;
import com.felipesntos.fabcrud.fabsoftcrud.repository.ItemMagicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

import static com.felipesntos.fabcrud.fabsoftcrud.service.util.ValidateService.validateOptional;

@Service
public class ItemMagicoService {

    @Autowired
    private ItemMagicoRepository itemMagicoRepository;
    @Autowired
    private ItemMagicoMapper itemMagicoMapper;

    public List<ItemMagicoDTO> findAll() {
        return itemMagicoMapper.toItemMagicoDTOList(itemMagicoRepository.findAll());
    }

    public ItemMagicoDTO findById(Long id){
        return itemMagicoMapper.toItemMagicoDTO(validateOptional(itemMagicoRepository.findById(id)));
    }

    public ItemMagicoDTO create(ItemMagicoDTO dto){
        validateAttributes(dto);
        ItemMagico response = itemMagicoRepository.save(itemMagicoMapper.toItemMagico(dto));
        return itemMagicoMapper.toItemMagicoDTO(response);
    }

    public ItemMagicoDTO update(Long id, ItemMagicoDTO dto){
        ItemMagicoDTO itemEntityDTO = findById(id);

        itemEntityDTO.setNome(dto.getNome());
        itemEntityDTO.setDefesa(dto.getDefesa());
        itemEntityDTO.setForca(dto.getForca());

        validateAttributes(itemEntityDTO);

        itemMagicoRepository.save(itemMagicoMapper.toItemMagico(itemEntityDTO));
        return itemEntityDTO;
    }

    public void deleteById(Long id){
        ItemMagicoDTO dto = findById(id);
        itemMagicoRepository.deleteById(dto.getId());
    }

    private void validateAttributes(ItemMagico itemMagico){
        if(itemMagico.getForca() + itemMagico.getDefesa() <= 0) throw new InvalidParameterException("ItemMagico has both attributes less than or equal to zeros");
        if(itemMagico.getForca() > 10 || itemMagico.getDefesa() > 10) throw new InvalidParameterException("ItemMagico has attributes with values above 10");
        if(itemMagico.getTipo() == TipoItem.ARMA && itemMagico.getDefesa() != 0) throw new InvalidParameterException("ItemMagico of type " + TipoItem.ARMA + " has defesa different from 0");
        if(itemMagico.getTipo() == TipoItem.ARMADURA && itemMagico.getForca() != 0) throw new InvalidParameterException("ItemMagico of type "+ TipoItem.ARMADURA +" has forca different from 0");
    }

    private void validateAttributes(ItemMagicoDTO itemMagicoDTO){
        validateAttributes(itemMagicoMapper.toItemMagico(itemMagicoDTO));
    }

}
