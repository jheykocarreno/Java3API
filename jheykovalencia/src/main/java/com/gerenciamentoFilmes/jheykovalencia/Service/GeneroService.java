package com.gerenciamentoFilmes.jheykovalencia.Service;

import com.gerenciamentoFilmes.jheykovalencia.Model.Genero;
import com.gerenciamentoFilmes.jheykovalencia.Repository.IGeneroRepositary;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Clock;
import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private IGeneroRepositary generoRepositary;

    public Genero cadastrarGenero(@RequestBody Genero genero){
        return generoRepositary.save(genero);

    }

    public List<Genero> listarTodosGeneros(){
        return generoRepositary.findAll();
    }

    public void deletarGenero(long id){
        Genero generoEncontrado = generoRepositary.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Genero nao encontrado"));
        generoRepositary.delete(generoEncontrado);
    }
}
