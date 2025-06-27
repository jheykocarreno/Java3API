package com.gerenciamentoFilmes.jheykovalencia.Controller;

import com.gerenciamentoFilmes.jheykovalencia.DTO.FilmeDTO;
import com.gerenciamentoFilmes.jheykovalencia.DTO.FilmeResponseDTO;
import com.gerenciamentoFilmes.jheykovalencia.Model.Filme;
import com.gerenciamentoFilmes.jheykovalencia.Service.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@CrossOrigin("*")
@Tag(name = "Filmes", description = "Endpoint para CRUD de filmes")

public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    public ResponseEntity<Filme> cadastroFilme(@RequestBody FilmeDTO filmeDTO) {
        return new ResponseEntity<>(filmeService.criarFilme(filmeDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todos os filmes")
    public ResponseEntity<List<FilmeResponseDTO>> listarFilmes() {
        List<FilmeResponseDTO> filmes = filmeService.listarTodosFilmes();

        if (filmes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar filme")
    public ResponseEntity<Void> deletarFilme(@PathVariable long id) {
        filmeService.deletarFilme(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{idFilme}")
    @Operation(summary = "Atualizar filme")
    public ResponseEntity<Filme> atualizarFilme(@RequestBody FilmeDTO filmeDTO) {
        Filme filmeAtualizado = filmeService.atualizarFilme(filmeDTO);

        return ResponseEntity.ok(filmeAtualizado);
    }

    @PostMapping("/{idFilme}")
    @Operation(summary = "Buscar filme por ID")
    public ResponseEntity<Filme> buscarFilme(@PathVariable long idFilme) {
        return new ResponseEntity<>(filmeService.buscarFilmePorId(idFilme), HttpStatus.OK);

        
    }
}
