package biblioteca.models.renovacaoReservaPackage;

import java.time.LocalDate;

import biblioteca.models.pessoasPackage.Pessoa;
import biblioteca.models.pessoasPackage.AlunoGraduacao;
import biblioteca.models.pessoasPackage.AlunoPosGraduacao;
import biblioteca.models.pessoasPackage.Professor;
import biblioteca.models.pessoasPackage.FuncionarioBiblioteca;
import biblioteca.models.emprestimoPackage.Emprestimo;
//import multimidiaPackage.Multimidia;;
import biblioteca.models.multimidiaPackage.Multimidia;

public class Renovacao { // classe dedicada a renovações e reservas inteligentes
    private boolean tipo; // true - renovação, false- reserva
    private static int proximoregistro = 1; // usado para fazer a atualização automática de registro
    private int registro; // registro de identificação renovação ou reserva
    private Pessoa pessoa; // pessoa que está fazendo a renovação ou reserva

    /* construtor dedicado apenas às renovações*/
    public Renovacao(boolean tipo, Pessoa pessoa) {
        this.pessoa = pessoa;
        this.tipo = tipo;
        this.registro = proximoregistro++;
    }

    /* getters para os atributos privados */
    public Pessoa getpessoa() {
        return pessoa;
    }

    public boolean gettipo() {
        return tipo;
    }

    public int getregistro() {
        return registro;
    }

    /*
     * a classe não tem setters pois os atributos não podem ser mudados
     */

    // renovação
    public void renovar(Emprestimo emprestimo) {
        LocalDate dataHoje = LocalDate.now();
        LocalDate prazo = emprestimo.getdataDevolucao();
        if (pessoa instanceof AlunoGraduacao) {
            if (prazo.isBefore(dataHoje)) {
                System.out.println("O usuário " + pessoa.getnome()
                        + " não pode renovar o empréstimo, pois o mesmo está em atraso.");
            } else {
                prazo = prazo.plusDays(15);
                System.out
                        .println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo aumentado em 5 dias.");
            }
        } else if (pessoa instanceof AlunoPosGraduacao) {
            if (prazo.isBefore(dataHoje)) {
                System.out.println("O usuário " + pessoa.getnome()
                        + " não pode renovar o empréstimo, pois o mesmo está em atraso.");
            } else {
                prazo = prazo.plusDays(20);
                System.out
                        .println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo aumentado em 5 dias.");
            }
        } else if (pessoa instanceof Professor) {
            if (prazo.isBefore(dataHoje)) {
                System.out.println("O usuário " + pessoa.getnome()
                        + " não pode renovar o empréstimo, pois o mesmo está em atraso.");
            } else {
                prazo = prazo.plusDays(30);
                System.out
                        .println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo aumentado em 5 dias.");
            }
        } else if (pessoa instanceof FuncionarioBiblioteca) {
            if (prazo.isBefore(dataHoje)) {
                System.out.println("O usuário " + pessoa.getnome()
                        + " não pode renovar o empréstimo, pois o mesmo está em atraso.");
            } else {
                prazo = prazo.plusDays(30);
                System.out
                        .println("O usuário " + pessoa.getnome() + " teve o prazo do empréstimo aumentado em 5 dias.");
            }
        } else {
            System.out.println(pessoa.getnome()
                    + " não é um membro da biblioteca, logo, não pode  fazer renovações, favor fazer cadastro");
        }
    }

    // reserva
    public void reservar(Multimidia item) {
        int copias = item.getnumCopiasDisponiveis();
            if (copias > 0) {
                System.out.println(
                        "Outras cópias do livro estão disponiveis para empréstimo, não é permitido reservar uma cópia em específico");
            } else {
                System.out.println("O livro está reservado para " + pessoa.getnome()
                        + ", o usuário será avisado quando o mesmo puder ser retirado");
            } 
    }

}
