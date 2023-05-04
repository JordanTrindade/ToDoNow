package com.app.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.todo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
