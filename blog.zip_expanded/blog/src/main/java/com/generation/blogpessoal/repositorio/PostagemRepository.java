package com.generation.blogpessoal.repositorio;
import com.generation.blogpessoal.blog.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemModel, Long>{
public List<PostagemModel> findAllByTituloContainingIgnoreCase(String titulo);


}