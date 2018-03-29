/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.View;

import EscolaSys.Model.BancoDeDados;
import EscolaSys.Model.TratarDados;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
/**
 *
 * @author dev01
 */
public class CursoView {
        protected BancoDeDados bd;
    
    public CursoView()
    {
        bd = new BancoDeDados();
    }
    
    public void SalvarCurso(String Curso) throws Exception
    {
        try {
            ArrayList<String> add_curso = new ArrayList<>();
            add_curso.clear();
            add_curso.add(Curso);
            bd.GerarJSON(add_curso, "curso");
            
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public String ListarDados() throws Exception
    {
        String retorno = "";
            try
            {
                retorno = new TratarDados().ListarDados("curso");
            } catch(Exception e)
            {
                throw new Exception(e.getMessage());
            }

        return retorno;
    }
}
