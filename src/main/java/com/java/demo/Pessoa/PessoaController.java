package com.java.demo.Pessoa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    private final PessoaService pessoaService;


    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaModel>> buscarTodos(){
        return ResponseEntity.ok(pessoaService.buscartodos());
    }
    @PostMapping
    public ResponseEntity<Void> CriarPessoa (@RequestBody PessoaModel Pessoa){
        pessoaService.cirarpessoa(Pessoa);
        return ResponseEntity.ok().build();
    }
}
