/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscolaSys;

import java.util.ArrayList;

/**
 *
 * @author 1171139648
 */
public class Turma extends Validacoes {
  
  
  public double professor_salario;
  protected ArrayList<String> alunos = new ArrayList<String> ();
  protected int valor_array_alunos;
  
  protected int Get_QntdALunos()
  {
      return alunos.size();
  }
  
  protected void Set_SalProf(double valor)
  {
      this.professor_salario = valor;
  }
  
  protected double Get_SalProf()
  {
     return this.professor_salario; 
  }
  
}
