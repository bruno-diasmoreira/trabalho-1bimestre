package br.edu.vianna.trabalhodupla.domain;

public class Medida {

    private int id;
    private double braco,antiBraco,abdomen,quadril,cintura,coxa,perna;
    private Aluno aluno;

    public Medida() {
    }

    public Medida(int id, double braco, double antiBraco, double abdomen, double quadril, double cintura, double coxa, double perna, Aluno aluno) {
        this.id = id;
        this.braco = braco;
        this.antiBraco = antiBraco;
        this.abdomen = abdomen;
        this.quadril = quadril;
        this.cintura = cintura;
        this.coxa = coxa;
        this.perna = perna;
        this.aluno = aluno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBraco() {
        return braco;
    }

    public void setBraco(double braco) {
        this.braco = braco;
    }

    public double getAntiBraco() {
        return antiBraco;
    }

    public void setAntiBraco(double antiBraco) {
        this.antiBraco = antiBraco;
    }

    public double getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(double abdomen) {
        this.abdomen = abdomen;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getCoxa() {
        return coxa;
    }

    public void setCoxa(double coxa) {
        this.coxa = coxa;
    }

    public double getPerna() {
        return perna;
    }

    public void setPerna(double perna) {
        this.perna = perna;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
