package biblioteca.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import java.util.Set;

import biblioteca.models.multimidiaPackage.Multimidia;
import biblioteca.models.manutencaoPackage.Manutencao;
import biblioteca.models.CReflectionPackage.CReflection;
//import biblioteca.models.multimidiaPackage.DVD_Video;
//import biblioteca.models.multimidiaPackage.LivroEletronico;
//import biblioteca.models.multimidiaPackage.LivroFisico;
//import biblioteca.models.multimidiaPackage.Outros;
import biblioteca.models.emprestimoPackage.*;
import biblioteca.models.equipamentosPackage.Equipamentos;
import biblioteca.models.pessoasPackage.Pessoa;
import java.util.Scanner;
//import biblioteca.models.pessoasPackage.Professor;
//import biblioteca.models.pessoasPackage.AlunoGraduacao;
//import biblioteca.models.pessoasPackage.AlunoPosGraduacao;
//import biblioteca.models.pessoasPackage.FuncionarioBiblioteca;
//import biblioteca.views.BibliotecaView;

public interface BibliotecaController {
    List<Multimidia> consultarItensDisponiveis();

    void emprestarItem(Pessoa membro, Multimidia item)throws BloqueioMembroException;

    void reflectionatributos(Scanner scanner);

    void reflectionmetodos(Scanner scanner);

    void reservaritem(Pessoa membro, Multimidia item);

     void addmanutencao(Manutencao manutencao);

    void reservarEquipamento(Equipamentos equipamento);

    boolean salaReservada(int id, LocalDate data, LocalTime hora, int duracao);

    void reservarSala(int id, LocalDate data, LocalTime hora, int duracao, int pessoas, int capaciadade);

    void renovaremprestimo(Pessoa membro,Emprestimo emprestimo);

    void devolverItem(Pessoa membro, Multimidia item, boolean dano) throws BloqueioMembroException;

    void addItemDisponivel(Multimidia item);

    void addemprestimo(Emprestimo emprestimo);


    void liberacao(Pessoa pessoa);

    void removerItemDispoinvel(int id);

    void removeremprestimo(int id);

    Multimidia retornaritem(int id);

    Emprestimo retornaremprestimo(int id);
    
    Set<Multimidia.Categoria> getCategoriasUsadas();
}
