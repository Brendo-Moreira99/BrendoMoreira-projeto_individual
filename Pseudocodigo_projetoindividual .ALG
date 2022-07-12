Algoritmo //"Sistema de cadastramento e consulta da agência Novos Ares "

//Aluno: Brendo dos Santos Moreira

//função para o cadastramento de clientes

funcao cadastramento(): caractere

var
   nome,email,prosseguir:caractere
   idade, cpf: inteiro

inicio

   Para i de 1 ate 10 faca

      Escreval("")
      Escreva("Digite nome:")
      leia(nome[i])
      Escreva("Digite cpf:")
      leia(cpf[i])
      Escreva ("Digite email:")
      leia(email[i])
      Escreva ("Digite idade:")
      leia(idade[i])


      nome<-nome[i]
      cpf<-cpf[i]
      email<-email[i]
      idade<-idade[i]

      escreva("Continuar o cadastro?")
      leia(prosseguir)
      prosseguir<-Maiusc(prosseguir)

      Se (prosseguir = "NÃO")ou(prosseguir = "NAO") entao
         interrompa
      Fimse


   fimpara

   retorne nome
fimfuncao

//função para o guardar o destino dos clientes

funcao destino(): caractere

var
   cidade,estado, pais,prosseguir: caractere

inicio

   Para i de 1 ate 10 faca

      Escreval("")
      Escreva("Defina o país:")
      leia(pais[i])
      Escreva ("Escolha estado:")
      leia(estado[i])
      Escreva ("Escolha a cidade:")
      leia(cidade[i])


      cidade<-cidade[i]
      estado<-estado[i]
      pais<-pais[i]

      escreva("Continuar o cadastro?")
      leia(prosseguir)
      prosseguir<-Maiusc(prosseguir)

      Se (prosseguir = "NÃO")ou (prosseguir = "NAO") entao
         interrompa

      Fimse

   fimpara
   retorne cidade
fimfuncao





//Variaveis
Var
   i:inteiro
   confirmacao: caractere
   consulta_menu: inteiro
   nome, email: vetor[1..10] de caractere
   cpf,idade: vetor[1..10] de inteiro
   cidade,estado,pais: vetor [1..10] de caractere
   cadastramento, destino: caractere



Inicio

   //Pergunta de acesso para abrir o menu

   Escreva ("Deseja acessar o menu?")
   Leia(confirmacao)
   confirmacao<-Maiusc(confirmacao)
   
   //Pergunta ao usuário
   enquanto (confirmacao = "SIM") faca

      Escreval ("O que deseja fazer?")
      Escreval("Escolha uma das opções para continuar: ")
      Escreval("")
      Escreval("1-Cadastrar cliente")
      Escreval("2-Cadastrar destino")
      Escreval("3-Consultar destino e cliente")
      Escreval("4-Interromper operação")


      Leia (consulta_menu)

      Escreval("")
      
      // Condicional para a escolha do usuário
      
      Se (consulta_menu = 1) entao


         Escreval ("Cadastro de Cliente:")
         Escreval ("")
         cadastramento <-cadastramento()

      senão
         Se (consulta_menu = 2) entao

            Escreval ("Cadastro de destino:")
            Escreval ("")
            destino<-destino()
         senao
            Se (consulta_menu = 3) entao

               Escreval ("Consulta de clientes e destinos:")
               Escreval("")

               Para i de 1 ate 10 faca
                  Se ((nome[i] = "") e (pais[i]="")) entao
                     Escreval("")
                     interrompa
                  senao

                     Escreval(i, "° Cadastro de CLIENTES.")
                     Escreval("")

                     Escreval("Nome: ", nome[i])
                     Escreval("CPF: ", cpf[i])
                     Escreval("Email:", email[i])
                     Escreval("Idade:", idade[i])
                     Escreval("")
                     
                     Escreval(i,"° Cadastro de DESTINOS.")
                     Escreval("")
                     Escreval("País: ", pais[i])
                     Escreval("Estado: ", estado[i])
                     Escreval("Cidade:", cidade[i])
                     Escreval("-----------------------")
                  fimse
               fimpara

            senao
               interrompa
            fimse
         fimse
      fimse

   fimenquanto



Fimalgoritmo