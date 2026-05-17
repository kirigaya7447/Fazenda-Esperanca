import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Relatorios {

//Registra a hora e a data do relatório
    private static void mostrarDataEHora(){
        LocalDateTime horaAtual = LocalDateTime.now();

        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formataHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        String data = horaAtual.format(formataData);
        String hora = horaAtual.format(formataHora);


        System.out.println("Relatório extraído em: " + data + " às " + hora);
    }

    //Relatório 1 - Acerto da Quinzena
    public static void relatorioQuinzena(
            CadastroFuncionario[] funcionarios,
            int totalFuncionarios,
            RegistroCafe[] registros,
            int totalRegistros) {

        System.out.println("\n----> RELATÓRIO DA QUINZENA <----");

        //percorre todos os funcionários
        for (int i = 0; i < totalFuncionarios; i++) {

            double totalLitros = 0;

            //percorre todos os registros
            for (int j = 0; j < totalRegistros; j++) {

                //verifica se o registro pertence ao funcionário
                if (registros[j].matriculaFuncionario ==
                        funcionarios[i].matricula) {

                    totalLitros += registros[j].quantidadeLitros;
                }
            }

            //mostra resultado do funcionário
            mostrarDataEHora();
            System.out.println("Funcionário: " + funcionarios[i].nome);
            System.out.println("Matrícula: " + funcionarios[i].matricula);
            System.out.println("Total Colhido: " + totalLitros + " litros");
            System.out.println("-----------------------------------");
        }
    }
    
    //Relatório 2- Talhão
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
            mostrarDataEHora();

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
    //Relatório 3 - Secagem
    public static void relatorioSecagem(
           RegistroCafe[] registros,
           int totalRegistros) {

           double totalSecador = 0;
           double totalTerreiro = 0;

           System.out.println("\n----> RELATÓRIO DE SECAGEM <----");

           //percorre todos os registros
           for (int i = 0; i < totalRegistros; i++) {

           //verifica o destino
           if (registros[i].destino.equalsIgnoreCase("Secador")) {

           totalSecador += registros[i].quantidadeLitros;

           } else if (registros[i].destino.equalsIgnoreCase("Terreiro")) {

           totalTerreiro += registros[i].quantidadeLitros;
           }
        }

        //exibe os resultados
        mostrarDataEHora();
        System.out.println("Total enviado para o Secador: " + totalSecador + " litros");
        System.out.println("Total enviado para o Terreiro: " + totalTerreiro + " litros");
        System.out.println("-----------------------------------");
}

}