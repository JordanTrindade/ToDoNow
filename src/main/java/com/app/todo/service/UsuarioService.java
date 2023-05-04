package com.app.todo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.app.todo.model.Usuario;
import com.app.todo.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usersRepository;
	
	//salva um usuário 
	public void salvaUsuario(Usuario user) {
		usersRepository.save(user);
	}
	
	//busca um usuario por id
	public Usuario buscaUsuarioPorId(Long id) {
		Optional<Usuario> usuario = usersRepository.findById(id);
		
		return usuario.orElseThrow(()-> new ObjectNotFoundException(id, "Usuario não encontrado"));
	}
	
	
	//busca todos usuarios do banco (tem duas implementações ainda não sei qual delas é uma pratica melhor)
	public List<Usuario> buscaTodosUsuarios(){		
//		try {
//			List<Users> usuarios = usersRepository.findAll();
//			return usuarios;
//		} catch (Exception e) {
//			throw new ObjectNotFoundException(usersRepository, "Nenhum usuario encontrado");
//		}
		
		List<Usuario> usuarios = usersRepository.findAll();
		if(CollectionUtils.isEmpty(usuarios)) {
			throw new ObjectNotFoundException(usersRepository, "Nenhum usuario encontrado");
		}else {
			return usuarios;
		}
	}
}
