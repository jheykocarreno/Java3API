package com.gerenciamentoFilmes.jheykovalencia.Controller;

import com.gerenciamentoFilmes.jheykovalencia.Model.Genero;
import com.gerenciamentoFilmes.jheykovalencia.Service.GeneroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
@CrossOrigin("*")
@Tag(name = "Generos", description = "Endpoint para CRUD de generos")

public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping
    @Operation(summary = "Cadastrar generos")
    public ResponseEntity<Genero> cadastroGenero(@RequestBody Genero genero) {
        return new ResponseEntity<>(generoService.cadastrarGenero(genero),HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todos os generos")
    public ResponseEntity<List<Genero>> listarGeneros(){
        List<Genero> generos = generoService.listarTodosGeneros();

        if (generos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(generos,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar genero")
    public ResponseEntity<Void> deletarGenero(@PathVariable long id){
        generoService.deletarGenero(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
