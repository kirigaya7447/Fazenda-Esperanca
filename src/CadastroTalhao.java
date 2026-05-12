public class CadastroTalhao {
    public String nome;
    public String variedadeCafe;
    public double estimativaProducao;

    public static boolean cadastrarTalhao(String nome, String variedadeCafe, double estimativaProducao){
        boolean cadastroEfetuado = false;
        CadastroTalhao talhao = new CadastroTalhao();

        talhao.nome = nome;
        talhao.variedadeCafe = variedadeCafe;
        talhao.estimativaProducao = estimativaProducao;
        return cadastroEfetuado;
    }
}
