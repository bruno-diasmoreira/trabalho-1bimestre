package br.edu.vianna.trabalhodupla.domain;

public class Exercicios{


    private int id;
    private String descricao,serie,repeticao;
    private Ficha ficha;

    public Exercicios() {
    }

    public Exercicios(String descricao, String serie, String repeticao) {
        this.descricao = descricao;
        this.serie = serie;
        this.repeticao = repeticao;
    }

    public Exercicios(int id, String descricao, String serie, String repeticao, Ficha ficha) {
        this.id = id;
        this.descricao = descricao;
        this.serie = serie;
        this.repeticao = repeticao;
        this.ficha = ficha;
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(String repeticao) {
        this.repeticao = repeticao;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public String toString() {
        return " "+ getDescricao() + ":: Serie:"+ getSerie() + ":: Repetições:"+ getRepeticao();
    }



}
