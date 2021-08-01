package com.automato_dev.project_docker_one.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.automato_dev.project_docker_one.entidade.Funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioCustomRepositorio {
    
    @Autowired
    private EntityManager entityManager;


    public List<Funcionario> findCustom(Long nrMatricula, String nome, String sobrenome){
        var query = "select f from tb_funcionario f ";
        var condicao = "where ";

        if(nrMatricula != null){
            query += condicao + "f.nrMatricula = :nrMatricula";
            condicao = "end ";
        }

        if(nome != null){
            query += condicao + "f.nome = :nome";
            condicao = "end ";
        }

        if(sobrenome != null){
            query += condicao + ".sobrenome = :sobrenome";
            
        }

        var queryFinal =  entityManager.createQuery(query, Funcionario.class);


        if(nrMatricula != null){
            queryFinal.setParameter("nrMatricula", nrMatricula);
        }

        if(nome != null){
            
            queryFinal.setParameter("nome", nome);
        }

        if(sobrenome != null){

            queryFinal.setParameter("sobrenome",sobrenome);
        }

        return queryFinal.getResultList();
    }
}
