package br.com.cuidebem.controllers;

import br.com.cuidebem.models.Curso;
import br.com.cuidebem.services.CursoService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")

public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Curso curso){
        var aux = cursoService.criar(curso);
        return ResponseEntity.ok(aux);
    }

    @GetMapping
    public ResponseEntity findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return ResponseEntity.ok(cursoService.findAll());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity findById(@PathVariable Long id) {
        var curso = cursoService.buscarPorId(id);
        return ResponseEntity.ok(curso);
    }

    //@PutMapping("/{id}")
    //public ResponseEntity atualizar(@PathVariable Long id,  @RequestBody Curso curso) {
        //var cursoAtualizado = cursoService.Atualizar(id, curso);
       // return ResponseEntity.ok(cursoAtualizado);



    @DeleteMapping("/{cpf}")
    public ResponseEntity deletar(@PathVariable Long id) {
        cursoService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
