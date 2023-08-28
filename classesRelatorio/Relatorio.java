/*pacote que contem apenas a classe de relatórios */

package classesRelatorio;

import java.time.LocalDate;
import classesObras.Multimidia;
import classesPessoas.Membro;
import classesFuncionarios.Funcionarios;
import classesRenovacaoReserva.Renovacao;
import classesEmprestimo.Emprestimo;

/*
 * classe dedicada apenas aos relatorios
 */

public class Relatorio {
    private Multimidia[] acervo; // todos os itens de emprestimo que a biblioteca possui
    private Membro[] membros; // todos os membros da biblioteca que podem fazer empréstimos
    private Funcionarios[] funcionarios; // todos os funcionarios da biblioteca
    private Emprestimo[] emprestimo; // todos os emprestimos feitos pela biblioteca
    private LocalDate data; // data de emissão do relatório
    private int numero; // numero do relatório
    private Renovacao[] renovacoes;// todas as renovações e reservas feitas

    /* construtor dedicado apenas relatório */
    public Relatorio(LocalDate data, int numero) {
        this.data = data;
        this.numero = numero;
        this.acervo = new Multimidia[10]; // Inicializa o vetor acervo com tamanho 10
        this.membros = new Membro[100]; // Inicializa o vetor Membro com tamanho 100
        this.funcionarios = new Funcionarios[100]; // Inicializa o vetor Funcionarios com tamanho 100
        this.renovacoes = new Renovacao[100]; // Inicializa o vetor Renovacao com tamanho 100
        this.emprestimo = new Emprestimo[100]; // Inicializa o vetor Emprestimo com tamanho 100

    }

    /* getters para os atributos privados */
    public LocalDate getdata() {
        return data;
    }

    public int getnumero() {
        return numero;
    }

    /* métodos para a emissão do relatótio */

    /* adicionando itens de emprestimo */
    public void addItem(Multimidia livro) {
        for (int i = 0; i < 10; i++) {
            if (acervo[i] == null) {
                acervo[i] = livro;
                return;
            }
        }
    }// supondo um acervo de 10 itens

    /* printando o acervo quando o relatório e consultado */
    public void qtdlivros() {
        int qtditens = 0;
        int qtddisponivel = 0;
        for (Multimidia acervos : acervo) {
            if (acervos != null) {
                qtditens = qtditens + acervos.copias;
                qtddisponivel = qtddisponivel + acervos.disponivel;
            }
        }
        System.out.println("Atualmente existem " + qtditens + " itens multimídia na biblioteca, dos quais "
                + qtddisponivel + " estão disponíveis para empréstimo.");
    }

    /* informações sobre os membros da biblioteca */
    public void addMembro(Membro pessoa) {
        for (int i = 0; i < 100; i++) {
            if (membros[i] == null) {
                membros[i] = pessoa;

                return;
            }
        }
    }// supondo um total de 100 membros

    /* imprimindo o total de membros da biblioteca */
    public void membro() {
        int qdtmembros = 0;
        for (Membro membro : membros) {
            if (membro != null) {
                qdtmembros++;
            }
        }
        System.out.println("Atualmente existem " + qdtmembros + " membros na biblioteca.");
    }

    /* adição de emprestimos */
    public void addEmprestimo(Emprestimo emprestado) {
        for (int i = 0; i < 100; i++) {
            if (emprestimo[i] == null) {
                emprestimo[i] = emprestado;

                return;
            }
        }
    }// supondo um total de 100 emprestimos

    // quantidade de empréstimos em atraso e total de multas devidas

    public void EmprestimosAtrasados() {
        int count = 0;
        float totalMultas = 0;
        int totalemprestimos = 0;
        LocalDate hoje = LocalDate.now();

        for (Emprestimo emprestimo : emprestimo) {
            LocalDate devolucao = emprestimo.getdevolucao();
            if (devolucao.isBefore(hoje)) {
                count++;
                totalMultas += emprestimo.getmulta();
            }
            if (emprestimo != null) {
                totalemprestimos++;
            }
        }
        String multaformatada = String.format("%.2f", totalMultas);
        System.out.println("Atualmente existem " + totalemprestimos + " empréstimos na biblioteca, dos quais " + count
                + " estão em atraso, totalizando R$" + multaformatada + " em multas.");
    }

    /* adicionando funcionarios */
    public void addFuncionario(Funcionarios pessoa) {
        for (int i = 0; i < 100; i++) {
            if (funcionarios[i] == null) {
                funcionarios[i] = pessoa;

                return;
            }
        }
    }// supondo um total de 100 funcionários

    /* imprimindo o total de funcionarios da bibliioteca */
    public void funcionarios() {
        int qtdfuncionarios = 0;
        for (Funcionarios funcionario : funcionarios) {
            if (funcionario != null) {
                qtdfuncionarios++;
            }
        }
        System.out.println("Atualmente existem " + qtdfuncionarios + " funcionarios na biblioteca.");
    }

    /* adição de reservas e renovações */
    public void addRenovacao(Renovacao novo) {
        for (int i = 0; i < 100; i++) {
            if (renovacoes[i] == null) {
                renovacoes[i] = novo;
                return;
            }
        }
    }// supondo um total de 100 reservas

    /* imprimindo o total de renovações e reservas */
    public void reservas() {
        int qtdreservas = 0;
        int qtdrenovacoes = 0;
        for (Renovacao renovacao : renovacoes) {
            if (renovacao.gettipo() == true) {
                qtdreservas++;
            } else if (renovacao.gettipo() == false) {
                qtdrenovacoes++;
            }
        }
        System.out.println("Até o presente dia foram feitas " + qtdreservas + " reservas e " + qtdrenovacoes
                + " renovações na biblioteca.");
    }
}
