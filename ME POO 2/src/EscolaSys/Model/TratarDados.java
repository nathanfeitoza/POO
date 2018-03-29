/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.Model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;

/**
 *
 * @author 1171139648
 */
public class TratarDados extends Validacoes {
  
  
    public String ListarDados(String tipo_dados) throws Exception
    {
        String retorno = "";
            try
            {
                ArrayList<String> dados = bd.LerDados(tipo_dados);
                if(dados.size() > 0)
                {
                    Iterable<String> iterable = dados;
                    retorno += "<strong>Total: </strong>"+dados.size()+"<br><br>";
                    for (String s : iterable) 
                    {
                        
                        JsonElement jelement = new JsonParser().parse(s);
                        JsonArray  jobject = jelement.getAsJsonArray();
                        retorno += jobject.get(0).getAsString();
                        if(tipo_dados.equals("professor"))
                        {
                            break;
                        }
                        
                        
                    }
                }
                else
                {
                    throw new Exception("Nada cadastrado ainda");
                }
            } catch(Exception e)
            {
                throw new Exception(e.getMessage());
            }

        return retorno;
    }
  
  
  
}
