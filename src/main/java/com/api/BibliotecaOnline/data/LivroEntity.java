
package com.api.BibliotecaOnline.data;


import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.Table; 
import lombok.Data; 
@Data 
@Entity 
@Table(name="Filmes") 
public class LivroEntity { 
@Id 
@GeneratedValue(strategy = GenerationType.AUTO) 

private Integer id; 
private String Titulo; 
private String Autor;     
private String Genero;    
private double Preco;    


} 
            