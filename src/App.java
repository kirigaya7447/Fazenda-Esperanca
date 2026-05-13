import java.util.Scanner;

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

                    System.out.println("Cadastro efetuado com sucesso!");
                    totalTalhoes++;
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
                    //relatorioQuinzena();
                    break;

                case 6:
                    //relatorioTalhao();
                    break;

                case 7:
                    //relatorioSecagem();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}