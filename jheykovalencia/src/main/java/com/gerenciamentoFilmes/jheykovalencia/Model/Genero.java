package com.gerenciamentoFilmes.jheykovalencia.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "generos")

public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGenero;

    @NotBlank(message = "O nome do campo é obrigatorio")
    private String nomeGenero;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<FilmeGenero> filmeGenero = new ArrayList<>();

}
