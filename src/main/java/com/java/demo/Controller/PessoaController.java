package com.java.demo.Controller;


import com.java.demo.Model.PessoaModel;
import com.java.demo.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity<PessoaModel> create(@RequestBody PessoaModel obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
     public ResponseEntity<PessoaModel> getId(@PathVariable Integer id){
         return ResponseEntity.ok().body(service.getId(id));
    }

    @GetMapping
    public ResponseEntity<List<PessoaModel>> getAll(){
         return ResponseEntity.ok().body(service.getAll());
        }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaModel> update (@PathVariable Integer id, @RequestBody PessoaModel obj){
         obj.setId(id);
         return ResponseEntity.ok().body(service.update(obj));
        }
}
