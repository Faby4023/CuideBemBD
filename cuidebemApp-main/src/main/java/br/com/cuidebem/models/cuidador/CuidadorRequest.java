package br.com.cuidebem.models.cuidador;

import br.com.cuidebem.models.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record CuidadorRequest(@NotBlank(message = "O nome não pode está vazio!")
                                  String cpf,
                                  String nome,
                                  String sobrenome,

                                  @Past
                                  LocalDate dataNascimento,
                                  String telefone,
                                  String antecedentes,
                                  boolean ativo,
                                  Endereco endereco) {

    public Cuidador toCuidador(){
        return new Cuidador(cpf(),nome(),sobrenome(), dataNascimento(), telefone(), antecedentes(), ativo(), endereco());
    }
}