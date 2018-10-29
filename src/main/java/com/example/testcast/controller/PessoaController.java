package com.example.testcast.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.testcast.model.Pessoa;
import com.example.testcast.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	public PessoaController() {
	}

	@PostMapping
	public ResponseEntity<Pessoa> manterPessoa(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<>(pessoaService.save(pessoa), HttpStatus.CREATED);

	}

	@RequestMapping(value = "/pessoas/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Pessoa> removerPessoa(@PathParam("id") Long id) {
		pessoaService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/rest/pessoa", method = RequestMethod.GET)
	public ResponseEntity listarPessoa(@PathParam("id") Long id) {
		return new ResponseEntity<>(pessoaService.buscar(id), HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<Pessoa>> listar() {
		return new ResponseEntity<List<Pessoa>>(pessoaService.buscarTodos(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> findById(@PathParam("id") Long id) {
		return new ResponseEntity<>(pessoaService.buscar(id), HttpStatus.OK);
	}

}