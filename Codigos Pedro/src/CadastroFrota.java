public static void cadastroFrota() {

        System.out.print("Placa: ");
        String placa = sc.nextLine();

        System.out.print("Capacidade máxima: ");
        double capacidade = sc.nextDouble();

        tratores.add(new Trator(placa, capacidade));

        System.out.println("Frota cadastrada!");
    }
}
