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
public class ProfessorView {
    
    protected BancoDeDados bd;
    
    public ProfessorView()
    {
        bd = new BancoDeDados();
    }
    
    public void SalvarProfessor(String Professor, String salario) throws Exception
    {
        try {
            ArrayList<String> add_prof = new ArrayList<>();
            add_prof.clear();
            add_prof.add(Professor);
            add_prof.add(salario);
            bd.GerarJSON(add_prof, "professor");
            
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public String ListarDados() throws Exception
    {
        String retorno = "";
            try
            {
                retorno = new TratarDados().ListarDados("professor");
            } catch(Exception e)
            {
                throw new Exception(e.getMessage());
            }

        return retorno;
    }
    
}
