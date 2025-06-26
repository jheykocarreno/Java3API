package com.gerenciamentoFilmes.jheykovalencia.Repository;

import com.gerenciamentoFilmes.jheykovalencia.Model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGeneroRepositary extends JpaRepository<Genero, Long> {
}
