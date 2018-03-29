/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.View;



import EscolaSys.Model.BancoDeDados;
import EscolaSys.Model.TratarDados;
import java.util.ArrayList;
/**
 *
 * @author dev01
 */
public class AlunoView{
    
    protected BancoDeDados bd;
    
    public AlunoView()
    {
        bd = new BancoDeDados();
    }
    
    public void SalvarAlunos(ArrayList Alunos) throws Exception
    {
        try {
            bd.GerarJSON(Alunos, "aluno");
            
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public String ListarDados() throws Exception
    {
        String retorno = "";
            try
            {
                retorno = new TratarDados().ListarDados("aluno");
            } catch(Exception e)
            {
                throw new Exception(e.getMessage());
            }

        return retorno;
    }
   
}
