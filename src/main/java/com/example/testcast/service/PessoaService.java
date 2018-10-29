package com.example.testcast.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testcast.model.Pessoa;
import com.example.testcast.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public void remove(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa buscar(Long id) {
        Optional<Pessoa> obj = pessoaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado", Pessoa.class.getName()));
    }
    
    
    public List<Pessoa> buscarTodos(){
    	return pessoaRepository.findAll();
    }
}
