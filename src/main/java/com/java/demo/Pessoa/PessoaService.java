package com.java.demo.Pessoa;


import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PessoaService {

    private final PessoaRepository repository;


    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List <PessoaModel> buscartodos(){
        return repository.findAll();
    }
    public void cirarpessoa(PessoaModel Pessoa){


        repository.saveAndFlush(Pessoa);
    }
}
