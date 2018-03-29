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
public class RecepcionistaView {
    
    protected BancoDeDados bd;
    
    public RecepcionistaView()
    {
        bd = new BancoDeDados();
    }
    
    public void SalvarRecep(String Recep) throws Exception
    {
        try {
            ArrayList<String> add_Recep = new ArrayList<>();
            add_Recep.clear();
            add_Recep.add(Recep);
            bd.GerarJSON(add_Recep, "recepcionista");
            
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public String ListarDados() throws Exception
    {
        String retorno = "";
            try
            {
                retorno = new TratarDados().ListarDados("recepcionista");
            } catch(Exception e)
            {
                throw new Exception(e.getMessage());
            }

        return retorno;
    } 
}
