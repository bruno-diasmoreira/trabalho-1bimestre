package br.edu.vianna.trabalhodupla.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ficha implements Serializable {

    private int id;

    private String descricao;

    private boolean ehPeito,ehTriceps,ehCostas,ehBiceps,ehPernas,ehOmbro;

    private Aluno aluno;

    public Ficha() {
    }

    public Ficha(int id, String descricao, boolean ehPeito, boolean ehTriceps, boolean ehCostas, boolean ehBiceps, boolean ehPernas, boolean ehOmbro, Aluno aluno) {
        this.id = id;
        this.descricao = descricao;
        this.ehPeito = ehPeito;
        this.ehTriceps = ehTriceps;
        this.ehCostas = ehCostas;
        this.ehBiceps = ehBiceps;
        this.ehPernas = ehPernas;
        this.ehOmbro = ehOmbro;
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEhPeito() {
        return ehPeito;
    }

    public void setEhPeito(boolean ehPeito) {
        this.ehPeito = ehPeito;
    }

    public boolean isEhTriceps() {
        return ehTriceps;
    }

    public void setEhTriceps(boolean ehTriceps) {
        this.ehTriceps = ehTriceps;
    }

    public boolean isEhCostas() {
        return ehCostas;
    }

    public void setEhCostas(boolean ehCostas) {
        this.ehCostas = ehCostas;
    }

    public boolean isEhBiceps() {
        return ehBiceps;
    }

    public void setEhBiceps(boolean ehBiceps) {
        this.ehBiceps = ehBiceps;
    }

    public boolean isEhPernas() {
        return ehPernas;
    }

    public void setEhPernas(boolean ehPernas) {
        this.ehPernas = ehPernas;
    }

    public boolean isEhOmbro() {
        return ehOmbro;
    }

    public void setEhOmbro(boolean ehOmbro) {
        this.ehOmbro = ehOmbro;
    }

}
