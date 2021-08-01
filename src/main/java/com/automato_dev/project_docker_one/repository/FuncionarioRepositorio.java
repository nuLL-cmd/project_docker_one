package com.automato_dev.project_docker_one.repository;

import java.util.List;

import com.automato_dev.project_docker_one.entidade.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByIdade(Integer idade);

    // @Query("select f from tb_funcionario f join fetch f.perfis where
    // f.nrMatricula = :id")
    // @EntityGraph(attributePaths = {"perfis"})
    // Optional<Funcionario> findById(@Param("id")Long id);

}
