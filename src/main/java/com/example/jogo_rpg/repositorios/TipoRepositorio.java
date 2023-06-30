package com.example.jogo_rpg.repositorios;

import com.example.jogo_rpg.entidades.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepositorio extends JpaRepository<Tipo, Long> {
    boolean existsById(Long id);
}
