package com.automato_dev.project_docker_one.resource;

import java.util.stream.Collectors;

import com.automato_dev.project_docker_one.dto.FuncionarioDTO;
import com.automato_dev.project_docker_one.entidade.Funcionario;
import com.automato_dev.project_docker_one.repository.FuncionarioCustomRepositorio;
import com.automato_dev.project_docker_one.repository.FuncionarioRepositorio;
import com.automato_dev.project_docker_one.repository.PerfilRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioRepositorio repositorio;

    @Autowired
    private PerfilRepositorio perfilRepositorio;

    @Autowired
    private FuncionarioCustomRepositorio fCustomRepositorio;

    @GetMapping
    public ResponseEntity<?> fetchAll() {

        var funcionarios = repositorio.findAll();

        return ResponseEntity
                .ok(funcionarios.stream().map((f) -> Funcionario.converter(f)).collect(Collectors.toList()));
    }

    @GetMapping("filter/{id}/id")
    private ResponseEntity<?> fetchById(@PathVariable("id") Long id) {
        var funcionario = repositorio.findById(id).orElse(null);
        return ResponseEntity.ok(Funcionario.converter(funcionario));
    }

    @GetMapping("filter/{idade}/idade")
    private ResponseEntity<?> fetchByAge(@PathVariable("idade") Integer idade) {
        var funcionarios = repositorio.findByIdade(idade);

        return ResponseEntity
                .ok(funcionarios.stream().map((f) -> Funcionario.converter(f)).collect(Collectors.toList()));
    }

    @PostMapping
    private ResponseEntity<?> postFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {

        funcionarioDTO.setPerfils(funcionarioDTO.getPerfis().stream().filter(perfil -> perfil.getIdPerfil() != null)
                .map(perfil -> perfilRepositorio.findById(perfil.getIdPerfil()).get()).collect(Collectors.toList()));

        var funcionario = new Funcionario().converterFuncionario(funcionarioDTO);

        funcionario = repositorio.save(funcionario);

        return ResponseEntity.ok(Funcionario.converter(funcionario));
    }

    @GetMapping("filter/custom")
    private ResponseEntity<?> buscaPorParametros(@RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "sobrenome", required = false) String sobrenome) {

        return ResponseEntity.ok(fCustomRepositorio.findCustom(id, nome, sobrenome));
    }
}
