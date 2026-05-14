import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int opcao;
        int totalColaboradores = 0;
        int totalTalhoes = 0;
        int totalTratores = 0;
        CadastroColaborador[] colaboradores = new CadastroColaborador[10];
        CadastroTalhao[] talhoes = new CadastroTalhao[10];
        CadastroFrota[] tratores = new CadastroFrota[10];

        
        totalColaboradores = carregarFuncionarios(colaboradores);
        totalTalhoes = carregarTalhao(talhoes);
        totalTratores = carregarFrota(tratores);
        totalTalhoes = carregarTalhao(talhoes);

        do {
            System.out.println("----> SISTEMA FAZENDA <----");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Cadastrar Talhão");
            System.out.println("3 - Cadastrar Trator");
            System.out.println("4 - Registrar Entrada de Café");
            System.out.println("5 - Relatório Quinzena");
            System.out.println("6 - Relatório Talhão");
            System.out.println("7 - Relatório Secagem");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("----> Cadastro de Colaborador <----");
                    colaboradores[totalColaboradores] = new CadastroColaborador();

                    System.out.println("Digite o nome do colaborador:");
                    colaboradores[totalColaboradores].nome = sc.nextLine();

                    System.out.println("Digite a matrícula do colaborador:");
                    colaboradores[totalColaboradores].matricula = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite o tipo de contrato do colaborador:");
                    colaboradores[totalColaboradores].tipoContrato = sc.nextLine();

                    System.out.println("Cadastro efetuado com sucesso!");
                    totalColaboradores++;

                    try {
                        FileWriter arquivo = new FileWriter("src/BancoDeDados/Funcionarios.csv");
                        PrintWriter gravador = new PrintWriter(arquivo);

                        for (int i = 0; i < totalColaboradores; i++) {
                            // converte o objeto para o formato CSV
                            String linha = colaboradores[i].nome + "; " +
                                    colaboradores[i].matricula + "; " +
                                    colaboradores[i].tipoContrato;
                            gravador.println(linha);
                            System.out.println("Sistema atualizado com sucesso!");

                        }
                        gravador.close();
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar: " + e.getMessage());
                    }

                    break;

                case 2:
            System.out.println("----> Cadastro de Talhão <----");
            talhoes[totalTalhoes] = new CadastroTalhao();

                    System.out.println("Digite o nome da área:");
                    talhoes[totalTalhoes].nome = sc.nextLine();

                    System.out.println("Digite a variedade do café:");
                    talhoes[totalTalhoes].variedadeCafe = sc.nextLine();

                    System.out.println("Digite a estimativa de produção:");
                    talhoes[totalTalhoes].estimativaProducao = sc.nextDouble();
                    System.out.println("Digite o código do talhão:");
                    talhoes[totalTalhoes].codigo = sc.nextInt();

                    System.out.println("Cadastro efetuado com sucesso!");
                    totalTalhoes++;

                    //salvando informações
                    try {

                        FileWriter arquivo = new FileWriter("src/BancoDeDados/Talhoes.csv");

                        PrintWriter gravar = new PrintWriter(arquivo);

                        for(int i = 0; i < totalTalhoes; i++) {

                            gravar.println( 
                                talhoes[i].codigo + ";" +
                                talhoes[i].nome + ";" +
                                talhoes[i].variedadeCafe + ";" +
                                talhoes[i].estimativaProducao
                            );

                        }

                        gravar.close();
                        arquivo.close();

                    } catch(Exception erro) {

                        System.out.println("Erro ao gravar arquivo");

                    }

                    break;

                case 3:
            System.out.println("----> Cadastro de Frota <----");
            tratores[totalTratores] = new CadastroFrota();

                    System.out.println("Digite a placa do trator:");
                    tratores[totalTratores].placa = sc.nextLine();

                    System.out.println("Digite a capacidade máxima:");
                    tratores[totalTratores].capacidadeMaxima = sc.nextDouble();

                   System.out.println("Cadastro efetuado com sucesso!");
                   totalTratores++;
                    break;

                case 4:
                    //registrarCafe();
                    break;

                case 5:
                    // relatorioQuinzena();
                    break;

                case 6:
                    // relatorioTalhao();
                    break;

                case 7:
                    // relatorioSecagem();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    public static int carregartalhoesCafe(RegistroCafe[] talhoes) {
        int cont = 0;

        try {
            Scanner leituraArquivo = new Scanner(new File("src/BancoDeDados/talhoesCafe.csv"));
            while (leituraArquivo.hasNextLine() && cont < talhoes.length) {
                String linha = leituraArquivo.nextLine();
                String[] separador = linha.split(";");
                talhoes[cont] = new RegistroCafe();
                talhoes[cont].matriculaFuncionario = Integer.valueOf(separador[0]);
                talhoes[cont].nomeTalhao = separador[1];
                talhoes[cont].placaTrator = separador[2];
                talhoes[cont].quantidadeLitros = Double.valueOf(separador[3]);
                cont++;
            }

            leituraArquivo.close();
        } catch (IOException err) {
            System.err.println("Erro encontrado na leitura do arquivo: " + err);
        }
        return cont;
    }

    public static int carregarFuncionarios(CadastroColaborador[] funcionarios) {
        int cont = 0;
        return cont;
    }

    public static int carregarFrota(CadastroFrota[] tratores) {
        int cont = 0;
        return cont;
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

    

}