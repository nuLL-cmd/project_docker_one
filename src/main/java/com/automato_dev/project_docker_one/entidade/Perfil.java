package com.automato_dev.project_docker_one.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.automato_dev.project_docker_one.enumerator.PerfilEnum;

@Entity(name = "tb_perfis")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_perfil")
    private Long idPerfil;
    
    @Column(name = "nm_perfil")
    @Enumerated(EnumType.STRING)
    private PerfilEnum nmPerfil;


    public Perfil(Long idPerfil, PerfilEnum nmPerfil) {
        this.idPerfil = idPerfil;
        this.nmPerfil = nmPerfil;
    }


    public Perfil() {
    }

    public Long getIdPerfil() {
        return this.idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public PerfilEnum getNmPerfil() {
        return this.nmPerfil;
    }

    public void setNmPerfil(PerfilEnum nmPerfil) {
        this.nmPerfil = nmPerfil;
    }

    
}
