package com.senai.projeto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materiais")
public class Material extends Model{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Column(name = "valor", nullable = false)
    private float valor;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Column(name = "descricao", nullable = false)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "tecido")
    private boolean tecido;

    public boolean isTecido() {
        return tecido;
    }

    public void setTecido(boolean tecido) {
        this.tecido = tecido;
    }

    @Column(name = "aviamento")
    private boolean aviamento;

    public boolean isAviamento() {
        return aviamento;
    }

    public void setAviamento(boolean aviamento) {
        this.aviamento = aviamento;
    }
}