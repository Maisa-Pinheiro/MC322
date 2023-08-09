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
        System.out.println("Nome: " + nome );
        System.out.println("Autor: " + autor );
        System.out.println("Registro: " + registro );
        System.out.println("Editora: " + editora);
        System.out.println("Edicao: " + edicao );
        System.out.println("Categoria: " + categoria);
    }
}

// classe dedicada apenas aos usuarios
class Usuarios {
    
    //objetos
    String nome; // nome do usuario
    int cpf;
    int registro;// numero de registro do usuario na base de dados
    int emprestimo; //quantos livros o usuario tem emprestado
    
    // String[] livros_empres = new String[5]; (nomes dos livros emprestados, o maximo de empréstimos é 5)
    // nomes[0] = "Alice no País das Maravilhas" etc...
       
    String prazo; // prazo de devolucao dos livros emprestados
    int atraso; // o numero de atraso em dias
    int idade; // idade do usuario
    String endereco;
    
    
    // construtor dedicado apenas aos livros
    Usuarios(String nome, int cpf, int registro, int emprestimo, String prazo, int atraso, int idade, String endereco) { //colocar livros_empres
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
        System.out.println("Nome: " + nome );
        System.out.println("CPF: " + cpf );
        System.out.println("Registro: " + registro );
        System.out.println("Emprestimo: " + emprestimo );
        System.out.println("Prazo: " + prazo );
        System.out.println("Atraso: " + atraso );
        System.out.println("Idade: " + idade);
        System.out.println("Endereco: " + endereco );
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
    int salario; // salario do funcionario
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
        System.out.println("Nome: " + nome );
        System.out.println("CPF: " + cpf );
        System.out.println("Registro: " + registro );
        System.out.println("Horario: " + horario );
        System.out.println("Cargo: " + cargo);
        System.out.println("Salario: " + salario );
        System.out.println("Idade: " + idade );
        System.out.println("Endereco: " + endereco );
    }
}

// classe dedicada apenas CDs e DVDs
class Cd {
    
    //objetos
    String tipo; // se é CD ou DVD
    int registro;
    String nome; // nome do CD ou DVD
    String autor; // diretor do filme ou compositor/cantor/banda do cd
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
        System.out.println("Nome: " + nome );
        System.out.println("Tipo: " + tipo );
        System.out.println("Registro: " + registro );
        System.out.println("Autor: " + autor );
        System.out.println("Ano: " + ano );
    }
}


class Main {
    public static void main(String[] args) {
        
        Livro livro1 = new Livro("Harry Potter e a Ordem da Fênix", "JK Rowling", 1234, "Rocco", 1,"fantasia"); 
        System.out.println("Informacoes do livro:\n");
        livro1.Informacoes();
        System.out.println("\n");
        
        Livro livro2 = new Livro("Picos e vales", "Spencer Jhonson", 8654, "BS", 3,"autoajuda"); 
        System.out.println("Informacoes do livro:\n");
        livro2.Informacoes();
        System.out.println("\n");
        
        Livro livro3 = new Livro("Dom Quixote", "Miguel de Cervantes", 1255, "FDT", 2,"fantasia"); 
        System.out.println("Informacoes do livro:\n");
        livro3.Informacoes();
        System.out.println("\n");
        
        
        Usuarios pessoa = new Usuarios("Maria", 123456789, 3698, 5, "12/05/2024", 0, 25, "Rua Jose de Alencar, 123");
        System.out.println("Informacoes do usuario:\n");
        pessoa.Informacoes();
        System.out.println("\n");
        
        Usuarios pessoa2 = new Usuarios("João", 896556787, 6549, 0, "sem emprestimos", 0, 33, "Rua Rosa da Silva, 55");
        System.out.println("Informacoes do usuario:\n");
        pessoa2.Informacoes();
        System.out.println("\n");
        
        Usuarios pessoa3 = new Usuarios("Bernardo", 999584506, 7893, 2, "22/03/2024", 5, 18, "Av Pascal, 606");
        System.out.println("Informacoes do usuario:\n");
        pessoa3.Informacoes();
        System.out.println("\n");

        Funcionarios trabalhador = new Funcionarios("Karl", 895456789, 7898, "7h30 às 17h15", "Bibliotecario", 2000, 27, "Avenida Marechal Rondon, 13");
        System.out.println("Informacoes do funcionario:\n");
        trabalhador.Informacoes();
        System.out.println("\n");
        
        Cd dvd = new Cd("DVD", 5866, "Alice no Pais das Maravilhas", "Tim Burton", 2010);
        System.out.println("Informacoes do CD ou DVD:\n");
        dvd.Informacoes();
        System.out.println("\n");


    }
}
