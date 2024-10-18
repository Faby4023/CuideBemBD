package br.com.cuidebem.models.acompanhante;

import br.com.cuidebem.models.Curso;
import br.com.cuidebem.models.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "acompanhantes")
public class Acompanhante {
    @Id
    private String cpf;
    private String nome;
    private String sobreNome;
    private String dataNascimento;
    private String telefone;
    private String antecedentes;
    private boolean ativo;
    @Embedded
    private Endereco endereco;
    @OneToMany
    private List<Curso> cursos;
}
