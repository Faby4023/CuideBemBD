package br.com.cuidebem.models.curso;

import br.com.cuidebem.models.Curso;
import br.com.cuidebem.models.Endereco;
import br.com.cuidebem.models.cuidador.Cuidador;

import java.time.LocalDate;

public record CursoResponse(
        Long id,
        String nomeDoCurso,
        String instituicao,
        String periodo,
        String certificacao){

    public CursoResponse(Curso curso){
        this(curso.getId(), curso.getNomeDoCurso(), curso.getInstituicao(), curso.getPeriodo(), curso.getCertificacao());
    }
}
