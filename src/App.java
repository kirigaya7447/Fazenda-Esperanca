import java.util.Scanner;
public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int opcao;
        CadastroColaborador colaboradores = new CadastroColaborador();
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
                    System.out.println("Digite o nome do colaborador:");
                    String nomeColaborador = sc.nextLine();
                    System.out.println("Digite a matrícula do colaborador:");
                    int matricula = sc.nextInt();
                    System.out.println("Digite o tipo de contrato do colaborador:");
                    String tipoContrato = sc.nextLine();

                    if(CadastroColaborador.cadastrarColaborador(nomeColaborador, matricula, tipoContrato, colaboradores)){
                        System.out.println("Cadastro efetuado com sucesso!");
                    }
                    else{
                        System.out.println("Falha no cadastro, este colaborador já existe!");
                    }
                    break;

                case 2:
                    System.out.println("Digite o nome da área:");
                    String nomeTalhao = sc.nextLine();
                    System.out.println("Digite a variedade do café:");
                    String variedadeCafe = sc.nextLine();
                    System.out.println("Digite a estimativa de produção:");
                    Double estimativaProducao = sc.nextDouble();


                    CadastroTalhao.cadastrarTalhao(nomeTalhao, variedadeCafe, estimativaProducao);
                    break;

                case 3:
                    cadastrarTrator();
                    break;

                case 4:
                    registrarCafe();
                    break;

                case 5:
                    relatorioQuinzena();
                    break;

                case 6:
                    relatorioTalhao();
                    break;

                case 7:
                    relatorioSecagem();
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
}
