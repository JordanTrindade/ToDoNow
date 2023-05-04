package com.app.todo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.app.todo.model.Tarefa;
import com.app.todo.repository.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	TarefaRepository tr;
	
	public void salvaTarefa(Tarefa tarefa) {
		tr.save(tarefa);
	}
	
	public Tarefa buscaTarefaPorId(Long id) {
		Optional<Tarefa> tarefa = tr.findById(id);
		
		return tarefa.orElseThrow(()-> new ObjectNotFoundException(id, "Tarefa não encontrada"));
	}
	
	public List<Tarefa> buscaTodasTarefas() {
		List<Tarefa> tarefas = tr.findAll();
		if(CollectionUtils.isEmpty(tarefas)) {
			throw new ObjectNotFoundException(tarefas, "Nenhuma tarefa encontrada");
		}else {
			return tarefas;
		}
	}
}
