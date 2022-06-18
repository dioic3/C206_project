# Introdução

```Para o projeto, deverá ser gravado e enviado dois vídeos de nomáximo 5 minutos cada:•1 vídeo que explique a ideia e funcionamento do projeto desenvolvido; •1 vídeo que explique o código fonte do projeto desenvolvido```

Bom dia, boa tarde e boa noite!

Oi, meu nome é Pedro/Joyce!

## Vídeo explicando a ideia e o funcionamento do projeto desenvolvido

O nosso projeto foi baseado em diversos jogos jogados na infância, como por exemplo aqueles jogos de sites que podem ser encontrados no click jogos ou friv. O jogo se chama Maraton3000 e consiste em um maratonista que precisa dar 10 passos e chegar na linha de chegada.

Foi colocado um contador de pulsos para ver quando tempo foi necessário para o maratonista começa e termina de dar os 10 passos. Esse contador de pulsos é o responsável por fazer a tomada de tempo do jogador.

Também é necessário saber a entrada de cada passo, sendo (a = pé esquerdo) e (d = pé direito), o maratonista precisa sempre andar com um pé e depois o outro. Ele não poderá entrar com duas informações iguais, por exemplo, **dd**. Não tem como uma pessoa andar com o pé direito duas vezes. Desse modo, é necessário um scanner de verificação de que está sendo inserido a informação corretamente, caso contrário não será validado.

Quando for inserido os 10 passos, sendo um passo de cada. Vai dar como se ele tivesse chegado no final.Além disso, existe uma saída de dados no contador de pulsos e no fim será colocado esse informação em um Banco de Dados para guardar o nome da pessoa que jogou e quantidade de pulsos que ela precisou para terminar a corrida, ou seja, quanto tempo o usuário para terminar a corrida.

Foi feito um ranking para mostrar a quantidade de pessoas que jogou e o tempo total, logo após terminar de jogar vai ser perguntado se ele quer jogar novamente. Caso a resposta seja sim ele pode jogar novamente, mas se digitar não ele volta para o Menu e poderá sair do jogo.

## Código

A pasta Conections indica a ponte de comunicação do código Java com o banco de dados, onde o ConnectionDAO armazena as informações do banco de dados contendo a url, user e password para ter acesso.

JogadorDAO e RankingDAO são os CRUDS para facilitar a comunicação com o banco de dados, sendo a inserção, atualização, recuperação e remoção de dados.

A pasta controller é o maestro da sinfonia para evitar que uma função tenha infinitas responsabilidades, aplicando o básico de compartilhar tarefas igual num time ágil. A classe Jogar dentro da pasta é o maestro e ele é o jogo em si, onde vai ser pedido para entrar com as informações do jogador e onde o desenvolvimento do jogo acontece.

A pasta models contém as classes do jogo, tendo o básico de Programação Orientada a Objetos. Dentro da pasta foram colocadas as classes destinadas a pequenas funções para a classe ser chamada em outro arquivo, assim evita o sobrecarregamento do arquivo principal entitulado como Main. Foram usados os conceitos de Getters and Setters, Herança, Polimorfismo, HashMap e entre outros.

Classes como Ranking, Rank e RankingJogadorDTO são relacionadas a organização e implementação das informações do Banco de Dados no código do Java, relacionando o Jogador e suas informações secundários sendo lançadas no SQL script.

A classe Move está sendo usado para identificar se o jogador insere as informações corretas do pé esquerdo e direito na hora de jogar, evitando que o código seja quebrado durante a inserção de dados. Também ao inserir informações repetidas do pé esquerdo e direito a classe Move indica que o cara poderia tropeçar.

A classe Menu Principal foi criado com a finalidade de validar qual opção que o usuário quer, sendo exibido as informações de JOGAR, COMO JOGAR, MOSTRAR RANKING e SAIR. Tem-se uma função para pegar a opção que o usuário quer dentro das 4 opções disponiveis, depois tem uma função para imprimir as opções.

...