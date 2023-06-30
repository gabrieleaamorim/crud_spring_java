package com.example.jogo_rpg.repositorios;

import com.example.jogo_rpg.entidades.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonagemRepositorio extends JpaRepository<Personagem, Long> {
}
