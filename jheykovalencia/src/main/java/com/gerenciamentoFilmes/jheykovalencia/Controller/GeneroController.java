package com.gerenciamentoFilmes.jheykovalencia.Controller;

import com.gerenciamentoFilmes.jheykovalencia.Model.Genero;
import com.gerenciamentoFilmes.jheykovalencia.Service.GeneroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    };

}
