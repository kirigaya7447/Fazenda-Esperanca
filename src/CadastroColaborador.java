public class CadastroColaborador {
    public int matricula;
    public String nome;
    public String tipoContrato;

    public static boolean cadastrarColaborador(String nome, int matricula, String tipoContrato, CadastroColaborador[] colaboradores, int totalColaboradores){
        boolean cadastroEfetuado = false;
        boolean cadastroDuplicado = false;

        for (int cont = 0; cont < colaboradores.length; cont++){
        if(colaboradores[cont].matricula == matricula){
            cadastroEfetuado = false;
            cadastroDuplicado = true;            
               
        }
        else{
            cadastroEfetuado = true;
        }
    }

    if(!cadastroDuplicado){
        colaboradores[totalColaboradores].matricula = matricula;
        colaboradores[totalColaboradores].nome = nome;
        colaboradores[totalColaboradores].tipoContrato = tipoContrato;
        
    }

        return cadastroEfetuado;
    }
}
