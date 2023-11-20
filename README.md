# MC322
Laboratórios da disciplina MC322 (Programação Orientada a Objetos) da Unicamp 2023s2

Dupla:

Maísa de Oliveira Pinheiro - RA: 244006
Fernanda Oliveira dos Santos - RA: 243385

# Detalhes sobre os 5 principios do SOLID utilizados nesse projeto

1) princípio da Responsabilidade Única (Single Responsibility Principle - SRP)

   A classe Multimídia foi modificada para atender o Princípio da Responsabilidade Única, isso foi feito através da exclusão de métodos que realizavam funções que não são responsabilidade dessa  classe, passando essas funções para as classes RelatorioControllerImpl e BibliotecaControllerImpl. Foram excluídos a lista e o map de itens, o gerenciamento do histórico de empréstimos, a busca de itens, e a lógica de empréstimo, que foram implementados dentro da funções emprestarItem, devolverItem e addemprestimo de BibliotecaControllerImpl e  nas funções addhistorico e gethistoricoEmprestimo de RelatorioControllerImpl

2) Princípio do Aberto/Fechado (Open/Closed Principle - OCP):

    O principio do aberto/fechado foi utilizado na classe de criação de relatórios afim de permitir que essa classe se torne aberta para extensões (adicionando novas estratégias) sem a necessidade de modificação direta de seu código-fonte original. Dessa forma, foi criada uma interface "EstratégiaRelatório" para definir métodos que todas as estratégias de relatório devem implementar. Posteriormente duas novas classes foram criadas "EmprestimosRelatorio" e "MultasRelatorio", cada uma representando uma estratégia especifica do relatório. Essa abordagem permite que diferentes comportamentos de relatório sejam adicionados sem alterar diretamente a classe Relatorio, mantendo-a flexível e reutilizável. Ao criar instâncias da classe Relatorio e passar diferentes estratégias, a lógica para contar eventos ou calcular totais no período pode ser alterada conforme a estratégia fornecida, seguindo assim o princípio de abertura para extensão e fechamento para modificação.

3) Princípio da Substituição de Liskov (Liskov Substitution Principle- LSP)

   A classe Multimídia e a main foram modificadas para atender o Princípio da substituição de Liskov. Isso foi feito a través da transformação da classe Multimídia, que antes era abstrata, para uma classe comum, que possui subclasses, bem como pela alteração das funções de adição e edição de itens na Main e da exclusão da classe "Outros". Esta mudança permite faz com que seja possível adicionar e editar tanto um item de uma das subclasses (LivroFIsico, LivroEletronico, DVD_Video, CD_Audio e Item_Biblioteca) quanto do tipo da classe mãe(Multimidia). Assim, caso se deseje adicionar um item que não se encaixe em nenhuma das subclasses, ele pode ser apenas uma multimídia, sendo um tem genérico, ao qual é possível aplicar o princípio da substituição.

4) Princípio da Segregação de Interfaces ( Interface Segregation Principle - ISP)

   O Princípio da segregação de interfaces já está presente no sistema da biblioteca, pois nenhuma classe que não precisa da funções das interfaces existentes é obrigada a usá-las, e não são necessárias interfaces adicionais nos models para que o princípio seja cumprido. As interfaces BibliotecaController, RelatorioController, MembroController, BilbiotecaView, RelatorioView, MembroView e ItemMultimidia não são implementadas em classes nas quais as mesmas não tem ação alguma.
   
5) Princípio da Inversão de Dependência (Dependency Inversion Principle - DIP): 

    Na classe "RecursoMultimidia", é empregada uma interface que foi implementada para ser utilizada pelas classes internas "Áudio" e "Vídeo". Esse método permite que as classes internas dependam da abstração oferecida por "ItemMultimidia", em conformidade com o Princípio da Inversão de Dependência (DIP). Essa abordagem estabelece uma distinção clara entre as classes internas e externas, minimizando o acoplamento direto e proporcionando maior flexibilidade para modificar ou expandir o comportamento das classes internas sem impactar a classe externa.

