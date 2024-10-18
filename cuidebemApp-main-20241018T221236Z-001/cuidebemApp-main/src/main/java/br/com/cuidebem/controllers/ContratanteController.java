package br.com.cuidebem.controllers;

import br.com.cuidebem.models.contratante.Contratante;
import br.com.cuidebem.services.ContratanteService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contratante")

public class ContratanteController {
    private final ContratanteService contratanteService;

    public ContratanteController(ContratanteService contratanteService) {
        this.contratanteService = contratanteService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Contratante contratante){
        var aux = contratanteService.criar(contratante);
        return ResponseEntity.ok(aux);
    }

    @GetMapping
    public ResponseEntity findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return ResponseEntity.ok(contratanteService.findAll());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity findById(@PathVariable String cpf) {
        var contratante = contratanteService.buscarPorId(cpf);
        return ResponseEntity.ok(contratante);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable String id,  @RequestBody Contratante contratante) {
        var contratanteAtualizado = contratanteService.Atualizar(id, contratante);
        return ResponseEntity.ok(contratanteAtualizado);
    }


    @DeleteMapping("/{cpf}")
    public ResponseEntity deletar(@PathVariable String cpf) {
        contratanteService.deletar(cpf);
        return ResponseEntity.noContent().build();
    }

}

