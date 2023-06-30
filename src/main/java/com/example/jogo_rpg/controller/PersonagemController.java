package com.example.jogo_rpg.controller;

import com.example.jogo_rpg.entidades.Personagem;
import com.example.jogo_rpg.entidades.Tipo;
import com.example.jogo_rpg.repositorios.PersonagemRepositorio;
import com.example.jogo_rpg.repositorios.TipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemRepositorio personagemRepositorio;

    @Autowired
    private TipoRepositorio tipoRepositorio;

    @GetMapping
    public List<Personagem> findAll(){
        List<Personagem> resultado = personagemRepositorio.findAll();
        return resultado;
    }
    @GetMapping(value = "/{id}")
    public Personagem findById(@PathVariable Long id){
        Personagem resultado = personagemRepositorio.findById(id).get();
        return resultado;
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Personagem personagem){
        //return null;
        //todo: validar se a variavel personagem é diferente de nulo
        // caso1: {} essa validação foi!
        // caso2:
        //todo: validar se a variavel personagem.getTipo() é diferente de nulo
        //caso1: {"nome":"Teste7","vida":5,"forca":7,"defesa":10,"agilidade":10,"quantidade_de_dados":8,"face_dos_dados":16,"tipo":{}}
        //caso2: {"nome":"Teste8","vida":5,"forca":7,"defesa":10,"agilidade":10,"quantidade_de_dados":8,"face_dos_dados":16,"tipo":null} validação concluída!
        //caso3: {"nome":"Teste9","vida":5,"forca":7,"defesa":10,"agilidade":10,"quantidade_de_dados":8,"face_dos_dados":16} validação concluída!

        if(personagem == null){
           return ResponseEntity.badRequest().body("O personagem não pode ser nulo");
        }

        if(personagem.getTipo() == null){
            return ResponseEntity.badRequest().body("O tipo do personagem não pode ser nulo!");
        }
        if(!tipoRepositorio.existsById(personagem.getTipo().getId())) {
            return ResponseEntity.badRequest().body("Numeração do ID inválida!");
            //System.out.println("json enviado: " + personagem.toString());

            //caso1: {}
            //caso2:
            //return null;
        }
        var resultado = personagemRepositorio.save(personagem);
        Tipo tipo = tipoRepositorio.findById(resultado.getTipo().getId()).get();
        resultado.setTipo(tipo);
        return ResponseEntity.ok("Personagem criado com sucesso!");
    }


//    @PostMapping
//    public Personagem insert(@RequestBody Personagem personagem){
//        //return null;
//        //todo: validar se a variavel personagem é diferente de nulo
//        // caso1: {}
//        // caso2:
//        //todo: validar se a variavel personagem.getTipo() é diferente de nulo
//        //caso1: {"nome":"Teste7","vida":5,"forca":7,"defesa":10,"agilidade":10,"quantidade_de_dados":8,"face_dos_dados":16,"tipo":{}}
//        //caso2: {"nome":"Teste8","vida":5,"forca":7,"defesa":10,"agilidade":10,"quantidade_de_dados":8,"face_dos_dados":16,"tipo":null}
//        //caso3: {"nome":"Teste9","vida":5,"forca":7,"defesa":10,"agilidade":10,"quantidade_de_dados":8,"face_dos_dados":16}
//
//        if (personagem == null){
//
//        }
//        if(!tipoRepositorio.existsById(personagem.getTipo().getId())) {
//            System.out.println("json enviado: " + personagem.toString());
//            System.out.println("Numeração do ID inválida.");
//            //caso1: {}
//            //caso2:
//            return null;
//        }
//        Personagem resultado = personagemRepositorio.save(personagem);
//        Tipo tipo = tipoRepositorio.findById(resultado.getTipo().getId()).get();
//        resultado.setTipo(tipo);
//        return resultado;
//    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id){
        personagemRepositorio.deleteById(id);
        return "Personagem excluído com sucesso!";
    }
}
