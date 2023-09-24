package main;

import java.net.URL;
import biblioteca.controllers.*;
//import biblioteca.models.*;
import biblioteca.models.multimidiaPackage.*;
import biblioteca.models.pessoasPackage.*;
import biblioteca.models.pessoasPackage.Pessoa.Perfil;
import biblioteca.models.comentariosPackage.*;
import biblioteca.models.equipamentosPackage.*;
import biblioteca.models.equipamentosPackage.Equipamentos.AudioVisual;
import biblioteca.models.emprestimoPackage.*;
import biblioteca.models.eventosPackage.*;
import biblioteca.models.recursosMultimidiaPackage.*;
import biblioteca.models.relatorioPackage.*;
import biblioteca.models.renovacaoReservaPackage.*;
import biblioteca.models.reservaSalaPackage.*;
import biblioteca.views.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.Duration;
import java.net.MalformedURLException;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Scanner;

public class BibliotecaMain {
    private static BibliotecaController bibliotecaController;
    private static MembroController membroController;
    private static RelatorioController relatorioController;

    public static void main(String[] args) {
        bibliotecaController = new BibliotecaControllerImpl();
        membroController = new MembroControllerImpl();
        relatorioController = new RelatorioControllerImpl();

        BibliotecaView bibliotecaView = new BibliotecaViewImpl(bibliotecaController);
        MembroView membroView = new MembroViewImpl(membroController);
        RelatorioView relatorioView = new RelatorioViewImpl(relatorioController);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---- Menu Biblioteca ----");
            System.out.println();
            System.out.println("1. Gerenciamento de Itens"); // MA
            System.out.println("2. Gerenciamento de Membros"); // FER
            System.out.println("3. Geração de Relatórios e Estatísticas");
            System.out.println("4. Administração de Funcionários");
            System.out.println("5. Sair");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Menu de Gerenciamento de Itens
                    menuGerenciamentoItens(scanner, bibliotecaView);
                    break;
                case 2:
                    // Menu de Gerenciamento de Membros
                    menuGerenciamentoMembros(scanner, membroView);
                    break;
                case 3:
                    // Menu de Geração de Relatórios e Estatísticas
                    // menuRelatoriosEstatisticas(scanner, relatorioView);
                    break;
                case 4:
                    // Menu de Administração de Funcionários
                    menuAdministracaoFuncionarios(scanner);
                    break;
                case 5:
                    System.out.println("Saindo do menu. Até logo!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    // maisa
    private static void menuGerenciamentoItens(Scanner scanner, BibliotecaView bibliotecaView) {
        while (true) {
            System.out.println("---- Menu Gerenciamento de Itens ----");
            System.out.println();
            System.out.println("1. Listar Itens Disponíveis");
            System.out.println("2. Adicionar Item"); // adicionar uma mulimidia ao acervo
            System.out.println("3. Editar Item");// editar objeto do tipo multimidia
            System.out.println("4. Remover Item"); // remover multimidia do acervo
            System.out.println("5. Empréstimo de Itens"); // ok
            System.out.println("6. Renovação de Empréstimos");// ok
            System.out.println("7. Reservas de Itens"); // ok
            System.out.println("8. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoItens = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoItens) {
                case 1:
                    List<Multimidia> itens = bibliotecaController.consultarItensDisponiveis();// ok
                    bibliotecaView.mostrarItensDisponiveis(itens);// ok
                    break;
                case 2:
                    adicionarItem(scanner);
                    break;
                case 3:
                    editarItem(scanner);
                    break;
                case 4:
                    removerItem(scanner);
                    break;
                case 5:
                    realizarEmprestimo(scanner);
                    break;
                case 6:
                    realizarRenovacao(scanner);
                    break;
                case 7:
                    fazerReserva(scanner);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    // fernanda
    private static void menuGerenciamentoMembros(Scanner scanner, MembroView membroView) {
        while (true) {
            System.out.println("---- Menu Gerenciamento de Membros ----");
            System.out.println();
            System.out.println("1. Listar Membros");
            System.out.println("2. Adicionar Membro");
            System.out.println("3. Editar Membro");
            System.out.println("4. Remover Membro");
            System.out.println("5. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoMembros = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoMembros) {
                case 1:
                    List<Pessoa> membros = membroController.listarMembros();
                    membroView.mostrarListaMembros(membros);
                    break;
                case 2:
                    adicionarMembro(scanner);
                    break;
                case 3:
                    editarMembro(scanner);
                    break;
                case 4:
                    removerMembro(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuRelatoriosEstatisticas(Scanner scanner, RelatorioView relatorioView) {
        while (true) {
            System.out.println("---- Menu Relatórios e Estatísticas ----");
            System.out.println();
            System.out.println("1. Gerar Relatório de Atividades de Membros");
            System.out.println("2. Gerar Relatório de Uso de Itens Multimídia");
            System.out.println("3. Gerar Relatório de Multas e Pagamentos");
            System.out.println("4. Gerar Relatório de Disponibilidade de Itens");
            System.out.println("5. Gerar Estatísticas de Uso por Perfil de Membro");
            System.out.println("6. Gerar Relatório de Itens Mais Populares");
            System.out.println("7. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoRelatorios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoRelatorios) {
                case 1:
                    gerarRelatorioAtividadesMembros();
                    break;
                case 2:
                    gerarRelatorioUsoItens();
                    break;
                case 3:
                    gerarRelatorioMultas();
                    break;
                case 4:
                    gerarRelatorioDisponibilidadeItens();
                    break;
                case 5:
                    gerarEstatisticasUsoPorPerfil();
                    break;
                case 6:
                    gerarRelatorioItensPopulares();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuAdministracaoFuncionarios(Scanner scanner) {
        while (true) {
            System.out.println("---- Menu Administração de Funcionários ----");
            System.out.println();
            System.out.println("1. Administradores");
            System.out.println("2. Atendentes");
            System.out.println("3. Gerentes");
            System.out.println("4. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoFuncionarios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoFuncionarios) {
                case 1:
                    // Menu de Administração de Administradores
                    menuAdministradores(scanner);
                    break;
                case 2:
                    // Menu de Administração de Atendentes
                    menuAtendentes(scanner);
                    break;
                case 3:
                    // Menu de Administração de Gerentes
                    menuGerentes(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuAdministradores(Scanner scanner) {
        // Lógica para administração de administradores
    }

    private static void menuAtendentes(Scanner scanner) {
        // Lógica para administração de atendentes
    }

    private static void menuGerentes(Scanner scanner) {
        // Lógica para administração de gerentes
    }

    // Métodos para realizar empréstimo, renovação e reserva

    private static void realizarEmprestimo(Scanner scanner) {
        // Lógica para realizar um empréstimo
        System.out.println("Operação de Empréstimo de Itens, insira o ID do usuário:");
        int iduser = scanner.nextInt();

        System.out.println("Insira o ID do item:");
        int iditem = scanner.nextInt();

        bibliotecaController.emprestarItem(membroController.buscarMembroPorIdentificacao(iduser),
                bibliotecaController.retornaritem(iditem));

    }

    private static void realizarRenovacao(Scanner scanner) {
        // Lógica para realizar uma renovação de empréstimo
        System.out.println("Operação de Renovação de Empréstimos, insira o ID do usuário:");
        int iduser = scanner.nextInt();

        System.out.println("Insira o ID da reserva:");
        int idreserva = scanner.nextInt();

        bibliotecaController.renovaremprestimo(membroController.buscarMembroPorIdentificacao(iduser),
                bibliotecaController.retornaremprestimo(idreserva));
    }

    // Lógica para fazer uma reserva de item
    private static void fazerReserva(Scanner scanner) {
        // Definição de qual item será reservado
        System.out.println(
                "Selecione o tipo de item: (1 - Item acervo Biblioteca, 2 - Equipamento, 3 - Reserva de Sala)");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Operação de Reserva de Itens, insira o ID do usuário:");
                int iduser = scanner.nextInt();

                System.out.println("Insira o ID do item:");
                int iditem = scanner.nextInt();

                bibliotecaController.reservaritem(membroController.buscarMembroPorIdentificacao(iduser),
                        bibliotecaController.retornaritem(iditem));

            case 2:
                /*
                 * logica para reservar o equipamento ainda precisa ser implementada, mas após
                 * as condicionais de reserva ele deve ser adicionado a lista de reserva
                 * generica
                 */
                /*
                 * Instanciando um objeto referencia de equipamento APENAS para demonstrar a
                 * utilização da classe generica, no futuro será mudado
                 */
                Equipamentos novEquipamento = new Equipamentos(1, 1234567, "AudioVisual", "Lenovo", "Microfone 5665",
                        "Novo");
                bibliotecaController.reservarEquipamento(novEquipamento);

            case 3:
                /*
                 * logica para reservar uma sala ainda precisa ser implementada, mas após as
                 * condicionais de reserva ele deve ser adicionado a lista de reserva generica
                 */
                /*
                 * Instanciando um objeto referencia de equipamento APENAS para demonstrar a
                 * utilização da classe generica, no futuro será mudado
                 */
                ReservaSala sala = new ReservaSala(1, LocalDate.now(), LocalTime.now(), 5);
                bibliotecaController.reservarSala(sala);
        }
    }

    // Métodos para adicionar, editar e remover itens e membros

    private static void adicionarItem(Scanner scanner) {
        // Lógica para adicionar um novo item
        System.out.println("Operação de Adição de Item");
        System.out.println("Por favor, insira as informações do novo item:");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Editora: ");
        String editora = scanner.nextLine();

        System.out.print("Ano de Publicação: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Sinopse: ");
        String sinopse = scanner.nextLine();

        System.out.print("Capa: ");
        String capa = scanner.nextLine();

        System.out.print("Disponibilidade (true/false): ");
        boolean disponibilidade = scanner.nextBoolean();

        System.out.print("Número de cópias: ");
        int copias = scanner.nextInt();

        System.out.print("Número de cópias dispiníveis: ");
        int copiasdisp = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Categoria(somente letras maiúsculas): ");
        String categoriauser = scanner.nextLine();
        Multimidia.Categoria categoriaselecionada = null;

        for (Multimidia.Categoria categoria : Multimidia.Categoria.values()) {
            if (categoria.name().equals(categoriauser)) {
                categoriaselecionada = categoria;
                break;
            }
        }

        System.out.print("Tipo de item (1 - Livro Fisico, 2 - Livro Eletrônico, 3 - CD, 4 - DVD, 5 - Outro): ");
        int tipo = scanner.nextInt();

        Multimidia novoItem = null;

        switch (tipo) {
            case 1:

                System.out.print("ISBN: ");
                long isbn = scanner.nextLong();

                System.out.print("Edição: ");
                int edicao = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Local: ");
                String local = scanner.nextLine();

                System.out.print("Estado de Conservação: ");
                String estado = scanner.nextLine();

                novoItem = new LivroFisico(titulo, autor, editora, ano, sinopse, capa, disponibilidade, copias,
                        copiasdisp, isbn, edicao, local, estado, categoriaselecionada);

                break;
            case 2:
                System.out.print("Data de disponibilidade:(formato: ano-mês-dia) ");
                String dataString = scanner.nextLine();
                LocalDate data = LocalDate.parse(dataString);

                System.out.print("URL: ");
                String stringurl = scanner.nextLine();
                try {
                    URL url = new URL(stringurl);
                    System.out.print("Formato: ");
                    String formato = scanner.nextLine();

                    System.out.print("Requisitos de Leitura: ");
                    String requisitos = scanner.nextLine();

                    novoItem = new LivroEletronico(titulo, autor, editora, ano, sinopse, capa, disponibilidade, copias,
                            copiasdisp, formato, url, requisitos, data, categoriaselecionada);

                } catch (MalformedURLException e) {

                    System.err.println("A URL fornecida é inválida.");
                    e.printStackTrace();
                }

                break;
            case 3:
                System.out
                        .print("Duração:(formato: PT10H30M ='10h e 30 min', inserindo a quantidade de tempo correta) ");
                String input = scanner.nextLine();
                Duration duration = Duration.parse(input);

                System.out.print("Lista de faixas: ");
                String faixas = scanner.nextLine();

                System.out.print("Estado de Conservação: ");
                String estadocon = scanner.nextLine();

                novoItem = new CD_Audio(titulo, autor, editora, ano, sinopse, capa, disponibilidade, copias, copiasdisp,
                        faixas, duration, estadocon, categoriaselecionada);
                break;
            case 4:
                System.out
                        .print("Duração:(formato: PT10H30M ='10h e 30 min', inserindo a quantidade de tempo correta) ");
                String durationinput = scanner.nextLine();
                Duration durationdvd = Duration.parse(durationinput);

                System.out.print("Estado de Conservação: ");
                String estadocons = scanner.nextLine();

                System.out.print("Elenco: ");
                String elenco = scanner.nextLine();

                System.out.print("Legendas: ");
                String legenda = scanner.nextLine();

                novoItem = new DVD_Video(titulo, autor, editora, ano, sinopse, capa, disponibilidade, copias,
                        copiasdisp, elenco, durationdvd, legenda, estadocons, categoriaselecionada);
                break;
            case 5:
                System.out.print("Local: ");
                String localoutro = scanner.nextLine();

                System.out.print("Formato: ");
                String formatooutro = scanner.nextLine();

                System.out.print("Tipo: ");
                String tipoitem = scanner.nextLine();

                System.out.print("Estado de Conservação: ");
                String estadoc = scanner.nextLine();

                novoItem = new Outros(titulo, autor, editora, ano, sinopse, capa, disponibilidade, copias, copiasdisp,
                        tipoitem, formatooutro, localoutro, estadoc, categoriaselecionada);
                break;
            default:
                System.out.println("Tipo de item inválido. Nenhum item adicionado.");
                return;
        }

        bibliotecaController.addItemDisponivel(novoItem);
        System.out.println("Novo item adicionado com sucesso!");
    }

    private static void editarItem(Scanner scanner) {
        // Lógica para editar um item existente
        System.out.println("Operação de Edição de Item, por favor,  insira o ID do item.");
        int id = scanner.nextInt();

        System.out.println("Selecione o que deseja editar:");
        System.out.println(
                "1- título, 2- autor, 3- editora, 4- ano de publicação, 5- sinopse, 6- capa, 7- disponibilidade, 8- numero de cópias, 9 - numero de cópias disponíveis, 10 - categoria, 11- outro");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Insira o novo título.");
                String titulo = scanner.nextLine();
                bibliotecaController.retornaritem(id).settitulo(titulo);
                break;
            case 2:
                System.out.println("Insira o novo autor.");
                String autor = scanner.nextLine();
                bibliotecaController.retornaritem(id).setautor(autor);
                break;
            case 3:
                System.out.println("Insira a nova editora.");
                String editora = scanner.nextLine();
                bibliotecaController.retornaritem(id).seteditora(editora);
                break;
            case 4:
                System.out.println("Insira o novo ano de publicação.");
                int ano = scanner.nextInt();
                bibliotecaController.retornaritem(id).setanoPublicacao(ano);
                break;
            case 5:
                System.out.println("Insira a nova sinopse.");
                String sinopse = scanner.nextLine();
                bibliotecaController.retornaritem(id).setsinopse(sinopse);
                break;
            case 6:
                System.out.println("Insira a nova capa.");
                String capa = scanner.nextLine();
                bibliotecaController.retornaritem(id).setcapa(capa);
                break;
            case 7:
                System.out.println("Insira a nova disponibilidade.(formato:disponível/indisponível");
                String disp = scanner.nextLine();
                if (disp.equalsIgnoreCase("disponível")) {
                    bibliotecaController.retornaritem(id).setdisponibilidade(true);
                } else if (disp.equalsIgnoreCase("indisponível")) {
                    bibliotecaController.retornaritem(id).setdisponibilidade(false);
                } else {
                    System.out.println("Entrada inválida. Por favor, digite 'disponível' ou 'indisponível'.");
                }
                break;
            case 8:
                System.out.println("Insira o novo número de cópias.");
                int numcopias = scanner.nextInt();
                bibliotecaController.retornaritem(id).setnumCopias(numcopias);
                break;
            case 9:
                System.out.println("Insira o novo número de cópias disponíveis.");
                int numcopiasdisp = scanner.nextInt();
                bibliotecaController.retornaritem(id).setnumCopiasDisponiveis(numcopiasdisp);
                break;
            case 10:
                System.out.println("Insira a nova categoria(somente letras maiúsculas). ");
                String categoriauser = scanner.nextLine();
                Multimidia.Categoria categoriaselecionada = null;
                ;

                for (Multimidia.Categoria categoria : Multimidia.Categoria.values()) {
                    if (categoria.name().equals(categoriauser)) {
                        categoriaselecionada = categoria;
                        bibliotecaController.retornaritem(id).setcategoria(categoriaselecionada);
                        break;
                    }
                }
                if (categoriaselecionada == null) {
                    System.out
                            .println("Categoria não encontrada. Insira a nova categoria(somente letras maiúsculas). ");
                }

                break;
            case 11:
                if (bibliotecaController.retornaritem(id) instanceof LivroFisico) {
                    System.out.println("Este item é um Livro Físico. Selecione o que deseja editar:");
                    System.out.println("1- ISBN, 2- Edição, 3- Local, 4- Estado de conservação");
                    int opcao1 = scanner.nextInt();
                    switch (opcao1) {
                        case 1:
                            System.out.println("Insira o novo ISBN.");
                            int isbn = scanner.nextInt();
                            ((LivroFisico) bibliotecaController.retornaritem(id)).setisbn(isbn);
                            break;
                        case 2:
                            System.out.println("Insira a nova Edição.");
                            int edicao = scanner.nextInt();
                            ((LivroFisico) bibliotecaController.retornaritem(id)).setedicao(edicao);
                            break;
                        case 3:
                            System.out.println("Insira o novo local.");
                            String local = scanner.nextLine();
                            ((LivroFisico) bibliotecaController.retornaritem(id)).setlocal(local);
                            break;
                        case 4:
                            System.out.println("Insira o estado de conservação.");
                            String estado = scanner.nextLine();
                            ((LivroFisico) bibliotecaController.retornaritem(id)).setestadoConservacao(estado);
                            break;
                        default:
                            System.out.println("Opção inválida, item não editado");
                            return;
                    }

                } else if (bibliotecaController.retornaritem(id) instanceof LivroEletronico) {
                    System.out.println("Este item é um Livro Eletrônico. Selecione o que deseja editar:");
                    System.out.println("1- URL, 2- Formato, 3- Requisitos de leituta, 4 - Data de disponibilidade:");
                    int opcao2 = scanner.nextInt();
                    switch (opcao2) {
                        case 1:
                            System.out.println("Insira a nova URL.");
                            String stringurl = scanner.nextLine();
                            try {
                                URL url = new URL(stringurl);
                                ((LivroEletronico) bibliotecaController.retornaritem(id)).setUrl(url);

                            } catch (MalformedURLException e) {

                                System.err.println("A URL fornecida é inválida.");
                                e.printStackTrace();
                            }
                            break;
                        case 2:
                            System.out.println("Insira o novo formato.");
                            String formato = scanner.nextLine();
                            ((LivroEletronico) bibliotecaController.retornaritem(id)).setformato(formato);
                            break;
                        case 3:
                            System.out.println("Insira os novos requisitos de leitura.");
                            String requisitos = scanner.nextLine();
                            ((LivroEletronico) bibliotecaController.retornaritem(id)).setrequisitosLeitura(requisitos);
                            break;
                        case 4:
                            System.out.println("Insira a nova data de disponibilidade (Formato: ano-mês-dia).");
                            String dataString = scanner.nextLine();
                            LocalDate data = LocalDate.parse(dataString);
                            ((LivroEletronico) bibliotecaController.retornaritem(id)).setDataDisponibilidade(data);
                            break;
                        default:
                            System.out.println("Opção inválida, item não editado");
                            return;
                    }
                } else if (bibliotecaController.retornaritem(id) instanceof CD_Audio) {
                    System.out.println("Este item é um CD. Selecione o que deseja editar");
                    System.out.println("1- Lista de faixas, 2- Duração, 3- Estado de conservação");
                    int opcao1 = scanner.nextInt();
                    switch (opcao1) {
                        case 1:
                            System.out.println("Insira a nova lista de faixas.");
                            String lista = scanner.nextLine();
                            ((CD_Audio) bibliotecaController.retornaritem(id)).setlistaFaixas(lista);
                            break;
                        case 2:
                            System.out.println(
                                    "Insira a nova duração.(formato: PT10H30M ='10h e 30 min', inserindo a quantidade de tempo correta) ");
                            String durationinput = scanner.nextLine();
                            Duration durationcd = Duration.parse(durationinput);
                            ((CD_Audio) bibliotecaController.retornaritem(id)).setDuracao(durationcd);
                            break;
                        case 3:
                            System.out.println("Insira o novo estado de conservação.");
                            String estadoc = scanner.nextLine();
                            ((CD_Audio) bibliotecaController.retornaritem(id)).setestadoConservacao(estadoc);
                            break;
                        default:
                            System.out.println("Opção inválida, item não editado");
                            return;
                    }
                } else if (bibliotecaController.retornaritem(id) instanceof DVD_Video) {
                    System.out.println("Este item é um DVD. Selecione o que deseja editar");
                    System.out.println("1- Elenco, 2- Duração, 3- Legendas, 4- Estado de conservação");
                    int opcao1 = scanner.nextInt();
                    switch (opcao1) {
                        case 1:
                            System.out.println("Insira o novo elenco.");
                            String elenco = scanner.nextLine();
                            ((DVD_Video) bibliotecaController.retornaritem(id)).setelenco(elenco);
                            break;
                        case 2:
                            System.out.println(
                                    "Insira a nova Duracao(formato: PT10H30M ='10h e 30 min', inserindo a quantidade de tempo correta) .");
                            String duration = scanner.nextLine();
                            Duration durationdvd = Duration.parse(duration);
                            ((DVD_Video) bibliotecaController.retornaritem(id)).setDuracao(durationdvd);
                            ;
                            break;
                        case 3:
                            System.out.println("Insira as novas opções de legenda.");
                            String legenda = scanner.nextLine();
                            ((DVD_Video) bibliotecaController.retornaritem(id)).setlegendasAudio(legenda);
                            break;
                        case 4:
                            System.out.println("Insira o novo estado de conservação.");
                            String estadocon = scanner.nextLine();
                            ((DVD_Video) bibliotecaController.retornaritem(id)).setestadoConservacao(estadocon);
                            break;
                        default:
                            System.out.println("Opção inválida, item não editado");
                            return;
                    }
                } else if (bibliotecaController.retornaritem(id) instanceof Outros) {
                    System.out
                            .println("Este item não se encaixa nas opções anteriores. Selecione o que deseja editar: ");
                    System.out.println("1- Tipo, 2- Formato, 3- Local, 4- Estado de Conservação");
                    int opcao1 = scanner.nextInt();
                    switch (opcao1) {
                        case 1:
                            System.out.println("Insira o novo tipo.");
                            String tipo = scanner.nextLine();
                            ((Outros) bibliotecaController.retornaritem(id)).settipo(tipo);
                            break;
                        case 2:
                            System.out.println("Insira o novo formato.");
                            String formatooutro = scanner.nextLine();
                            ((Outros) bibliotecaController.retornaritem(id)).setformato(formatooutro);
                            break;
                        case 3:
                            System.out.println("Insira o novo local.");
                            String localoutro = scanner.nextLine();
                            ((Outros) bibliotecaController.retornaritem(id)).setlocal(localoutro);
                            break;
                        case 4:
                            System.out.println("Insira o estado de conservação.");
                            String estadooutro = scanner.nextLine();
                            ((Outros) bibliotecaController.retornaritem(id)).setestadoConservacao(estadooutro);
                            break;
                        default:
                            System.out.println("Opção inválida, item não editado");
                            return;
                    }
                } else {
                    System.out.println("Erro, verifique se o múmero do id está correto.");
                }
                break;
            default:
                System.out.println("Opção inválida, nenhum item editado");
                return;

        }

    }

    private static void removerItem(Scanner scanner) {
        // Lógica para remover um item
        System.out.println("Operação de remoção de Item, por favor,  insira o ID do item.");
        int id = scanner.nextInt();

        bibliotecaController.removerItemDispoinvel(id);
        System.out.println("Novo item removido com sucesso!");

    }

    private static void adicionarMembro(Scanner scanner) {
        // Lógica para adicionar um novo membro
        System.out.println("\n");
        System.out.println("Selecione o tipo de membro: ");
        System.out.println("1 - Aluno de Graduação");
        System.out.println("2 - Aluno de Pós Graduação");
        System.out.println("3 - Funcionario da Biblioteca");
        System.out.println("4 - Professor");

        System.out.print("\nEscolha uma opção: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        switch (id) {
            case 1:
                /* nome do aluno */
                System.out.print("Nome do aluno: ");
                String nome = scanner.nextLine();

                /* contato do aluno */
                System.out.print("Contato do aluno (e-mail): ");
                String contato = scanner.nextLine();

                /* idade do aluno */
                System.out.print("Idade do aluno: ");
                int idade = scanner.nextInt();
                scanner.nextLine();

                /* endereço do aluno */
                System.out.print("Endereço do aluno: ");
                String endereco = scanner.nextLine();

                /* adicionando o perfil */
                Perfil perfil = Perfil.ESTUDANTE_GRADUACAO;

                /* RA do aluno */
                System.out.print("RA do aluno: ");
                int ra = scanner.nextInt();
                scanner.nextLine();

                /* curso do aluno */
                System.out.print("Curso do aluno: ");
                String curso = scanner.nextLine();

                AlunoGraduacao novoMembro = new AlunoGraduacao(nome, LocalDate.now(), contato, idade, endereco, perfil,
                        ra, curso);
                membroController.addMembro(novoMembro);
                break;

            case 2:

                /* nome do aluno */
                System.out.print("Nome do aluno: ");
                String nomeAlunoPos = scanner.nextLine();

                /* contato do aluno */
                System.out.print("Contato do aluno (e-mail): ");
                String contatoAlunoPos = scanner.nextLine();

                /* idade do aluno */
                System.out.print("Idade do aluno: ");
                int idadeAlunoPos = scanner.nextInt();
                scanner.nextLine();

                /* endereço do aluno */
                System.out.print("Endereço do aluno: ");
                String enderecoAlunoPos = scanner.nextLine();

                /* adicionando o perfil */
                Perfil perfilAlunoPos = Perfil.ESTUDANTE_POS_GRADUACAO;

                /* RA do aluno */
                System.out.print("RA do aluno: ");
                int raAlunoPos = scanner.nextInt();
                scanner.nextLine();

                /* curso do aluno */
                System.out.print("Curso do aluno: ");
                String cursoAlunoPos = scanner.nextLine();

                AlunoPosGraduacao novoMembroAlunoPos = new AlunoPosGraduacao(nomeAlunoPos, LocalDate.now(),
                        contatoAlunoPos, idadeAlunoPos, enderecoAlunoPos, perfilAlunoPos,
                        raAlunoPos, cursoAlunoPos);
                membroController.addMembro(novoMembroAlunoPos);
                break;

            case 3:
                /* nome do funcionario */
                System.out.print("Nome do funcionario: ");
                String nomeFuncionario = scanner.nextLine();

                /* contato do funcionario */
                System.out.print("Contato do funcionario (e-mail): ");
                String contatoFuncionario = scanner.nextLine();

                /* idade do funcionario */
                System.out.print("Idade do funcionario: ");
                int idadeFuncionario = scanner.nextInt();
                scanner.nextLine();

                /* endereço do funcionario */
                System.out.print("Endereço do funcionario: ");
                String enderecoFuncionario = scanner.nextLine();

                /* adicionando o perfil */
                Perfil perfilFuncionario = Perfil.FUNCIONARIO;

                /* cargo do funcionario */
                System.out.print("Cargo do funcionario: ");
                String cargoFuncionario = scanner.nextLine();

                /* salario do funcionario */
                System.out.print("Salario do funcionario: ");
                float salarioFuncionario = scanner.nextFloat();
                scanner.nextLine();

                /* horario do funcionario */
                System.out.print("Horário do funcionario: ");
                String horarioFuncionario = scanner.nextLine();

                /* acesso do funcionario */
                System.out.print("Acesso do funcionario: ");
                String acessoFuncionario = scanner.nextLine();

                FuncionarioBiblioteca novoFuncionario = new FuncionarioBiblioteca(nomeFuncionario, LocalDate.now(),
                        contatoFuncionario, idadeFuncionario, enderecoFuncionario, perfilFuncionario,
                        cargoFuncionario, salarioFuncionario, horarioFuncionario, acessoFuncionario);
                membroController.addMembro(novoFuncionario);
                break;

            case 4:
                /* nome do professor */
                System.out.print("Nome do professor: ");
                String nomeProfessor = scanner.nextLine();

                /* contato do funcionario */
                System.out.print("Contato do professor (e-mail): ");
                String contatoProfessor = scanner.nextLine();

                /* idade do funcionario */
                System.out.print("Idade do professor: ");
                int idadeProfessor = scanner.nextInt();
                scanner.nextLine();

                /* endereço do funcionario */
                System.out.print("Endereço do professor: ");
                String enderecoProfessor = scanner.nextLine();

                /* adicionando o perfil */
                Perfil perfilProfessor = Perfil.PROFESSOR;

                /* endereço do funcionario */
                System.out.print("Instituto do professor: ");
                String institutoProfessor = scanner.nextLine();

                Professor novoProfessor = new Professor(nomeProfessor, LocalDate.now(),
                        contatoProfessor, idadeProfessor, enderecoProfessor, perfilProfessor,
                        institutoProfessor);
                membroController.addMembro(novoProfessor);
                break;
        }

    }

    private static void editarMembro(Scanner scanner) {
        // Lógica para editar um membro existente
        System.out.println("Operação de Edição de Membro");
    }

    private static void removerMembro(Scanner scanner) {
        // Lógica para remover um membro
        System.out.println("Operação de Remoção de Membro");
    }

    // Métodos para gerar relatórios e estatísticas
    private static void gerarRelatorioAtividadesMembros() {
        // Lógica para gerar o Relatório de Atividades de Membros
        System.out.println("Gerando Relatório de Atividades de Membros");
    }

    private static void gerarRelatorioUsoItens() {
        // Lógica para gerar o Relatório de Uso de Itens Multimídia
        System.out.println("Gerando Relatório de Uso de Itens Multimídia");
    }

    private static void gerarRelatorioMultas() {
        // Lógica para gerar o Relatório de Multas e Pagamentos
        System.out.println("Gerando Relatório de Multas e Pagamentos");
    }

    private static void gerarRelatorioDisponibilidadeItens() {
        // Lógica para gerar o Relatório de Disponibilidade de Itens
        System.out.println("Gerando Relatório de Disponibilidade de Itens");
    }

    private static void gerarEstatisticasUsoPorPerfil() {
        // Lógica para gerar as Estatísticas de Uso por Perfil de Membro
        System.out.println("Gerando Estatísticas de Uso por Perfil de Membro");
    }

    private static void gerarRelatorioItensPopulares() {
        // Lógica para gerar o Relatório de Itens Mais Populares
        System.out.println("Gerando Relatório de Itens Mais Populares");
    }
}
