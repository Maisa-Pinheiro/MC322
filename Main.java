// classe dedicada apenas aos livros
class Livro {
    
    //objetos
    String nome;// nome do livro
    String autor;// nome do autor
    int registro; // registro na base de dados da biblioteca
    String editora;
    int edicao;
    String categoria; //biografia, fantasia, infantil, etc
    
    // construtor dedicado apenas aos livros
    Livro(String nome, String autor, int registro, String editora, int edicao, String categoria) {
        this.nome = nome;
        this.autor = autor;
        this.registro = registro;
        this.editora = editora;
        this.edicao = edicao;
        this.categoria = categoria;
    }

    //imprimir informacoes
    void Informacoes() {
        System.out.println("Nome: " + nome + "\n");
        System.out.println("Autor: " + autor + "\n");
        System.out.println("Registro: " + registro + "\n");
        System.out.println("Editora: " + editora + "\n");
        System.out.println("Edicao: " + edicao + "\n");
        System.out.println("Categoria: " + categoria + "\n");
    }
}

// classe dedicada apenas aos usuarios
class Usuarios {
    
    //objetos
    String nome;
    int cpf;
    int registro;
    int emprestimo; //quantos livros o usuario tem emprestado
    
    // String[] nomes = new String[5];
    // nomes[0] = "Alice";
       
    String prazo; // prazo de devolucao
    int atraso; // o numero de atraso em dias
    int idade; // idade do usuario
    String endereco;
    
    
    // construtor dedicado apenas aos livros
    Usuarios(String nome, int cpf, int registro, int emprestimo, String prazo, int atraso, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.registro = registro;
        this.emprestimo = emprestimo;
        this.prazo = prazo;
        this.atraso = atraso;
        this.idade = idade;
        this.endereco = endereco;
        // this.livros_empres = livros_empres;
    }

    //imprimir informacoes
    void Informacoes() {
        System.out.println("Nome: " + nome + "\n");
        System.out.println("CPF: " + cpf + "\n");
        System.out.println("Registro: " + registro + "\n");
        System.out.println("Emprestimo: " + emprestimo + "\n");
        System.out.println("Prazo: " + prazo + "\n");
        System.out.println("Atraso: " + atraso + "\n");
        System.out.println("Idade: " + idade + "\n");
        System.out.println("Endereco: " + endereco + "\n");
        //System.out.println("Livros Emprestados: " + livros_empres + "\n");
    }
}

// classe dedicada apenas aos funcionarios
class Funcionarios {
    
    //objetos
    String nome;
    int cpf;
    int registro;
    String horario; // horário de entrada e de saída do funcionário
    String cargo; // cargo do Funcionarios
    int salario; 
    int idade; // idade do funcionario
    String endereco;
    
    
    // construtor dedicado apenas aos livros
    Funcionarios(String nome, int cpf, int registro, String horario, String cargo, int salario, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.registro = registro;
        this.horario = horario;
        this.cargo = cargo;
        this.salario = salario;
        this.idade = idade;
        this.endereco = endereco;
    }

    //imprimir informacoes
    void Informacoes() {
        System.out.println("Nome: " + nome + "\n");
        System.out.println("CPF: " + cpf + "\n");
        System.out.println("Registro: " + registro + "\n");
        System.out.println("Horario: " + horario + "\n");
        System.out.println("Cargo: " + cargo + "\n");
        System.out.println("Salario: " + salario + "\n");
        System.out.println("Idade: " + idade + "\n");
        System.out.println("Endereco: " + endereco + "\n");
    }
}

// classe dedicada apenas CDs e DVDs
class Cd {
    
    //objetos
    String tipo; // se é CD ou DVD
    int registro;
    String nome; // nome do CD ou DVD
    String autor; // "autor" do CD ou DVD
    int ano; 
    
    // construtor dedicado apenas aos CDs e DVDs
    Cd(String tipo, int registro, String nome, String autor, int ano) {
        this.tipo = tipo;
        this.registro = registro;
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
    }

    //imprimir informacoes
    void Informacoes() {
        System.out.println("Nome: " + nome + "\n");
        System.out.println("Tipo: " + tipo + "\n");
        System.out.println("Registro: " + registro + "\n");
        System.out.println("Autor: " + autor + "\n");
        System.out.println("Ano: " + ano + "\n");
    }
}


class Main {
    public static void main(String[] args) {
        
        Livro livro1 = new Livro("Harry Potter", "JK Rowling", 1234, "Rocco", 1,"fantasia"); 
        System.out.println("Informacoes do livro:\n");
        livro1.Informacoes();
        
        Usuarios pessoa = new Usuarios("Maria", 123456789, 3698, 5, "12/05/2024", 0, 25, "Rua Jose de Alencar, 123");
        System.out.println("Informacoes do usuario:\n");
        pessoa.Informacoes();

        Funcionarios trabalhador = new Funcionarios("Karl", 895456789, 7898, "7h30 às 17h15", "Bibliotecario", 2000, 27, "Avenida Marechal Rondon, 13");
        System.out.println("Informacoes do funcionario:\n");
        trabalhador.Informacoes();
        
        Cd dvd = new Cd("DVD", 5866, "Alice no Pais das Maravilhas", "Tim Burton", 2010);
        System.out.println("Informacoes do CD ou DVD:\n");
        dvd.Informacoes();


    }
}
