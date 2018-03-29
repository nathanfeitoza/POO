/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.Model;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
/**
 *
 * @author dev01
 */
public class AlunoModel{
    
    protected BancoDeDados bd;
    
    public AlunoModel()
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
                retorno = new Validacoes().ListarDados("aluno");
            } catch(Exception e)
            {
                throw new Exception(e.getMessage());
            }

        return retorno;
    }
   
}
