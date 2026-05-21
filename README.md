# Fazenda-Esperanca

## Comandos e resultados de apoio que solicitamos para a I.A. ChatGPT no desenvolvimento do escopo e andamento deste projeto:

### Observação: Toda vez que iniciamos uma linha de raciocínio com a IA informada, delimitávamos que ela não poderia exceder os conteúdos que estudamos, a fim de não termos ciência de algo muito específico que ela pudesse realizar

### Ana Paula:
Faça a classe colaborador;
**Comando 01:** A IA retornou um arquivo chamado colaborador. Java, que foi usado como base para a criação das outras classes.

**Comando 02:** A parte dos cadastros já está pronta, agora precisamos entregar a parte do cruzamento de dados para  o cadastro da colheita;

Nessa parte foi necessário o envio do código que já tínhamos para que o chat soubesse como estávamos nomeando as variáveis. 

Antes de dar o comando, foi enviado ao chat o arquivo da aula 15 - persistência de dados.
**Comando 03:** Com base nos exemplos dos slides, programe a gravação das informações para o seguinte trecho: - cadastro de talhão.

**Comando 04:** Foco da aula: Fazer o sistema "lembrar" dos dados após fechado. Será necessário gerenciar múltiplos locais de salvamento. 

**Comando 05:** Desenvolva o código para o relatório do talhão, lembrando que se possível, o código deve ser uma função que estará em um módulo chamado relatórios e será chamado na main. Não fuja as regras do primeiro documento que mandei;

### Giulia Guimarães:
**Comando 01:** Monte o registro do café (RegistroCafe) com as especificações do documento para esta função e o chame na main (arquivo "App.java"), deve incluir a busca pela placa informada pelo usuário, se existe ou não e se a capacidade não foi excedida. Faça a divisão do sistema em módulos.

**Resultado:**

### João Henrique:
**Comando 01:** Seguinte chat, estou com esta estrutura de arquivos da imagem e precisava registrar as alterações do codigo ao lado no arquivo RegistrosCafe.csv, como ficaria o pathname para ele?

**Resultado 01:** Chat listou um código que apresentava 3 versões de caminhos: Para o Windows, Linux e MAC.
Utilizamos a opção Windows e para testes em meu caso deixei comentado os antigos caminhos em Linux;

**Comando 02:** Chat, estou tentando salvar o arquivo de RegistrosCafe na base de dados, porém ele não está executando, segue o código abaixo. Existe algum erro na lógica?

    try{
    
    FileWriter arqRegistroCafe = new FileWriter("src/BancoDeDados/RegistrosCafe.csv"); 
    PrintWriter gravador = new PrintWriter(arqRegistroCafe); 
    for(int cont = 0; cont < totalRegistros; cont++){ 
    
        String linha = "TESTE;";/*registros[cont].matriculaFuncionario + ";" + 
        registros[cont].nomeTalhao + ";" + registros[cont].placaTrator + ";" + registros[cont].quantidadeLitros;*/ 
        gravador.println(); 
    } 
    gravador.close(); 
    System.out.println("Sistema atualizado com sucesso!"); 
    } 
    catch(IOException err){ 
        System.err.println("Erro apresentado: " + err); 
    }

**Resultado 02:** 
Sim, tem um pequeno erro lógico: você criou a variável linha, mas não está escrevendo ela no arquivo.

Atualmente está assim:

    gravador.println();

Isso apenas pula linhas em branco no CSV.

O correto é:

    gravador.println(linha);

### Pedro Henrique:
**Comando:** Faça um sistema de colheita em java, separando-os em arquivos, que serão:  funcionário, talhão e trator. Na main, deverá ter cadastro do funcionário, do talhão e do trator. Deverá registrar a entrada de café com sua quantidade. Por fim, deve mostrar os relatório de cada arquivo e uma opçao para sair. O código não deverá ser usado com comandos muito elaborados, visto que será pego de inspiração por estudantes de java.

**Resultado:** O resultado deste comando pode ser encontrado no arquivo **"Fazenda-Esperanca\Arquivos IA\Codigo_Base.java"**

