package main;

import java.time.LocalDate;

import biblioteca.models.pessoasPackage.Professor;
//import biblioteca.models.pessoasPackage.FuncionarioBiblioteca;
import biblioteca.models.pessoasPackage.Pessoa;
//import biblioteca.models.pessoasPackage.Pessoa.Perfil;

public class main {
    public static void main(String[] args) {
        // Suponhamos que você tenha os seguintes dados para criar um professor:
        String nome = "Professor Exemplo";
        LocalDate data = LocalDate.of(2023, 9, 12); // Data de Registro
        int id = 1; // Número de Identificação
        String contato = "professor@example.com";
        int idade = 40;
        String endereco = "Endereço do Professor";
        Pessoa.Perfil perfil = Pessoa.Perfil.PROFESSOR;
        String instituto = "Instituto do Professor";

        Professor professor = new Professor(nome, data, id, contato, idade, endereco, perfil, instituto);



    }
}
