package br.edu.vianna.trabalhodupla.domain;

import java.util.Date;
import java.util.List;

public class AgendarAluno {

    private int id;

    private Aluno aluno;

    private String descricao;

    private Date dataAula;

    private Date horaAula;

    public AgendarAluno() {
    }

    public AgendarAluno(int id, Aluno aluno, String descricao, Date dataAula,Date horaAula) {
        this.id = id;
        this.aluno = aluno;
        this.descricao = descricao;
        this.dataAula = dataAula;
        this.horaAula = horaAula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataAula() {
        return dataAula;
    }

    public void setDataAula(Date dataAula) {
        this.dataAula = dataAula;
    }

    public Date getHoraAula() {
        return horaAula;
    }

    public void setHoraAula(Date horaAula) {
        this.horaAula = horaAula;
    }
}
