public class Relatorios {

    public static void relatorioTalhao(
        CadastroTalhao[] talhoes,
        int totalTalhoes,
        RegistroCafe[] registros,
        int totalRegistros
    ) {

        System.out.println("---- RELATÓRIO DE TALHÕES ----");

        for(int i = 0; i < totalTalhoes; i++) {

            double totalProduzido = 0;

            for(int j = 0; j < totalRegistros; j++) {

                if(registros[j].nomeTalhao.equalsIgnoreCase(talhoes[i].nome)) {

                    totalProduzido = totalProduzido + registros[j].quantidadeLitros;

                }

            }

            System.out.println();

            System.out.println("Talhão: " + talhoes[i].nome);

            System.out.println("Código: " + talhoes[i].codigo);

            System.out.println("Produção atual: " + totalProduzido + " litros");

            System.out.println("Estimativa inicial: " + talhoes[i].estimativaProducao + " litros");

            if(totalProduzido >= talhoes[i].estimativaProducao) {

                System.out.println("Estimativa atingida!");

            } else {

                System.out.println("Estimativa ainda não atingida.");

            }

        }

    }

}