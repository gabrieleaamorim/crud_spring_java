package com.example.jogo_rpg.entidades;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_personagem")
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int vida;
    private int forca;
    private int defesa;
    private int agilidade;
    private int quantidade_de_dados;
    private int face_dos_dados;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;

    @Override
    public String toString() {
        return "Personagem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", vida=" + vida +
                ", forca=" + forca +
                ", defesa=" + defesa +
                ", agilidade=" + agilidade +
                ", quantidade_de_dados=" + quantidade_de_dados +
                ", face_dos_dados=" + face_dos_dados +
                ", tipo=" + tipo +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getQuantidade_de_dados() {
        return quantidade_de_dados;
    }

    public void setQuantidade_de_dados(int quantidade_de_dados) {
        this.quantidade_de_dados = quantidade_de_dados;
    }

    public int getFace_dos_dados() {
        return face_dos_dados;
    }

    public void setFace_dos_dados(int face_dos_dados) {
        this.face_dos_dados = face_dos_dados;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
