package com.automato_dev.project_docker_one.enumerator;

import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Marco Aurélio
 * @date 03/06/2021
 * 
 * Enumerador para a entidade de perfil
 */
public enum PerfilEnum {
    
    ADMIN("ADMIN","ROLE_ADMINISTRADOR"),
    USER("USER","ROLE_USUARIO");


    private final String codigo;
    private final String descricao;

    private PerfilEnum(String codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao; 
        
        try{

            Field field = this.getClass().getSuperclass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(this, this.codigo);


        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro PerfilEnum: "+e.getMessage());
        }
    }


    public String getDescricao(){
        return this.descricao;
    }

    @JsonValue
    public String getCodigigo(){
        return this.codigo;
    }
}
