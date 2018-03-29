/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.View;

import EscolaSys.Model.AlunoModel;
import EscolaSys.Model.Pessoa;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;
/**
 *
 * @author 1171139648
 */
public class AlunoView extends Pessoa{
    
    protected String matricula;
    protected String celular;
    
    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }
    public String getMatricula()
    {
        return this.matricula;
    }
    
    public void setCelular(String celular)
    {
        this.celular = celular;
    }
    public String getCelular()
    {
        return this.celular;
    }
    
    
    public void cadastrarAluno(String pessoa) throws Exception
    {
 
            String matricula_local = this.getMatricula();
            boolean validar_matricula = validarNumero(matricula_local);

            if(matricula_local.length() < 1 || validar_matricula == false)
            {
                throw new Exception("Matrícula inválida");
            }

            String celular_local = this.getCelular();
            boolean validar_celular = validarNumero(celular_local);

            if(celular_local.length() < 10 || celular_local.length() > 11 || validar_celular == false)
            {
                throw new Exception("Celular inválido");
            }

            String alunos_add = pessoa+
                    "<br><strong>Celular:</strong> "+celular+"<br><strong>Matrícula:</strong> "+matricula+"</font><br><br>";

            if(alunos.add(alunos_add))
            {
                AlunoModel salvar = new AlunoModel();
                try
                {
                   salvar.SalvarAlunos(alunos);
                   JOptionPane.showMessageDialog(null, "Aluno Cadastrado com sucesso "); 
                } catch(Exception e)
                {
                    throw new Exception(e.getMessage());
                }
                
                //this.Get_QntdALunos();
            }
            else
            {
                throw new Exception("Erro ao cadastrar aluno, tente novamente");
            }

    }
   
    
}
