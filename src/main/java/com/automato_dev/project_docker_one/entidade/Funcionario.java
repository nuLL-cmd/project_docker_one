package com.automato_dev.project_docker_one.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.automato_dev.project_docker_one.dto.FuncionarioDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "tb_funcionario")
@JsonInclude(content = Include.NON_NULL)
public class Funcionario {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr_matricula")
    private Long nrMatricula;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "idade")
    private Integer idade;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "tb_perfil_usuario", joinColumns = @JoinColumn(name = "nr_matricula"), inverseJoinColumns = @JoinColumn(name = "id_perfil"))
    private List<Perfil> perfis = new ArrayList<>();

    public static FuncionarioDTO converter(Funcionario funcionario) {

        if (funcionario != null) {
            var dto = new FuncionarioDTO();
            dto.setMatricula(funcionario.getNrMatricula());
            dto.setNome(funcionario.getNome());
            dto.setIdade(funcionario.getIdade());
            dto.setSobrenome(funcionario.getSobrenome());
            dto.getPerfis().addAll(funcionario.getPerfis() != null ? funcionario.getPerfis() : new ArrayList<>());

            return dto;

        }

        return null;
    }

    public Funcionario converterFuncionario(FuncionarioDTO dto) {
        setIdade(dto.getIdade());
        setNome(dto.getNome());
        setSobrenome(dto.getSobrenome());
        setNrMatricula(dto.getMatricula());
        this.perfis.addAll(dto.getPerfis());

        return this;
    }


    public List<Perfil> getPerfis() {
        return this.perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }


    public Long getNrMatricula() {
        return this.nrMatricula;
    }

    public void setNrMatricula(Long nrMatricula) {
        this.nrMatricula = nrMatricula;
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

}
