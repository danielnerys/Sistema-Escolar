package model;

import java.time.LocalDate;

public class Turma {
    private int id;
    private int id_instituicao;
    private int professor_id;
    private String nome;
    private LocalDate ano_letivo;
    private String turno;
    private int vagas;
    private LocalDate criado_em;

    public Turma(int id, int id_instituicao, int professor_id, String nome, LocalDate ano_letivo, String turno, int vagas, LocalDate criado_em) {
        this.id = id;
        this.id_instituicao = id_instituicao;
        this.professor_id = professor_id;
        this.nome = nome;
        this.ano_letivo = ano_letivo;
        this.turno = turno;
        this.vagas = vagas;
        this.criado_em = criado_em;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_instituicao() {
        return id_instituicao;
    }

    public void setId_instituicao(int id_instituicao) {
        this.id_instituicao = id_instituicao;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAno_letivo() {
        return ano_letivo;
    }

    public void setAno_letivo(LocalDate ano_letivo) {
        this.ano_letivo = ano_letivo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public LocalDate getCriado_em() {
        return criado_em;
    }

    public void setCriado_em(LocalDate criado_em) {
        this.criado_em = criado_em;
    }

    public String toString(){
        return String.format("id: %s - Turma: %s - criado em: %s", id, nome, criado_em);
    }
}
