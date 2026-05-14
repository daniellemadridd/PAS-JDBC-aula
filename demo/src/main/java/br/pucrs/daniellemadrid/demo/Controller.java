package br.pucrs.daniellemadrid.demo;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/biblioteca")
public class Controller {
    private IAcervoRepository acervo;

    @Autowired
    public Controller(IAcervoRepository acervo) {
        this.acervo = acervo;        
    }

    @GetMapping("/")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return acervo.getLivros();
    }
    
    @GetMapping("/titulos")
    public List<String> getTitulos() {
        return acervo.getTitulos();
    }

    @GetMapping("/autores")
    public List<String> getListaAutores() {
        return acervo.getListaAutores();
    }

    @GetMapping("/livrosautor")
    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return acervo.getLivrosDoAutor(autor);
    }

    @GetMapping("/livrosautorano/{autor}/ano/{ano}")
    public List<Livro> getLivrosDoAutor(@PathVariable(value="autor") String autor,
                                        @PathVariable(value="ano")int ano) {
        return acervo.getLivrosDoAutor(autor, ano);
    }
    
    @PostMapping("/novolivro")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        return acervo.cadastraLivroNovo(livro);
    }

    @GetMapping("/livrotitulo/{titulo}")
    public ResponseEntity<Livro> getLivroTitulo(@PathVariable("titulo") String titulo) {
        Livro livro = acervo.getLivroTitulo(titulo);
        return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(livro);
        }

}
