/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys;

import java.util.*;
import javax.swing.*;
import java.lang.*;

/**
 *54554
 * @author 1171139648
 */
public class Escola {
    public static void main(String[] args) {
     
        int opc = 0;
        
        Aluno aluno = new Aluno();
        Professor professor = new Professor();
        Curso curso = new Curso();
        
        while(opc != 7)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog(""+
                    "XYZ Tecnologia\n\n"+
                    "1 - Cadastrar Aluno\n"+
                    "2 - Cadastrar Professor\n"+
                    "3 - Cadastrar Curso\n"+
                    "4 - Exibir Alunos\n"+
                    "5 - Exibir Professor\n"+
                    "6 - Exibir Curso\n"+                    
                    "7 - Sair do Sistema\n"                    
                    ));
     
        
        switch(opc){
            case 1:
                aluno.cadastrarAluno();
                break;
            case 2:
                professor.cadastrarProfessor();
                break;
            case 3:
                professor.calcularSalario();
                curso.valores(aluno.Get_QntdALunos(), professor.Get_SalProf());
                curso.cadastrarCurso();
                break;
            case 4:
                aluno.exibirAluno();
                break;
            case 5:
                professor.exibirProfessor();
                break;
            case 6:
                curso.exibirCurso();
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "Tchau... Até mais!");
                break;
            default:
                 JOptionPane.showMessageDialog(null,"Opção Inválida");
                 break;
                
        }
      }
    }
}
