package br.edu.vianna.trabalhodupla.utils;

public class Item {

    private int imagem;
    private String descricao;

    public Item(int imagem, String descricao) {
        this.imagem = imagem;
        this.descricao = descricao;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
