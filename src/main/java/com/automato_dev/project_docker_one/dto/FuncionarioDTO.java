package com.automato_dev.project_docker_one.dto;

import java.util.ArrayList;
import java.util.List;

import com.automato_dev.project_docker_one.entidade.Perfil;



public class FuncionarioDTO {
    
    private Long matricula;
    private String nome;
    private String sobrenome;
    private Integer idade;
    private List<Perfil> perfis = new ArrayList<>();


    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Long matricula, String nome, String sobrenome, Integer idade, List<Perfil> perfis) {
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.perfis = perfis;
    }


    public Long getMatricula() {
        return this.matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getIdade() {
        return this.idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }


    public List<Perfil> getPerfis() {
        return this.perfis;
    }

    public void setPerfils(List<Perfil> perfis) {
        this.perfis = perfis;
    }



}
