package br.pucrs.daniellemadrid.demo;

import java.util.List;
import org.springframework.http.ResponseEntity;

public interface IAcervoRepository {
List<Livro> getLivros();
List<String> getTitulos();
List<String> getAutores();
List<Livro> getLivrosDoAutor(String autor);
List<Livro> getLivrosDoAutor(String autor, int ano);
Livro getLivroTitulo(String titulo);
boolean cadastraLivroNovo(Livro livro);
boolean removeLivro(int id);
}