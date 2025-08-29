package com.java.demo.Service;

import com.java.demo.Repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service

public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }


}
