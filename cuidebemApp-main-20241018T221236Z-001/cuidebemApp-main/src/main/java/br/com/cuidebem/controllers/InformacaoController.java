package br.com.cuidebem.controllers;

import br.com.cuidebem.models.idoso.Informacao;
import br.com.cuidebem.services.InformacaoService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class InformacaoController {
    private final InformacaoService informacaoService;

    public InformacaoController(InformacaoService informacaoService) {
        this.informacaoService = informacaoService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Informacao informacao){
        var aux = informacaoService.criar(informacao);
        return ResponseEntity.ok(aux);
    }

    @GetMapping
    public ResponseEntity findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return ResponseEntity.ok(informacaoService.findAll());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity findById(@PathVariable Long id) {
        var informacao = informacaoService.buscarPorId(id);
        return ResponseEntity.ok(informacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id,  @RequestBody Informacao informacao) {
        var informacaoAtualizado = informacaoService.Atualizar(id, informacao);
        return ResponseEntity.ok(informacaoAtualizado);
    }


    @DeleteMapping("/{cpf}")
    public ResponseEntity deletar(@PathVariable Long id) {
        informacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}




