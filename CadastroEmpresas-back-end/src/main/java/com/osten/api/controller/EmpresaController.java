package com.osten.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osten.api.model.Empresa;
import com.osten.api.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> detalharEmpresa(@PathVariable Long id) {
        Empresa empresa = empresaRepository.findById(id).orElse(null);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Empresa> cadastrarEmpresa(@RequestBody Empresa empresa) {
        Empresa novaEmpresa = empresaRepository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEmpresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresaAtualizada) {
        Empresa empresa = empresaRepository.findById(id).orElse(null);
        if (empresa != null) {
            empresa.setNome(empresaAtualizada.getNome());
            empresa.setRuaAvenida(empresaAtualizada.getRuaAvenida());
            empresa.setNumero(empresaAtualizada.getNumero());
            empresa.setBairro(empresaAtualizada.getBairro());
            empresa.setCidade(empresaAtualizada.getCidade());
            empresa.setEstado(empresaAtualizada.getEstado());

            Empresa empresaAtualizada1 = empresaRepository.save(empresa);
            return ResponseEntity.ok(empresaAtualizada1);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEmpresa(@PathVariable Long id) {
        Empresa empresa = empresaRepository.findById(id).orElse(null);
        if (empresa != null) {
            empresaRepository.delete(empresa);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}