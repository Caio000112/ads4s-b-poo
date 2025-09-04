package com.java.demo.Service;

import com.java.demo.Model.PessoaModel;
import com.java.demo.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PessoaService {

    @Autowired
    private PessoaRepository repository;

        public PessoaModel create (PessoaModel obj){
           return  repository.save(obj);
        }

        public void delete(Integer id){
            repository.deleteById(id);
        }

    public PessoaModel getId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada!"));
    }


    public List<PessoaModel> getAll(){
            return repository.findAll();
        }

        public PessoaModel update(PessoaModel obj){
            Optional<PessoaModel> novoObj = repository.findById(obj.getId());
            updatePessoa(novoObj, obj);
             return repository.save(novoObj.get());
        }

    private void updatePessoa(Optional<PessoaModel> novoObj, PessoaModel obj) {
            novoObj.get().setNome(obj.getNome());
            novoObj.get().setIdade(obj.getIdade());
            novoObj.get().setCpf(obj.getCpf());

    }

}
