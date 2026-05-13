public class CadastroColaborador {
    public int matricula;
    public String nome;
    public String tipoContrato;

    public static boolean cadastrarColaborador(String nome, int matricula, String tipoContrato, CadastroColaborador colaboradores){
        boolean cadastroEfetuado = false;
        
        colaboradores.matricula = matricula;
        colaboradores.nome = nome;
        colaboradores.tipoContrato = tipoContrato;
        
        return cadastroEfetuado;
    }
}
