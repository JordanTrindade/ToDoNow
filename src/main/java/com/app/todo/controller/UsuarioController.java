package com.app.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.app.todo.model.Tarefa;
import com.app.todo.model.Usuario;
import com.app.todo.service.TarefaService;
import com.app.todo.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService userService;
	
	@Autowired
	TarefaService tarefaService;
	
	@GetMapping
	public ResponseEntity<?> buscaTodosUsuarios(){
		List<Usuario> usuarios = userService.buscaTodosUsuarios();
		
		if(usuarios != null) {
			return ResponseEntity.ok(usuarios);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscaUsuario(@PathVariable Long id){
		
		Usuario usuario = userService.buscaUsuarioPorId(id);
		
		if(usuario != null) {
			return ResponseEntity.ok(usuario);
		}else {
			return ResponseEntity.notFound().build();		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvaUsuario(@RequestBody Usuario user) {
		try {
			userService.salvaUsuario(user);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/{userId}/tarefas")
	public void adicionaTarefa(@PathVariable Long userId, @RequestBody Tarefa tarefa) {
		Usuario usuario = userService.buscaUsuarioPorId(userId);
		usuario.getTarefas().add(tarefa);
		
		tarefaService.salvaTarefa(tarefa);
	}
}
