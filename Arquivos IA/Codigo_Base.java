public class Codigo_Base-Pedro {
    import java.util.ArrayList;
import java.util.Scanner;

    // ===================== CLASSES =====================

    static class Funcionario {
        String nome;
        int matricula;
        String contrato;

        Funcionario(String nome, int matricula, String contrato) {
            this.nome = nome;
            this.matricula = matricula;
            this.contrato = contrato;
        }
    }

    static class Talhao {
        String codigo;
        String nome;
        String variedade;
        double estimativa;

        Talhao(String codigo, String nome, String variedade, double estimativa) {
            this.codigo = codigo;
            this.nome = nome;
            this.variedade = variedade;
            this.estimativa = estimativa;
        }
    }

    static class Trator {
        String placa;
        double capacidade;

        Trator(String placa, double capacidade) {
            this.placa = placa;
            this.capacidade = capacidade;
        }
    }

    static class Lancamento {
        String data;
        int matriculaFuncionario;
        String codigoTalhao;
        String placaTrator;
        double litros;
        String destino;

        Lancamento(String data, int matriculaFuncionario, String codigoTalhao,
                    String placaTrator, double litros, String destino) {

            this.data = data;
            this.matriculaFuncionario = matriculaFuncionario;
            this.codigoTalhao = codigoTalhao;
            this.placaTrator = placaTrator;
            this.litros = litros;
            this.destino = destino;
        }
    }
// ===================== LISTAS =====================

    static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    static ArrayList<Talhao> talhoes = new ArrayList<>();
    static ArrayList<Trator> tratores = new ArrayList<>();
    static ArrayList<Lancamento> lancamentos = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // ===================== MAIN =====================

    public static void main(String[] args) {

        int opcao;
do {
System.out.println("\n===== SISTEMA FAZENDA =====");
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
                    cadastrarFuncionario();
                    break;

                case 2:
                    cadastrarTalhao();
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
// ===================== CADASTROS =====================

    static void cadastrarFuncionario() {

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Matrícula: ");
        int matricula = sc.nextInt();
        sc.nextLine();

        System.out.print("Tipo de contrato (Diarista/Fixo): ");
        String contrato = sc.nextLine();

        funcionarios.add(new Funcionario(nome, matricula, contrato));

        System.out.println("Funcionário cadastrado!");
    }

    static void cadastrarTalhao() {

        System.out.print("Código: ");
        String codigo = sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Variedade do café: ");
        String variedade = sc.nextLine();

        System.out.print("Estimativa de produção: ");
        double estimativa = sc.nextDouble();

        talhoes.add(new Talhao(codigo, nome, variedade, estimativa));

        System.out.println("Talhão cadastrado!");
    }

    static void cadastrarTrator() {

        System.out.print("Placa: ");
        String placa = sc.nextLine();

        System.out.print("Capacidade máxima: ");
        double capacidade = sc.nextDouble();

        tratores.add(new Trator(placa, capacidade));

        System.out.println("Trator cadastrado!");
    }
// ===================== LANÇAMENTO =====================

    static void registrarCafe() {

        System.out.print("Data: ");
        String data = sc.nextLine();

        System.out.print("Matrícula do funcionário: ");
        int matricula = sc.nextInt();
        sc.nextLine();

        Funcionario funcionario = buscarFuncionario(matricula);

        if (funcionario == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }

        System.out.print("Código do talhão: ");
        String codigoTalhao = sc.nextLine();

        Talhao talhao = buscarTalhao(codigoTalhao);

        if (talhao == null) {
            System.out.println("Talhão não encontrado!");
            return;
        }

        System.out.print("Placa do trator: ");
        String placa = sc.nextLine();

        Trator trator = buscarTrator(placa);

        if (trator == null) {
            System.out.println("Trator não encontrado!");
            return;
        }

        System.out.print("Quantidade de litros: ");
        double litros = sc.nextDouble();
        sc.nextLine();

        if (litros > trator.capacidade) {
            System.out.println("ERRO: carga maior que a capacidade do trator!");
            return;
        }

        System.out.print("Destino (Terreiro/Secador): ");
        String destino = sc.nextLine();

        lancamentos.add(new Lancamento(data, matricula, codigoTalhao,
                placa, litros, destino));

        System.out.println("Lançamento realizado com sucesso!");
    }
// ===================== BUSCAS =====================

    static Funcionario buscarFuncionario(int matricula) {

        for (Funcionario f : funcionarios) {
            if (f.matricula == matricula) {
                return f;
            }
        }

        return null;
    }

    static Talhao buscarTalhao(String codigo) {

        for (Talhao t : talhoes) {
            if (t.codigo.equalsIgnoreCase(codigo)) {
                return t;
            }
        }

        return null;
    }

    static Trator buscarTrator(String placa) {

        for (Trator t : tratores) {
            if (t.placa.equalsIgnoreCase(placa)) {
                return t;
            }
        }

        return null;
    }
// ===================== RELATÓRIOS =====================

    static void relatorioQuinzena() {

        System.out.println("\n===== ACERTO DA QUINZENA =====");

        for (Funcionario f : funcionarios) {

            double total = 0;

            for (Lancamento l : lancamentos) {
                if (l.matriculaFuncionario == f.matricula) {
                    total += l.litros;
                }
            }

            System.out.println(f.nome + " -> " + total + " litros");
        }
    }

    static void relatorioTalhao() {

        System.out.println("\n===== FECHAMENTO DOS TALHÕES =====");

        for (Talhao t : talhoes) {

            double total = 0;

            for (Lancamento l : lancamentos) {
                if (l.codigoTalhao.equalsIgnoreCase(t.codigo)) {
                    total += l.litros;
                }
            }

            System.out.println("Talhão: " + t.nome);
            System.out.println("Produção atual: " + total + " litros");
            System.out.println("Estimativa: " + t.estimativa + " litros");

            if (total >= t.estimativa) {
                System.out.println("Estimativa atingida!");
            } else {
                System.out.println("Estimativa ainda não atingida.");
            }

            System.out.println();
        }
    }

    static void relatorioSecagem() {

        double terreiro = 0;
        double secador = 0;

        for (Lancamento l : lancamentos) {

            if (l.destino.equalsIgnoreCase("Terreiro")) {
                terreiro += l.litros;
            }

            if (l.destino.equalsIgnoreCase("Secador")) {
                secador += l.litros;
            }
        }

        System.out.println("\n===== RELATÓRIO DE SECAGEM =====");
        System.out.println("Terreiro: " + terreiro + " litros");
        System.out.println("Secador: " + secador + " litros");
    }