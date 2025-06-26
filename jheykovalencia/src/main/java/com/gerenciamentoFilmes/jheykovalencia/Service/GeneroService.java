package com.gerenciamentoFilmes.jheykovalencia.Service;

import com.gerenciamentoFilmes.jheykovalencia.Model.Genero;
import com.gerenciamentoFilmes.jheykovalencia.Repository.IGeneroRepositary;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class GeneroService {

    @Autowired
    private IGeneroRepositary generoRepositary;

    public Genero cadastrarGenero(@RequestBody Genero genero){
        return generoRepositary.save(genero);

    }

}
