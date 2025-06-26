package com.gerenciamentoFilmes.jheykovalencia.Repository;

import com.gerenciamentoFilmes.jheykovalencia.Model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFilmesRepositary extends JpaRepository<Filme, Long> {
}
