package com.gerenciamentoFilmes.jheykovalencia.DTO;

import java.util.List;

public record FilmeResponseDTO(
        long idFilme,
        String nomeFilme,
        Integer anoLancamentoFilmes,
        List<String> generos
) {
}
