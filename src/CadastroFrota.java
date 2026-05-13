public class CadastroFrota {
    public String placa;
    public double capacidadeMaxima;

    public static boolean cadastrarFrota(String placa, double capacidadeMaxima, CadastroFrota tratores){
        boolean cadastroEfetuado = false;

        tratores.placa = placa;
        tratores.capacidadeMaxima = capacidadeMaxima;
        return cadastroEfetuado;
    }
}
