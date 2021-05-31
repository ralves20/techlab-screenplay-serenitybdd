# language: pt
# encoding: utf-8

@e2e @cadastro
Funcionalidade: Realizar cadastro de um novo estudante
  Como um coordenador da faculdade
  José deseja acessar o formulário de cadastro de estudantes
  Para que ele consiga gerenciar no sistema tendo um devido controle de todos os estudantes da faculdade

  Contexto:
    Dado que José acessa o formulário de cadastro de estudantes

  @valido @regressivo @prioridade:alta
  Cenario: Realizar cadastro com sucesso
    E ele preenche todos os dados do aluno corretamente
    Quando ele aciona a opção para gravar os dados no sistema
    Então os dados do aluno são gravados com sucesso

  @invalido @regressivo @prioridade:media
  Cenário: Validar obrigatoriedade de preenchimento
    Quando ele aciona a opção para gravar os dados no sistema sem preencher campo algum
    Então ele deve ver que impedindo o cadastro erros são apresentados para os campos obrigatórios