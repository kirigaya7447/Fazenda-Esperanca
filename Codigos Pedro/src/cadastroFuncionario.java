import java.util.Scanner;

public static void cadastroFuncionario() {
    static Scanner sc = new Scanner(System.in);

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
