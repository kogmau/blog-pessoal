package com.generation.blogpessoal.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogpessoal.blog.model.UsuarioModel;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	public List<UsuarioModel> findAllByDescricaoContainingIgnoreCase(String usuario);
}