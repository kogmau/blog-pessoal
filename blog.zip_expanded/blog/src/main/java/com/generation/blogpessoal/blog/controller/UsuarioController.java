package com.generation.blogpessoal.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.blog.model.UsuarioModel;
import com.generation.blogpessoal.repositorio.UsuarioRepository;




@RestController
@CrossOrigin ( origins  =   " * " , allowedHeaders  =  " * " )
@RequestMapping ("/usuario")

public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public List<UsuarioModel>GetAll(){
		return repository.findAll();
	}

	@GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> GetById(@PathVariable long id) {
    	return repository.findById(id)
    			.map(resp -> ResponseEntity.ok(resp))
    			.orElse(ResponseEntity.notFound().build());
    	}

	
	@GetMapping("/nome/{nome}")
    public ResponseEntity<List<UsuarioModel>> getByName(@PathVariable String nome){
	 return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
 }
	

	
    @PostMapping
    public ResponseEntity<UsuarioModel> post (@RequestBody UsuarioModel usuarioS) {
	return ResponseEntity.status(HttpStatus.CREATED)
			.body(repository.save(usuarioS));
}
 
    @PutMapping
    public ResponseEntity<UsuarioModel> put (@RequestBody UsuarioModel usuarioS){
	 return ResponseEntity.ok(repository.save(usuarioS));
	 
 }
 
    
    
   @DeleteMapping("/{id}")
   public void delete(@PathVariable long id) {
	 repository.deleteById(id);

}
	
	
}
