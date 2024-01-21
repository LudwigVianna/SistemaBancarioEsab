package com.esab.academico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esab.academico.model.Cliente;
import com.esab.academico.service.ClienteService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	
	@ApiOperation(value="Endpoint para buscar todos os clientes")
	@GetMapping("/get")
	public List<Cliente> buscarClientes() {
		return this.clienteService.buscarClientes();
	}
	
	@ApiOperation(value="Endpoint para buscar cliente por id")
	@GetMapping("/{id}")
	public Cliente buscarCliente(@PathVariable("id") Long id) {
		return this.clienteService.buscarCliente(id);
	}
	
	@ApiOperation(value="Endpoint para atualizar cliente")
	@PutMapping("/{id}")
	public void atualizarCliente (@PathVariable("id") Long id, @RequestBody Cliente cliente) throws Exception {
		this.clienteService.atualizarCliente(cliente, id);
	}
	
	@ApiOperation(value="Endpoint para deletar cliente")
	@DeleteMapping("/{id}")
	public String excluirCliente (@PathVariable("id") Long id) {
		this.clienteService.deletar(id);

		return "Cliente ID: " + id + " foi deletado com sucesso!";
	}
	
}