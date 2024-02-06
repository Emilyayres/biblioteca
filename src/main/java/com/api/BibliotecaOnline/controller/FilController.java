package com.api.BibliotecaOnline.controller;

import com.api.BibliotecaOnline.data.LivroEntity; 
import com.api.BibliotecaOnline.service.LivroService; 
import jakarta.validation.Valid; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 

@Controller 

public class FilController { 
@Autowired 
LivroService livroService; 
 @GetMapping("/") 
public String viewHomePage(Model model) { 
model.addAttribute("listarLivros", livroService.listarTodosLivros()); 
 return "index"; 
} 

 @GetMapping("/deletarLivro/{id}") 
 public String deletarLivro(@PathVariable(value = "id") Integer id) { 
livroService.deletarLivro(id); 
 return "redirect:/"; 
 } 

@GetMapping("/criarLivroForm") 
public String criarLivroForm(Model model) { 
LivroEntity liv = new LivroEntity(); 
 model.addAttribute("livro", liv); 
return "inserir"; 
} 
@PostMapping("/salvarLivro") 
public String salvarLivro(@Valid @ModelAttribute("livro") LivroEntity liv, BindingResult result) { 
if (result.hasErrors()) { 
 return "inserir"; 
} 
if (liv.getId()==null) { 
livroService.criarLivro(liv); 
 } else { 
livroService.atualizarLivro(liv.getId(), liv); 
} 
return "redirect:/"; 
} 

@GetMapping("/atualizarLivroForm/{id}") 
public String atualizarLivroForm(@PathVariable(value = "id") Integer id, Model model) { 
LivroEntity liv = livroService.getLivroId(id); 
model.addAttribute("livro", liv); 
 return "atualizar"; 
} 
} 