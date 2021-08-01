package com.automato_dev.project_docker_one.repository;

import com.automato_dev.project_docker_one.entidade.Perfil;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepositorio extends JpaRepository<Perfil, Long>{
    
}
