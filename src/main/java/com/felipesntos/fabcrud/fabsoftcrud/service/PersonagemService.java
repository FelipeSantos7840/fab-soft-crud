package com.felipesntos.fabcrud.fabsoftcrud.service;

import com.felipesntos.fabcrud.fabsoftcrud.dto.ItemMagicoDTO;
import com.felipesntos.fabcrud.fabsoftcrud.dto.PersonagemDTO;
import com.felipesntos.fabcrud.fabsoftcrud.mapper.ItemMagicoMapper;
import com.felipesntos.fabcrud.fabsoftcrud.mapper.PersonagemMapper;
import com.felipesntos.fabcrud.fabsoftcrud.model.ItemMagico;
import com.felipesntos.fabcrud.fabsoftcrud.model.Personagem;
import com.felipesntos.fabcrud.fabsoftcrud.repository.ItemMagicoRepository;
import com.felipesntos.fabcrud.fabsoftcrud.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

import static com.felipesntos.fabcrud.fabsoftcrud.service.util.ValidateService.validateOptional;

@Service
public class PersonagemService {
    @Autowired
    private ItemMagicoService itemMagicoService;
    @Autowired
    private PersonagemRepository personagemRepository;
    @Autowired
    private ItemMagicoRepository itemMagicoRepository;
    @Autowired
    private PersonagemMapper personagemMapper;

    @Autowired
    private ItemMagicoMapper itemMagicoMapper;

    public List<PersonagemDTO> findAll(){
        return personagemMapper.toPersonagemDTOList(personagemRepository.findAll());
    }

    public PersonagemDTO findById(Long id){
        return personagemMapper.toPersonagemDTO(validateOptional(personagemRepository.findById(id)));
    }

    public PersonagemDTO create(PersonagemDTO dto){
        validateAttributes(dto.getForca(),dto.getDefesa(),10);
        Personagem person = personagemMapper.toPersonagem(dto);
        return personagemMapper.toPersonagemDTO(personagemRepository.save(person));
    }

    public PersonagemDTO update(PersonagemDTO dto, Long id){
        PersonagemDTO dataDTO = findById(id);

        dataDTO.setNome(dto.getNome());
        dataDTO.setNomeAventureiro(dto.getNomeAventureiro());
        dataDTO.setLevel(dto.getLevel());
        dataDTO.setClasse(dto.getClasse());

        personagemRepository.save(personagemMapper.toPersonagem(dataDTO));
        return dataDTO;
    }

    public void deleteById(Long id){
        PersonagemDTO dto = findById(id);
        personagemRepository.deleteById(dto.getId());
    }

    public PersonagemDTO addItemMagicoToPersonagem(Long personagemId,Long itemMagicoId){
        ItemMagico itemMagico = validateOptional(itemMagicoRepository.findById(itemMagicoId));
        Personagem personagem = validateOptional(personagemRepository.findById(personagemId));

        personagem.addItemMagico(itemMagico);
        personagem = personagemRepository.save(personagem);


        return findWithItemsMagicosById(personagem.getId());
    }

    public PersonagemDTO findWithItemsMagicosById(Long id){
        Personagem person = validateOptional(personagemRepository.findById(id));
        PersonagemDTO dto = personagemMapper.toPersonagemDTO(person);
        dto.setItensMagicos(itemMagicoMapper.toItemMagicoDTOList(person.getItemMagicos()));
        dto.updateAttributes();
        return dto;
    }

    public boolean validateAttributes(Integer forca, Integer defesa, Integer limit){
        if(forca + defesa <= limit)
            return true;
        throw new InvalidParameterException("Attributes sum greater than " + limit);
    }
}
