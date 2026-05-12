public class CadastroColaborador {
    public String nome;
    public int matricula;
    public String tipoContrato;

    public static boolean cadastrarColaborador(String nome, int matricula, String tipoContrato, CadastroColaborador colaboradores){
        boolean cadastroEfetuado = false;
        
        colaboradores.nome = nome;
        colaboradores.matricula = matricula;
        colaboradores.tipoContrato = tipoContrato;
        
        return cadastroEfetuado;
    }
}
