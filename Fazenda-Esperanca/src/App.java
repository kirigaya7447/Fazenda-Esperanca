import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int opcao;

        CadastroFuncionario[] funcionarios = new CadastroFuncionario[100];
        CadastroTalhao[] talhoes = new CadastroTalhao[100];
        CadastroFrota[] tratores = new CadastroFrota[100];
        RegistroCafe[] registros = new RegistroCafe[100];

        int totalFuncionarios = carregarFuncionarios(funcionarios);
        int totalTalhoes = carregarTalhao(talhoes);
        int totalTratores = carregarFrota(tratores);
        int totalRegistros = carregartalhoesCafe(registros);

        do {
            System.out.println("\n----> SISTEMA FAZENDA <----");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Cadastrar Talhão");
            System.out.println("3 - Cadastrar Trator");
            System.out.println("4 - Registrar Entrada de Café");
            System.out.println("5 - Relatório Quinzena");
            System.out.println("6 - Relatório Talhão");
            System.out.println("7 - Relatório Secagem");
            System.out.println("8 - Relatório Geral");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("----> Cadastro de Funcionário <----");
                    System.out.println("Digite a matrícula do funcionário(Formato 000):");
                    int matricula = sc.nextInt();
                    sc.nextLine();

                    boolean funcionarioExiste = false;

                    for (int i = 0; i < totalFuncionarios; i++) {

                        if (funcionarios[i].matricula == matricula) {
                            funcionarioExiste = true;
                            break;
                        }

                    }

                    if (funcionarioExiste) {

                        System.out.println("ERRO: Funcionário já cadastrado!");
                        break;

                    }

                    System.out.println("Digite o nome do funcionário:");
                    String nomeFuncionario = sc.nextLine();

                    System.out.println("Digite o tipo de contrato do funcionário(Diarista ou Fixo):");
                    String tipoContrato = sc.nextLine();

                    totalFuncionarios = cadastrarFuncionario(matricula, nomeFuncionario, tipoContrato,
                            totalFuncionarios, funcionarios);
                    break;

                case 2:
                    System.out.println("----> Cadastro de Talhão <----");
                    System.out.println("Digite o código do talhão(000):");
                    int codigoTalhao = sc.nextInt();
                    sc.nextLine();

                    boolean talhaoExiste = false;

                    for (int i = 0; i < totalTalhoes; i++) {

                        if (talhoes[i].codigo == codigoTalhao) {
                            talhaoExiste = true;
                            break;
                        }
                    }

                    if (talhaoExiste) {
                        System.out.println("ERRO: Código de talhão já cadastrado!");
                        break;
                    }

                    System.out.println("Digite o nome da área:");
                    String nomeTalhao = sc.nextLine();

                    for (int i = 0; i < totalTalhoes; i++) {

                        if (talhoes[i].nome.equalsIgnoreCase(nomeTalhao)) {
                            talhaoExiste = true;
                            break;
                        }
                    }

                    if (talhaoExiste) {
                        System.out.println("ERRO: Nome de talhão já cadastrado!");
                        break;
                    }

                    System.out.println("Digite a variedade do café:");
                    String variedade = sc.nextLine();

                    System.out.println("Digite a estimativa de produção:");
                    double estimativa = sc.nextDouble();
                    totalTalhoes = cadastrarTalhao(codigoTalhao, nomeTalhao, variedade, estimativa, totalTalhoes,
                            talhoes);
                    break;

                case 3:
                    System.out.println("----> Cadastro de Frota <----");
                    System.out.println("Digite a placa do trator(Formato AAA-0000):");
                    String placa = sc.nextLine();

                    boolean tratorExiste = false;

                    for (int i = 0; i < totalTratores; i++) {
                        if (tratores[i].placa.equalsIgnoreCase(placa)) {
                            tratorExiste = true;
                            break;
                        }
                    }

                    if (tratorExiste) {
                        System.out.println("ERRO: Trator já cadastrado!");
                        break;
                    }

                    System.out.println("Digite a capacidade máxima:");
                    Double capacidadeMaxima = sc.nextDouble();

                    totalTratores = cadastrarFrota(placa, capacidadeMaxima, totalTratores, tratores);
                    break;

                case 4:
                    System.out.println("\n----> Registro de Entrada de Café <----");

                    System.out.print("Matrícula do Funcionário: ");
                    int mat = sc.nextInt();
                    sc.nextLine();

                    boolean funcExiste = false;

                    for (int i = 0; i < totalFuncionarios; i++) {
                        if (funcionarios[i].matricula == mat) {
                            funcExiste = true;
                            break;
                        }
                    }
                    if (!funcExiste) {
                        System.out.println("ERRO: Funcionário não cadastrado!");
                        break;
                    }
                    System.out.print("Nome do Talhão: ");
                    String nomeT = sc.nextLine();
                    talhaoExiste = false;

                    for (int i = 0; i < totalTalhoes; i++) {
                        if (talhoes[i].nome.equalsIgnoreCase(nomeT)) {
                            talhaoExiste = true;
                            break;
                        }
                    }
                    if (!talhaoExiste) {
                        System.out.println("ERRO: Talhão não encontrado!");
                        break;
                    }
                    System.out.print("Placa do Trator(Formato AAA-0000):");
                    String placaT = sc.nextLine();
                    int indexTrator = -1;

                    for (int i = 0; i < totalTratores; i++) {
                        if (tratores[i].placa.equalsIgnoreCase(placaT)) {
                            indexTrator = i;
                            break;
                        }
                    }
                    if (indexTrator == -1) {
                        System.out.println("ERRO: Trator não existe!");
                        break;
                    }
                    System.out.print("Quantidade de Litros: ");
                    double litros = sc.nextDouble();
                    sc.nextLine();

                    if (litros > tratores[indexTrator].capacidadeMaxima) {
                        System.out.println("ERRO: Carga maior que a capacidade do trator!");
                        break;
                    }

                    System.out.print("Data (dd/mm): ");
                    String data = sc.nextLine();

                    System.out.print("Destino (Terreiro/Secador): ");
                    String destino = sc.nextLine();

                    totalRegistros = cadastrarRegistrosCafe(mat, nomeT, placaT, litros, data, destino, totalRegistros,
                            registros);
                    break;

                case 5:
                    Relatorios.relatorioQuinzena(funcionarios, totalFuncionarios, registros, totalRegistros);
                    break;

                case 6:
                    Relatorios.relatorioTalhao(talhoes, totalTalhoes, registros, totalRegistros);
                    break;

                case 7:
                    Relatorios.relatorioSecagem(registros, totalRegistros);
                    break;

                case 8: 
                    Relatorios.relatorioGeral(funcionarios, totalFuncionarios, talhoes, totalTalhoes, tratores, totalTratores, registros, totalRegistros);
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    // FUNÇÕES DOS CADASTROS

    public static int cadastrarFuncionario(int matricula, String nome, String tipoContrato, int totalFuncionarios,
            CadastroFuncionario[] funcionarios) {
        funcionarios[totalFuncionarios] = new CadastroFuncionario();

        funcionarios[totalFuncionarios].matricula = matricula;
        funcionarios[totalFuncionarios].nome = nome;
        funcionarios[totalFuncionarios].tipoContrato = tipoContrato;

        System.out.println("Cadastro efetuado com sucesso!");
        totalFuncionarios++;

        try {
            FileWriter arquivo = new FileWriter("src/BancoDeDados/Funcionarios.csv");
            PrintWriter gravador = new PrintWriter(arquivo);

            for (int i = 0; i < totalFuncionarios; i++) {
                // converte o objeto para o formato CSV
                String linha = funcionarios[i].matricula + ";" +
                        funcionarios[i].nome + ";" +
                        funcionarios[i].tipoContrato;
                gravador.println(linha);

            }
                System.out.println("Sistema atualizado com sucesso!");
                arquivo.close();
            gravador.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }

        return totalFuncionarios;
    }

    public static int cadastrarTalhao(int codigo, String nome, String variedade, double estimativa, int totalTalhoes,
            CadastroTalhao[] talhoes) {
        talhoes[totalTalhoes] = new CadastroTalhao();

        talhoes[totalTalhoes].codigo = codigo;
        talhoes[totalTalhoes].nome = nome;
        talhoes[totalTalhoes].variedadeCafe = variedade;
        talhoes[totalTalhoes].estimativaProducao = estimativa;

        System.out.println("Cadastro efetuado com sucesso!");
        totalTalhoes++;

        // salvando informações
        try {

            FileWriter arquivo = new FileWriter("src/BancoDeDados/Talhoes.csv");

            PrintWriter gravar = new PrintWriter(arquivo);

            for (int i = 0; i < totalTalhoes; i++) {

                gravar.println(
                        talhoes[i].codigo + ";" +
                                talhoes[i].nome + ";" +
                                talhoes[i].variedadeCafe + ";" +
                                talhoes[i].estimativaProducao);

            }
                System.out.println("Sistema atualizado com sucesso!");
                arquivo.close();
            gravar.close();

        } catch (Exception erro) {

            System.out.println("Erro ao gravar arquivo");

        }
        return totalTalhoes;

    }

    public static int cadastrarFrota(String placa, double capacidadeMaxima, int totalTratores,
            CadastroFrota[] tratores) {
        tratores[totalTratores] = new CadastroFrota();

        tratores[totalTratores].placa = placa;

        tratores[totalTratores].capacidadeMaxima = capacidadeMaxima;

        System.out.println("Cadastro efetuado com sucesso!");
        totalTratores++;

        try {
            FileWriter arquivo = new FileWriter("src/BancoDeDados/Frota.csv");
            PrintWriter gravador = new PrintWriter(arquivo);

            for (int i = 0; i < totalTratores; i++) {
                // converte o objeto para o formato CSV
                String linha = tratores[i].placa + ";" +
                        tratores[i].capacidadeMaxima;
                gravador.println(linha);

            }
                System.out.println("Sistema atualizado com sucesso!");
                arquivo.close();
            gravador.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
        return totalTratores;
    }

    public static int cadastrarRegistrosCafe(int mat, String nomeT, String placaT, double litros, String data,
            String destino, int totalRegistros, RegistroCafe[] registros) {
        RegistroCafe novoRegistro = new RegistroCafe();

        novoRegistro.matriculaFuncionario = mat;
        novoRegistro.nomeTalhao = nomeT;
        novoRegistro.placaTrator = placaT;
        novoRegistro.quantidadeLitros = litros;
        novoRegistro.data = data;
        novoRegistro.destino = destino;

        registros[totalRegistros] = novoRegistro;
        totalRegistros++;
        System.out.println("Lançamento realizado com sucesso!");
        try {
            FileWriter arquivo = new FileWriter("src/BancoDeDados/RegistrosCafe.csv");
            PrintWriter gravador = new PrintWriter(arquivo);

            for (int cont = 0; cont < totalRegistros; cont++) {
                String linha = registros[cont].matriculaFuncionario + ";" +
                        registros[cont].nomeTalhao + ";" +
                        registros[cont].placaTrator + ";" +
                        registros[cont].quantidadeLitros + ";" +
                        registros[cont].data + ";" +
                        registros[cont].destino;
                gravador.println(linha);
            }
                System.out.println("Sistema atualizado com sucesso!");
                arquivo.close();
            gravador.close();
        } catch (IOException err) {
            System.out.println("Erro ao salvar: " + err.getMessage());
        }

        return totalRegistros;
    }

    // FUNÇÕES DE CARREGAMENTOS DOS ARQUIVOS SALVOS

    public static int carregarFuncionarios(CadastroFuncionario[] funcionarios) {
        int a = 0;

        try {
            Scanner leituraArquivo = new Scanner(new File("src/BancoDeDados/Funcionarios.csv"));

            while (leituraArquivo.hasNextLine() && a < funcionarios.length) {
                String linha = leituraArquivo.nextLine();
                String[] separador = linha.split(";");
                funcionarios[a] = new CadastroFuncionario();
                funcionarios[a].matricula = Integer.valueOf(separador[0]);
                funcionarios[a].nome = separador[1];
                funcionarios[a].tipoContrato = separador[2];
                a++;
            }
            leituraArquivo.close();
        } catch (IOException err) {
            System.err.println("Erro encontrado na leitura do arquivo: " + err);
        }
        return a;
    }

    public static int carregarTalhao(CadastroTalhao[] talhoes) {
        int cont = 0;

        try {
            Scanner leituraArquivo = new Scanner(new File("src/BancoDeDados/Talhoes.csv"));
            while (leituraArquivo.hasNextLine() && cont < talhoes.length) {
                String linha = leituraArquivo.nextLine();
                String[] separador = linha.split(";");
                talhoes[cont] = new CadastroTalhao();
                talhoes[cont].codigo = Integer.valueOf(separador[0]);
                talhoes[cont].nome = separador[1];
                talhoes[cont].variedadeCafe = separador[2];
                talhoes[cont].estimativaProducao = Double.valueOf(separador[3]);
                cont++;
            }

            leituraArquivo.close();
        } catch (IOException err) {
            System.err.println("Erro encontrado na leitura do arquivo: " + err);
        }
        return cont;
    }

    public static int carregarFrota(CadastroFrota[] tratores) {
        int cont = 0;

        try {
            Scanner leituraArquivo = new Scanner(new File("src/BancoDeDados/Frota.csv"));
            while (leituraArquivo.hasNextLine() && cont < tratores.length) {
                String linha = leituraArquivo.nextLine();
                String[] separador = linha.split(";");
                tratores[cont] = new CadastroFrota();
                tratores[cont].placa = separador[0];
                tratores[cont].capacidadeMaxima = Double.valueOf(separador[1]);
                cont++;
            }

            leituraArquivo.close();
        } catch (IOException err) {
            System.err.println("Erro encontrado na leitura do arquivo: " + err);
        }

        return cont;
    }

    public static int carregartalhoesCafe(RegistroCafe[] talhoes) {
        int cont = 0;

        try {
            Scanner leituraArquivo = new Scanner(new File("src/BancoDeDados/RegistrosCafe.csv"));
            while (leituraArquivo.hasNextLine() && cont < talhoes.length) {
                String linha = leituraArquivo.nextLine();
                String[] separador = linha.split(";");
                talhoes[cont] = new RegistroCafe();
                talhoes[cont].matriculaFuncionario = Integer.valueOf(separador[0]);
                talhoes[cont].nomeTalhao = separador[1];
                talhoes[cont].placaTrator = separador[2];
                talhoes[cont].quantidadeLitros = Double.valueOf(separador[3]);
                talhoes[cont].data = separador[4];
                talhoes[cont].destino = separador[5];
                cont++;
            }

            leituraArquivo.close();
        } catch (IOException err) {
            System.err.println("Erro encontrado na leitura do arquivo: " + err);
        }
        return cont;
    }
}