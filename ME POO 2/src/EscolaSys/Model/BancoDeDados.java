/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.gson.*;
import java.io.File;
import java.io.Writer;
/**
 *
 * @author dev01
 */
public class BancoDeDados {
    boolean append = true;
    
    private boolean SetAppend(String local)
    {
        return local.equals("aluno");
    }
    
    private String Locais(String tipo_salvar)
    {
        String caminho;
        switch(tipo_salvar.toLowerCase())
        {
            case "aluno":
                caminho = "Table_Alunos.json";
                break;
            case "professor":
                caminho = "Table_Professores.json";
                break;
            case "recepcionista":
                caminho = "Table_Recepcionista.json";
                break;
            case "curso":
                caminho = "Table_Curso.json";
                break;
            default:
                caminho = "";
                break;
        }
        return caminho;
    }
    
    private void SalvarDados(String Dados, String caminho, boolean append) throws Exception{
        
        Path arquivo = Paths.get(caminho);
        
        if(!Files.exists(arquivo))
        {
            File arq = new File(caminho);
            try {
                arq.createNewFile();
                try{
                    Writer writer = new FileWriter(caminho, append);
                    try (BufferedWriter save = new BufferedWriter(writer)) {
                        save.write(Dados);
                    }
                } catch (IOException e)
                {
                    throw new Exception("Erro ao salvar arquivo: "+e.getMessage());
                } 

            } catch (IOException e) {
                throw new Exception("Erro ao salvar arquivo: "+e.getMessage());
            } catch (Exception e) {
                throw new Exception("Erro ao salvar arquivo: "+e.getMessage());
            }
            
            
        }
        else
        {
            //new File(caminho).delete();
            try{
                Writer writer = new FileWriter(caminho, append);
                try (BufferedWriter save = new BufferedWriter(writer)) {
                    if(append == false)
                    {
                        save.write("");
                        save.flush();
                    }
                    else
                    {
                        save.newLine();
                    }
                    save.write(Dados);
                }
            } catch (IOException e)
            {
                throw new Exception("Erro ao salvar arquivo: "+e.getMessage());
            }
            
        }
    }
    
    public void GerarJSON(ArrayList<String> Dados_Salvar, String tipo_salvar) throws Exception{
 
        String caminho = Locais(tipo_salvar);
          System.out.println("Length caminho: "+caminho.length());  
        if(caminho.length() == 0)
        {
            throw new Exception("O caminho '"+tipo_salvar+"' especificado não é válido");
        }
        else
        {
               
        Gson gson = new Gson();
        String dados_salvar = gson.toJson(Dados_Salvar);
        try{
            this.SalvarDados(dados_salvar, caminho, this.SetAppend(tipo_salvar));
        } catch(Exception e)
        {
           throw new Exception(e.getMessage()); 
        }
        
        }
        
    }
    
    public ArrayList<String> LerDados(String tipo_leitura) throws Exception
    {
        ArrayList<String> dados_lidos = new ArrayList<>();
        
        String caminho = this.Locais(tipo_leitura);
        
        if(caminho.length() == 0)
        {
            throw new Exception("O caminho '"+tipo_leitura+"' especificado não é válido");
        }
        else
        {
            Path arquivo = Paths.get(caminho);
            
            if(Files.exists(arquivo))
            {
                dados_lidos = (ArrayList<String>) Files.readAllLines(arquivo, Charset.defaultCharset());
            }
            else
            {
                throw new Exception("Nada encontrado em '"+tipo_leitura+"'");
            }
        }
            
        
        return dados_lidos;
    }
    
}
