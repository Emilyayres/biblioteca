package com.api.BibliotecaOnline.service;


import com.api.BibliotecaOnline.data.LivroEntity;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.stereotype.Service; 
import com.api.BibliotecaOnline.data.LivroRepository;

@Service 

public class LivroService { 
@Autowired 
LivroRepository livroRepository; 
public LivroEntity criarLivro(LivroEntity liv) { 
liv.setId(null); 
livroRepository.save(liv); 
return liv; 
} 
public LivroEntity atualizarLivro(Integer livId, LivroEntity livroRequest) { 
LivroEntity liv = getLivroId(livId); 
liv.setTitulo(livroRequest.getTitulo()); 
liv.setAutor(livroRequest.getAutor()); 
liv.setGenero(livroRequest.getGenero()); 
liv.setPreco(livroRequest.getPreco()); 
livroRepository.save(liv); 
return liv; 
} 
public LivroEntity getLivroId(Integer livId) { 
return livroRepository.findById(livId).orElse(null); 
} 
public List<LivroEntity> listarTodosLivros() { 
return livroRepository.findAll(); 
} 
public void deletarLivro(Integer livId) { 
LivroEntity liv = getLivroId(livId); 
livroRepository.deleteById(liv.getId()); 
 } 

} 