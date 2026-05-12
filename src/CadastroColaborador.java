public class CadastroColaborador {
    public String nome;
    public int matricula;
    public String tipoContrato;

    public static boolean cadastrarColaborador(String nome, int matricula, String tipoContrato){
        boolean cadastroEfetuado = false;
        CadastroColaborador colaborador = new CadastroColaborador();
        
        colaborador.nome = nome;
        colaborador.matricula = matricula;
        colaborador.tipoContrato = tipoContrato;
        
        return cadastroEfetuado;
    }
}
