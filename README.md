# MC322
Laboratórios da disciplina MC322 (Programação Orientada a Objetos) da Unicamp 2023s2

Dupla:

Maísa de Oliveira Pinheiro - RA: 244006
Fernanda Oliveira dos Santos - RA: 243385

# Detalhes sobre os 5 principios do SOLID utilizados nesse projeto

1) Princípio da Inversão de Dependência (Dependency Inversion Principle - DIP): 

    Na classe "RecursoMultimidia", é empregada uma interface que foi implementada para ser utilizada pelas classes internas "Áudio" e "Vídeo". Esse método permite que as classes internas dependam da abstração oferecida por "ItemMultimidia", em conformidade com o Princípio da Inversão de Dependência (DIP). Essa abordagem estabelece uma distinção clara entre as classes internas e externas, minimizando o acoplamento direto e proporcionando maior flexibilidade para modificar ou expandir o comportamento das classes internas sem impactar a classe externa.

2) Princípio do Aberto/Fechado (Open/Closed Principle - OCP):

    O principio do aberto/fechado foi utilizado na classe de criação de relatórios afim de permitir que essa classe se torne aberta para extensões (adicionando novas estratégias) sem a necessidade de modificação direta de seu código-fonte original. Dessa forma, foi criada uma interface "EstratégiaRelatório" para definir métodos que todas as estratégias de relatório devem implementar. Posteriormente duas novas classes foram criadas "EmprestimosRelatorio" e "MultasRelatorio", cada uma representando uma estratégia especifica do relatório. Essa abordagem permite que diferentes comportamentos de relatório sejam adicionados sem alterar diretamente a classe Relatorio, mantendo-a flexível e reutilizável. Ao criar instâncias da classe Relatorio e passar diferentes estratégias, a lógica para contar eventos ou calcular totais no período pode ser alterada conforme a estratégia fornecida, seguindo assim o princípio de abertura para extensão e fechamento para modificação.