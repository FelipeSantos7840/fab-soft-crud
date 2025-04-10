package com.felipesntos.fabcrud.fabsoftcrud.controller;

import com.felipesntos.fabcrud.fabsoftcrud.dto.ItemMagicoDTO;
import com.felipesntos.fabcrud.fabsoftcrud.service.ItemMagicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemMagicoController {

    @Autowired
    private ItemMagicoService itemMagicoService;

    @GetMapping
    public ResponseEntity<List<ItemMagicoDTO>> findAll(){
        return ResponseEntity.ok(itemMagicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemMagicoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(itemMagicoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ItemMagicoDTO> create(@RequestBody ItemMagicoDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(itemMagicoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemMagicoDTO> update(@PathVariable Long id, @RequestBody ItemMagicoDTO dto){
        return ResponseEntity.ok(itemMagicoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemMagicoDTO> delete(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
}
