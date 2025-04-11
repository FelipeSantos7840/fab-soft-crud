package com.felipesntos.fabcrud.fabsoftcrud.controller;

import com.felipesntos.fabcrud.fabsoftcrud.dto.PersonagemDTO;
import com.felipesntos.fabcrud.fabsoftcrud.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    PersonagemService personagemService;

    @GetMapping
    public ResponseEntity<List<PersonagemDTO>> findAll(){
        return ResponseEntity.ok(personagemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(personagemService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PersonagemDTO> create(@RequestBody PersonagemDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        PersonagemDTO response = personagemService.create(dto);
        return ResponseEntity.created(uri).body(response);
    }

    @PostMapping("/{idp}/item/{idi}")
    public ResponseEntity<PersonagemDTO> addItem(@PathVariable Long idp, @PathVariable Long idi){
        return ResponseEntity.ok(personagemService.addItemMagicoToPersonagem(idp,idi));
    }



    @PutMapping("/{id}")
    public ResponseEntity<PersonagemDTO> update(@PathVariable Long id, @RequestBody PersonagemDTO dto){
        return ResponseEntity.ok(personagemService.update(dto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonagemDTO> delete(@PathVariable Long id){
        personagemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
