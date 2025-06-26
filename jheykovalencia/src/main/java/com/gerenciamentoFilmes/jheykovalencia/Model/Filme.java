package com.gerenciamentoFilmes.jheykovalencia.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//Con esto no preciso crear getters ni setters
@Data
//Para identificar que esta clase es una entidad
@Entity
//con esto renombramos el nombre de la tabla, sino pegaria el nombre de la clase
@Table(name = "filmes")

public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFilme;

    @NotBlank(message = "O nome do filme é obrigatório!")
    private String nomeFilme;

    @NotNull(message = "O ano de lançamento é obrigatorio!")
    @Min(value = 1888 , message = "Ano de lançamento é invalido")
    private Integer anoLancamentoFilme;

    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmeGenero> generos = new ArrayList();


}
