##Coordenada: 
Define uma coordenada (x, y) no tabuleiro de 10x10, com métodos para acessar e modificar essas coordenadas.

##Navio:
Representa um navio no jogo. Cada navio tem um nome, um conjunto de partes (representadas como booleanos) que indicam se foram atingidas, e a coordenada da proa do navio. Também inclui métodos para verificar se uma parte do navio foi atingida (atingir), exibir o estado de uma parte (exibir) e retornar uma representação textual do navio (toString).

##BatalhaNaval: 
Gerencia o tabuleiro de jogo e os navios. O tabuleiro é representado por uma matriz de objetos Atingivel, que pode ser um navio ou água. A classe inclui métodos para adicionar navios ao tabuleiro (addNavio), exibir o estado atual do tabuleiro (exibir), e registrar um tiro em uma coordenada específica (atingir).

##Mar: 
Representa uma célula de água no tabuleiro. Implementa a interface Atingivel, e pode ser atingida, retornando "Agua", ou exibir seu estado atual (exibir).

##TiroInvalidoException: 
Exceção lançada quando um tiro é feito em uma coordenada inválida.

##Atingivel: 
Interface que define os métodos atingir e exibir que devem ser implementados por todas as classes que podem ser atingidas no tabuleiro (como Navio e Mar).
