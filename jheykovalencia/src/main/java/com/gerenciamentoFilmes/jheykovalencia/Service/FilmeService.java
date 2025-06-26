package com.gerenciamentoFilmes.jheykovalencia.Service;

import com.gerenciamentoFilmes.jheykovalencia.DTO.FilmeDTO;
import com.gerenciamentoFilmes.jheykovalencia.DTO.FilmeResponseDTO;
import com.gerenciamentoFilmes.jheykovalencia.Model.Filme;
import com.gerenciamentoFilmes.jheykovalencia.Model.FilmeGenero;
import com.gerenciamentoFilmes.jheykovalencia.Model.Genero;
import com.gerenciamentoFilmes.jheykovalencia.Repository.IFilmesRepositary;
import com.gerenciamentoFilmes.jheykovalencia.Repository.IGeneroRepositary;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired  //Utilizada para realizar a injecao de dependencias de forma automatica
    private IFilmesRepositary filmesRepositary;

    @Autowired
    private IGeneroRepositary generoRepositary;

    public Filme criarFilme(@NotNull FilmeDTO filmeDTO){
        //Criar instancia da entidade filme
        Filme filme = new Filme();

        //define o nome do filme com base no DTO recebido
        filme.setNomeFilme(filmeDTO.nomeFilme());

        //define o ano de lancamento do filme com base no DTO recebido
        filme.setAnoLancamentoFilme(filmeDTO.anoLancamentoFilme());

        Filme filmeSalvo = filmesRepositary.save(filme);

        for(Long idGenero : filmeDTO.generoIds()) {
            Genero genero = generoRepositary.findById(idGenero)
                    .orElseThrow(() -> new EntityNotFoundException("Genero com Id " + idGenero + " Nao foi encontrado!"));

            //Criar uma nova instancia da entidade que esta associada a Filme
            FilmeGenero filmeGenero = new FilmeGenero();

            filmeGenero.setFilme(filmeSalvo);
            filmeGenero.setGenero(genero);

            //Salvando a associacao à lista de generos de filmes
            filmeSalvo.getGeneros().add(filmeGenero);
        }

        return filmesRepositary.save(filmeSalvo);
    }

    public List<FilmeResponseDTO> listarTodosFilmes(){
        return filmesRepositary.findAll().stream()
                .map(filme -> {
                    List<String> nomesGeneros = filme.getGeneros().stream()
                            .map(filmeGenero -> filmeGenero.getGenero().getNomeGenero()).toList();

                    return new FilmeResponseDTO(
                            filme.getIdFilme(),
                            filme.getNomeFilme(),
                            filme.getAnoLancamentoFilme(),
                            nomesGeneros

                    );
                }).toList();
    }
}
