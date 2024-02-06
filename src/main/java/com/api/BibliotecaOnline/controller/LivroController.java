
package com.api.BibliotecaOnline.controller;


import com.api.BibliotecaOnline.data.LivroEntity; 

import com.api.BibliotecaOnline.service.LivroService; 

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.http.HttpStatus; 

import org.springframework.http.ResponseEntity; 

import org.springframework.web.bind.annotation.DeleteMapping; 

import org.springframework.web.bind.annotation.GetMapping; 

import org.springframework.web.bind.annotation.PathVariable; 

import org.springframework.web.bind.annotation.PostMapping; 

import org.springframework.web.bind.annotation.PutMapping; 

import org.springframework.web.bind.annotation.RequestBody; 

import org.springframework.web.bind.annotation.RequestMapping; 

import org.springframework.web.bind.annotation.RestController; 

@RestController 

@RequestMapping("/livro") 

public class LivroController { 

@Autowired 
LivroService livroService; 
 @GetMapping("/listar") 
 public ResponseEntity<List> getAllLivros() { 
 List<LivroEntity> livros = livroService.listarTodosLivros(); 
 return new ResponseEntity<>(livros, HttpStatus.OK); 
} 
@GetMapping("/pesquisar/{id}") 
public ResponseEntity<LivroEntity> getLivroById(@PathVariable Integer id) { 
LivroEntity livros = livroService.getLivroId(id); 
return new ResponseEntity<>(livros, HttpStatus.OK); 
 } 
@PostMapping("/adicionar") 
public ResponseEntity<LivroEntity> addLivro(@RequestBody LivroEntity liv) { 
var novoLivro = livroService.criarLivro(liv); 
return new ResponseEntity<>(novoLivro, HttpStatus.CREATED); 
 } 
 @PutMapping("/atualizar/{id}") 
public ResponseEntity<LivroEntity> atualizarLivro(@PathVariable Integer id, @RequestBody LivroEntity livro) { 
var LivroAtualizado = livroService.atualizarLivro(id, livro); 
return new ResponseEntity<>(LivroAtualizado, HttpStatus.OK); 
} 
@DeleteMapping("/deletar/{id}") 
public ResponseEntity deletarlivro(@PathVariable Integer id) { 
livroService.deletarLivro(id); 
return new ResponseEntity<>(HttpStatus.OK); 
} 

} 