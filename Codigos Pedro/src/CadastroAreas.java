public static void cadastroAreas() {

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
