/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys.Control;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;
/**
 *
 * @author 1171139648
 */
public class Aluno extends Pessoa{
    
    protected String matricula;
    protected String celular;
    
    
    public void cadastrarAluno()
    {
        int contar = alunos.size();
        if(contar < 30)
        {
            super.cadastrarPessoa();
            matricula = JOptionPane.showInputDialog("Entre com a Matrícula: ");
            boolean validar_matricula = validarNumero(matricula);

            while(matricula.length() < 1 || validar_matricula == false)
            {
                JOptionPane.showMessageDialog(null, "Formato de matrícula inválido");
                matricula = JOptionPane.showInputDialog("Entre com a Matrícula: ");
                validar_matricula = validarNumero(matricula);
            }

            celular = JOptionPane.showInputDialog("Entre com o Celular: ");
            boolean validar_celular = validarNumero(celular);

            while(celular.length() < 10 || celular.length() > 11 || validar_celular == false)
            {
                JOptionPane.showMessageDialog(null, "Telefone inválido");
                celular = JOptionPane.showInputDialog("Entre com o Celular: ");
                validar_celular = validarNumero(celular);
            }

            String alunos_add = super.exibirPessoa()+
                    "<br><strong>Celular:</strong> "+celular+"<br><strong>Matrícula:</strong> "+matricula+"</font><br><br>";

            if(alunos.add(alunos_add))
            {
                JOptionPane.showMessageDialog(null, "Aluno Cadastrado com sucesso ");
                //this.Get_QntdALunos();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Erro ao cadastras aluno");
            }
       }
        else
        {
            JOptionPane.showMessageDialog(null, "Não é mais possível cadastrar alunos, a cota máxima são de 30");
        }
    }
    
        public void exibirAluno()
    {
        int quantidade_alunos = alunos.size();
        
        if(quantidade_alunos > 0)
        {
        String todos = "";
        
        for(int i = 0; i < quantidade_alunos; i++)
        {
            todos += alunos.get(i);
        }
        
        String mensagemTitulo = "Alunos Cadastrados - "+quantidade_alunos;
        
       ShowPainel(todos, mensagemTitulo);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Ainda não há alunos cadastrados");
        }
                
    }


    
}
