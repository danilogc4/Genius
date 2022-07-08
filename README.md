# Genius

A aplicação possui 6 classes principais, um enumerator para representar as Cores e a classe App sendo esta responsável somente por instanciar o jogo. Segue abaixo uma descrição de cada componente do programa:

## Game

Esta é a classe “mãe” da aplicação, é ela que contém as configurações do jogo que será jogado. Isto é, nela temos o modo de jogo, a dificuldade é o banco (disponível apenas em tempo de execução) dos jogadores.  Por se tratar da classe principal, temos os procedimentos de play (jogar) cuja função é simplesmente rodar o modo de jogo que estiver configurado. Além disso, a apresentação de menu, a manipulação da dificuldade e do banco são feitos nesta mesma classe.

## GameMode

Os modos de jogo do Genius possuem certas características e comportamentos em comum, dito isso, é possível abstrair essas semelhanças em uma classe abstrata, que nesta aplicação é a GameMode. Entre os atributos protected da GameMode, vale ressaltar sequence (sequência) que nada mais é do que a sequência de cores do modo de jogo e round que representa a rodada atual do jogo. De forma privada, temos o currentPlayer que armazena o jogador que está jogando atualmente, dessa forma é possível contabilizar vitórias, derrotas, dizer o nome do jogador que está jogando e atualizar o banco de jogadores que está definido na classe Game supracitada.

Dentre os procedimentos abstratos que deverão ser implementados pelas classes filhas, temos:

- `run`: o método principal de cada modo de jogo que irá chamar outros procedimentos. De forma sucinta e comum em todos os modos de jogo, aqui será limpado o console, mostrará a sequência e irá requisitar do jogador a sequência que ele acha correta.
- `update`: este método será chamado a cada nova rodada de jogo para atualizar o status do jogo, trocar jogador e/ou adicionar nova cor na sequência.
- `defeat`: método para marcar a derrota de um jogador.
- `win`: método para marcar a vitória de um ou mais jogadores a depender do modo de jogo.


## RepeatSequence

Esta classe é uma filha de GameMode, sendo assim, herda todos os atributos e implementa os métodos abstratos supracitados. Neste modo, o método update irá adicionar uma cor aleatória no ArrayList sequence da classe mãe. No método run, será feito, inicialmente, um update, será mostrada a sequência de cor e irá pedir para o jogador inserir a sequência que ele acha correta. Isso será feito até que a sequência de cores atinja o tamanho máximo e usuário acerte (contabilizando uma vitória) ou o jogador erre a qualquer momento a sequência de cores.


## Multiplayer

Os métodos de multiplayer são bastante similares ao de RepeatSequence, a diferença aqui é que podem haver mais de um vencedores, e, quando um jogador erra, o jogo não é finalizado, ele é apenas eliminado do jogo. Para contabilizar a vitória, ou todos os jogadores precisam ser eliminados, restando somente 1 ou a sequência atinge o tamanho máximo e mais de um jogador acerta a sequência inteira.


## CreateSequence

No modo de CreateSequence, o método update irá requisitar uma cor do usuário, não sendo mais uma cor randômica que seŕa adicionada à sequência. Todo o restante do jogo é bem semelhante o RepeatSequence.


## Player

Esta é a classe que representa o jogador, sendo responsável por chamar o procedimento para escolher uma cor, contabilizar quantas vitórias um jogador x possui e seu nome.



Segue abaixo o diagrama de classe da aplicação:



![Diagrama de Classe](https://i.imgur.com/JEmjPga.png)
