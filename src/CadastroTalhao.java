public class CadastroTalhao {
    public String nome;
    public String variedadeCafe;
    public double estimativaProducao;

    public static boolean cadastrarTalhao(String nome, String variedadeCafe, double estimativaProducao, CadastroTalhao talhoes){
        boolean cadastroEfetuado = false;

        talhoes.nome = nome;
        talhoes.variedadeCafe = variedadeCafe;
        talhoes.estimativaProducao = estimativaProducao;
        return cadastroEfetuado;
    }
}
