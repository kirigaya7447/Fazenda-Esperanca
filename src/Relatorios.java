import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

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

    private static String retornaDataeHora(){
        LocalDateTime horaAtual = LocalDateTime.now();

        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd-MM-yyyy - HH:mm:ss");

        String data = horaAtual.format(formataData);
        return data;
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

            //gera um arquivo com o relatório mostrado na tela
            try {
                        File arquivo = new File("src/Relatorios/Quinzena/" + retornaDataeHora() + ".txt");
                        if(arquivo.createNewFile()){
                            PrintWriter gravador = new PrintWriter(arquivo);

                            for (int k = 0; k < totalFuncionarios; k++) {
                                // converte o objeto para o formato CSV
                                String linha = "Funcionário: " + funcionarios[i].nome +
                                                "\nMatrícula: " + funcionarios[i].matricula +
                                                "\nTotal Colhido: " + totalLitros + " litros"; 
                                
                                    gravador.println(linha);

                        }
                        System.out.println("Relatório gerado e disponível em Relatorios/Quinzena/");
                        gravador.close();
                        }
                        
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar: " + e.getMessage());
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