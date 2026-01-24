# 💣 Campo Minado (Minesweeper)

Um jogo de Campo Minado desenvolvido em Java com interface de console, aplicando conceitos de Programação Orientada a Objetos e Test-Driven Development (TDD).

## 📋 Sobre o Projeto

Este projeto é uma implementação completa do clássico jogo Campo Minado, desenvolvido como exercício de aprendizado de Java. O jogo funciona totalmente via terminal/console e possui uma cobertura robusta de testes unitários com JUnit 5.

## 🎮 Como Jogar

1. O jogo exibe um tabuleiro com células ocultas representadas por `?`
2. Digite as coordenadas no formato `x, y` (exemplo: `3, 4`)
3. Escolha a ação:
   - **1** - Abrir o campo
   - **2** - Marcar/Desmarcar o campo (bandeira)
4. Objetivo: Abrir todos os campos sem minas ou marcar corretamente todas as minas

### Legenda do Tabuleiro

- `?` - Campo fechado
- `x` - Campo marcado (bandeira)
- ` ` - Campo aberto sem minas vizinhas
- `1-8` - Número de minas nos campos adjacentes
- `*` - Mina explodida (game over)

## 🚀 Tecnologias Utilizadas

- **Java** - Linguagem de programação
- **JUnit 5** - Framework de testes unitários
- **Eclipse IDE** - Ambiente de desenvolvimento

## 📦 Estrutura do Projeto

```
src/
├── main/
│   └── java/
│       └── br/com/rafaelkanashiro/cm/
│           ├── Aplicacao.java              # Classe principal
│           ├── modelo/
│           │   ├── Campo.java              # Lógica de cada célula
│           │   └── Tabuleiro.java          # Gerenciamento do tabuleiro
│           ├── visao/
│           │   └── TabuleiroConsole.java   # Interface com usuário
│           └── excecao/
│               ├── ExplosaoException.java  # Exceção para mina explodida
│               └── SairException.java      # Exceção para sair do jogo
└── test/
    └── java/
        └── br/com/rafaelkanashiro/cm/
            └── modelo/
                ├── CampoTeste.java         # Testes da classe Campo
                └── TabuleiroTeste.java     # Testes da classe Tabuleiro
```

## ⚙️ Como Executar

### Pré-requisitos

- Java JDK 8 ou superior instalado
- Eclipse IDE (ou outra IDE Java de sua preferência)

### Passos para execução

1. Clone o repositório:
```bash
git clone https://github.com/rafaelkanashiro/projeto-campo-minado.git
```

2. Importe o projeto no Eclipse:
   - File → Import → Existing Projects into Workspace
   - Selecione a pasta do projeto
   - Finish

3. Execute a classe `Aplicacao.java`:
   - Clique com botão direito em `Aplicacao.java`
   - Run As → Java Application

## 🧪 Executando os Testes

Os testes cobrem as principais funcionalidades do jogo:

- Validação de vizinhos entre campos
- Abertura de campos e propagação
- Marcação e desmarcação de minas
- Verificação de vitória/derrota
- Reinicialização do tabuleiro

Para executar os testes no Eclipse:

1. Clique com botão direito na classe de teste (`CampoTeste.java` ou `TabuleiroTeste.java`)
2. Run As → JUnit Test

Ou execute todos os testes de uma vez clicando com botão direito na pasta `test` e selecionando Run As → JUnit Test.

## 🎯 Funcionalidades

- ✅ Tabuleiro configurável (linhas, colunas e quantidade de minas)
- ✅ Abertura automática de campos seguros adjacentes
- ✅ Sistema de marcação de bandeiras
- ✅ Contagem de minas vizinhas
- ✅ Detecção de vitória/derrota
- ✅ Opção de reiniciar partida
- ✅ Comando "sair" para encerrar o jogo
- ✅ Cobertura completa de testes unitários

## 📝 Configuração Padrão

O jogo inicia com as seguintes configurações (editáveis em `Aplicacao.java`):

- **Tabuleiro:** 12x12
- **Minas:** 25

Para alterar, modifique os parâmetros no construtor:
```java
Tabuleiro tabuleiro = new Tabuleiro(linhas, colunas, quantidadeMinas);
```

## 👨‍💻 Autor

**Rafael Kanashiro**

- GitHub: [@rafaelkanashiro](https://github.com/rafaelkanashiro)

---

⭐ Se este projeto te ajudou de alguma forma, considere dar uma estrela!
