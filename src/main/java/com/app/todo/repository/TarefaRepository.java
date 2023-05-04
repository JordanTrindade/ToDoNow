package com.app.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.todo.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
